angular.module( 'ngBoilerplate.cliente', [
  'ui.router',
  'placeholders',
  'ui.bootstrap',
  'cobranzaFilters'
])

.config(function config( $stateProvider ) {
  $stateProvider.state( 'cliente', {
  url: '/cliente/:idCliente',
    views: {
      "main": {
        controller: 'ClienteCtrl',
        templateUrl: 'template/gestion_cliente.html'
      }
    },
    data:{ pageTitle: 'Gesti\u00f3n cliente' }
  });
})


.controller( 'ClienteCtrl', ['$scope', '$stateParams', '$http','$modal',function($scope,$stateParams,$http, $modal ) {
        console.log($stateParams.idCliente);
        $http.get('rest/cliente/gestion/'+$stateParams.idCliente).success(function(data) {
            $scope.body = data.body;
            $scope.success = data.success;
            $scope.cliente = data.body.cliente;
            $scope.campanhas = data.body.campanhaVOList;
            $scope.carteraCliente = data.body.carteraCliente;
            $scope.tramos = data.body.tramos;
            $scope.documentos = data.body.documentosCliente;
        });
        $http.get('rest/cliente/gestion/contactos/'+$stateParams.idCliente).success(function(data) {
            $scope.contactos = data;
        });
        $scope.documentosSeleccionados = [];
        $scope.selectedAll = false;
        $scope.selectAll  = function() {
            _.each($scope.documentos,function(documento) {
                console.log(documento);
                documento.seleccionado = $scope.selectedAll;
                updateSelected(documento);
            })
        }

        $scope.selectElement = function(documento) {
            console.log(documento)
            updateSelected(documento);
        }

        var updateSelected = function( documento) {
            if (documento.seleccionado && $scope.documentosSeleccionados.indexOf(documento) === -1) {
                $scope.documentosSeleccionados.push(documento);
            }
            if (!documento.seleccionado && $scope.documentosSeleccionados.indexOf(documento) !== -1) {
                $scope.documentosSeleccionados.splice($scope.documentosSeleccionados.indexOf(documento), 1);
            }
            console.log($scope.documentos);
            console.log($scope.documentosSeleccionados);
        };




        $scope.open = function (size,view) {
            if($scope.documentosSeleccionados.length == 0) {
                alert("Debe seleccionar un documento");
                return;
            }
            console.log(size);
            var modalInstance = $modal.open({
                templateUrl: view,
                controller: ModalAgendarCtrl,
                size: size,
                resolve: {
                    data: function () {
                        return  {documentos: $scope.documentosSeleccionados,
                            idCliente:$stateParams.idCliente,
                            contactos: $scope.contactos};
                    }

                }
            });

            modalInstance.result.then(function (contactos) {
                $scope.contactos = contactos;
            }, function () {
                console.log('Modal dismissed at: ' + new Date());
            });
        };
}]);

var ModalAgendarCtrl = function ($scope, $modalInstance,$modal,$http, data) {


    $scope.documentos = data.documentos;
    $scope.idCliente = data.idCliente;
    $scope.contactos = data.contactos;
    console.log($scope.contactos);
    $scope.contactoSeleccionado = data.contactos != null && data.contactos.length > 0 ? data.contactos[0] : null;
    $scope.fechaAgendada = new Date();
    $scope.observacion = "";
    $scope.cargo = "";
    $scope.contacto = {};

    $scope.ok = function () {
        var idDocumentos = [];
        _.each($scope.documentos,function(documento) {
            idDocumentos.push(documento.idDocumento);

        });

        var agenda = {fechaAgendada:$scope.fechaAgendada, comentario:$scope.observacion,
            idContacto: $scope.contactoSeleccionado.idContacto,
            idDocumentos: idDocumentos,idCliente: $scope.idCliente};

        console.log($scope.contactoSeleccionado);
        console.log($scope.observacion);
        console.log(idDocumentos);
        console.log(agenda);

        $http({
            url: 'rest/cliente/gestion/guardar-agenda.htm',
            dataType: 'json',
            method: 'POST',
            data: JSON.stringify(agenda),
            headers: {
                "Content-Type": "application/json"
            }}).success(function(data, status, headers, config) {
                $scope.posts = data;
                $modalInstance.close($scope.contactos);
            }).
            error(function(data, status, headers, config) {
                alert("Ha ocurrido un error al guardar la agenda");
            });
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };

    $scope.open = function (size,view) {
        var modalInstance = $modal.open({
            templateUrl: view,
            controller: ModalContactoCtrl,
            size: size,
            resolve: {
                items: function () {
                    return $scope.documentosSeleccionados;
                },
                idCliente: function() {
                    return $scope.idCliente;
                }
            }
        });

        modalInstance.result.then(function (contacto) {
            $scope.contactos.push(contacto);
        }, function () {
            console.log('Modal dismissed at: ' + new Date());
        });
    };
};


var ModalContactoCtrl = function ($scope, $modalInstance,$http, idCliente) {
    console.log($modalInstance);
    console.log(idCliente);
    $scope.contacto = {idCliente: idCliente, nombre:'', cargo:'',email:'',fono:'',idContacto:null};
    $scope.master = {idCliente: idCliente, nombre:'', cargo:'',email:'',fono:'',idContacto:null};
    $scope.isUnchanged = function(contacto) {
        return angular.equals(contacto, $scope.master);
    };
    $scope.ok = function () {
        $scope.master = angular.copy($scope.contacto);
        $http({
            url: 'rest/cliente/gestion/guardar-contacto.htm',
            dataType: 'json',
            method: 'POST',
            data: JSON.stringify($scope.contacto),
            headers: {
                "Content-Type": "application/json"
        }}).success(function(data, status, headers, config) {
            $scope.posts = data;
            $modalInstance.close($scope.contacto);
        }).
        error(function(data, status, headers, config) {
            alert("Ha ocurrido un error al guardar");
        });

    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};
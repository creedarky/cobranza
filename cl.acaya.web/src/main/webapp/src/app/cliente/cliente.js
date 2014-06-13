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
            $scope.contingencias = data.body.contingencia;
            console.log($scope.contingencias);
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
                            contactos: $scope.contactos,
                            contingencias:$scope.contingencias};
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

    console.log(data);
    $scope.documentos = data.documentos;
    $scope.idCliente = data.idCliente;
    $scope.contactos = data.contactos;
    console.log($scope.contactos);
    $scope.contingencias = data.contingencias;
    $scope.contactoSeleccionado = data.contactos != null && data.contactos.length > 0 ? data.contactos[0] : null;
    $scope.fechaAgendada = new Date();
    $scope.observacion = "";
    $scope.cargo = "";


    $scope.validarContingencia = function(documento) {
        if(documento.contingencia) {
            documento.validar = false;
            documento.recaudar = false;
        }
        documento.contingenciaSeleccionada = null;
    };

    $scope.validarRecaudar = function(documento) {
        if(documento.recaudar || documento.validar) {
            documento.contingencia = false;
        }
        documento.contingenciaSeleccionada = null;
    };

    $scope.guardarAgenda = function () {
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

    $scope.guardar_gestion = function () {
        var idContacto = $scope.contactoSeleccionado != null ? $scope.contactoSeleccionado.idContacto : null;
        $scope.gestion = {idCliente:$scope.idCliente,observacion:$scope.observacion,
            idContacto:idContacto,
            idDocumentosValidados: [],
            idDocumentosRecaudados:[],
            idDocumentosContingencia:[],
            idContingencias: [],
            observacionesContingencia: []
        }
        var idDocumentosValidados = [];
        var idDocumentosRecaudados = [];
        var idDocumentosContingencia = [];
        var idContingencias = [];
        var observacionesContingencia= []
        _.each($scope.documentos,function(documento) {
            if(documento.validar)
                idDocumentosValidados.push(documento.idDocumento)
            if(documento.recaudar)
                idDocumentosRecaudados.push(documento.idDocumento)
            if(documento.contingencia) {
                idDocumentosContingencia.push(documento.idDocumento),
                idContingencias.push(documento.contingenciaSeleccionada.idContingencia);
                observacionesContingencia.push(documento.observacion);
            }
        });

        $scope.gestion.idDocumentosValidados = idDocumentosValidados;
        $scope.gestion.idDocumentosRecaudados = idDocumentosRecaudados;
        $scope.gestion.idDocumentosContingencia = idDocumentosContingencia;
        $scope.gestion.idContingencias = idContingencias;
        $scope.gestion.observacionesContingencia = observacionesContingencia;

        console.log($scope.gestion);
        console.log(JSON.stringify($scope.gestion));
        if(idDocumentosRecaudados.length > 0) {
            var modalInstance = $modal.open({
                templateUrl: 'template/gestion_modal/recaudar_modal.html',
                controller: ModalRecaudaCtrl,
                size: 'lg',
                resolve: {
                    params: function() {
                        return {contactos: $scope.contactos};
                    }
                }
            });

            modalInstance.result.then(function (recauda) {
                $scope.gestion.recaudaVO = recauda;
                enviarGestion();
            }, function () {
                console.log('Modal dismissed at: ' + new Date());
            });
        }else
            enviarGestion();
    };

    var enviarGestion = function() {
        $http({
            url: 'rest/cliente/gestion/guardar-gestion.htm',
            dataType: 'json',
            method: 'POST',
            data: JSON.stringify($scope.gestion),
            headers: {
                "Content-Type": "application/json"
            }}).success(function(data, status, headers, config) {
            $scope.posts = data;
            $modalInstance.close($scope.contactoSeleccionado);
        }).
        error(function(data, status, headers, config) {
            alert("Ha ocurrido un error al guardar la gestión");
        });

    }
};


var ModalContactoCtrl = function ($scope, $modalInstance,$http, idCliente) {
    console.log($modalInstance);
    console.log(idCliente);
    $scope.contactoSeleccionado = {idCliente: idCliente, nombre:'', cargo:'',email:'',fono:'',idContacto:null};
    $scope.master = {idCliente: idCliente, nombre:'', cargo:'',email:'',fono:'',idContacto:null};
    $scope.isUnchanged = function(contacto) {
        return angular.equals(contacto, $scope.master);
    };
    $scope.ok = function () {
        $scope.master = angular.copy($scope.contactoSeleccionado);
        $http({
            url: 'rest/cliente/gestion/guardar-contacto.htm',
            dataType: 'json',
            method: 'POST',
            data: JSON.stringify($scope.contactoSeleccionado),
            headers: {
                "Content-Type": "application/json"
        }}).success(function(data, status, headers, config) {
            $scope.posts = data;
            $modalInstance.close($scope.contactoSeleccionado);
        }).
        error(function(data, status, headers, config) {
            alert("Ha ocurrido un error al guardar");
        });

    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};

var ModalRecaudaCtrl = function ($scope, $modalInstance,$http, params) {
    $scope.contactos = params.contactos;
    $http.get('rest/cliente/gestion/bancos').success(function(data) {
        $scope.bancos = data.body.bancos;
        $scope.formasPago = data.body.formasPago;
        $scope.bancoSeleccionado = $scope.bancos != null && $scope.bancos.length > 0 ? $scope.bancos[0] : null
        $scope.contactoSeleccionado = $scope.contactos != null && $scope.contactos.length > 0 ? $scope.contactos[0] : null
        $scope.formaPagoSeleccionado = $scope.formasPago != null && $scope.formasPago.length > 0 ? $scope.formasPago[0] : null
    });
    $scope.recauda = {fecha:new Date(),pagoLun:false,pagoMar:false,pagoMie:false,pagoJue:false,pagoVie:false}
    $scope.ok = function () {
        console.log($scope.bancoSeleccionado);
        console.log($scope.formaPagoSeleccionado);
        console.log($scope.contactoSeleccionado);
        $scope.recauda.idBanco = $scope.bancoSeleccionado.idBanco;
        $scope.recauda.idContacto = $scope.contactoSeleccionado.idContacto;
        $scope.recauda.idFormaPago = $scope.formaPagoSeleccionado.systemId;
        $modalInstance.close($scope.recauda);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};

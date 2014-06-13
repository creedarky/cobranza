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

        $scope.validarCheck = function(tipo) {
            alert(tipo);
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
                    items: function () {
                        return $scope.documentosSeleccionados;
                    }
                }
            });

            modalInstance.result.then(function (selectedItem) {

            }, function () {
                console.log('Modal dismissed at: ' + new Date());
            });
        };

        $scope.guardar_gestion = function (size,view) {
            alert("adasdad");
        };
}]);

var ModalAgendarCtrl = function ($scope, $modalInstance, items) {
    console.log($modalInstance);
    $scope.documentos = items;
    $scope.fechaAgendada = new Date();
    $scope.observacion = "";
    $scope.cargo = "";
    $scope.contacto = {};

    $scope.today = function() {
        $scope.fechaAgendada = new Date();
    };
    $scope.today();

    $scope.clear = function () {
        $scope.fechaAgendada = null;
    };

    $scope.hstep = 1;
    $scope.mstep = 5;

    $scope.ismeridian = true;
    // Disable weekend selection
    $scope.disabled = function(date, mode) {
        return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
    };

    $scope.toggleMin = function() {
        $scope.minDate = $scope.minDate ? null : new Date();
    };
    $scope.toggleMin();

    $scope.open = function($event) {
        $event.preventDefault();
        $event.stopPropagation();

        $scope.opened = true;
    };

    $scope.dateOptions = {
        formatYear: 'yy',
        startingDay: 1
    };

    $scope.initDate = new Date();
    $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
    $scope.format = $scope.formats[0];
    $scope.changed = function () {
        console.log('Time changed to: ' + $scope.fechaAgendada);
    };
    $scope.ok = function () {
        $modalInstance.close($scope.selected.item);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};

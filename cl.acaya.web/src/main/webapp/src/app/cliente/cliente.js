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
}]);

var ModalAgendarCtrl = function ($scope, $modalInstance, items) {

    $scope.documentos = items;
    $scope.fechaAgendada = new Date();
    $scope.observacion = "";
    $scope.cargo = "";
    $scope.contacto = {};

    $scope.ok = function () {
        $modalInstance.close($scope.selected.item);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};

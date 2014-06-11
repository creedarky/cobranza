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
    data:{ pageTitle: 'What is It?' }
  });
})

    /*

     phonecatControllers.controller('PhoneListCtrl', ['$scope', 'Phone',
     function($scope, Phone) {
     $scope.phones = Phone.query();
     $scope.orderProp = 'age';
     }]);

     phonecatControllers.controller('PhoneDetailCtrl', ['$scope', '$routeParams', 'Phone',
     function($scope, $routeParams, Phone) {
     $scope.phone = Phone.get({phoneId: $routeParams.phoneId}, function(phone) {
     $scope.mainImageUrl = phone.images[0];
     });

     $scope.setImage = function(imageUrl) {
     $scope.mainImageUrl = imageUrl;
     }
     }]);
     */
.controller( 'ClienteCtrl', ['$scope', '$stateParams', '$http',function($scope,$stateParams,$http ) {
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
}]);

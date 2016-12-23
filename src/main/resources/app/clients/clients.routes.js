routes.$inject = ['$stateProvider'];

export default function routes($stateProvider) {
  $stateProvider
    .state('clients', {
      url: '/clients',
      template: require('./clients.html'),
      controller: 'ClientsController',
      controllerAs: 'ctrl'
    })
  
  .state('newClient', {
      url: '/clients/new',
      template: require('./newClient.html'),
      controller: 'NewClientController',
      controllerAs: 'ctrl'
    });
}
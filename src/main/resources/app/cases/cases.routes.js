routes.$inject = ['$stateProvider'];

export default function routes($stateProvider) {
  $stateProvider
    .state('cases', {
      url: '/cases',
      template: require('./cases.html'),
      controller: 'CasesController',
      controllerAs: 'ctrl'
    })
  
  .state('newCase', {
      url: '/cases/new',
      template: require('./newCase.html'),
      controller: 'NewCaseController',
      controllerAs: 'ctrl'
    });
}
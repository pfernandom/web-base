routes.$inject = ['$stateProvider'];

export default function routes($stateProvider) {
  $stateProvider
    .state('timesheets', {
      url: '/timesheets',
      template: require('./timesheets.html'),
      controller: 'TimesheetsController',
      controllerAs: 'ctrl'
    })
  
  .state('newTimesheet', {
      url: '/timesheets/new',
      template: require('./newTimesheet.html'),
      controller: 'NewTimesheetController',
      controllerAs: 'ctrl'
    });
}
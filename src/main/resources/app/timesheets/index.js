import angular from 'angular';
import uirouter from 'angular-ui-router';
import ngMessages from 'angular-messages';

import routing from './timesheets.routes';
import TimesheetsController from './timesheets.controller';
import NewTimesheetController from './newTimesheet.controller';

export default angular.module('app.timesheets', [uirouter, ngMessages])
  .config(routing)
  .controller('TimesheetsController', TimesheetsController)
  .controller('NewTimesheetController', NewTimesheetController)
  .name;
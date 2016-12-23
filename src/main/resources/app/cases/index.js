import angular from 'angular';
import uirouter from 'angular-ui-router';
import ngMessages from 'angular-messages';

import routing from './cases.routes';
import CasesController from './cases.controller';
import NewCaseController from './newCase.controller';

export default angular.module('app.cases', [uirouter, ngMessages])
  .config(routing)
  .controller('CasesController', CasesController)
  .controller('NewCaseController', NewCaseController)
  .name;
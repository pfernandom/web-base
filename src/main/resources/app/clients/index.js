import angular from 'angular';
import uirouter from 'angular-ui-router';
import ngMessages from 'angular-messages';

import routing from './clients.routes';
import ClientsController from './clients.controller';
import NewClientController from './newClient.controller';

export default angular.module('app.clients', [uirouter, ngMessages])
  .config(routing)
  .controller('ClientsController', ClientsController)
  .controller('NewClientController', NewClientController)
  .name;
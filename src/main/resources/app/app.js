import angular from 'angular'
import uirouter from 'angular-ui-router';
import routing from './app.config';
import home from './home';
import about from './about';

import clients from './clients';
import cases from './cases';
import timesheets from './timesheets';

import security from './security';

import { HamMenu } from './nav'


angular.module('app',[uirouter, home, about, cases, timesheets, clients, security])
.config(routing)
.component('hamMenu', HamMenu)
.run(function($rootScope, $http, $window ) {
		
  $rootScope.$on('$stateChangeSuccess', function() {
    console.log("$stateChangeSuccess ");
  });
  
  $http.get('/api/user')
  	.then(resp => {
  		if(!resp.data.details){
  			$window.location.reload();
  		}
  		console.log(resp.data) 
  		$rootScope.$broadcast('userLoaded',resp.data);
  		
  	})
  	.catch(err=>{
  		//$window.location.reload();
  		console.error(err)
  	})

})


.controller('Main',function(){
	var ctrl = this;
	ctrl.hello = "Helloseasd	";
});

angular.bootstrap(document, ['app']);
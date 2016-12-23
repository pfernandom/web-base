export default class NewTimesheetController {
  constructor($http, $state) {
	  var ctrl = this;
	  ctrl.newTimesheet = {};
	  ctrl.title = "";
	  ctrl.description = "";
	  ctrl.$http = $http;
	  ctrl.$state = $state;
	  
	  $http.get('/api/cases')
	  	.then(resp=>{
	  		ctrl.cases = resp.data._embedded.cases;
	  	})
	  	.catch(err=>{
	  		console.error(err);
	  	})
	  
	  $http.get('/api/clients')
	  	.then(resp=>{
	  		ctrl.clients = resp.data._embedded.clients;
	  	})
	  	.catch(err=>{
	  		console.error(err);
	  	})
	  
  }
  
  create(){
	  var ctrl = this;
	  var {$http, $state} = ctrl;
	  
	  $http.post('/api/timesheets', ctrl.newTimesheet)
    	.then(resp=>{    
    		console.log(resp);
    		$state.go("timesheets")
    	})
    	.catch(err=>{
    		console.error(err);
    	})
  }

}

NewTimesheetController.$inject = ['$http', '$state'];
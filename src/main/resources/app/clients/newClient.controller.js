export default class NewClientController {
  constructor($http, $state) {
	  var ctrl = this;
	  ctrl.newClient = {
			  address:{}
	  };
	  ctrl.name = "";
	  ctrl.alias = "";
	  ctrl.$http = $http;
	  ctrl.$state = $state;
	  
	  $http.get('/api/states')
	  	.then(resp=>{
	  		console.log(resp);
	  		ctrl.states = resp.data._embedded.states;
	  	})
	  	.catch(err=>{
	  		console.error(err);
	  	})
  }
  
  create(){
	  var ctrl = this;
	  var {$http, $state} = ctrl;

	  
	  $http.post('/api/clients', ctrl.newClient)
    	.then(resp=>{    		
    		$state.go("clients")
    	})
    	.catch(err=>{
    		console.error(err);
    	})
  }

}

NewClientController.$inject = ['$http', '$state'];
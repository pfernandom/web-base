export default class NewCaseController {
  constructor($http, $state) {
	  var ctrl = this;
	  ctrl.newCase = {};
	  ctrl.title = "";
	  ctrl.description = "";
	  ctrl.$http = $http;
	  ctrl.$state = $state;
  }
  
  create(){
	  var ctrl = this;
	  var {$http, $state} = ctrl;

	  
	  $http.post('/api/cases', ctrl.newCase)
    	.then(resp=>{    		
    		$state.go("cases")
    	})
    	.catch(err=>{
    		console.error(err);
    	})
  }

}

NewCaseController.$inject = ['$http', '$state'];
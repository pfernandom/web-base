export default class CasesController {
  constructor($http) {
    let ctrl = this;
    
    $http.get('/api/cases')
    	.then(resp=>{
    		ctrl.cases = resp.data._embedded.cases;
    	})
    	.catch(err=>{
    		console.error(err);
    	})
    
  }

}

CasesController.$inject = ['$http'];
export default class TimesheetsController {
  constructor($http) {
    let ctrl = this;
    
    $http.get('/api/timesheets')
    	.then(resp=>{
    		console.log(resp);
    		ctrl.timesheets = resp.data._embedded.timesheets;
    	})
    	.catch(err=>{
    		console.error(err);
    	})
    
  }

}

TimesheetsController.$inject = ['$http'];
export default class TimesheetsController {
  constructor($http) {
    let ctrl = this;
    
    $http.get('/api/timesheets')
    	.then(resp=>{
    		ctrl.timesheets = resp.data._embedded.timesheets;
    	})
    	.catch(err=>{
    		console.error(err);
    	})
    
  }

}

TimesheetsController.$inject = ['$http'];
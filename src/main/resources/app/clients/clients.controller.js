export default class ClientsController {
  constructor($http) {
    let ctrl = this;
    
    $http.get('/api/clients')
    	.then(resp=>{
    		ctrl.clients = resp.data._embedded.clients;
    	})
    	.catch(err=>{
    		console.error(err);
    	})
    
  }

}

ClientsController.$inject = ['$http'];
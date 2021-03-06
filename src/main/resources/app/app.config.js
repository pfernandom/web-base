routing.$inject = ['$urlRouterProvider', '$locationProvider'];

export default function routing($urlRouterProvider, $locationProvider) {
  $locationProvider.html5Mode({
	    enabled: true,
	    requireBase: false,
	    rewriteLinks: false
	});
  $urlRouterProvider.otherwise('/');
}
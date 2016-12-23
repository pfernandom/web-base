import angular from 'angular';
import Access from './access.directive'

export default angular.module('app.security', [])
	.directive('access', () => new Access())
	.name;
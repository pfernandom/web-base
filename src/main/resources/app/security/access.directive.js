class Access {
	constructor(){
		 this.restrict = 'A';
		 this.scope = {
				 access:"="
		 }
	}
	compile(tElement,attrs) {
        this.el = tElement;
    }
	controller($scope, $element, $attrs) {
		$element.hide();
		$scope.$on('userLoaded', (e, user) => { 
			for(var i in user.authorities){
				console.log(user.authorities[i]);
				console.log($attrs.access);
				console.log(user.authorities[i].authority == $attrs.access)
				if(user.authorities[i].authority == $attrs.access){
					$element.show();
				}
			}
		})
		 
    }
};

export default Access
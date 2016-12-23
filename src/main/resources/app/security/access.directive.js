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
				if(user.authorities[i].authority == $attrs.access){
					$element.show();
				}
			}
		})
		 
    }
};

export default Access
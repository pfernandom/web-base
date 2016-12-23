import Hamburger from './HamMenu.html'

const HamMenu = {
    bindings: {
        message: '<'
    },
    template:Hamburger,
    controller: function () {
    	this.constructor = () => {
    		//console.log("Constructor");
    	}
    	 this.$onInit = () => {
    		 //console.log("iniit");
	    };
    }
};

export default HamMenu
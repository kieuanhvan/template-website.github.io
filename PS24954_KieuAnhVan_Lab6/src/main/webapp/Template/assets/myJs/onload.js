 window.addEventListener('pageshow', (event) => {
        	    var isNavigation = event.persisted || 
        	        (typeof window.performance != 'undefined' && window.performance.navigation.type === 2);
        	    if (isNavigation) {
        	        window.location.reload();
        	    }
        	});
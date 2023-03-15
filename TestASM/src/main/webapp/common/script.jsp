 <!-- ##### All Javascript Script ##### -->
    <!-- jQuery-2.2.4 js -->
    <script src="<c:url value='/templates/users/js/jquery/jquery-2.2.4.min.js'/>"></script>
    <!-- Popper js -->
    <script src="<c:url value='/templates/users/js/bootstrap/popper.min.js'/>"></script>
    <!-- Bootstrap js -->
    <script src="<c:url value='/templates/users/js/bootstrap/bootstrap.min.js'/>"></script>
    <!-- All Plugins js -->
    <script src="<c:url value='/templates/users/js/plugins/plugins.js'/>"></script>
    <!-- Active js -->
    <script src="<c:url value='/templates/users/js/active.js'/>"></script>
    <script>
    window.addEventListener('pageshow', (event) => {
	    var isNavigation = event.persisted || 
	        (typeof window.performance != 'undefined' && window.performance.navigation.type === 2);
	    if (isNavigation) {
	        window.location.reload();
	    }
	});
    </script>
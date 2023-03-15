
 <script src="${pageContext.request.contextPath}/templates/admins/assets/libs/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="${pageContext.request.contextPath}/templates/admins/assets/libs/popper.js/dist/umd/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/templates/admins/assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="${pageContext.request.contextPath}/templates/admins/assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/templates/admins/assets/extra-libs/sparkline/sparkline.js"></script>
    <!--Wave Effects -->
    <script src="${pageContext.request.contextPath}/templates/admins/dist/js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="${pageContext.request.contextPath}/templates/admins/dist/js/sidebarmenu.js"></script>
    <!--Custom JavaScript -->
    <script src="${pageContext.request.contextPath}/templates/admins/dist/js/custom.min.js"></script>
    <!-- this page js -->
    <script src="${pageContext.request.contextPath}/templates/admins/assets/extra-libs/multicheck/datatable-checkbox-init.js"></script>
    <script src="${pageContext.request.contextPath}/templates/admins/assets/extra-libs/multicheck/jquery.multicheck.js"></script>
    <script src="${pageContext.request.contextPath}/templates/admins/assets/extra-libs/DataTables/datatables.min.js"></script>
    <script>
        /****************************************
         *       Basic Table                   *
         ****************************************/
        $('#zero_config').DataTable();
    </script>
        <script>
    window.addEventListener('pageshow', (event) => {
	    var isNavigation = event.persisted || 
	        (typeof window.performance != 'undefined' && window.performance.navigation.type === 2);
	    if (isNavigation) {
	        window.location.reload();
	    }
	});
    </script>
    
    
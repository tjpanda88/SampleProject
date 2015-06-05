$(document).ready(function() {

	$('#manager_user_table').dataTablesEditor( {
	    url: "/managerUser",
	    dataTableConfig :  {
		    ajax: "/managerUser?action=load",
	        columns: [
	            { data: "id" },
	            { data: "name" },
	            { data: "roleId" },
	            { data: "registerDate" }
	        ]
		}
	} );


} );
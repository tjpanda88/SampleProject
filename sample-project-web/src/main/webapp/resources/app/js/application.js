$(document).ready(function() {

	//var editor = new $.fn.dataTable.Editor( {} );

	var editor = new $.fn.dataTable.Editor( {
	    ajax:  '/managerUser',
	    table: '#manager_user_table',
	    fields: [
	        { label: 'First name', name: 'first_name' },
	        { label: 'Last name',  name: 'last_name'  },
	        // etc
	    ]
	} );

	$('#manager_user_table').DataTable( {
	    dom:  'Tfrtip',
	    ajax: "/managerUser/load",
        columns: [
            { data: null, render: function ( data, type, row ) {
                // Combine the first and last names into a single table field
                return "1";
            } },
            { data: "" },
            { data: "type" },
            { data: "name" },
            { data: "" }
        ],
	    tableTools: {
	        sRowSelect: 'os',
	        aButtons: [
	            { sExtends: 'editor_create', editor: editor },
	            { sExtends: 'editor_edit',   editor: editor },
	            { sExtends: 'editor_remove', editor: editor }
	        ]
	    }
	} );
} );
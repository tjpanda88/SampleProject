$(document).ready(function() {

	var editor = new $.fn.dataTable.Editor( {} );

	new $.fn.dataTable.Editor( {
	    ajax:  '/api/staff',
	    table: '#staff',
	    fields: [
	        { label: 'First name', name: 'first_name' },
	        { label: 'Last name',  name: 'last_name'  },
	        // etc
	    ]
	} );

	$('#manager_user_table').DataTable( {
	    dom:  'Tfrtip',
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
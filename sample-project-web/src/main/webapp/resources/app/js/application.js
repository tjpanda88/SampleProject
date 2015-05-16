$(document).ready(function() {

	//var editor = new $.fn.dataTable.Editor( {} );

	var editor = new $.fn.dataTable.Editor( {
		ajax: '/managerUser/edit',
	    table: '#manager_user_table',
	    fields: [
	        { label: '用户名', name: 'id' },
	        { label: '姓名',  name: 'name'  },
	        { label: '权限',  name: 'roleId'  }
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
            { data: "roleId" },
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
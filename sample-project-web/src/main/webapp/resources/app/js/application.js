$(document).ready(function() {


	$('#manager_user_table').DataTable( {
	    ajax: "/managerUser?action=load",
        columns: [
            { data: "id" },
            { data: "name" },
            { data: "roleId" },
            { data: "registerDate" }
        ]
	} );

	$("#createUser").click(function(){
		$('#manager_user_table_editor').modal('show');
		$('.alert').hide();
	})

	$("#manager_user_table_editor_create").click(function(){
		$.ajax({
            type: "POST",
            dataType: "json",
            url: "/managerUser?action=create",
            data: $('#manager_user_table_editor_form').serialize(),
            success: function (result) {
            	dataTableEditorCreate(result,"manager_user_table")
            },
            error: function(data) {
                alert("error:"+data.responseText);
             }
        });
	})

} );

function dataTableEditorCreate(resultObject, dataTableId) {
	if(resultObject.fieldErrors != null) {
		$.each(resultObject.fieldErrors, function(index,element){
			var id = dataTableId + "_editor_form_" + element.name;
			alert(id);
			$("#" + id).text(element.status);
			$("#" + id).show();
		})
	} else if(resultObject.row != null) {
		$('#' + dataTableId).DataTable().row.add(resultObject.row).draw();

		$('#'  + dataTableId + '_editor').modal('hide');

	}
}
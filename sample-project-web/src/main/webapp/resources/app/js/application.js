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

	$('#manager_user_table tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
        	$('#manager_user_table').DataTable().$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );

	$("#createUser").click(function(){
		$('#manager_user_table_editor').modal('show');
		$('.alert').hide();
	})

	$("#removeUser").click(function(){
		var table = $('#manager_user_table').DataTable();
		var selectRow = table.row('.selected');

		if(selectRow.length == 0) {
			bootbox.alert("请选择一条记录");
		} else {
			bootbox.confirm("真的要删除这条记录吗？", function(result){
				if(!result) {
					return;
				}
				var selectRowData = selectRow.data();
				dataTableEditorConvert(selectRowData,"manager_user_table");
				$.ajax({
		            type: "POST",
		            dataType: "json",
		            url: "/managerUser?action=remove",
		            data: $('#manager_user_table_editor_form').serialize(),
		            success: function (result) {
		            	table.row('.selected').remove().draw( false );
		            },
		            error: function(data) {
		                alert("error:"+data.responseText);
		             }
		        });
			});
		}
	})

	$("#editUser").click(function(){
		var table = $('#manager_user_table').DataTable();
		var selectRow = table.row('.selected');

		if(selectRow.length == 0) {
			bootbox.alert("请选择一条记录");
		} else {

			var selectRowData = selectRow.data();
			dataTableEditorConvert(selectRowData,"manager_user_table");
			$('#manager_user_table_editor').modal('show');
			$('.alert').hide();

			$('#manager_user_table_editor_create').hide();

		}
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

	$("#manager_user_table_editor_edit").click(function(){
		$.ajax({
            type: "POST",
            dataType: "json",
            url: "/managerUser?action=edit",
            data: $('#manager_user_table_editor_form').serialize(),
            success: function (result) {
            	dataTableEditorEditor(result,"manager_user_table")
            },
            error: function(data) {
                alert("error:"+data.responseText);
             }
        });
	})


} );

function dataTableEditorConvert(resultObject, dataTableId){

	for(var name in resultObject) {
		var id = dataTableId + "_editor_form_" + name;
		$("#" + id).val(resultObject[name]);
	}
}

function dataTableEditorCreate(resultObject, dataTableId) {
	if(resultObject.fieldErrors != null) {
		$.each(resultObject.fieldErrors, function(index,element){
			var id = dataTableId + "_editor_form_error_" + element.name;
			alert(id);
			$("#" + id).text(element.status);
			$("#" + id).show();
		})
	} else if(resultObject.row != null) {
		$('#' + dataTableId).DataTable().row.add(resultObject.row).draw();

		$('#'  + dataTableId + '_editor').modal('hide');

	}
}

function dataTableEditorEditor(resultObject, dataTableId) {

	var table = $('#manager_user_table').DataTable();
	if(resultObject.fieldErrors != null) {
		$.each(resultObject.fieldErrors, function(index,element){
			var id = dataTableId + "_editor_form_error_" + element.name;
			alert(id);
			$("#" + id).text(element.status);
			$("#" + id).show();
		})
	} else if(resultObject.row != null) {
		table.row('.selected').data(resultObject.row).draw( false );

		$('#'  + dataTableId + '_editor').modal('hide');

	}
}
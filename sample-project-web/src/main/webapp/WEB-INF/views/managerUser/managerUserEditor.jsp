<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/include.jsp" %>
<!-- Modal -->
<div class="modal fade" dataTablesEditorRole="modal" data-target="manager_user_table" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">用户信息</h4>
      </div>
      <div class="modal-body">
        <form action="" dataTablesEditorRole="form" data-target="manager_user_table">
	        <div class="form-group">
	            <label for="recipient-name" class="control-label">用户ID</label>
	            <input type="text" class="form-control" name="data[id]" dataTablesEditorRole="modal.input" data-target="id" data-readonly="edit">
	            <div class="alert alert-danger" role="alert" dataTablesEditorRole="modal.error" data-target="id"></div>
	        </div>

	        <div class="form-group">
	            <label for="recipient-name" class="control-label">用户名</label>
	            <input type="text" class="form-control" name="data[name]" dataTablesEditorRole="modal.input" data-target="name">
	            <div class="alert alert-danger" role="alert" dataTablesEditorRole="modal.error" data-target="name"></div>
	        </div>

	        <div class="form-group">
	            <label for="recipient-name" class="control-label">角色</label>
	            <input type="text" class="form-control" name="data[roleId]" dataTablesEditorRole="modal.input" data-target="roleId">
	            <div class="alert alert-danger" role="alert" dataTablesEditorRole="modal.error" data-target="roleId"></div>
	        </div>

	        <div class="form-group">
	            <label for="recipient-name" class="control-label">密码</label>
	            <input type="password" class="form-control" name="data[password]" dataTablesEditorRole="modal.input" data-target="password">
	            <div class="alert alert-danger" role="alert" dataTablesEditorRole="modal.error" data-target="password"></div>
	        </div>

        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-hide="edit" dataTablesEditorRole="button" data-target="manager_user_table" data-action="modalCreate">追加</button>
        <button type="button" class="btn btn-primary" data-hide="create" dataTablesEditorRole="button" data-target="manager_user_table" data-action="modalEdit">修正</button>
      </div>
    </div>
  </div>
</div>
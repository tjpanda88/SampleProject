<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/include.jsp" %>
<!-- Modal -->
<div class="modal fade" id="manager_user_table_editor" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">用户信息</h4>
      </div>
      <div class="modal-body">
        <form action="" id="manager_user_table_editor_form">
	        <div class="form-group">
	            <label for="recipient-name" class="control-label">用户ID</label>
	            <input type="text" class="form-control" name="data[id]" id="manager_user_table_editor_form_id">
	            <div class="alert alert-danger" role="alert" id="manager_user_table_editor_form_error_id" ></div>
	        </div>

	        <div class="form-group">
	            <label for="recipient-name" class="control-label">用户名</label>
	            <input type="text" class="form-control" name="data[name]" id="manager_user_table_editor_form_name">
	            <div class="alert alert-danger" role="alert" id="manager_user_table_editor_form_error_name" ></div>
	        </div>

	        <div class="form-group">
	            <label for="recipient-name" class="control-label">角色</label>
	            <input type="text" class="form-control" name="data[roleId]" id="manager_user_table_editor_form_roleId">
	            <div class="alert alert-danger" role="alert" id="manager_user_table_editor_form_error_roleId" ></div>
	        </div>

	        <div class="form-group">
	            <label for="recipient-name" class="control-label">密码</label>
	            <input type="password" class="form-control" name="data[password]" id="manager_user_table_editor_form_password">
	            <div class="alert alert-danger" role="alert" id="manager_user_table_editor_form_error_password" ></div>
	        </div>

        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="manager_user_table_editor_create">追加</button>
        <button type="button" class="btn btn-primary" id="manager_user_table_editor_edit">修正</button>
      </div>
    </div>
  </div>
</div>
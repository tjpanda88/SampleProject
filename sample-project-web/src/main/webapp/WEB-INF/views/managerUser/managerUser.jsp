<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/include.jsp" %>
<%@ include file="/WEB-INF/views/managerUser/managerUserEditor.jsp" %>
<h1 class="page-header">Dashboard</h1>

<div class="row placeholders">
	<table id="manager_user_table"
		class="table table-striped table-bordered bootstrap-datatable datatable responsive">
		<thead>
			<tr>
				<th>用户名</th>
				<th>姓名</th>
				<th>角色</th>
				<th>注册日期</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
<button type="button" id="createUser">Launch modal</button>
	<a class="btn btn-info" href="#"> <i
						class="glyphicon glyphicon-edit icon-white"></i> 编辑用户
				</a> <a class="btn btn-danger" href="#"> <i
						class="glyphicon glyphicon-trash icon-white"></i> 删除用户
				</a>
</div>

<h2 class="sub-header">Section title</h2>
<div class="table-responsive">试验2</div>




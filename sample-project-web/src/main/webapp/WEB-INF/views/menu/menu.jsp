<%@ include file="/WEB-INF/views/common/include.jsp" %>
<div class="container">
	<div class="span-24 last">
		<form action="${pageContext.request.contextPath}/searchuser/search"
			method="get">
			<fieldset class="notice">
				<div class="span-5">
					<input id="searchTourBtn" style="width: 150px;" type="submit"
						value="<spring:message code="label.tr.menu.searchBtnMessage" />">
				</div>
				<div class="span-18 last">
					<p>
						<spring:message code="label.tr.menu.userSearchMessage" />
					</p>
				</div>
				<input type="hidden" name="form" />
			</fieldset>
		</form>
		
		<form
				action="${pageContext.request.contextPath}/adduser/create"
				method="get">
				<fieldset class="notice">
					<div class="span-5">
						<input id="customerRegisterBtn" style="width: 150px;" type="submit"
							value="add user">
					</div>
					<div class="span-18 last">
						<p>
							AddUser
						</p>
					</div>
					<input type="hidden" name="form" />
				</fieldset>
			</form>
	</div>
</div>

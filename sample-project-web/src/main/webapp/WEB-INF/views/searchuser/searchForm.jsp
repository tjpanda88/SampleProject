<%@ include file="/WEB-INF/views/common/include.jsp" %>
<div class="container">
	<h2 id="screenName">
		User Search
	</h2>
	<div class="info">
		<p><strong>User Search</strong></p>
	</div>
	<div class="span-24 last">
		<form:form method="get" modelAttribute="searchUserForm" cssClass="inline">
			<fieldset>
				<legend>
					Search Conditions
				</legend>
				<form:errors path="*" cssClass="error" element="div" />
				<div class="span-14">
					<form:label path="searchId">
						ID:
					</form:label><form:input path="searchId"/>
					<form:label path="searchName">
						Name:
					</form:label><form:input path="searchName"/>
				</div>
				<div class="span-8 last">
					UserName And Password
				</div>
				<div class="span-14">
					<form:label path="searchType">
						Type:
					</form:label>
					<form:select path="searchType">
						<form:option value="" label="No Selected" />
						<form:option value="1" label="Normal User" />
						<form:option value="2" label="Manager" />
					</form:select>
				</div>
				<div class="span-8 last">
					UserType
				</div>
				<div class="span-24 last">
					<input id="searchBtn" type="submit"
						name="search"
						value="<spring:message code="label.tr.common.search" />">
				</div>
			</fieldset>
		</form:form>
	</div>
	<hr>
	<c:if test="${page != null}">
		
		<table id="UserTable">
			<caption>
				UserTable
			</caption>
			<thead>
				<tr>
					<th>Index</th>
					<th>ID</th>
					<th>Name</th>
					<th>Type</th>
				</tr>
			</thead>
			<c:forEach var="userInfo" items="${page.content}" varStatus="sts">
				<tr>
					<td>${page.number * page.size + sts.index + 1}</td>
					<td>${userInfo.id}</td>
					<td>${userInfo.name}</td>
					<td>${userInfo.type}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</div>

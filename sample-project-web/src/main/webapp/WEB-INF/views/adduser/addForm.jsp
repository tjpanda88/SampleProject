<%@ include file="/WEB-INF/views/common/include.jsp" %>
<div class="container">
	<h2 id="screenName">
		Add Search
	</h2>
	<div class="info">
		<p><strong>Add Search</strong></p>
	</div>
	<div class="span-24 last">
		<form:form method="get" modelAttribute="addUserForm" cssClass="inline">
			<fieldset>
				<legend>
					Search Conditions
				</legend>
				<form:errors path="*" cssClass="error" element="div" />
				<div class="span-14">
					<form:label path="id">
						ID:
					</form:label><form:input path="id"/>
					<form:label path="name">
						Name:
					</form:label><form:input path="name"/>
					<form:label path="password">
						Password:
					</form:label><form:input path="password"/>
				</div>
				<div class="span-8 last">
					UserName And Password
				</div>
				<div class="span-14">
					<form:label path="type">
						Type:
					</form:label>
					<form:select path="type">
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
						name="add"
						value="Add User">
				</div>
			</fieldset>
		</form:form>
	</div>
</div>

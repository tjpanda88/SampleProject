<%@ include file="/WEB-INF/views/common/include.jsp" %>
<%@ pagepageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1">

	<%@ include file="/WEB-INF/views/common/includeCss.jsp" %>
	<%@ include file="/WEB-INF/views/common/includeJavascript.jsp" %>

    <!-- The fav icon -->
    <link rel="shortcut icon" href="img/favicon.ico">

	<title><tiles:insertAttribute name="title" /></title>
</head>

<body>
	<tiles:insertAttribute name="header" />
	<div class="container-fluid">
		<div class="row">
			<tiles:insertAttribute name="menu" />
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>
	<tiles:insertAttribute name="footer" />
</body>
</html>
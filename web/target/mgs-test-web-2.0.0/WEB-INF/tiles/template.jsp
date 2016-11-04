<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link rel="stylesheet" href="<c:url value="/bootstrap/css/bootstrap.min.css"/>">
<%-- <link rel="stylesheet" href="<c:url value="/bootstrap/css/bootstrap-theme.min.css"/>" > --%>
<link rel="stylesheet" href="<c:url value="/css/app.css"/>">
<!--[if lt IE 9]>
<script src="<c:url value="/bootstrap/js/html5shiv.min.js"/>"></script>
<script src="<c:url value="/bootstrap/js/respond.min.js"/>"></script>
<![endif]-->
<script src="<c:url value="/bootstrap/js/jquery-1.10.2.min.js"/>"></script>
<script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/bootstrap/js/bootbox.min.js"/>"></script>
<script src="<c:url value="/js/app.js"/>"></script>
<script src="<c:url value="/js/${page}.js"/>"></script>
<title>mgs-test <tiles:getAsString name="title" /></title>
</head>
<body>
	<!-- Fixed navbar -->
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<tiles:insertAttribute name="navbar" />
	</div>

	<div class="container">
		<!-- Main component for a primary marketing message or call to action -->
		<tiles:insertAttribute name="content" />
		<hr>
		<footer>
			<p>&copy; Company 2014</p>
		</footer>
	</div>

	<div class="loading" style="display:none"></div>
</body>
</html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<html>
<head>
<script src="<c:url value='/js/jquery-1.8.3.min.js'/>"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {		
		window.location.href="<%=request.getContextPath()%>/index.htm";
	});
</script>
</head>
<body>
<h2> 
</h2>
</body>
</html>
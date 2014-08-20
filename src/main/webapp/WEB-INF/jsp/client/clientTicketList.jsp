<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<body>
<%
	String customerId = request.getParameter("customerId");
	if(customerId == null){
%>
	<script type="text/javascript">
		window.location.href = "<%=request.getContextPath()%>/login.htm";
	</script>
<%
	}else{
%>
	<form action='ticket.htm' id="form1" name='form1' method='POST'>
		<input name='customerId' type='hidden' value="<%=customerId%>"/>
	</form>
	<script type="text/javascript">
		document.getElementById("form1").submit();
	</script>
<%		
	}
%>

</body>

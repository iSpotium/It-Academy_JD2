<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body style="background-color:DarkGray;">
<center>
    <fieldset style="width:450px;
color:Lavender; background-color:Black"
align="center">
<p> <style="color:Lavender;"> Change account data &#128373
</p>
	<table>
    	<td>
    	<button onclick="location.href='${pageContext.request.contextPath}/updatePassword'" method="post"> Change password
	</button>
    </td>
    <td>
    <button onclick="location.href='${pageContext.request.contextPath}/updateEmail'" method="post"> Change email
	</button>
    </td>
    <td>
    	<button onclick="location.href='${pageContext.request.contextPath}/updateName'" method="post"> Change user name
	</button>
    </td>
     <td>
    	<button onclick="location.href='${pageContext.request.contextPath}/welcome'" method="get"> Back
	</button>
    </td>
    <td>
    	<button onclick="location.href='${pageContext.request.contextPath}/logout'" method="post"> Logout
	</button>
    </td>
      </table>
    </fieldset>
 </center>
 <div>
 <center>
 <fieldset style="width:450px;
color:Lavender; background-color:Black"
align="center">
 <p> <style="color:Lavender;"> View my data &#128373
</p>
	<table>
 	<form action="${pageContext.request.contextPath}/viewMyData" method="post">
        <p><input type = "submit" value="View my data"/></p>
   </form>
 </table>
 </fieldset>
 </center>
</div>
 <div>
<center>
<c:if test="${loggedInUserRole=='ADMIN'}">
<fieldset style="width:450px;
color:Lavender; background-color:Black"
align="center">
<p> <style="color:Lavender;"> Special abilities
</p>
    <form action="${pageContext.request.contextPath}/viewUsers" method="get">
         <p><input type = "submit" value="View users"/></p>
     </form>
    <td>
</fieldset>
</c:if>
 </center>
 </div>
</body>
</html>
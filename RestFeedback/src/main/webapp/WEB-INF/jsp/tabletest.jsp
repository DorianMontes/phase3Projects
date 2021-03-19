<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<h2>Feedback</h2>

<table style="float:left">
   	<tr>
   		<th>User</th>
   		<th>Rating</th>
   		<th>Comments</th>
   	</tr>
   <c:forEach items="${tabletest}" var="feedback">
    <tr>
        <td>${feedback.user}</td>
        <td>${feedback.rating}</td>
        <td>${feedback.comments}</td>
    </tr>
  </c:forEach>
</table>


</body>
</html>
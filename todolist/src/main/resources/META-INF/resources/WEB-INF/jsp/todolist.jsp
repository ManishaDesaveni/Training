

<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>


<div class="container">

<h2>Your todos</h2>
<table class="table">
<thead>
<tr>
<th>Description</th><th>TargetDate</th><th>?Done</th><th></th><th></th>
</tr>
</thead>
<tbody>
<c:forEach items="${todos}" var="todo">
<tr>
<td>${todo.description}</td>
<td>${todo.targetdate}</td>
<td>${todo.done}</td>
<td><a href="todo-delete?id=${todo.id}" class="btn btn-warning" >DELETE ${todo.id }</a></td>
<td><a href="todo-update?id=${todo.id}" class="btn btn-success" >UPDATE ${todo.id }</a></td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="add-todo" class="btn btn-success">AddTodo</a>
</div> 
<%@include file="common/footer.jspf"%>
<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
<div class="container">
<h1>Enter details</h1>
<form:form method="post" modelAttribute="todo" >

<fieldset class="mb-3">
<form:label path="description">Description</form:label>
<form:input type="text" path="description" required="required"/>
<form:errors path="description" cssClass="text-warning"/>
</fieldset>

<fieldset class="mb-3">
<form:label path="targetdate">targetDate</form:label>
<form:input type="text" path="targetdate" required="required"/>
<form:errors path="description" cssClass="text-warning"/>
</fieldset>

<form:input type="hidden" path="id" required="required"/></br>
<form:input type="hidden" path="done" required="required"/></br>
<input type="submit"/>
</form:form>
</div>
<%@include file="common/footer.jspf" %>
<script type="text/javascript">
$('#targetdate').datepicker({
    format: 'yyyy-mm-dd',
    startDate: '-3d'
});
</script>
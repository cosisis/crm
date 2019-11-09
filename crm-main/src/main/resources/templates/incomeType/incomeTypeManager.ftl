<html lang="en">

<body>

<form action="/crm/incomeType/save">

    ID：<input type="text" name="id"><br/>
    type_name:<input type="text" name="type_name"><br/>
    <input type="submit" name="submitBon" value="保 存">
</form>

<#list list as type>
	${type.type_name}
</#list>

</body>

</html>
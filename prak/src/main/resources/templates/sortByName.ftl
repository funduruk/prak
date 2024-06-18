<!DOCTYPE html>
<html>
<head>
    <title>Sort User List</title>
</head>
<body>
<h1>Sort User List</h1>
<ul>
    <#assign sortedStudents = students?sort_by("firstname")>
    <#list sortedStudents as student>
        <li>${student.firstname} | ${student.middlename} | ${student.lastname} | ${student.email} | ${student.status}</li>
    </#list>
</ul>

<form action="/userlist" method="get">
    <input type="submit" value="Вернуться">
</form>

<form action="/" method="get">
    <input type="submit" value="Главная страница">
</form>
</body>
</html>

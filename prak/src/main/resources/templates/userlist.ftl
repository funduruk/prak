<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h1>User List</h1>
<form action="/sortByName" method="get">
    <input type="submit" value="Отсортировать">
</form>
<ul>
    <#list students as student>
        <li>${student}</li>
    </#list>
</ul>

<form action="/findByEmail" method="get">
    <input type="email" name="email" placeholder="Введите почту">
    <button type="submit">Отправить</button>
</form>

<form action="/" method="get">
    <button type="submit">Вернуться</button>
</form>

<form action="/less25" method="get">
    <button type="submit">Моложе 25</button>
</form>
<form action="/endingStudents" method="get">
    <button type="submit">Окончившие студенты</button>
</form>

<form action="/emptyNumber" method="get">
    <button type="submit">Пустые номера</button>
</form>

<form action="/generate" method="get">
    <input type="number" name="id" placeholder="Напишите ID студента">
    <button type="submit">скачать инфоормацию о студенте</button>
</form>

</body>
</html>

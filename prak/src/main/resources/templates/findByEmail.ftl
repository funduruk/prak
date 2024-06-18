<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Найденные студенты</title>
</head>
<body>
<h2>Студенты с почтовым адресом ${email}:</h2>
<ul>
    <#if student??>
        <li>Студент: ${student.lastname} | ${student.firstname} | ${student.middlename} | ${student.phonenumber} | ${student.email} | ${student.status}</li>

    <#else>
        <li>Студенты не найдены</li>
    </#if>
</ul>
</body>
</html>

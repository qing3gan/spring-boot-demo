<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图书列表</title>
</head>
<body>
<table>
    <tr>
        <td>图书名称</td>
        <td>图书作者</td>
        <td>图书价格</td>
    </tr>
    <#if books ??&&(books?size>0)>
    <#list books as book>
    <tr>
        <td>${book.name}</td>
        <td>${book.author}</td>
        <td>${book.price}</td>
    </tr>
    </#list>
    </#if>
</table>
</body>
</html>
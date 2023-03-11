<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8" />
    <title></title>
</head>
<body>
${name}

<#if sex=='0'>
    男
    <#elseif sex=='1'>
    女
        <#else>
    其它
</#if>

<#if age gte 18>
    已经成年了
    <#else>
    未成年

</#if>


<#list userlist as user>
    ${user}
</#list>
</body>
</html>
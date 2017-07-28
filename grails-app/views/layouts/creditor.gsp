<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="creditor"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:stylesheet src="application.css"/>
    <g:layoutHead/>
</head>
<body>
    <div class="container">
        <table>
        <tr>
            <td>
                <label>Какую сумму Вы хотите положить?</label>
            </td>
        </tr>
        <tr>
            <td>
                <g:textField name="sum" value="${creditor?.sum}" />
            </td>
        </tr>
        </table>
        <br/><br/><br/>
        <g:actionSubmit value="Положить деньги" action="putMoney" />
    </div>
</body>
</html>
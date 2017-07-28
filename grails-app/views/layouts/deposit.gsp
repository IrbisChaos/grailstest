<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="deposit"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:stylesheet src="application.css"/>
    <g:layoutHead/>
</head>
<body>
    <div class="container">
        <label>Пополните счет на сумма займа / на 4</label>
        <br/><br/><br/>
        <table>
        <tr>
            <td>
                <label>Сумма для пополнения</label>
            </td>
        </tr>
        <tr>
            <td>
                <g:textField name="sum" value="${deposit?.sum}" />
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td>
                <label>Номер карты</label>
            </td>
        </tr>
        <tr>
            <td>
                <g:textField name="depositCardNoPart1" value="${deposit?.card?.NoPart?.part[0]}" />
            </td>
            <td>
                <g:textField name="depositCardNoPart2" value="${deposit?.card?.NoPart?.part[1]}" />
            </td>
            <td>
                <g:textField name="depositCardNoPart3" value="${deposit?.card?.NoPart?.part[2]}" />
            </td>
            <td>
                <g:textField name="depositCardNoPart4" value="${deposit?.card?.NoPart?.part[3]}" />
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td>
                <label>Код</label>
            </td>
        </tr>
        <tr>
            <td>
                <g:textField name="depositCardCodeCVC" value="${deposit?.card?.codeCVC}" />
            </td>
        </tr>
        </table>
        <br/><br/><br/>
        <g:actionSubmit value="Пополнить счет" action="depositMoney" />
    </div>
</body>
</html>
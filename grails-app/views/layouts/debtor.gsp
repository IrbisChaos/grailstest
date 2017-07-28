<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="debtor"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:stylesheet src="application.css"/>
    <g:layoutHead/>
    <%@page import="calc.Rule" %>
</head>
<body>
    <div class="container">
        <table>
        <tr>
            <td>
                <label>Какую сумму Вы хотите получить?</label>
            </td>
        </tr>
        <tr>
            <td>
                <g:textField name="sumGet" value="${debtor?.sumGet}" />
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td>
                <label>На какой срок Вы хотите одолжить средства?</label>
            </td>
        </tr>
        <tr>
            <td>
                <g:textField name="timeLimit" value="${debtor?.timeLimit}" />
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td>
                <label>Проценты по займу за ${debtor?.timeLimit} дней составят ${Rule.sumPercentTime(${debtor?.sum}, ${debtor?.timeLimit})} рублей</label>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td>
                <label>Сумма к возврату составит ${debtor?.sumBack()} рублей</label>
            </td>
        </tr>
        </table>
        <br/><br/><br/>
        <g:actionSubmit value="Получить деньги" action="getMoney" />
    </div>
</body>
</html>
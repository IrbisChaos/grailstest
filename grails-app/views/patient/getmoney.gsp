<html>
<head>
    <asset:javascript src="application.js"/>
    <asset:stylesheet src="application.css"/>
    <%@page import="calc.Rule" %>
</head>
<body>
    <div class="container">
        <table>
        <tr>
            <td>
                <label>Поздравляем! Вы получили в долг</label>
            </td>
        </tr>
        <tr>
            <td>
                <label id="lblPay">${actor?.actorRole?.sum} рублей</label>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td>
                <label>На срок</label>
            </td>
        </tr>
        <tr>
            <td>
                <label id="lblTime">${actor?.actorRole?.timeLimit} дней</label>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td>
                <label id="lblEnd">Сумма к возврату в конце срока кредитования составит ${actor?.actorRole?.sumBack} рублей</label>
            </td>
        </tr>
        </table>
        <br/><br/><br/>
        <g:link controller="card" action="putmoney" params="[actor: actor]">Вывести средства на свою карту</g:link>
    </div>
</body>
</html>
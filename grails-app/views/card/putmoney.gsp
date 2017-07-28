<html>
<%@page import="calc.Rule" %>
<head>
    <meta name="layout" content="main" />
    <asset:javascript src="application.js"/>
    <asset:javascript src="jquery.browser.min.js"/>
    <asset:javascript src="jquery.maskedinput-1.3.min.js"/>
    <asset:javascript src="putmoney.js"/>
    <title></title>
</head>
<body>
    <div class="container">
    <g:hasErrors bean="${user}">
      <ul>
       <g:eachError var="err" bean="${user}">
           <li>${err}</li>
       </g:eachError>
      </ul>
    </g:hasErrors>
	<card:ifPatient>
        <label>Пополните счет на сумма займа ${actor?.actorRole?.sum}</label>
    </card:ifPatient>
        <br/><br/><br/>
        <table>
        <tr>
            <td>
                <label>Сумма для пополнения</label>
            </td>
        </tr>
        <tr>
            <td>
                <g:textField name="sum" value="${actor?.actorRole?.sum}" />
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
                <g:textField id="actorCardnoPart1" name="actorCardnoPart1" value="${actor?.card?.noPart?.part[0]}" />
            </td>
            <td>
                <g:textField id="actorCardnoPart2" name="actorCardnoPart2" value="${actor?.card?.noPart?.part[1]}" />
            </td>
            <td>
                <g:textField id="actorCardnoPart3" name="actorCardnoPart3" value="${actor?.card?.noPart?.part[2]}" />
            </td>
            <td>
                <g:textField id="actorCardnoPart4" name="actorCardnoPart4" value="${actor?.card?.noPart?.part[3]}" />
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td>
                <label>CVS-код</label>
            </td>
        </tr>
        <tr>
            <td>
                <g:textField id="actorCardCodeCVC" name="actorCardCodeCVC" value="${actor?.card?.codeCVC}" />
            </td>
        </tr>
        </table>
        <br/><br/><br/>
        <g:form name="putMoneyForm">
            <g:actionSubmit value="Пополнить счет" controller="card" action="actorMoney"/>
        </g:form>
    </div>
</body>
</html>
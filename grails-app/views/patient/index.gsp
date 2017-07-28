<html>
<%@page import="calc.Rule" %>
<head>
    <meta name="layout" content="main" />
    <asset:javascript src="application.js"/>
    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="simple-slider.css"/>
    <title></title>
</head>
<body>
    <div class="container">
        <g:form name="patientMainForm">
            <input id="txtConsist" type="hidden" name="txtConsist" value="составят "></input>
            <input id="txtRubles" type="hidden" name="txtRubles" value=" рублей "></input>
            <table>
            <tr>
                <td>
                    <label>Какую сумму Вы хотите получить?</label>
                </td>
            </tr>
            <tr>
                <td>
                    <g:textField id="sumGet" name="sumGet" value="${debtor?.sum}" onchange="${remoteFunction(action: 'recalcSumPercentPortion', update: 'lblSumPercentPortion', params:'\'sumGet=\' + document.getElementById(\'sumGet\').value + \'&timeLimit=\' + document.getElementById(\'timeLimitTxt\').value +  \'&txtConsist=\' + document.getElementById(\'txtConsist\').value +  \'&txtRubles=\' + document.getElementById(\'txtRubles\').value')};${remoteFunction(action: 'recalcSumBack', update: 'lblSumBack', params:'\'sumGet=\' + document.getElementById(\'sumGet\').value + \'&timeLimit=\' + document.getElementById(\'timeLimitTxt\').value +  \'&txtRubles=\' + document.getElementById(\'txtRubles\').value')};"/> рублей
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
                    <g:textField id="timeLimitTxt" name="timeLimit" value="${debtor?.timeLimit}" onchange="${remoteFunction(	action: 'recalcSumPercentPortion', 	update: 'lblSumPercentPortion', 	params:'\'sumGet=\' + document.getElementById(\'sumGet\').value + \'&timeLimit=\' + document.getElementById(\'timeLimitTxt\').value +  \'&txtConsist=\' + document.getElementById(\'txtConsist\').value +  \'&txtRubles=\' + document.getElementById(\'txtRubles\').value')};	${remoteFunction(action: 'recalcSumBack', update: 'lblSumBack', params:'\'sumGet=\' + document.getElementById(\'sumGet\').value + \'&timeLimit=\' + document.getElementById(\'timeLimitTxt\').value +  \'&txtRubles=\' + document.getElementById(\'txtRubles\').value')};${remoteFunction(action: 'refillTimeLimit', update: 'timeLimitLbl', params:'\'&timeLimit=\' + document.getElementById(\'timeLimitTxt\').value')};"/> дней
                </td>
            </tr>
            <tr></tr>
            <tr>
                <td>
                    Проценты займа за <label id="timeLimitLbl">${debtor?.timeLimit}</label> дней
                </td>
                <td>
                    <label class="patientBolded" id="lblSumPercentPortion">составят ${Rule.sumPercentPortion(debtor?.sum, debtor?.timeLimit)} рублей</label>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Сумма к возврату составит</label>
                </td>
                <td>
                    <label class="patientBolded" id="lblSumBack">${Rule.sumBack(debtor?.sum, debtor?.timeLimit)} рублей</label>
                </td>
            </tr>
            </table>
            <br/><br/><br/>
            <g:actionSubmit value="Получить деньги" action="putmoney"/>
        </g:form>
    </div>

      <h2>Range &amp; Steps</h2>
      <input type="text" data-slider="true" data-slider-range="1000,100000" data-slider-step="0.01">
</body>
</html>
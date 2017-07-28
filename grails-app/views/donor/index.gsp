<html>
<body>
    <div class="container">
        <g:form name="donorMainForm">
            <table>
            <tr>
                <td>
                    <label>Какую сумму Вы хотите положить?</label>
                </td>
            </tr>
            <tr>
                <td>
                    <g:textField name="sum" value="${creditor?.sum}">  </g:textField> рублей
                </td>
            </tr>
            </table>
            <br/><br/><br/>
            <g:actionSubmit value="Положить деньги" action="putmoney"/>
        </g:form>
    </div>
</body>
</html>
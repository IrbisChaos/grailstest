$( document ).ready(function() {
    $("#actorCardnoPart1").mask("9999");
    $("#actorCardnoPart2").mask("9999");
    $("#actorCardnoPart3").mask("9999");
    $("#actorCardnoPart4").mask("999?999");
    $("#actorCardCodeCVC").mask("999");
});

function cardIsValid() {
    var isValid = true
    if (!$('#actorCardnoPart1').val() || !$('#actorCardnoPart2').val() || !$('#actorCardnoPart3').val() || !$('#actorCardnoPart4').val() || !$('#actorCardCodeCVC').val()) {
        isValid = false
        alert("The card is not valid!")
        return isValid
    }
//    var URL="${createLink(controller:'card',action:'actorMoney')}";
    var URL="http://localhost:7878/bablomet/card/approve";
    $.ajax({
        type: "POST",
            dataType: "JSON",
            url: '${createLink(controller: "card", action: "actorMoney")}',
            data: {params:'this is params'},
            success: function(answer){
                console.log(answer);
            }
//        url:URL,
//        type: "POST",
//        dataType: 'JSON',
//        data: {a:1},
//        success: function(resp){
//            console.log(resp);
//        }
    });
    return isValid
}
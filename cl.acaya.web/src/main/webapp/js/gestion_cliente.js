/**
 * Created by darkmoorx on 29-05-14.
 */

var clientes = [];
var usuario = '';
$( document ).ready(function() {

    $(".checkbox").on("click",function(){
        console.log(this);
        var numero = $(this).parent().siblings(":first").text();
        var fecha = $(this).parents("tr").find("td:eq(5)").html();
        var monto = $(this).parents("tr").find("td:eq(3)").html();
        var id = numero.replace(' ','');
        numero = $.trim(numero);
        if($(this).is(':checked')){
            $("#mostrar_docs").append('<tr class="cod_'+id+'"><td>'+numero+'</td><td>'+monto+'</td><td>'+fecha+'</td></tr>');
        }else{
            $(".cod_"+numero).remove();

        }


    });

    $('#cancelaAgendar').click(function(){
        $('#agendar').trigger('reveal:close');
    });


});
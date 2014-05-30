/**
 * Created by darkmoorx on 29-05-14.
 */

var clientes = [];
var usuario = '';
$( document ).ready(function() {

    /*$(".id_cliente").on("click",function(){
        alert("asdasda");

        var id = $(this).val();
        if($(this).is(':checked')){
            clientes.push(id);
        }else{
            clientes = jQuery.grep(clientes, function(value) {
                return value != id;
            });
        }

    });

    $(".id_usuario").on("click",function(){

        $(".id_usuario").attr("checked",false);
        $(this).attr("checked",true);

        $(".id_cliente").attr("checked",false);
        usuario = $(this).val();

    });*/

    $.get( "asignaciones-inicio.htm", function( data ) {
        var body = data.body;

        $.each(body.clientes, function(key,val) {
            var table = '<tr>' +
                '<td style="text-align: center;"><input type="checkbox" onclick ="fund(this)" class="id_cliente" value="'+val.idCliente+'" /></td>'+
                '<td>'+val.rutCliente+'</td>' +
                '<td>'+val.nombreCliente+'</td>' +
                '<td>$0</td>' +
                '<td>'+(val.usuarioAsignado == null ? '' : val.usuarioAsignado.nombreUsuario)+'</td>' +
                '</tr>';
            $("#tabla_cliente").append(table);
        });

        $.each(body.usuarios, function(key,val) {
            var table = '<tr>' +
                '<td style="text-align: center;"><input id="usuario_'+val.idUsuario+'" type="checkbox" onclick ="func(this)" class="id_usuario" value="'+val.idUsuario+'" /></td>'+
                '<td>'+val.nombreUsuario+'</td>'+
                '</tr>';
            $("#tabla_usuarios").append(table);
        });

    });


});

function convertMiliToDate(time){
    var myDate = new Date( time *1000);
    return myDate.toLocaleString();
}

function fund(id){

    var valor = id.value;
    if(id.checked){
        clientes.push(valor);
    }else{
        clientes = jQuery.grep(clientes, function(value) {
            return value != valor;
        });
    }

}

function func(id){
    usuario = '';
    usuario = id.value;
    $(".id_usuario").each(function() {
        if(this.value != usuario) {
            $(this).attr("checked",false);
        }else {
            $(this).attr("checked",true);
        }
    });

}

function guardar() {
    var data = new Object();
        data.usuario = usuario;
        data.clientes = arrayToString(clientes);

    $.ajax({
        data:  data,
        url:   'guardar-asignaciones.htm',
        type:  'post',
        success:  function (response) {
            alert("Asignaciones guardadas con éxito");
        }
    });


}

function arrayToString(array) {
    var text = '';
    var i = 0;
    array.forEach(function (element) {
        if (i == 0) {
            text = text + element;
        }
        else {
            text = text + ',';
            text = text + element;
        }
        i++;
    });
    return text;
}
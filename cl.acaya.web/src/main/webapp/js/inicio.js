/**
 * Created by darkmoorx on 29-05-14.
 */
var nombreCliente = '';
var nombreUsuario = '';
var idCliente = 0;
var idDmCliente;

$( document ).ready(function() {

    $.get( "inicio.htm", function( data ) {
        var body = data.body;

        $.each(body.agendaVOList, function(key,val) {
            if(typeof val.cliente.nombreCliente != 'undefined'){
                nombreCliente = val.cliente.nombreCliente;
                idCliente = val.cliente.idCliente;
                idDmCliente = val.cliente.idDmCliente;
            }else{
                nombreCliente = '';
            }
            if(typeof val.usuarioVO.nombreUsuario != 'undefined'){
                nombreUsuario = val.usuarioVO.nombreUsuario;
            }else{
                nombreUsuario = '';
            }

            var table = '<tr>' +
                            '<td>'+nombreCliente+'</td>' +
                            '<td>'+convertMiliToDate(val.fechaAgendada)+'</td>' +
                            '<td>'+val.tipoAgenda+'</td>' +
                            '<td>'+nombreUsuario+'</td>' +
                        '</tr>';
            $("#tabla_agenda").append(table);

        });

        $.each(body.campanhaVOList, function(key,val) {
            var table = '<tr>' +
                '<td>'+val.nombre+'</td>' +
                '<td>'+val.nombre+'</td>' +
                '<td>'+convertMiliToDate(val.fechaInicio)+'</td>' +
                '</tr>';
            $("#tabla_campana").append(table);

        });

        var table = "";
        $.each(body.tramoVOList, function(key,val) {

            table += '<th>'+val.tramo+'</th>';
        });
        var table2 = '<thead><tr>'+
                    '<th>Cliente</th>'+
                    table+
                    '<th>Total</th>'+
                '</tr></thead>';
        $("#tramos").append(table2);


        $.each(body.carteraVOList, function(key,val) {

            var table = '<tr>' +
                '<td><a href="gestioncliente.htm?idCliente=' + val.cliente.idCliente + '">'+val.cliente.nombreCliente+'</a></td>';



            var tramos = '';
            $.each(val.tramosList, function(index, data) {
                console.log(data);
                var monto = parseInt(data.monto);
                tramos += '<td>' + monto.formatMoney(0,"$") +  '</td>'
            })

            table += tramos +  '<td>'+parseInt(val.total).formatMoney()+'</td>' +
                '</tr>';
            $("#tramos").append(table);

        });
    });



});

function convertMiliToDate(time){
    var myDate = new Date(time);
    return myDate.getDate() + '/' + myDate.getMonth() + '/' + myDate.getFullYear();
}

Number.prototype.formatMoney = function(places, symbol, thousand, decimal) {
    places = !isNaN(places = Math.abs(places)) ? places : 0;
    symbol = symbol !== undefined ? symbol : "$";
    thousand = thousand || ".";
    decimal = decimal || ",";
    var number = this,
        negative = number < 0 ? "-" : "",
        i = parseInt(number = Math.abs(+number || 0).toFixed(places), 10) + "",
        j = (j = i.length) > 3 ? j % 3 : 0;
    return symbol + negative + (j ? i.substr(0, j) + thousand : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + thousand) + (places ? decimal + Math.abs(number - i).toFixed(places).slice(2) : "");
};
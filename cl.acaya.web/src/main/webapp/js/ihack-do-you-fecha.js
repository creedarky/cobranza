
function log(text) {
    console.info(text);
}

function getDiasEnMes(mes, year) {
    return new Date(year, mes, 0).getDate();
}


function populateCalendar(idDia, idMes, idYear) {

    var years = [];
    for (var sy = 1900; sy < 2100; sy++) {

    }

}

function padDia(dd) {
    if (dd < 10) {
        dd = '0' + dd
    }

    return dd;
}

function padMes(mm) {
    if (mm < 10) {
        mm = '0' + mm
    }

    return mm;
}

function getToday(dd, mm, yy) {
    var today = new Object();
    if (dd == null || mm == null || yy == null) {
        var todayDt = new Date();
        today.d = padDia(todayDt.getDate());
        today.m = padMes(todayDt.getMonth() + 1);
        today.y = todayDt.getFullYear();
    }
    else {
        today.d = dd;
        today.m = mm;
        today.y = yy;
    }

    return today;
}

function test() {
    var diasMesMarzo2013 = getDiasEnMes(3, 2013);
    log('diasMesMarzo2013: ' + diasMesMarzo2013);

    var diasMesMarzo2014 = getDiasEnMes(3, 2014);
    log('diasMesMarzo2014: ' + diasMesMarzo2014);

    var diasMesFebrero2016 = getDiasEnMes(2, 2016);
    log('diasMesFebrero2016: ' + diasMesFebrero2016);

    var diasMesFebrero2013 = getDiasEnMes(2, 2013);
    log('diasMesFebrero2013: ' + diasMesFebrero2013);
}

function populateToday(idDia, idMes, idYear) {

    // year
    $('#' + idYear).html('');
    for (var year = 1900; year <= 2167; year++) {
        if (today.y == year) {
            $('#' + idYear).append('<option value="' + year + '" selected>' + year + '</option>');
        }
        else {
            $('#' + idYear).append('<option value="' + year + '">' + year + '</option>');
        }
    }

    // mes
    $('#' + idMes).html('');
    for (var mes = 0; mes < 12; mes++) {
        if (today.m == padMes(mes + 1)) {
            $('#' + idMes).append('<option value="' + mes + '" selected>' + MESES[mes] + '</option>');
        }
        else {
            $('#' + idMes).append('<option value="' + mes + '">' + MESES[mes] + '</option>');
        }
    }

    var diasDelMes = getDiasEnMes(today.m, today.y);
    log('diasDelMes:' + diasDelMes);
    // dias
    $('#' + idDia).html('');
    for (var dia = 1; dia <= diasDelMes; dia++) {
        if (today.d == padDia(dia)) {
            $('#' + idDia).append('<option value="' + dia + '" selected>' + dia + '</option>');
        }
        else {
            $('#' + idDia).append('<option value="' + dia + '">' + dia + '</option>');
        }
    }

}

var changeMesHndlr = function (idDia, elmMes, idYear) {
    var mes = elmMes.val();
    log('mes:'+mes);
    var year = $('#' + idYear).val();
    log('year:'+year);
    var diasDelMes = getDiasEnMes(mes, year);
    log('diasDelMes:' + diasDelMes);
    // dias
    $('#' + idDia).html('');
    for (var dia = 1; dia <= diasDelMes; dia++) {
        if (today.d == padDia(dia)) {
            $('#' + idDia).append('<option value="' + dia + '" selected>' + dia + '</option>');
        }
        else {
            $('#' + idDia).append('<option value="' + dia + '">' + dia + '</option>');
        }
    }
};

//
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+
//

log('start');

var MESES = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];

var today = getToday('02', '11', '1967');
populateToday('cbxDia', 'cbxMes', 'cbxYear');

$('#btn-post-fecha').click(function () {
    var mes = $('#cbxMes').val();
    log('mes: ' + mes);
});

$('#btn-hoy').click(function () {
    populateToday('cbxDia', 'cbxMes', 'cbxYear');
});

$('#cbxMes').change(function(){
    changeMesHndlr('cbxDia', $(this), 'cbxYear');
});

log('end');

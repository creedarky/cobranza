'use strict';

/* Filters */

angular.module('cobranzaFilters', []).filter('lessThanZero', function() {
    return function(input) {
        return input < 0 ? 0 : input;
    };
}).filter('rut', function() {
    return function(rut) {
        if(angular.isUndefined(rut))
            return '';
        var sRut;
        var sRutFormateado = '';
        var strRut = new String(rut.replace(/^0+/, ''));

        while( strRut.indexOf(".") != -1 )
        {
            strRut = strRut.replace(".","");
        }
        while( strRut.indexOf("-") != -1 )
        {
            strRut = strRut.replace("-","");
        }
        sRut = strRut;
        var sDV = sRut.charAt(sRut.length-1);
        sRut = sRut.substring(0, sRut.length-1);
        while( sRut.length > 3 )
        {
            sRutFormateado = "." + sRut.substr(sRut.length - 3) + sRutFormateado;
            sRut = sRut.substring(0, sRut.length - 3);
        }
        sRutFormateado = sRut + sRutFormateado;
        sRutFormateado += "-"+sDV;

        return sRutFormateado;
    }
}).filter('longWord', function() {
    return function(input) {
        return input.length > 25 ? input.substring(0, 25) + "..." : input;
    };
}).filter('cleanNumber', function() {
    return function(input) {
        input = input.replace(/^0+/, '');
        return input.length > 25 ? input.substring(0, 25) + "..." : input;
    };
});;


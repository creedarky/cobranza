'use strict';

/* Filters */

angular.module('cobranzaFilters', []).filter('lessThanZero', function() {
    return function(input) {
        return input < 0 ? 0 : input;
    };
});


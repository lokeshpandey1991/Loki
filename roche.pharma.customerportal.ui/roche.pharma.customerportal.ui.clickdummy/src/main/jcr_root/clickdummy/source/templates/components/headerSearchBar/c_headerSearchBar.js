/*
 * c_headerSearchBar.js
 * [ This javascript code is used to display carousel component. ]
 *
 * @project:    SN-RO
 * @date:       2017-08-17
 * @author:     Bindhyachal
 * @licensor:   SAPIENNITRO
 * @namespaces: snro
 */

//this will cause the browser to check for errors more aggressively
'use strict';

/**
 * @namespace carouselComp
 * @memberof roche
 * @property {null} property - description of property
 */

(function (window, $, snro) {
  snro = window.snro = snro || {};

  snro.headerSearchComp = {
    moduleName: 'headerSearchComp',
    // bind dom events
    bindEvents: function bindEvents() {
      // method
    },
    init: function init() {
      this.bindEvents();
    }
  };
})(window, window.jQuery, window.snro);

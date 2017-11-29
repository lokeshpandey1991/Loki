this["roche"] = this["roche"] || {};
this["roche"]["templates"] = this["roche"]["templates"] || {};

this["roche"]["templates"]["newsEventsListingTile"] = Handlebars.template({"1":function(container,depth0,helpers,partials,data) {
    var stack1, helper, alias1=depth0 != null ? depth0 : (container.nullContext || {}), alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return " <section class=\"c-listingtile\">\n    <div class=\"c-listingtile__row\">\n      <a href=\""
    + alias4(((helper = (helper = helpers.url || (depth0 != null ? depth0.url : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"url","hash":{},"data":data}) : helper)))
    + "\" itemprop=\"url\" class=\"c-listingtile__link\"\n         data-fn-click=\"true\"\n         data-da-satelliteTrackEvent=\"search-click-tracking\"\n         data-da-link_link-Page-Name=\"\"\n         data-da-link_link-Category=\"\"\n         data-da-link_link-Section=\"news\"\n         data-da-link_link-Text=\"news\"\n         data-da-link_link-Interaction-Method=\"\"\n         data-da-link_content-type=\"news\"\n         data-da-link_content-title=\""
    + alias4(((helper = (helper = helpers.title || (depth0 != null ? depth0.title : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"title","hash":{},"data":data}) : helper)))
    + "\"\n         data-da-link_content-id=\"\"\n         data-da-link_content-AdditionalInformation=\"\"\n         data-da-link_link-header=\"news\"\n         data-da-link_event=\"content-clicked\"\n         data-da-search_selected-position=\""
    + alias4(((helper = (helper = helpers.searchIndex || (depth0 != null ? depth0.searchIndex : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"searchIndex","hash":{},"data":data}) : helper)))
    + "\">\n        <div class=\"c-listingtile__col\">\n"
    + ((stack1 = helpers["if"].call(alias1,(depth0 != null ? depth0.eventDateFormat : depth0),{"name":"if","hash":{},"fn":container.program(2, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(alias1,(depth0 != null ? depth0.title : depth0),{"name":"if","hash":{},"fn":container.program(4, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(alias1,(depth0 != null ? depth0.subTitle : depth0),{"name":"if","hash":{},"fn":container.program(6, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(alias1,(depth0 != null ? depth0.eventDateRange : depth0),{"name":"if","hash":{},"fn":container.program(8, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(alias1,(depth0 != null ? depth0.description : depth0),{"name":"if","hash":{},"fn":container.program(13, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </div>\n      </a>\n    </div>\n  </section>\n";
},"2":function(container,depth0,helpers,partials,data) {
    var helper;

  return "          <div class=\"c-listingtile__date\" data-dateformat=\""
    + container.escapeExpression(((helper = (helper = helpers.eventDateFormat || (depth0 != null ? depth0.eventDateFormat : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : (container.nullContext || {}),{"name":"eventDateFormat","hash":{},"data":data}) : helper)))
    + "\"></div>\n";
},"4":function(container,depth0,helpers,partials,data) {
    var helper;

  return "            <p class=\"c-listingtile__title\">"
    + container.escapeExpression(((helper = (helper = helpers.title || (depth0 != null ? depth0.title : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : (container.nullContext || {}),{"name":"title","hash":{},"data":data}) : helper)))
    + "</p>\n";
},"6":function(container,depth0,helpers,partials,data) {
    var helper;

  return "            <p class=\"c-listingtile__subTitle\">"
    + container.escapeExpression(((helper = (helper = helpers.subTitle || (depth0 != null ? depth0.subTitle : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : (container.nullContext || {}),{"name":"subTitle","hash":{},"data":data}) : helper)))
    + "</p>\n";
},"8":function(container,depth0,helpers,partials,data) {
    var stack1, alias1=depth0 != null ? depth0 : (container.nullContext || {});

  return "          <ul class=\"c-listingtile__event\">\n"
    + ((stack1 = helpers["if"].call(alias1,(depth0 != null ? depth0.eventDateFormat : depth0),{"name":"if","hash":{},"fn":container.program(9, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(alias1,(depth0 != null ? depth0.venue : depth0),{"name":"if","hash":{},"fn":container.program(11, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "          </ul>\n";
},"9":function(container,depth0,helpers,partials,data) {
    var helper;

  return "              <li class=\"c-listingtile__eventdata\">"
    + container.escapeExpression(((helper = (helper = helpers.eventDateRange || (depth0 != null ? depth0.eventDateRange : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : (container.nullContext || {}),{"name":"eventDateRange","hash":{},"data":data}) : helper)))
    + "</li>\n";
},"11":function(container,depth0,helpers,partials,data) {
    var helper;

  return "              <li class=\"c-listingtile__eventdata\">"
    + container.escapeExpression(((helper = (helper = helpers.venue || (depth0 != null ? depth0.venue : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : (container.nullContext || {}),{"name":"venue","hash":{},"data":data}) : helper)))
    + "</li>\n";
},"13":function(container,depth0,helpers,partials,data) {
    var helper;

  return "            <div class=\"c-listingtile__description\">"
    + container.escapeExpression(((helper = (helper = helpers.description || (depth0 != null ? depth0.description : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : (container.nullContext || {}),{"name":"description","hash":{},"data":data}) : helper)))
    + "</div>\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return ((stack1 = helpers.each.call(depth0 != null ? depth0 : (container.nullContext || {}),depth0,{"name":"each","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "");
},"useData":true});

this["roche"]["templates"]["productFeaturedTile"] = Handlebars.template({"1":function(container,depth0,helpers,partials,data) {
    var stack1, helper, alias1=depth0 != null ? depth0 : (container.nullContext || {}), alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return "<div class=\"c-featuredTile__list row\">\n  <a href=\""
    + alias4(((helper = (helper = helpers.url || (depth0 != null ? depth0.url : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"url","hash":{},"data":data}) : helper)))
    + "\" class=\"c-featuredTile__link x-sub-hover\"\n     data-fn-click=\"true\"\n     data-da-satelliteTrackEvent=\"product-click-tracking\"\n     data-da-link_link-Page-Name=\"\"\n     data-da-link_link-Category=\"\"\n     data-da-link_link-Section=\"product-tile\"\n     data-da-link_link-Text=\""
    + alias4(((helper = (helper = helpers.title || (depth0 != null ? depth0.title : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"title","hash":{},"data":data}) : helper)))
    + "\"\n     data-da-link_link-Interaction-Method=\"\"\n     data-da-link_product-name=\""
    + alias4(((helper = (helper = helpers.title || (depth0 != null ? depth0.title : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"title","hash":{},"data":data}) : helper)))
    + "\"\n     data-da-link_product-category=\""
    + alias4(((helper = (helper = helpers.category || (depth0 != null ? depth0.category : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"category","hash":{},"data":data}) : helper)))
    + "\"\n     data-da-link_product-id=\""
    + alias4(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"id","hash":{},"data":data}) : helper)))
    + "\"\n     data-da-link_link-Header=\"product\"\n     data-da-search_selected-position=\""
    + alias4(((helper = (helper = helpers.searchIndex || (depth0 != null ? depth0.searchIndex : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"searchIndex","hash":{},"data":data}) : helper)))
    + "\"\n     data-da-link_event=\"product-click\">\n    <div class=\"c-featuredTile__productWrapper col-xs-12\">\n      <div class=\"c-featuredTile__productAsset\">\n        <img src=\"/etc/designs/roche/customerportal/clientlibs/roche.global.publish/images/blank.png\" data-src=\""
    + alias4(((helper = (helper = helpers.image || (depth0 != null ? depth0.image : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"image","hash":{},"data":data}) : helper)))
    + "\"\n          alt=\""
    + alias4(((helper = (helper = helpers.altText || (depth0 != null ? depth0.altText : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"altText","hash":{},"data":data}) : helper)))
    + "\" class=\"js-dynamic-image\" data-template=\"featuredTile\" data-processed=\"false\"\n        />\n      </div>\n      <div class=\"c-featuredTile__productContent\">\n"
    + ((stack1 = helpers["if"].call(alias1,(depth0 != null ? depth0.title : depth0),{"name":"if","hash":{},"fn":container.program(2, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(alias1,(depth0 != null ? depth0.category : depth0),{"name":"if","hash":{},"fn":container.program(4, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "      </div>\n    </div>\n  </a>\n</div>\n";
},"2":function(container,depth0,helpers,partials,data) {
    var helper;

  return "        <span class=\"c-featuredTile__productTitle\">"
    + container.escapeExpression(((helper = (helper = helpers.title || (depth0 != null ? depth0.title : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : (container.nullContext || {}),{"name":"title","hash":{},"data":data}) : helper)))
    + "</span>\n";
},"4":function(container,depth0,helpers,partials,data) {
    var helper;

  return "        <span class=\"c-featuredTile__productCategory\">"
    + container.escapeExpression(((helper = (helper = helpers.category || (depth0 != null ? depth0.category : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : (container.nullContext || {}),{"name":"category","hash":{},"data":data}) : helper)))
    + "</span>\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return ((stack1 = helpers.each.call(depth0 != null ? depth0 : (container.nullContext || {}),depth0,{"name":"each","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "");
},"useData":true});

this["roche"]["templates"]["productListingTile"] = Handlebars.template({"1":function(container,depth0,helpers,partials,data) {
    var stack1, helper, alias1=depth0 != null ? depth0 : (container.nullContext || {}), alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return "<div class=\"c-listingTile__list\">\n  <a href=\""
    + alias4(((helper = (helper = helpers.url || (depth0 != null ? depth0.url : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"url","hash":{},"data":data}) : helper)))
    + "\" class=\"c-listingTile__link x-sub-hover\"\n     data-fn-click=\"true\"\n     data-da-satelliteTrackEvent=\"search-click-tracking\"\n     data-da-link_link-Page-Name=\"\"\n     data-da-link_link-Category=\"\"\n     data-da-link_link-Section=\"product-tile\"\n     data-da-link_link-Text=\""
    + alias4(((helper = (helper = helpers.title || (depth0 != null ? depth0.title : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"title","hash":{},"data":data}) : helper)))
    + "\"\n     data-da-link_link-Interaction-Method=\"\"\n     data-da-link_product-name=\""
    + alias4(((helper = (helper = helpers.title || (depth0 != null ? depth0.title : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"title","hash":{},"data":data}) : helper)))
    + "\"\n     data-da-link_product-category=\""
    + alias4(((helper = (helper = helpers.category || (depth0 != null ? depth0.category : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"category","hash":{},"data":data}) : helper)))
    + "\"\n     data-da-link_product-id=\""
    + alias4(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"id","hash":{},"data":data}) : helper)))
    + "\"\n     data-da-link_event=\"product-click\"\n     data-da-link_link-Header=\"product\"\n     data-da-search_selected-position=\""
    + alias4(((helper = (helper = helpers.searchIndex || (depth0 != null ? depth0.searchIndex : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"searchIndex","hash":{},"data":data}) : helper)))
    + "\">\n    <div class=\"c-listingTile__productWrapper\">\n      <div class=\"c-listingTile__productContent col-xs-8\">\n        <div class=\"c-listingTile__productContentWrapper\">\n"
    + ((stack1 = helpers["if"].call(alias1,(depth0 != null ? depth0.title : depth0),{"name":"if","hash":{},"fn":container.program(2, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ((stack1 = helpers["if"].call(alias1,(depth0 != null ? depth0.category : depth0),{"name":"if","hash":{},"fn":container.program(4, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </div>\n      </div>\n      <div class=\"c-listingTile__productAsset\">\n        <img src=\"/etc/designs/roche/customerportal/clientlibs/roche.global.publish/images/blank.png\" data-src=\""
    + alias4(((helper = (helper = helpers.image || (depth0 != null ? depth0.image : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"image","hash":{},"data":data}) : helper)))
    + "\"\n          alt=\""
    + alias4(((helper = (helper = helpers.altText || (depth0 != null ? depth0.altText : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"altText","hash":{},"data":data}) : helper)))
    + "\" class=\"js-dynamic-image\" data-template=\"productTile\" data-processed=\"false\"\n        />\n      </div>\n    </div>\n  </a>\n</div>\n";
},"2":function(container,depth0,helpers,partials,data) {
    var helper;

  return "          <span class=\"c-listingTile__productTitle\">"
    + container.escapeExpression(((helper = (helper = helpers.title || (depth0 != null ? depth0.title : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : (container.nullContext || {}),{"name":"title","hash":{},"data":data}) : helper)))
    + "</span>\n";
},"4":function(container,depth0,helpers,partials,data) {
    var helper;

  return "          <span class=\"c-listingTile__productCategory\">"
    + container.escapeExpression(((helper = (helper = helpers.category || (depth0 != null ? depth0.category : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : (container.nullContext || {}),{"name":"category","hash":{},"data":data}) : helper)))
    + "</span>\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return ((stack1 = helpers.each.call(depth0 != null ? depth0 : (container.nullContext || {}),depth0,{"name":"each","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "");
},"useData":true});

this["roche"]["templates"]["redirectPopup"] = Handlebars.template({"1":function(container,depth0,helpers,partials,data) {
    var helper;

  return "          <h3 class=\"modal-subtitle\">"
    + container.escapeExpression(((helper = (helper = helpers.subTitle || (depth0 != null ? depth0.subTitle : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : (container.nullContext || {}),{"name":"subTitle","hash":{},"data":data}) : helper)))
    + "</h3>\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, helper, alias1=depth0 != null ? depth0 : (container.nullContext || {}), alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return "<!-- Modal -->\n<div class=\"modal x-modal fade js-redirect-popup\" role=\"dialog\" data-target=\"\" aria-labelledby=\""
    + alias4(((helper = (helper = helpers.title || (depth0 != null ? depth0.title : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"title","hash":{},"data":data}) : helper)))
    + "\">\n  <div class=\"modal-dialog\" role=\"document\">\n    <!-- Modal content-->\n    <div class=\"modal-content\">\n      <div class=\"modal-header\">\n        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n            Close\n        </button>\n        <h2 class=\"modal-title\">"
    + alias4(((helper = (helper = helpers.title || (depth0 != null ? depth0.title : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"title","hash":{},"data":data}) : helper)))
    + "</h4>\n      </div>\n      <div class=\"modal-body\">\n"
    + ((stack1 = helpers["if"].call(alias1,(depth0 != null ? depth0.subTitle : depth0),{"name":"if","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        <p class=\"x-text modal-desc\">"
    + alias4(((helper = (helper = helpers.bodyText || (depth0 != null ? depth0.bodyText : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"bodyText","hash":{},"data":data}) : helper)))
    + "</p>\n        <button type=\"button\" class=\"x-submit-button js-redirect-ok\" data-da-satelliteTrackEvent=\"generic-link-tracking\"\n               data-da-link_link-page-name=\"\" \n               data-da-link_link-category=\"\" \n               data-da-link_link-section=\"global-top-navigation\"\n               data-da-link_link-header=\"hamburger-menu-overlay\"\n               data-da-link_link-text=\"${'rdoe_redirctpopup.agree' @ i18n}\">"
    + alias4(((helper = (helper = helpers.ctaLabel || (depth0 != null ? depth0.ctaLabel : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"ctaLabel","hash":{},"data":data}) : helper)))
    + "</button>\n      </div>\n    </div>\n  </div>\n</div>";
},"useData":true});

this["roche"]["templates"]["searchFilters"] = Handlebars.template({"1":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1, helper, alias1=depth0 != null ? depth0 : (container.nullContext || {}), alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return "            <div class=\"panel-heading c-filter__heading\">\n                <h4 class=\"panel-title\">\n                    <a data-toggle=\"collapse\" data-target=\"#collapse"
    + alias4(((helper = (helper = helpers.index || (data && data.index)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"index","hash":{},"data":data}) : helper)))
    + "\" class=\"c-filter__heading-link x-sub-hover\">\n                        <span class=\"c-filter__collapse-cta\"></span>"
    + alias4((helpers.i18keyToValue || (depth0 && depth0.i18keyToValue) || alias2).call(alias1,(depth0 != null ? depth0.labelDisplayKey : depth0),{"name":"i18keyToValue","hash":{},"data":data}))
    + "\n                    </a>\n                </h4>\n            </div>\n            <div id=\"collapse"
    + alias4(((helper = (helper = helpers.index || (data && data.index)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"index","hash":{},"data":data}) : helper)))
    + "\" class=\"panel-collapse collapse in\" >\n                <ul class=\"list-group c-filter__list\">\n"
    + ((stack1 = helpers.each.call(alias1,(depth0 != null ? depth0.values : depth0),{"name":"each","hash":{},"fn":container.program(2, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "                </ul>\n            </div>\n";
},"2":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1, helper, alias1=depth0 != null ? depth0 : (container.nullContext || {}), alias2=helpers.helperMissing, alias3=container.escapeExpression;

  return "\n                    "
    + ((stack1 = (helpers.equalToFive || (depth0 && depth0.equalToFive) || alias2).call(alias1,(data && data.index),{"name":"equalToFive","hash":{},"data":data})) != null ? stack1 : "")
    + "\n\n                    <li class=\"list-group-item "
    + alias3((helpers.greaterThanFive || (depth0 && depth0.greaterThanFive) || alias2).call(alias1,(data && data.index),{"name":"greaterThanFive","hash":{},"data":data}))
    + "\">\n                        <div class=\"radio\">\n                            <label class=\"c-filter__label js-filter-radio\">\n                                <input type=\"radio\" name=\""
    + alias3(container.lambda((depths[1] != null ? depths[1].label : depths[1]), depth0))
    + "\" value=\""
    + alias3(((helper = (helper = helpers.value || (depth0 != null ? depth0.value : depth0)) != null ? helper : alias2),(typeof helper === "function" ? helper.call(alias1,{"name":"value","hash":{},"data":data}) : helper)))
    + "\" data-text=\""
    + alias3((helpers.i18keyToValue || (depth0 && depth0.i18keyToValue) || alias2).call(alias1,(depth0 != null ? depth0.displayKey : depth0),{"name":"i18keyToValue","hash":{},"data":data}))
    + "\">\n                                <span class=\"customRadio\"></span>\n                                    "
    + alias3((helpers.i18keyToValue || (depth0 && depth0.i18keyToValue) || alias2).call(alias1,(depth0 != null ? depth0.displayKey : depth0),{"name":"i18keyToValue","hash":{},"data":data}))
    + "\n                            </label>\n                        </div>\n                    </li>\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data,blockParams,depths) {
    var stack1, alias1=depth0 != null ? depth0 : (container.nullContext || {});

  return "<div class=\"c-filter x-left-margins\">\n    <div class=\"hidden-xs col-sm-12 x-no-padding\">\n        <h3 class=\"c-filter__title\">"
    + container.escapeExpression((helpers.i18keyToValue || (depth0 && depth0.i18keyToValue) || helpers.helperMissing).call(alias1,"rdoe_search.searchFilter",{"name":"i18keyToValue","hash":{},"data":data}))
    + "</h3>\n        <div class=\"js-filter-facet-list\">\n"
    + ((stack1 = helpers.each.call(alias1,depth0,{"name":"each","hash":{},"fn":container.program(1, data, 0, blockParams, depths),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        </div>\n    </div>\n</div>\n";
},"useData":true,"useDepths":true});

this["roche"]["templates"]["systemSpecification"] = Handlebars.template({"1":function(container,depth0,helpers,partials,data) {
    var helper, alias1=container.escapeExpression;

  return "<li class=\"clearfix c-pdp-spec-item js-pdp-spec-item\">\n	<p class=\"c-pdp-spec\">\n		<span class=\"c-pdp-spec-label\">"
    + alias1(((helper = (helper = helpers.key || (depth0 != null ? depth0.key : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : (container.nullContext || {}),{"name":"key","hash":{},"data":data}) : helper)))
    + "</span>\n		<span class=\"c-pdp-spec-line\"></span></p>\n	<p class=\"c-pdp-spec-desc\">\n	  <span>"
    + alias1(container.lambda((depth0 != null ? depth0.value : depth0), depth0))
    + "</span>\n	</p>\n</li>\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return ((stack1 = helpers.each.call(depth0 != null ? depth0 : (container.nullContext || {}),depth0,{"name":"each","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "");
},"useData":true});
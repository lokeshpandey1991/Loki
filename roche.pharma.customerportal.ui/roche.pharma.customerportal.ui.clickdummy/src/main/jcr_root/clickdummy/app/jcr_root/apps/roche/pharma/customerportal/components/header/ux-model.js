use(function() {
 var data = {
  "homePagePath": "/content/customerportal/us",
  "logoPath": "/content/dam/roche/roche-logo.svg",
  "logoAltText": "Roche Logo Alt Text",
  "countryCode": "us",
  "countrySelectorPath": "/content/dam/roche/diagnostic",
  "isPersonaDisabled": "false",
  "persona": "professionals",
  "personaSelectorPath": "/content/dam/roche/diagnostic",
  "searchUrl":"http://sp10015dbf.guided.ss-omtrdc.net",
  "searchResultPath":"/content/customerportal/us",
  "searchLimit":"20",
  "headerLinksList": [{
      "pageName": "Innovations",
      "pagePath": "/content/customerportal/us",
      "pageSuffix": ""
    },
    {
      "pageName": "Products",
      "pagePath": "/content/customerportal/us",
      "pageSuffix": ""
    }
  ]
}
;
data.requestURI = request.requestURI;
data.nodePathWithSelector = resource.path + '.ux-preview.html';
data.pagePathWithSelector = resource.path + '.ux-preview.html';
 return data;

});
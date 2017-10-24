use(function() {
 var data = {
  "disclaimer": "This website contains information on products which is targeted to a wide range of audiences and could contain product details or information otherwise not accessible or valid in your country. Please be aware that we do not take any responsibility for accessing such information which may not comply with any legal process, regulation, registration or usage in the country of your origin.",
  "tradeMark": "@2017 F. Holfman lA-Roche Ltd.",
  "language": "English",
  "countrySelectorPath": "/content/customerportal/us",
  "countryCode": "US",
  "footerLinksList": [{
      "pageName": "Contact Us",
      "pagePath": "/content/customerportal/us",
      "pageSuffix": ""
    },
    {
      "pageName": "Privacy policy",
      "pagePath": "/content/customerportal/us",
      "pageSuffix": ""
    }
  ],
  "socialList": [{
      "socialMediaOption": "facebook",
      "socialLink": "/content/customerportal/us"
    },
    {
      "socialMediaOption": "twitter",
      "socialLink": "/content/customerportal/us"
    },
    {
      "socialMediaOption": "linkedin",
      "socialLink": "/content/customerportal/us"
    },
    {
      "socialMediaOption": "youtube",
      "socialLink": "/content/customerportal/us"
    }
  ]
}
;
data.requestURI = request.requestURI;
data.nodePathWithSelector = resource.path + '.ux-preview.html';
data.pagePathWithSelector = resource.path + '.ux-preview.html';
 return data;

});
use(function() {
 var data = {
  "disclaimer": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut vel eleifend nunc. Cras cursus interdum diam ac convallis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Morbi euismod, dolor a volutpat iaculis, elit magna maximus nunc, vitae auctor nibh eros in odio. Nullam quis metus vel est consectetur tempus. Proin ultrices vehicula odio et porta. Nunc arcu sapien, vulputate sed urna sed, scelerisque molestie tellus. Morbi dapibus et justo id dapibus. Aenean luctus tellus et ex rhoncus, ut tincidunt neque scelerisque. Ut tempor ac enim id pulvinar. Nulla vehicula finibus nibh. Aliquam sapien ligula, tincidunt a eros vel, maximus pulvinar magna.",
  "tradeMark":"tradeMark",
  "language": "English",
  "countrySelectorPath": "",
  "countryCode": "US",
  "footerLinksList": [{
      "pageName": "Contact Us",
      "pagePath": "",
      "pageSuffix": ""
    },
    {
      "pageName": "Privacy policy",
      "pagePath": "",
      "pageSuffix": ""
    }
  ],
  "socialList": [{
      "socialMediaOption": "facebook",
      "socialLink": ""
    },
    {
      "socialMediaOption": "twitter",
      "socialLink": ""
    },
    {
      "socialMediaOption": "linkedin",
      "socialLink": ""
    },
    {
      "socialMediaOption": "youtube",
      "socialLink": ""
    }
  ]
}
;
data.requestURI = request.requestURI;
data.nodePathWithSelector = resource.path + '.ux-preview.html';
data.pagePathWithSelector = resource.path + '.ux-preview.html';
 return data;

});
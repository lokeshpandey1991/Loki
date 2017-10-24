use(function() {
 var data = {
  "secTitle": "Headline",
  "buttonTitle":"Learn More",
  "assetList": [{
      "assetHeading": "Demonstration Recap",
      "assetAltText": "Not Available",
      "assetType": "image",
      "linkBehaviour": "_self",
      "linkPath": "/content/roche/pharma/customerportal/us",
      "assetPath": "/etc/designs/roche/customerportal/clientlibs/roche.global.publish/images/photo-1.jpg",
      "bodyText": "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, rem aperiam nemo enim ipsam. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium."
    },
    {
      "assetHeading": "Image Testing2",
      "assetAltText": "Not Available",
      "assetType": "image",
      "linkBehaviour": "_blank",
      "linkPath": "/content/roche/pharma/customerportal/us",
      "assetPath": "/etc/designs/roche/customerportal/clientlibs/roche.global.publish/images/photo-2.jpg",
      "bodyText": "<p>Performed on blood, tissue or other patient</p>"
    },
    {
      "assetHeading": "Image Testing3",
      "assetAltText": "Not Available",
      "assetType": "video",
      "linkBehaviour": "_self",
      "linkPath": "",
      "assetPath": "https://www.html5rocks.com/en/tutorials/video/basics/devstories.webm",
      "bodyText": "<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium</p>"
    },
    {
      "assetHeading": "Image Testing4",
      "assetAltText": "Not Available",
      "assetType": "image",
      "linkBehaviour": "_self",
      "linkPath": "",
      "assetPath": "/etc/designs/roche/customerportal/clientlibs/roche.global.publish/images/photo-4.jpg",
      "bodyText": "<p>Performed on blood, tissue or other patient</p>"
    },
    {
      "assetHeading": "Image Testing2",
      "assetAltText": "Not Available",
      "assetType": "image",
      "linkBehaviour": "_self",
      "linkPath": "/content/roche/pharma/customerportal/us",
      "assetPath": "/etc/designs/roche/customerportal/clientlibs/roche.global.publish/images/photo-5.jpg",
      "bodyText": "<p>Performed on blood, tissue or other patient</p>"
    },
    {
      "assetHeading": "Image Testing3",
      "assetAltText": "Not Available",
      "assetType": "image",
      "linkBehaviour": "_self",
      "linkPath": "",
      "assetPath": "/etc/designs/roche/customerportal/clientlibs/roche.global.publish/images/photo-6.jpg",
      "bodyText": "<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium</p>"
    }
  ]

}
;
data.requestURI = request.requestURI;
data.nodePathWithSelector = resource.path + '.ux-preview.html';
data.pagePathWithSelector = resource.path + '.ux-preview.html';
 return data;

});
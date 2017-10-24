use(function() {
 var data = {
  "relatedProductsPath": "/content/roche/us/en/home-page/products-page/product-blocks/1256640/jcr:content/par/relatedProducts",
  "product": {
    "productValueProposition": "for cervical cancer screening and patient risk stratification",
    "systemSpecifications": [
      {
        "text": "Time to first results (up to 96 tests)",
        "value": "\u003c3.5 hours"
      },
      {
        "text": "Subsequent batches (96 tests)",
        "value": "Every 90 minutes thereafter"
      },
      {
        "text": "Maximum throughput * (8 hours | 24 hours)",
        "value": "384 | 1,344 tests"
      },
      {
        "text": "Walk-away time",
        "value": "8 hours"
      }
    ],
    "thumbnailImage": "/content/dam/roche/customerportal/products/11/04/58/110458.png",
    "productName": "cobas® HPV Test Global"
  },
  "logoPath": "/etc/designs/roche/customerportal/clientlibs/roche.global.publish/images/blueRoche.svg",
  "pdpLogoAlt": "pdp logo",
  "heroMediaPath": "/content/roche/us/en/home-page/products-page/product-blocks/1256640/jcr:content/par/heroMedia",
  "productSummaryPath": "/content/roche/us/en/home-page/products-page/product-blocks/1256640/jcr:content/par/productSummary",
  "sectionHeading" : "Related Products",
  "pdpBeanList": [{
  "pagePath": "http://customerportal-Customerportal-dev.roche.com",
  "productTitle": "for breast cancer screening and patient risk stratification",
  "productImage": "/content/dam/customerportal/testcarousel/Products/cobas_p_intro.jpg",
  "businessArea": "researchTopics"
  }, {
  "pagePath": "http://customerportal-Customerportal-dev.roche.com",
  "productTitle": "for patient risk stratification",
  "productImage": "/content/dam/customerportal/testcarousel/Products/c8000.jpg",
  "businessArea": "researchTopics,healthTopics"
  }]
};
data.requestURI = request.requestURI;
data.nodePathWithSelector = resource.path + '.ux-preview.html';
data.pagePathWithSelector = resource.path + '.ux-preview.html';
 return data;

});
use(function() {
 var data = {
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
}
;
data.requestURI = request.requestURI;
data.nodePathWithSelector = resource.path + '.ux-preview.html';
data.pagePathWithSelector = resource.path + '.ux-preview.html';
 return data;

});
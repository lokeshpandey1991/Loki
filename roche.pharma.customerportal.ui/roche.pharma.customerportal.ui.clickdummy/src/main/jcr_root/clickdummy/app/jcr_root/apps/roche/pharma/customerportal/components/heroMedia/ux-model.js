use(function() {
 var data = {
	"assetType": "image",
	"fileReference": "https://roche-staging-h.assetsadobe2.com/is/image/content/dam/customerportal/testimages/rendition/herobanner-2880X1404.jpg?wid=991&hei=483",
	"altText":"This is sample alt text",
	"headline":"This is sample headline",
	"subHeadline":"This is a sample subheadline",
	"headlinePosition": "bottomRight",
	"quoteText":"",
	"textPosition": "leftInsideImage", 
	"CTALabel": "read more",
	"CTALink": "http://www.fsjf.com",
	"isExternal": "true",
	"variationType": "heroBanner",
	"transparentOverlay": "true",
	"posterLink":"http://www.jplayer.org/video/poster/Big_Buck_Bunny_Trailer_480x270.png"
};
data.requestURI = request.requestURI;
data.nodePathWithSelector = resource.path + '.ux-preview.html';
data.pagePathWithSelector = resource.path + '.ux-preview.html';
 return data;

});
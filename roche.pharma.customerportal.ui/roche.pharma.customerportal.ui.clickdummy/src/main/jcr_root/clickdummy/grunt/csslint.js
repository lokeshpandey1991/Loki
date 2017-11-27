module.exports = {
    
    app: {
			options: {
				csslintrc: '.csslintrc',
				formatter: [
					{id: 'junit-xml', dest: 'report/csslint_junit.xml'},
					{id: 'csslint-xml', dest: 'report/csslint.xml'}
				  ]
			},
			src: ['<%= config.source %>/assets/css/*.css', '!<%= config.source %>/assets/css/vendor.css']
		}
};
    



    
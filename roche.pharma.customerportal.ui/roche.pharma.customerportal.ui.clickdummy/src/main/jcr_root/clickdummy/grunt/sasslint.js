module.exports = {
    
    app: {
			options: {
				configFile: 'sass-lint.yml',
				formatter: 'html',
				outputFile: 'sass-lint-report.html'
			},
			src: ['<%= config.source %>/templates/components/**/*.scss', '<%= config.source %>/assets/*.scss']
			}
};
    



    
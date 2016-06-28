module.exports = function(grunt) {

    // Project configuration.
    grunt.initConfig({
        main: {
            expand: true,
            cwd: 'project/',
            src: [
                '*.html',
                'assets/images/**/*',
                'assets/fonts/*.*',
                '!app/',
                'external-js/**/*',
                '!external-js/dashboard-js/**/*'
            ],
            dest: 'dist/',
            flatten: false,
            filter: 'isFile'
        },

        connect: {
            server: {
                options: {
                    port: 9000,
                    hostname: '127.0.0.1',
                    protocol: 'http',
                    open: true,
                    base: [
                        'public'
                    ],
                    keepalive: true
                }
            }
        }
    });



    grunt.registerTask('s', ['connect']);

    // Load the plugin that provides the "uglify" task.
    grunt.loadNpmTasks('grunt-contrib-connect');


};
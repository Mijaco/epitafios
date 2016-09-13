var services = angular.module('exampleApp.services', ['ngResource']);

services.factory('UserService', function($resource) {

    return $resource('rest/user/:action', {},
            {
                authenticate: {
                    method: 'POST',
                    params: {'action': 'authenticate'},
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                },
            }
    );
});

services.factory('ConfiguracionService', function($resource) {

    return $resource('rest/personalizacion/:action', {},
            {
                obtenerHtmlMain: {
                    method: 'POST',
                    params: {'action': 'obtenerHtmlMain'},
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }

            }
    );
});

services.factory('NewsService', function($resource) {

    return $resource('rest/news/:id', {id: '@id'});
});


services.service('fileUpload', ['$http', function($http) {
        this.uploadFileToUrl = function(file, uploadUrl) {
            var fd = new FormData();
            fd.append('file', file);
            $http.post("/oasis/rest/user/salvarImagenLogo", fd, {transformRequest: angular.identity, headers: {'Content-Type': undefined}}).success(function() {
            }).error(function() {
            });
        }
    }]);


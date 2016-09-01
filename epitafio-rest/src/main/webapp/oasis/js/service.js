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


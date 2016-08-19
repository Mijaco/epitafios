angular.module('exampleApp', ['ngRoute', 'ngCookies', 'exampleApp.services'])
        .config(
        
                ['$routeProvider', '$locationProvider', '$httpProvider', function($routeProvider, $locationProvider, $httpProvider) {
                        
                       
                        $routeProvider.when('/create', {
                            templateUrl: 'partials/create.html',
                            controller: CreateController
                        });

                        $routeProvider.when('/edit/:id', {
                            templateUrl: 'partials/edit.html',
                            controller: EditController
                        });

                        $routeProvider.when('/login', {
                            templateUrl: 'partials/login.html',
                            controller: LoginController
                        });
                        
                        $routeProvider.when('/configuracion', {
                            templateUrl: 'partials/configuracion.html',
                            controller: configuracionController
                        });

                      
                        $routeProvider.when('/mainbody', {
                            templateUrl: 'partials/mainbody.html',
                            controller: mainBodyController
                        });
                        
                          $routeProvider.when('/', {
                            templateUrl: 'partials/mainbody.html',
                            controller: HomeController
                        });
//                        
                        
                        $routeProvider.otherwise({
                            templateUrl: 'partials/mainbody.html',
                            controller: HomeController
                        });

//			$locationProvider.hashPrefix('!');
                        $locationProvider.html5Mode({
                            enabled: false,
                            requireBase: false
                        });

                        /* Register error provider that shows message on failed requests or redirects to login page on
                         * unauthenticated requests */
                        $httpProvider.interceptors.push(function($q, $rootScope, $location) {
                            return {
                                'responseError': function(rejection) {
                                    var status = rejection.status;
                                    var config = rejection.config;
                                    var method = config.method;
                                    var url = config.url;

                                    alert("status: " + status);
                                    if (status == 401) {
                                        $location.path("/login");
                                    } else {
                                        $rootScope.error = method + " on " + url + " failed with status " + status;
                                    }

                                    return $q.reject(rejection);
                                }
                            };
                        }
                        );

                        /* Registers auth token interceptor, auth token is either passed by header or by query parameter
                         * as soon as there is an authenticated user */
                        $httpProvider.interceptors.push(function($q, $rootScope, $location) {
                            return {
                                'request': function(config) {
                                    var isRestCall = config.url.indexOf('rest') == 0;
                                    if (isRestCall && angular.isDefined($rootScope.authToken)) {
                                        var authToken = $rootScope.authToken;
                                        if (exampleAppConfig.useAuthTokenHeader) {
                                            config.headers['X-Auth-Token'] = authToken;
                                        } else {
                                            config.url = config.url + "?token=" + authToken;
                                        }
                                    }
                                    return config || $q.when(config);
                                }
                            };
                        }
                        );

                    }]

                ).run(function($rootScope, $location, $cookieStore, UserService) {


    /* Reset error when a new view is loaded */
    $rootScope.$on('$viewContentLoaded', function() {
        delete $rootScope.error;
    });

    /*asignando color por default*/
    $rootScope.colorFondo = '#efefef';
    $rootScope.loginVisible = false;
    $rootScope.rutaInicial = 'oasis';
    
    
    $rootScope.hasRole = function(role) {

        if ($rootScope.user === undefined) {
            return false;
        }

        if ($rootScope.user.roles[role] === undefined) {
            return false;
        }

        return $rootScope.user.roles[role];
    };

    $rootScope.logout = function() {
//        delete $rootScope.user;
//        delete $rootScope.authToken;
//        $cookieStore.remove('authToken');
//        $location.path("/login");
        delete $rootScope.user;
        delete $rootScope.authToken;
        $cookieStore.remove('authToken');
        alert('Removiendo Token queda > ' + $cookieStore.get('authToken'));
        $location.path("/login");
    };
    
    var authToken = $cookieStore.get('authToken');
    alert('authToken: ' + authToken + " ;  loginVisible" + $rootScope.loginVisible);

    var originalPath = $location.path();
    
    if (authToken !== undefined) {
        $rootScope.authToken = authToken;
        UserService.get(function(user) {
            $rootScope.user = user;
            $location.path(originalPath);
        });
    } else {
        /* Try getting valid user from cookie or go to login page */
        
//        $location.path("/index");
//		$location.path("/other"); 
    }

    $rootScope.initialized = true;
    
});


function configuracionController($scope, NewsService,$rootScope,$cookieStore,$location) {
    
    

    var authToken = $cookieStore.get('authToken');
    
    alert('estamos en el configuracionController; authToken : ' + authToken);
    if (authToken !== undefined) {
        $scope.newsEntries = NewsService.query();
        $scope.deleteEntry = function (newsEntry) {
            newsEntry.$remove(function () {
                $scope.newsEntries = NewsService.query();
            });
        };
    }else{
        $location.path("/login");
    }
      
    
     $rootScope.logout = function() {

        delete $rootScope.user;
        delete $rootScope.authToken;
        $cookieStore.remove('authToken');
        alert('Removiendo Token queda > ' + $cookieStore.get('authToken'));
        $location.path("/login");
    };
    
};


function EditController($scope, $routeParams, $location, NewsService) {

    $scope.newsEntry = NewsService.get({id: $routeParams.id});

    $scope.save = function() {
        $scope.newsEntry.$save(function() {
            $location.path('/');
        });
    };
}
;


function CreateController($scope, $location, NewsService) {

    $scope.newsEntry = new NewsService();

    $scope.save = function() {
        $scope.newsEntry.$save(function() {
            $location.path('/');
        });
    };
}
;


function LoginController($scope, $rootScope, $location, $cookieStore, UserService) {

    $scope.rememberMe = true;
    $rootScope.loginVisible = true;
    

    $scope.login = function() {
        /*$.param (Jquery) crea un objeto serializable para poder viajar en la session*/
        UserService.authenticate($.param({id: $scope.username, password: $scope.password, rutaInicial : $rootScope.rutaInicial} ), function(authenticationResult) {
            var authToken = authenticationResult.token;
            $rootScope.authToken = authToken;

            alert('alerta de logueo: ' + $rootScope.authToken);
            if ($scope.rememberMe) {
                alert('rememberMe: ' + $scope.rememberMe);
                $cookieStore.put('authToken', authToken);
            }
            UserService.get(function(user) {
                $rootScope.user = user;
                $location.path("/configuracion");
            });
        });
    };
};


function HomeController($scope, $rootScope, $location, $cookieStore) {

    alert('Estamos en el home');
    $rootScope.initialized = true;
//    $rootScope.modoConfig = false;
//   var authToken = $cookieStore.get('authToken');
//    
    $scope.datosHome;// se debe traer la data del rest  

    var authToken = $cookieStore.get('authToken');
    
    if (authToken !== undefined) {
//        $scope.newsEntries = NewsService.query();
//        $scope.deleteEntry = function (newsEntry) {
//            newsEntry.$remove(function () {
//                $scope.newsEntries = NewsService.query();
//            });
//        };
    }else{
        $location.path("/login");
    }
   
   
    
};

function mainBodyController($scope, $rootScope, $location, $cookieStore, UserService) {

    alert('Estamos en el mainBodyController');
    // CUSTOMIZADO DEL INDEX
    
    $rootScope.colorFondo = 'red';
    $rootScope.modoModificacion= true;
    
};


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

services.factory('NewsService', function($resource) {

    return $resource('rest/news/:id', {id: '@id'});
});

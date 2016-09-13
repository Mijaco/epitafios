angular.module('exampleApp', ['ngRoute', 'ngCookies', 'exampleApp.services','exampleApp.directives',"xeditable"])
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
                                        $location.path("/");
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

                ).run(function($rootScope, $location, $cookieStore, UserService,ConfiguracionService,editableOptions) {


    /*Estilo para xeditable*/
    editableOptions.theme = 'bs3';
    


    /* Reset error when a new view is loaded */
    $rootScope.$on('$viewContentLoaded', function() {
        delete $rootScope.error;
    });

    /*asignando color por default*/
    $rootScope.colorFondo = '#efefef';
    $rootScope.loginVisible = false;
    $rootScope.rutaInicial = 'oasis';
    $rootScope.distrito = 'olivos';
    
    /*Asignando Cabecera por Defecto*/
//    $rootScope.HTMLMain.cabecera.titulo = "#Titulo Cabecera";
//    $rootScope.HTMLMain.cabecera.rutaLogo = "logo/logo.jpg";
//    $rootScope.HTMLMain.cabecera.medidaLogo = "height: 70px; margin-top: 10px; margin-left: 20px";
//    $rootScope.HTMLMain.cabecera.colorFondo = "#333333";
//    $rootScope.HTMLMain.cabecera.classMenu = "menu";
   
    $rootScope.loginVisible = false;
    
   
    
    /*Asignando Cuerpo por Defecto*/
    
    /*Asignando Pie por Defecto*/
    
    
    /*Extraemos configuracion del Rest que ya tiene cargado desde el sigleton*/
    ConfiguracionService.obtenerHtmlMain($.param({distrito: $rootScope.distrito, idbussines: 'oasis'} ), function(result) {
            var HTMLMain = result;
            $rootScope.HTMLMain = HTMLMain;

            alert('HTMLMain Resultado: ' + $rootScope.HTMLMain.cabecera.titulo);
//            alert('HTMLMain Resultado: ' + $rootScope.HTMLMain);
            
        });
    
    
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


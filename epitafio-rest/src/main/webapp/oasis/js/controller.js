
function configuracionController($scope, $rootScope, $cookieStore, $location,fileUpload) {

    $scope.uploadFile = function(){
               var file = $scope.myFile;
               
               alert('file ' + file);
               
               var uploadUrl = "/fileUpload";
               fileUpload.uploadFileToUrl(file, uploadUrl);
            };

  
     
    $rootScope.head = {
        titulo: 'Oasis',
        imagen: {rutaImagen: "img-cabecera/logo.jpg", medida: 'mediano'},
        colorFondo: 'blue'
    };

//    $rootScope.HTMLMain.cabecera.colorFondo = "HTMLMain";


    $scope.user = {
        email: 'email@example.com',
        tel: '123-45-67',
        number: 29,
        range: 10,
        url: 'http://example.com',
        search: 'blabla',
        color: '#6a4415',
        date: null,
        time: '12:30',
        datetime: null,
        month: null,
        week: null
    };

    var authToken = $cookieStore.get('authToken');

    alert('estamos en el configuracionController; authToken : ' + authToken);
    if (authToken !== undefined) {
//        $scope.newsEntries = NewsService.query();
        $scope.newsEntries;

    } else {
        $location.path("/login");
    }

    $rootScope.logout = function () {

        delete $rootScope.user;
        delete $rootScope.authToken;
        $cookieStore.remove('authToken');
        alert('Removiendo Token queda > ' + $cookieStore.get('authToken'));
        $location.path("/login");
    };

}
;


function EditController($scope, $routeParams, $location, NewsService) {

//    $scope.newsEntry = NewsService.get({id: $routeParams.id});
    $scope.newsEntry;
    $scope.save = function () {
        $scope.newsEntry.$save(function () {
            $location.path('/');
        });
    };
}
;


function CreateController($scope, $location, NewsService) {

//    $scope.newsEntry = new NewsService();
    $scope.newsEntry;

    $scope.save = function () {
        $scope.newsEntry.$save(function () {
            $location.path('/');
        });
    };
}
;


function LoginController($scope, $rootScope, $location, $cookieStore, UserService) {

    $scope.rememberMe = true;
    $rootScope.loginVisible = true;


    $scope.login = function () {
        /*$.param (Jquery) crea un objeto serializable para poder viajar en la session*/
        var id = $scope.username + "-" + $rootScope.rutaInicial;
        alert('logueando con id : ' + id);

//      delete $rootScope.user;
        delete $rootScope.authToken;
        $cookieStore.remove('authToken');

        UserService.authenticate($.param({id: id, password: $scope.password, rutaInicial: $rootScope.rutaInicial}), function (authenticationResult) {
            var authToken = authenticationResult.token;
            $rootScope.authToken = authToken;

            alert('alerta de logueo: ' + $rootScope.authToken);
            if ($scope.rememberMe) {
                alert('rememberMe: ' + $scope.rememberMe);
                $cookieStore.put('authToken', authToken);
            }
            UserService.get(function (user) {
                $rootScope.user = user;
                $location.path("/configuracion");
            });
        });
    };
}
;


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
    } else {
        $location.path("/");
    }

}
;

function mainBodyController($scope, $rootScope, $location, $cookieStore, UserService) {

    alert('Estamos en el mainBodyController');
    // CUSTOMIZADO DEL INDEX

    $rootScope.colorFondo = 'red';
    $rootScope.modoModificacion = true;

}
;

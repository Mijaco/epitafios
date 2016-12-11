
function configuracionController($scope, $rootScope, $cookieStore, $location,fileUpload) {
    $scope.cambiarModoUpload = function() {
        modoUpload = !modoUpload;
    };
    
    $scope.myFunction = function() {
        $scope.ClearCanvas();
        var c = document.getElementById("canvas-logo");
        var ctx = c.getContext("2d");
        var tra = document.getElementById("words").value;
        ctx.font = "110px  'Lobster', cursive";
        ctx.textAlign = 'center';
        
        var gradient = ctx.createLinearGradient(0, 0, 150, 60);
        gradient.addColorStop("0", "black");
        gradient.addColorStop("0.2", "blue");
        gradient.addColorStop("0.3", "black");
        gradient.addColorStop("0.4", "black");
        gradient.addColorStop("0.5", "white");
        gradient.addColorStop("0.6", "black");
        gradient.addColorStop("0.7", "black");
        gradient.addColorStop("0.8", "white");
        gradient.addColorStop("1.0", "black");
        ctx.fillStyle = gradient;
        ctx.fillText(tra, 150, 90);
        ctx.textAlign = "center";    
        
    }


    $scope.ClearCanvas = function() {
        var c = document.getElementById("canvas-logo");
        var ctx = c.getContext("2d");
        ctx.clearRect(0, 0, c.width, c.height);
    }

//    $scope.Preview = function() {
//        var canvas = document.getElementById("canvas-logo");
//        var dataUrl = canvas.toDataURL();
//
//        window.open(dataUrl, "toDataURL() image", "width=600, height=200");
//    }
   

    $scope.uploadFile = function(){
               var file = $scope.myFile;
               
               alert('file ' + file);
               
               var uploadUrl = "/fileUpload";
               fileUpload.uploadFileToUrl(file, uploadUrl);
            };
    
    $scope.uploadGeneratedLogo = function() {
        var canvas = document.getElementById("canvas-logo");
        var dataURL = canvas.toDataURL();
//        var dataURL = canvas.toDataURL('image/jpg', 0.5);
        var file = dataURItoBlob(dataURL);
        alert('file: ' + file);
        var uploadUrl = "/fileUpload";

        console.log("updateandooo...");
        fileUpload.uploadGeneratedFile(file, uploadUrl);       
        $scope.$digest();
       
    };
    
    function dataURItoBlob(dataURI) {
    // convert base64/URLEncoded data component to raw binary data held in a string
    var byteString;
    if (dataURI.split(',')[0].indexOf('base64') >= 0)
        byteString = atob(dataURI.split(',')[1]);
    else
        byteString = unescape(dataURI.split(',')[1]);

    // separate out the mime component
    var mimeString = dataURI.split(',')[0].split(':')[1].split(';')[0];

    // write the bytes of the string to a typed array
    var ia = new Uint8Array(byteString.length);
    for (var i = 0; i < byteString.length; i++) {
        ia[i] = byteString.charCodeAt(i);
    }

    return new Blob([ia], {type:mimeString});
}



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

    $rootScope.logout = function() {

        delete $rootScope.user;
        delete $rootScope.authToken;
        $cookieStore.remove('authToken');
        alert('Removiendo Token queda > ' + $cookieStore.get('authToken'));
        $location.path("/login");
    };


    var tabClasses;

    function initTabs() {
        tabClasses = ["", "", "", ""];
    }

    $scope.getTabClass = function(tabNum) {
        return tabClasses[tabNum];
    };

    $scope.getTabPaneClass = function(tabNum) {
        return "tab-pane " + tabClasses[tabNum];
    }

    $scope.setActiveTab = function(tabNum) {
        initTabs();
        tabClasses[tabNum] = "active";
    };

    $scope.tab1 = "This is first section";
    $scope.tab2 = "This is SECOND section";
    $scope.tab3 = "This is THIRD section";
    $scope.tab4 = "This is FOUTRH section";

    //Initialize 
    initTabs();
    $scope.setActiveTab(1);

}
;


function EditController($scope, $routeParams, $location, NewsService) {

//    $scope.newsEntry = NewsService.get({id: $routeParams.id});
    $scope.newsEntry;
    $scope.save = function() {
        $scope.newsEntry.$save(function() {
            $location.path('/');
        });
    };
}
;


function CreateController($scope, $location, NewsService) {

//    $scope.newsEntry = new NewsService();
    $scope.newsEntry;

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
        var id = $scope.username + "-" + $rootScope.rutaInicial;
        alert('logueando con id : ' + id);

//      delete $rootScope.user;
        delete $rootScope.authToken;
        $cookieStore.remove('authToken');

        UserService.authenticate($.param({id: id, password: $scope.password, rutaInicial: $rootScope.rutaInicial}), function(authenticationResult) {
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

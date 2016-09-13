//var directives = angular.module('exampleApp.services', ['ngResource']);
//       
//directives.directive('directivaLoader', ['$parse', function ($parse) {
//        
var directivas = angular.module('exampleApp.directives', ['ngResource']);
directivas.directive('fileModel', ['$parse', function ($parse) {
            return {
               restrict: 'A',
               link: function(scope, element, attrs) {
                  var model = $parse(attrs.fileModel);
                  var modelSetter = model.assign;
                  
                  element.bind('change', function(){
                     scope.$apply(function(){
                        modelSetter(scope, element[0].files[0]);
                     });
                  });
               }
            };
         }]);
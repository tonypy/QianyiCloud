var uiApp = angular.module("uiApp", ["ui.router"]);

uiApp.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("person");

    $stateProvider
        .state('person', {
            url: '/person',
            templateUrl: '/tpl/person.html',
            controller: 'PersonController'
        })
        .state('some',{
        	url:'/some',
        	 templateUrl: '/tpl/some.html',
             controller: 'SomeController'
        })
        .state("sms",{
            url:'/sms',
            templateUrl: '/tpl/sms.html',
            controller: 'SmsController'
        })
      ;
});


uiApp.controller("PersonController", function ($scope, $http) {

        $scope.people = "";
        $scope.errorMessage = "";

    $scope.getMessageResponse = function(personName) {
    	$http.post('/dispatch', personName).success(function(data){
            $scope.people = data;
            $scope.errorMessage = "";
        }).error(function() {
            $scope.errorMessage = "错误";
        });
    }
  
});


uiApp.controller("SomeController", function ($scope, $http) {
	$scope.str = "";
    $scope.errorMessage = "";

$scope.getSome = function(){
	$http.get('/getsome').success(function(data){
        $scope.str = data;
        $scope.errorMessage = "";
    }).error(function() {
        $scope.errorMessage = "错误";
    });
}
});
uiApp.controller("SmsController", function ($scope, $http) {

    $scope.msgstr = "";
    $scope.errorMessage = "";
    $scope.sendMessage = function(msg){
        $http.post('/sendMessage',msg).success(function(data){
            $scope.msgstr = data;
            $scope.errorMessage = "";
        }).error(function() {
            $scope.errorMessage = "错误";
        });
    }
    $scope.datastr = "";
    $scope.errorMessage = "";

    $scope.report = function(code){
        $http.post('/report',code).success(function(data){
            $scope.datastr = data;
            $scope.errorMessage = "";
        }).error(function() {
            $scope.errorMessage = "错误";
        });
    }
    $scope.str = "";
    $scope.errorMessage = "";
    $scope.reply = function(replyinfo){
        $http.post('/reply',replyinfo).success(function(data){
            $scope.str = data;
            $scope.errorMessage = "";
        }).error(function() {
            $scope.errorMessage = "错误";
        });
    }
});
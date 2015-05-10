app.controller('RegistrationController',function($rootScope,$scope,$location,authService)
{
    $scope.newUser={
        firstName:'test',
        lastName:'test',
        username:'test',
        password:'test',
        email:'adnan.sivro@gmail.com'
    } ;
    $scope.goToLogin=function()
    {
        $location.path('/login');
    }

    $scope.register=function()
    {
        authService.register($scope.newUser)
            .success(function(data){
                alert('Mail je poslan1 na '+$scope.newUser.email);
                $rootScope.setInfoMessage('HEADER');})
            .error(function(){
                alert('Pala registracija');
                $rootScope.setInfoMessage('HEADER');
            });
    };
});
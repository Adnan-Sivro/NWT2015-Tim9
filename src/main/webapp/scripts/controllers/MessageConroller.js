/**
 * Created by Enes on 9.5.2015..
 */

app.controller('MessageController', function ($translate, $scope,$rootScope,$cookieStore) {
    if($rootScope.message.text)
    {
        $rootScope.hideTimer();
    }
});
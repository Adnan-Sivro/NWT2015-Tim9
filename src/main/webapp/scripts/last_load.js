/**
 * Created by Enes on 9.5.2015..
 */
var token = "";

app.run(function ($rootScope, $location, $cookieStore,$translate) {


    if($cookieStore.get('currentLng'))
         $rootScope.currentLng=$cookieStore.get('currentLng');
    else
         $rootScope.currentLng='bs';

});


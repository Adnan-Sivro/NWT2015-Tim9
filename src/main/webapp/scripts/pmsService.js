/**
 * Created by Enes on 9.5.2015..
 */
app.service('pmsService', function ($http, $rootScope, $cookieStore,$location) {
    var UserApiURL = "/Hotel/rest/users";
    var pmsService={};
     var _postData = function (path, data) {
        return $http.post(path, data, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    };
    var _putData = function (path, data) {
        return $http.put(path, data, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    };

    var _getData=function (path){
      return $http({
          url: path,
          method: "GET",
          data: {},
          headers: {
              'Authorization':$rootScope.user.jwt,
              'Accept': 'application/json',
              'Content-Type': 'application/json'
          }
      })
    };

    var _getUserData=function(){
        return _getData(UserApiURL+"/"+$rootScope.user.name);
    };

   pmsService.getUserData=_getUserData;

    return pmsService;


});


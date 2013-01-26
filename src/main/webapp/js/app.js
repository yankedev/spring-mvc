function RegistrationCtrl($scope, $http) {
    $http.get('countries.json').success(function(data) {
        $scope.countries = data;
    });
    $scope.newUserId = -1;

    //function posting data as normal html form post parameters
    //param1=val1&param2=val2&...
    $scope.createUser = function() {
        var user = $scope.user;
        var xsrf = $.param(user);
        var url = 'registration';
        $http({
            method: 'POST',
            url: url,
            data: xsrf,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).success(function(data) {
                $scope.newUserId = 999;
                alert(data);
            }).error(function(message, e){
                $scope.errors = e;
                $scope.errorMessage = message;
                $scope.newUserId = -1;
            })
    };

    //function posting the user as JSON structure in the request body
    $scope.createUserJSON = function() {
        var user = $scope.user;
        var url = 'rest/registration';
        $http({
            method: 'POST',
            url: url,
            data: user
        }).success(function(data) {
            $scope.newUserId = data;
        }).error(function(message, e){
                $scope.errors = e;
                $scope.errorMessage = message;
                $scope.newUserId = -1;
            })
    };

}
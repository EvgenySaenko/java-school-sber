angular.module('app').controller('recipeController', function ($scope, $http, $location, $routeParams) {
    const contextPath = 'http://localhost:8189/cooks';


    //открыть страницу рецепта
    $scope.showRecipe = function () {
         console.log(JSON.parse(JSON.stringify('working method show Recipe')));
         console.log(JSON.parse(JSON.stringify($routeParams.recipeId)));
        $http({
            url: contextPath + '/api/v1/recipes/' + $routeParams.recipeId,
            method: 'GET',
        }).then(function (response){
            $scope.Recipe = response.data;
        });
        
    }

     $scope.showRecipe();
});


(function ($localStorage) {
    'use strict';

    angular
        .module('app', ['ngRoute', 'ngStorage'])
        .config(config)//функции для конфигурирования и запуска
        .run(run);

    function config($routeProvider, $httpProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'home/home.html',
                controller: 'homeController'
            })
            .when('/recipes', {
                templateUrl: 'recipes/recipes.html',
                controller: 'recipesController'
            })
            .when('/recipes/:recipeId', {
                templateUrl: 'recipe/recipe.html',
                controller: 'recipeController'
            })
            .when('/ingredients', {
                templateUrl: 'ingredients/ingredients.html',
                controller: 'ingredientsController'
            })
            .when('/new_recipe',{
                templateUrl: 'new_recipe/new_recipe.html',
                controller: 'new_recipeController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }



    const contextPath = 'http://localhost:8189/cooks';


    //при старте
    function run($rootScope, $http, $localStorage) {

    }
})();



angular.module('app').controller('indexController', function ($scope, $http, $localStorage, $location) {
    const contextPath = 'http://localhost:8189/cooks';

    $scope.imageSources = [];

    $scope.imageSources.push('https://i.ibb.co/L8BQNBX/i.jpg');

});

//template: '<h1>This is my Recipe page recipeId </h1>'

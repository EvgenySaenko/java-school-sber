angular.module('app').controller('new_recipeController', function ($scope, $http, $location, $window, $routeParams) {
    const contextPath = 'http://localhost:8189/cooks';


    $scope.Ingredients = [
    ];

    $scope.Add = function () {
        var ingredient = {};
        ingredient.title = $scope.title;
        ingredient.quantity = $scope.quantity;
        $scope.Ingredients.push(ingredient);

        //Clear the TextBoxes.
        $scope.title = "";
        $scope.quantity = "";
    };

    $scope.Remove = function (index) {
        //Find the record using Index from Array.
        var title = $scope.Ingredients[index].title;
        if ($window.confirm("Do you want to delete: " + title)) {
            //Remove the item from Array using Index.
            $scope.Ingredients.splice(index, 1);
        }
    }


    //добавить новый рецепт
    $scope.addNewRecipe = function () {
        $scope.newRecipe.ingredients = $scope.Ingredients;
        //$scope.newRecipe.ingredients.push($scope.Ingredients);
        $http.post(contextPath + '/api/v1//recipes/new_recipe', $scope.newRecipe)
            .then(function (response) {
                $scope.newRecipe = null;
                $location.path('/recipes');
            });
    }

});


angular.module('app').controller('recipesController', function ($scope, $http, $location ,$window, $localStorage) {
    const contextPath = 'http://localhost:8189/cooks';

    //отображение таблицы рецептов
    $scope.showRecipesPage = function (pageIndex = 1) {
        $http({
            url: contextPath + '/api/v1/recipes',
            method: 'GET',
            params: {
                title: $scope.filter ? $scope.filter.title : null,
                p: pageIndex
            }
        }).then(function (response) {
            $scope.RecipesPage = response.data;
            console.log($scope.RecipesPage)

            let minPageIndex = pageIndex - 2;
            if (minPageIndex < 1) {
                minPageIndex = 1;
            }

            let maxPageIndex = pageIndex + 2;
            if (maxPageIndex > $scope.RecipesPage.totalPages) {
                maxPageIndex = $scope.RecipesPage.totalPages;
            }
            //PaginationArray - индексы страниц сгенериные по странице
            $scope.PaginationArray = $scope.generatePagesIndexes(minPageIndex, maxPageIndex);
        });
    };


    //создает лист список страниц например с 5 по 15
    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }


    //открыть страницу рецепта
    $scope.showRecipe = function (recipeId) {
        console.log(JSON.parse(JSON.stringify(recipeId + 'это наш id')));
        $location.path('/recipes/' + recipeId);
    }


    //удаление рецепта по id
    $scope.deleteRecipeById = function (recipeId) {
        $http.delete(contextPath + '/api/v1/recipes/' + recipeId)
            .then(function (response) {
                $scope.showRecipesPage();
            });
    }



    $scope.showRecipesPage();
});
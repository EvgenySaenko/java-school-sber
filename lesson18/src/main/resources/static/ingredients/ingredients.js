angular.module('app').controller('ingredientsController', function ($scope, $http, $location, $localStorage) {
    const contextPath = 'http://localhost:8189/cooks';

    //отображение таблицы ингредиентов
    $scope.showIngredientsPage = function (pageIndex = 1) {
        $http({
            url: contextPath + '/api/v1/ingredients',
            method: 'GET',
            params: {
                title: $scope.filter ? $scope.filter.title : null,
                p: pageIndex
            }
        }).then(function (response) {
            $scope.IngredientsPage = response.data;
            console.log($scope.IngredientsPage)

            let minPageIndex = pageIndex - 2;
            if (minPageIndex < 1) {
                minPageIndex = 1;
            }

            let maxPageIndex = pageIndex + 2;
            if (maxPageIndex > $scope.IngredientsPage.totalPages) {
                maxPageIndex = $scope.IngredientsPage.totalPages;
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

    $scope.showIngredientsPage();
});
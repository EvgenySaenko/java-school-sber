
//$scope.x = 0;

$scope.addInput = function () {
    //  if ($scope.x < 10) {
    $scope.str = '  <div class="form-group col-md-6">\n' +
        '            <input class="form-control" type="text" placeholder="Название ингридиента" ng-model="newRecipe.ingredients.ingredient.getProduct().getTitle()">\n' +
        '            <input class="form-control" type="number" placeholder="Количество"  ng-model="newRecipe.ingredients.ingredient.getProduct().getTitle()">\n' +
        '            <div id="input\' + ($scope.x + 1) + \'"></div>\n' +
        '        </div>';
    document.getElementById('input' + $scope.x).innerHTML = $scope.str;
    // $scope.x++;
    // } else
    // {
    //     alert('STOP it!');
    // }
}

$scope.choiceSet = {
    choices: []
};
$scope.quest = {};
$scope.choiceSet.choices = [];

$scope.addNewChoice = function() {
    $scope.choiceSet.choices.push('');
};
$scope.removeChoice = function(z) {
    $scope.choiceSet.choices.splice(z, 1);
};
//////////////////////////////////////////////////////////////////////////////////

$scope.SelectProduct = {
    model: null,
    availableOptions: [
        "Молоко","Скущеное молоко","Мука","Сахар","Сливки","Маргарин","Сливочное масло","Дрожжи",
        "Клубника","Белый шоколад","Черный шоколад","Желатин","Яйца","Мед"
    ]
};
//////////////////////////////////////
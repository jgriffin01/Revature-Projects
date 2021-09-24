function getHashTags(string) {
    var stringOne;
    var stringTwo;
    var stringThree;
    var array = string.split(" ");
    for (var i = 0; i < array.size(); i++) {
        if (array[i].size() > stringOne.size()) {
            stringThree = stringTwo;
            stringTwo = stringOne;
            stringOne = array[i];
        }
        else if (array[i].size() > stringTwo.size()) {
            stringThree = stringTwo;
            stringTwo = array[i];
        }
        else if (array[i].size() > stringThree.size()) {
            stringThree = array[i];
        }
    }
    var answer = ["#", "#", "#"];
    answer[0] = "#" + stringOne;
    answer[1] = "#" + stringtwo;
    answer[2] = "#" + stringThree;
    return answer;
}

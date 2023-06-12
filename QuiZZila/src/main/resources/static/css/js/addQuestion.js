$(document).ready(function () {
    let questionIndex = 2;

    $("#addQuestion").click(function () {
        let newQuestion =
            '<div class="question">' +
            '<label for="question' + questionIndex + '">Question ' + questionIndex + ':</label>' +
            '<input type="text" id="question' + questionIndex + '" name="questions[' + (questionIndex - 1) + '].text" required/>' +
            '<div class="answer">' +
            '<label for="choice1">Choice 1:</label>' +
            '<input type="text" id="choice1" name="questions[' + (questionIndex - 1) + '].answers[0].text" required/>' +
            '<input type="radio" id="correctOption1" name="questions[' + (questionIndex - 1) + '].correctOption" value="1" required>' +
            '<label for="correctOption1">Correct Option</label>' +
            '</div>' +
            '<div class="answer">' +
            '<label for="choice2">Choice 2:</label>' +
            '<input type="text" id="choice2" name="questions[' + (questionIndex - 1) + '].answers[1].text" required/>' +
            '<input type="radio" id="correctOption2" name="questions[' + (questionIndex - 1) + '].correctOption" value="2" required>' +
            '<label for="correctOption2">Correct Option</label>' +
            '</div>' +
            '</div>';
        $("#questionsContainer").append(newQuestion);
        questionIndex++;
    });
});
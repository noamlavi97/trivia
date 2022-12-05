package trivia;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.control.Button;

public class Game {

    //Class variables
    private QuestionArray qArray;
    private int currentScore, currentQuestion;
    private final int CORRECT_ANSWER_SCORE=10, INCORRECT_ANSWER_SCORE=-5, NUM_OF_QUESTIONS = 5;
    private TextFlow currentScoreTextFlow, questionTextFlow;
    private Button buttonA, buttonB, buttonC, buttonD;

    //Constructor
    public Game(TextFlow currentScoreTextFlow, TextFlow questionTextFlow, Button buttonA, Button buttonB, Button buttonC, Button buttonD) {
        qArray = new QuestionArray();
        qArray.readQuestionFromFile();
        currentScore = 0;
        currentQuestion = 0;
        this.currentScoreTextFlow=currentScoreTextFlow;
        printCurrentScore();
        this.questionTextFlow= questionTextFlow;
        this.buttonA=buttonA;
        this.buttonB=buttonB;
        this.buttonC=buttonC;
        this.buttonD=buttonD;
        //Enable buttons
        this.buttonA.setDisable(false);
        this.buttonB.setDisable(false);
        this.buttonC.setDisable(false);
        this.buttonD.setDisable(false);
        qArray.printQuestion(currentQuestion, questionTextFlow, buttonA, buttonB, buttonC, buttonD);
    }

    //Check the user answer to the question and print the score - then skip to the next question
    public void checkAnswer(int answerNum) {
        if(qArray.checkAnswer(currentQuestion, answerNum)) {
            currentScore += CORRECT_ANSWER_SCORE;
        }
        else {
            currentScore += INCORRECT_ANSWER_SCORE;
        }
        printCurrentScore();
        //If this is the last question (-1 because count starts from 0)
        if(currentQuestion == NUM_OF_QUESTIONS-1) {
            gameOver(questionTextFlow);
        }
        //Print the next question
        else {
            currentQuestion++;
            qArray.printQuestion(currentQuestion, questionTextFlow, buttonA, buttonB, buttonC, buttonD);
        }
    }

    //Print the current score
    public void printCurrentScore () {
        Text score=new Text("The current score is: "+Integer.toString(this.currentScore));
        score.setFill(Color.PURPLE);
        score.setFont(Font.font("Helvetica", FontPosture.ITALIC, 25));
        //if a word already exists
        if (!currentScoreTextFlow.getChildren().isEmpty()) {
            currentScoreTextFlow.getChildren().clear();
        }
        currentScoreTextFlow.getChildren().addAll(score);
        currentScoreTextFlow.setStyle("-fx-background-color: yellow"); 
    }

    //Print game over and block the buttons
    public void gameOver(TextFlow questionTextFlow) {
        Text question=new Text("The game is over!");
        question.setFill(Color.PURPLE);
        question.setFont(Font.font("Helvetica", FontPosture.ITALIC, 35));
        //if a word already exists
        if (!questionTextFlow.getChildren().isEmpty()) {
            questionTextFlow.getChildren().clear();
        }
        questionTextFlow.getChildren().addAll(question);
        questionTextFlow.setStyle("-fx-background-color: yellow");
        //Disable buttons
        this.buttonA.setDisable(true);
        this.buttonB.setDisable(true);
        this.buttonC.setDisable(true);
        this.buttonD.setDisable(true);
        //Restart the count
        currentQuestion=0;
    }

}

package trivia;

import java.util.Random;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Question {
    
    private String question;
    //Correct answer
    private String [] answers;
    private int correctAnswerIndex;
    private final int NUM_OF_ANSWERS=4;

    //Constructor (the correct answer is in the first position in the array)
    public Question(String question, String [] answers) {
        this.question = question;
        this.answers = new String [NUM_OF_ANSWERS];
        //Initialize
        for (int i=0; i<NUM_OF_ANSWERS; i++) {
            this.answers[i] = "";
        }
        //Put the answers and randomize the order, while keeping the index of the correct answer
        Random r = new Random();
        correctAnswerIndex=r.nextInt(NUM_OF_ANSWERS);
        //i runs on all the places in the answers array, j runs on the incorrect answers
        for (int i=0, j=1; i<NUM_OF_ANSWERS; i++) {
            //If this is the index of the correct answer, then we put the correct answer
            if(i==correctAnswerIndex) {
                this.answers[i]=answers[0];
            }
            else {
                this.answers[i] = answers[j];
                j++;
                }
            }     
    }
    
    //getters
    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    //Print the question to the buttons
    public void printQuestionToButton (Button buttonA, Button buttonB, Button buttonC, Button buttonD) {
        buttonA.setText(answers[0]);
        buttonB.setText(answers[1]);
        buttonC.setText(answers[2]);
        buttonD.setText(answers[3]);
    }

    public void printQuestionToTextBox(TextFlow questionTextFlow) {
        Text question=new Text(this.question);
        question.setFill(Color.PURPLE);
        question.setFont(Font.font("Helvetica", FontPosture.ITALIC, 35));
        //if a word already exists
        if (!questionTextFlow.getChildren().isEmpty()) {
            questionTextFlow.getChildren().clear();
        }
        questionTextFlow.getChildren().addAll(question);
        questionTextFlow.setStyle("-fx-background-color: yellow"); 
    }


}

package trivia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.control.Button;
import javafx.scene.text.TextFlow;

public class QuestionArray {
    
    //Class variables
    private ArrayList<Question> qArray;
    private final int NUM_OF_QUESTIONS = 5, NUM_OF_ANSWERS=4;

    //Constructor
    public QuestionArray() {
        qArray = new ArrayList<Question>();
    }

    //This method generates the question arraylist abd shuffles it
    public void readQuestionFromFile() {
        Question q;
        String [] answers = new String [NUM_OF_ANSWERS];
        String question="";
        FileReader questionsFileReader;
        BufferedReader reader;
        //Read a word from the file and save it to the arraylist
        try {
            java.net.URL url = getClass().getResource("Questions.txt");
            questionsFileReader = new FileReader(url.getPath());
            reader= new BufferedReader(questionsFileReader);
            //Read the questions
            for (int i = 0; i < NUM_OF_QUESTIONS; i++) {
                question = reader.readLine();
                for (int j=0; j < NUM_OF_ANSWERS; j++) {
                    answers[j] = reader.readLine();
                }
                q = new Question(question, answers);
                qArray.add(q);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.shuffle(qArray);
    }

    //Check the current guess
    public Boolean checkAnswer(int questionNum, int answerNum) {
        return (qArray.get(questionNum).getCorrectAnswerIndex() == answerNum);      
    }

    //Print question
    public void printQuestion(int questionNum, TextFlow questionTextFlow, Button buttonA, Button buttonB, Button buttonC, Button buttonD) {
        qArray.get(questionNum).printQuestionToButton(buttonA, buttonB, buttonC, buttonD);
        qArray.get(questionNum).printQuestionToTextBox(questionTextFlow);
    }
}

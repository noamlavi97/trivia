package trivia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuestionArray {
    
    //Class variables
    private ArrayList<Question> questionsArray;
    private final int NUM_OF_QUESTIONS = 5, NUM_OF_ANSWERS=4;

    //Constructor
    public QuestionArray() {
        questionsArray = new ArrayList<Question>();
    }

    //This method generates the question arraylist
    public void readQuestionFromFile() {
        Question q;
        String [] answers = new String [NUM_OF_ANSWERS];
        String question="";
        FileReader wordsFileReader;
        BufferedReader reader;
        //Read a word from the file and save it to the arraylist
        try {
            wordsFileReader = new FileReader("src\\trivia\\Questions.txt");
            reader= new BufferedReader(wordsFileReader);
            //Read the questions
            for (int i = 0; i < NUM_OF_QUESTIONS; i++) {
                question = reader.readLine();
                for (int j=0; j < NUM_OF_ANSWERS; j++) {
                    answers[j] = reader.readLine();
                }
                q = new Question(question, answers);
                questionsArray.add(q);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Check the current guess
    public void checkAnswer(int question, int answers) {

        System.out.println("Current Guess: " + currentScore);
    }
}

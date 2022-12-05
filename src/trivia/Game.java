package trivia;

public class Game {

    //Class variables
    private QuestionArray qArray;
    private int currentScore;
    private final int NUM_OF_QUESTIONS = 5, NUM_OF_ANSWERS=4;

    //Constructor
    public Game() {
        qArray = new QuestionArray();
        qArray.readQuestionFromFile();
        currentScore = 0;
    }



}

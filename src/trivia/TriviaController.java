package trivia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.TextFlow;

public class TriviaController {

    @FXML
    private Button buttonA;

    @FXML
    private Button buttonB;

    @FXML
    private Button buttonC;

    @FXML
    private Button buttonD;

    @FXML
    private TextFlow currentScoreTextFlow;

    @FXML
    private TextFlow questionTextFlow;

    @FXML
    private Button exitButton;

    @FXML
    private Button newGameButton;

    private Game game;

    @FXML
    void buttonAClick(ActionEvent event) {
        game.checkAnswer(0);
    }

    @FXML
    void buttonBClick(ActionEvent event) {
        game.checkAnswer(1);
    }

    @FXML
    void buttonCClick(ActionEvent event) {
        game.checkAnswer(2);
    }

    @FXML
    void buttonDClick(ActionEvent event) {
        game.checkAnswer(3);
    }

    //Close program
    @FXML
    void exitProgram(ActionEvent event) {
        System.exit(0);
    }

    // Start a new game
    @FXML
    void newGame(ActionEvent event) {
        game=new Game(currentScoreTextFlow, questionTextFlow, buttonA, buttonB, buttonC, buttonD);
    }

    //Turn off the buttons
    public void initialize() {
        //Turn on in a new game
        this.buttonA.setDisable(true);
        this.buttonB.setDisable(true);
        this.buttonC.setDisable(true);
        this.buttonD.setDisable(true);
    }

}

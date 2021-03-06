package runner;

import controller.GameController;
import view.CivEnum;
import view.GameScreen;
import view.GridFX;
import view.NewSettlementPrompt;
import view.StartScreen;
import model.Bandit;
import model.Egypt;
import model.QinDynasty;
import model.RomanEmpire;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {

    private Stage stage;

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    public void start(Stage primaryStage) {
        stage = new Stage();
        stage.setTitle("CS1331 Civilization");
        Scene display = startGame();
        stage.setScene(display);
        primaryStage = stage;
        primaryStage.show();
    }

    /**
     * This is the main method that launches the javafx application
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
    * This method is responsible for setting the scene to the corresponding
    * layout.
    * and returning the scene.
    * @return Scene
    */
    public Scene startGame() {
        StartScreen startScreen = new StartScreen();
        Scene start = new Scene(startScreen);
        startScreen.getStartButton().setOnMousePressed(e -> {
                NewSettlementPrompt.newSettlementAlert();
                CivEnum selected = startScreen.getCivList().getSelectionModel()
                                                           .getSelectedItem();
                if (selected == null) {
                    Egypt egypt = new Egypt();
                    String name = NewSettlementPrompt.getText().getResult();
                    GridFX.getMap().putSettlement(name, egypt, 0, 9);
                    GridFX.getMap().addEnemies(new Bandit(), 1);
                    GameController.setCivilization(egypt);
                } else {
                    civOption(selected);
                }

                if (NewSettlementPrompt.getText().getResult() == null) {
                    stage.setScene(start);
                } else {
                    GameScreen gameScreen = new GameScreen();
                    gameScreen.update();
                    stage.setScene(new Scene(gameScreen));
                }
            });
        return start;
    }

    //Helper for startGame() method
    public void civOption(CivEnum selected) {
        String name = new String();
        switch (selected) {
        case ANCIENT_EGYPT:
            Egypt egypt = new Egypt();
            name = NewSettlementPrompt.getText().getResult();
            GridFX.getMap().putSettlement(name, egypt, 0, 9);
            GridFX.getMap().addEnemies(new Bandit(), 1);
            GameController.setCivilization(egypt);
            break;
        case QIN_DYNASTY:
            QinDynasty qin = new QinDynasty();
            name = NewSettlementPrompt.getText().getResult();
            GridFX.getMap().putSettlement(name, qin, 0, 9);
            GridFX.getMap().addEnemies(new Bandit(), 1);
            GameController.setCivilization(qin);
            break;
        case ROMAN_EMPIRE:
            RomanEmpire rome = new RomanEmpire();
            name = NewSettlementPrompt.getText().getResult();
            GridFX.getMap().putSettlement(name, rome, 0, 9);
            GridFX.getMap().addEnemies(new Bandit(), 1);
            GameController.setCivilization(rome);
            break;
        default: break;
        }
    }
}

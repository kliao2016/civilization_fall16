package view;

import model.Civilization;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 * This class represents the Start Screen for the Civ applicatios. This is the
 * layout that should be displayed upon running the Civ application.
 *
 * This class should have and display
 * 1. a background
 * 2. a list of Civilizations
 * 3. a Start button
 */
public class StartScreen extends StackPane {

    private Button startButton = new Button();
    private static final String IMAGE_SRC =
                                "File:./src/main/java/view/civ_background.png";
    private ImageView startImage;
    private ListView<CivEnum> civList = new ListView<>();
    // private ObservableList<CivEnum> passList = FXCollections
    //                             .observableArrayList(CivEnum.ANCIENT_EGYPT,
    //                                                  CivEnum.QIN_DYNASTY,
    //                                                  CivEnum.ROMAN_EMPIRE);
    private StackPane startLayout;
    private VBox startBox = new VBox();
    private Label startLabel = new Label("Select a Civilization to Begin");

    /**
    * constuctor of the start screen. Should set the background
    * image and display a list of civilizations and a start button
    */
    public StartScreen() {

        //Image
        startImage = new ImageView(IMAGE_SRC);

        //List
        civList.getItems().addAll(CivEnum.ANCIENT_EGYPT,
                                CivEnum.QIN_DYNASTY,
                                CivEnum.ROMAN_EMPIRE);

        //Label
        startLabel.setTextFill(Color.RED);

        //Button
        startButton.setText("START GAME");

        //VBox
        startBox.getChildren().addAll(startLabel, civList, startButton);
        startBox.setAlignment(Pos.BOTTOM_CENTER);
        startBox.setMaxWidth(375);
        startBox.setPadding(new Insets(530, 0, 100, 0));

        //StackPane
        startLayout = new StackPane(startImage, startBox);
    }

    public StackPane getStartLayout() {
        return startLayout;
    }

    /**
    * gets the start button
    * @return the start button
    */
    public Button getStartButton() {
        return startButton;
    }
    /**
    * return a ListView of CivEnums representing the list of
    * available civilizations to choose from
    * @return listview of CivEnum
    */
    public ListView<CivEnum> getCivList() {
        return civList;
    }
}
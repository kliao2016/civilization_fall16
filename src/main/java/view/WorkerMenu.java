package view;

import controller.GameController;
import controller.TileType;
import model.MapObject;
import model.TerrainTile;
import javafx.scene.control.Button;
import model.AnglerUnit;
import model.CoalMinerUnit;
import model.FarmerUnit;
import model.MasterBuilderUnit;
import model.SettlerUnit;
import model.Unit;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class WorkerMenu extends AbstractMenu {

    private Button moveButton = new Button("Move");
    private Button convertButton = new Button("Convert");
    /**
    * There should be a convert and move button
    * as well as the functions associated with those
    * buttons
    */
    public WorkerMenu() {
        moveButton.setOnMousePressed(e -> {
                MapObject occup = GameController.getLastClicked().getTile()
                                                                 .getOccupant();
                GameController.moving();
                if (occup instanceof Unit
                    && !((Unit) occup)
                    .canMove(1)) {
                    NoActionAlert.displayAlert();
                }
            });
        convertButton.setOnMousePressed(e -> {
                TerrainTile tile = GameController.getLastClicked().getTile();
                MapObject occupant = tile.getOccupant();
                TileType type = tile.getType();
                if (occupant.isWorker()
                    && occupant instanceof AnglerUnit
                    && ((AnglerUnit) occupant).canConvert(type)) {
                    tile.setOccupant(((AnglerUnit) occupant).convert());
                    GameController.getLastClicked().updateTileView();
                } else if (occupant.isWorker()
                           && occupant instanceof CoalMinerUnit
                           && ((CoalMinerUnit) occupant).canConvert(type)) {
                    tile.setOccupant(((CoalMinerUnit) occupant).convert());
                    GameController.getLastClicked().updateTileView();
                } else if (occupant.isWorker()
                           && occupant instanceof FarmerUnit
                           && ((FarmerUnit) occupant).canConvert(type)) {
                    tile.setOccupant(((FarmerUnit) occupant).convert());
                    GameController.getLastClicked().updateTileView();
                } else if (occupant.isWorker()
                           && occupant instanceof MasterBuilderUnit
                           && ((MasterBuilderUnit) occupant).canConvert(type)) {
                    tile.setOccupant(((MasterBuilderUnit) occupant).convert());
                    GameController.getLastClicked().updateTileView();
                } else if (occupant.isWorker()
                           && occupant instanceof SettlerUnit
                           && ((SettlerUnit) occupant).canConvert(type)) {
                    tile.setOccupant(((SettlerUnit) occupant).convert());
                    GameController.getLastClicked().updateTileView();
                } else {
                    NoActionAlert.displayAlert();
                }
                GameController.updateResourcesBar();
            });
        moveButton.setStyle("-fx-base: #00FF00");
        convertButton.setStyle("-fx-base: #FF00FF");
        addMenuItem(moveButton);
        addMenuItem(convertButton);
    }
}

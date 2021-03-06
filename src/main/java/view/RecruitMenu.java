package view;

import controller.GameController;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Civilization;
import model.Unit;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class RecruitMenu extends AbstractMenu {

    private ListView<UnitEnum> recruitItems = new ListView<>();
    private Civilization owner = GameController.getCivilization();
    private Button selectButton = new Button("Select");
    /**
    * recuit menu should have a list of worker/units
    * to choose from. There should also be a select button
    * and the function of the button should be implemented
    *here
    */
    public RecruitMenu() {
        recruitItems.getItems().addAll(UnitEnum.MELEE,
                                       UnitEnum.RANGED,
                                       UnitEnum.HYBRID,
                                       UnitEnum.SIEGE,
                                       UnitEnum.SETTLE,
                                       UnitEnum.FARMERS,
                                       UnitEnum.COALS,
                                       UnitEnum.ANGLERS,
                                       UnitEnum.MASTERS);
        selectButton.setOnMousePressed(e -> {
                UnitEnum sel = recruitItems.getSelectionModel()
                                           .getSelectedItem();
                if (sel == null) {
                    NoActionAlert.setMessage("Could not recruit. "
                                             + "Please make sure "
                                             + "you have selected a unit "
                                             + "to recruit.");
                    NoActionAlert.displayAlert();
                } else {
                    recruit(sel);
                }
            });
        selectButton.setStyle("-fx-base: #0000FF");
        addMenuItem(recruitItems);
        addMenuItem(selectButton);
    }

    //Helper method for constructor
    public void recruit(UnitEnum selected) {
        Unit recruit;
        String alert = "Could not recruit unit. "
                        + "Please make sure you have enough "
                        + "gold, food, resources, and happiness.";
        switch (selected) {
        case MELEE:
            recruit = owner.getMeleeUnit();
            if (!recruit.isAffordable()) {
                NoActionAlert.setMessage(alert);
                NoActionAlert.displayAlert();
            } else {
                recruit.applyInitialCosts();
                GameController.getLastClicked().getTile().setOccupant(
                    owner.getMeleeUnit());
                GameController.setLastClicked(
                                    GameController.getLastClicked());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
            }
            break;
        case RANGED:
            recruit = owner.getRangedUnit();
            if (!recruit.isAffordable()) {
                NoActionAlert.setMessage(alert);
                NoActionAlert.displayAlert();
            } else {
                recruit.applyInitialCosts();
                GameController.getLastClicked().getTile().setOccupant(
                    owner.getRangedUnit());
                GameController.setLastClicked(
                                    GameController.getLastClicked());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
            }
            break;
        case HYBRID:
            recruit = owner.getRangedUnit();
            if (!recruit.isAffordable()) {
                NoActionAlert.setMessage(alert);
                NoActionAlert.displayAlert();
            } else {
                recruit.applyInitialCosts();
                GameController.getLastClicked().getTile().setOccupant(
                    owner.getRangedUnit());
                GameController.setLastClicked(
                                    GameController.getLastClicked());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
            }
            break;
        case SIEGE:
            recruit = owner.getSiegeUnit();
            if (!recruit.isAffordable()) {
                NoActionAlert.setMessage(alert);
                NoActionAlert.displayAlert();
            } else {
                recruit.applyInitialCosts();
                GameController.getLastClicked().getTile().setOccupant(
                    owner.getSiegeUnit());
                GameController.setLastClicked(
                                    GameController.getLastClicked());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
            }
            break;
        case SETTLE:
            String name = "";
            recruit = owner.getSettlerUnit(name);
            if (!recruit.isAffordable()) {
                NoActionAlert.setMessage(alert);
                NoActionAlert.displayAlert();
            } else {
                recruit.applyInitialCosts();
                NewSettlementPrompt.newSettlementAlert();
                name = NewSettlementPrompt.getText().getResult();
                recruit = owner.getSettlerUnit(name);
                GameController.getLastClicked().getTile().setOccupant(recruit);
                GameController.setLastClicked(
                                    GameController.getLastClicked());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
            }
            break;
        case FARMERS:
            if (!owner.getFarmerUnit().isAffordable()) {
                NoActionAlert.setMessage(alert);
                NoActionAlert.displayAlert();
            } else {
                owner.getFarmerUnit().applyInitialCosts();
                GameController.getLastClicked().getTile().setOccupant(
                    owner.getFarmerUnit());
                GameController.setLastClicked(
                                    GameController.getLastClicked());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
            }
            break;
        case COALS:
            recruit = owner.getSiegeUnit();
            if (!recruit.isAffordable()) {
                NoActionAlert.setMessage(alert);
                NoActionAlert.displayAlert();
            } else {
                recruit.applyInitialCosts();
                GameController.getLastClicked().getTile().setOccupant(
                    owner.getCoalMinerUnit());
                GameController.setLastClicked(
                                    GameController.getLastClicked());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
            }
            break;
        case ANGLERS:
            if (!owner.getAnglerUnit().isAffordable()) {
                NoActionAlert.setMessage(alert);
                NoActionAlert.displayAlert();
            } else {
                owner.getAnglerUnit().applyInitialCosts();
                GameController.getLastClicked().getTile().setOccupant(
                    owner.getAnglerUnit());
                GameController.setLastClicked(
                                    GameController.getLastClicked());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
            }
            break;
        case MASTERS:
            if (!owner.getMasterBuilderUnit().isAffordable()) {
                NoActionAlert.setMessage(alert);
                NoActionAlert.displayAlert();
            } else {
                owner.getMasterBuilderUnit().applyInitialCosts();
                GameController.getLastClicked().getTile().setOccupant(
                    owner.getMasterBuilderUnit());
                GameController.setLastClicked(
                                    GameController.getLastClicked());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
            }
            break;
        default: break;
        }
    }
}

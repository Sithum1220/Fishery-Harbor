package lk.ijse.fisheryharbour.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;

public class BoatJourneyFormController {
    public VBox vBox;
    private static BoatJourneyFormController controller;

    public BoatJourneyFormController() {
        controller = this;
    }

    public static BoatJourneyFormController getInstance() {
        return controller;
    }

    public void btnBoatJourneyAddOnAction(ActionEvent actionEvent) {
    }

    public void btnBoatEmployeeDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(AdminGlobalFormController.getInstance().pagingPane, "BoatEmployeeDetailsForm.fxml");
    }
}

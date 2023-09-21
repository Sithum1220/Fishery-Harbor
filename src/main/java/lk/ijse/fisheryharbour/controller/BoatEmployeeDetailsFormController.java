package lk.ijse.fisheryharbour.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;

public class BoatEmployeeDetailsFormController {
    public VBox vBox;

    public void btnBoatEmployeeAddOnAction(ActionEvent actionEvent) {
    }

    public void btnBoatJourneyOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(AdminGlobalFormController.getInstance().pagingPane, "BoatJourneyForm.fxml");
    }
}

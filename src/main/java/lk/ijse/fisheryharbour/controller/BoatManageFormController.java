package lk.ijse.fisheryharbour.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;

public class BoatManageFormController {
    public VBox vBox;

    public void btnOwnerDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(ManagerGlobalFormController.getInstance().pagingPane, "OwnerManageForm.fxml");
    }

    public void btnBoatAddOnAction(ActionEvent actionEvent) {

    }
}

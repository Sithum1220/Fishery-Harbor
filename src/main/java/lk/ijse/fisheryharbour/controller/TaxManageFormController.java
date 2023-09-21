package lk.ijse.fisheryharbour.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;

public class TaxManageFormController {
    public VBox vBox;


    public void btnTaxAddOnAction(ActionEvent actionEvent) {
    }

    public void btnRentDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(AdminGlobalFormController.getInstance().pagingPane, "RentDetailsForm.fxml");
    }
}

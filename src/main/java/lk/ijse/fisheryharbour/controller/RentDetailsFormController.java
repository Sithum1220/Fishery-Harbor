package lk.ijse.fisheryharbour.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;

public class RentDetailsFormController {
    public VBox vBox;


    public void btnRentAddOnAction(ActionEvent actionEvent) {
    }

    public void btnTaxDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(AdminGlobalFormController.getInstance().pagingPane, "TaxManageForm.fxml");
    }
}

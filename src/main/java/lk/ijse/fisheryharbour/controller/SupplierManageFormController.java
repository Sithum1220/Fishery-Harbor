package lk.ijse.fisheryharbour.controller;

import javafx.event.ActionEvent;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;

public class SupplierManageFormController {
    public void btnSupplierAddOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupPane("SupplierAddForm.fxml");
    }
}

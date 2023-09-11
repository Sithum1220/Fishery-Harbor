package lk.ijse.fisheryharbour.controller;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;

public class AdminAddFormController {
    public void closeOnMouseClick(MouseEvent event) {
    }

    public void btnAsAEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(ManagerGlobalFormController.getInstance().crudPane, "EmployeeAddForm.fxml");
    }

    public void btnEmployeeAddOnAction(ActionEvent actionEvent) throws IOException {

    }
}

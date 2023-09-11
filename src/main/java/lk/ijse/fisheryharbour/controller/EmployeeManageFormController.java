package lk.ijse.fisheryharbour.controller;

import javafx.event.ActionEvent;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;

public class EmployeeManageFormController {
    public void btnEmployeeAddOnAction(ActionEvent actionEvent) throws IOException {
        ManagerGlobalFormController.getInstance().popupPane.setVisible(true);
        ManagerGlobalFormController.getInstance().crudPane.setVisible(true);
        Navigation.switchPaging(ManagerGlobalFormController.getInstance().crudPane, "EmployeeAddForm.fxml");
    }
}

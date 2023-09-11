package lk.ijse.fisheryharbour.controller;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;

public class EmployeeAddFormController {

    public void closeOnMouseClick(MouseEvent event) {
        ManagerGlobalFormController.getInstance().crudPane.getChildren().clear();
        ManagerGlobalFormController.getInstance().crudPane.setVisible(false);
        ManagerGlobalFormController.getInstance().popupPane.setVisible(false);
    }

    public void btnEmployeeAddOnAction(ActionEvent actionEvent) {
        ManagerGlobalFormController.getInstance().crudPane.getChildren().clear();
        ManagerGlobalFormController.getInstance().crudPane.setVisible(false);
        ManagerGlobalFormController.getInstance().popupPane.setVisible(false);
    }


    public void btnAsAAdminOnAction(ActionEvent actionEvent) throws IOException {
        ManagerGlobalFormController.getInstance().crudPane.getChildren().clear();
        Navigation.switchPaging(ManagerGlobalFormController.getInstance().crudPane, "AdminAddForm.fxml");

    }
}

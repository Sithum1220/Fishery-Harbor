package lk.ijse.fisheryharbour.controller;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

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
}

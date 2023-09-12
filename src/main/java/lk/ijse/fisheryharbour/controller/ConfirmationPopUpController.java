package lk.ijse.fisheryharbour.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import lk.ijse.fisheryharbour.model.EmployeeModel;

import java.sql.SQLException;

public class ConfirmationPopUpController {

    private static String id;
    EmployeeModel employeeModel = new EmployeeModel();
    public void closeOnMouseClick(MouseEvent event) {
        ManagerGlobalFormController.getInstance().crudPane.getChildren().clear();
        ManagerGlobalFormController.getInstance().crudPane.setVisible(false);
        ManagerGlobalFormController.getInstance().popupPane.setVisible(false);
    }

    public void btnConfirmOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (id.startsWith("E")){
            boolean delete = employeeModel.delete(id);
            if (delete){
                EmployeeManageFormController.getInstance().getAllId();
                ManagerGlobalFormController.getInstance().crudPane.getChildren().clear();
                ManagerGlobalFormController.getInstance().crudPane.setVisible(false);
                ManagerGlobalFormController.getInstance().popupPane.setVisible(false);
            }else {
                new Alert(Alert.AlertType.CONFIRMATION,"Error. Please Try Again !!").showAndWait();
            }
        }

    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        ManagerGlobalFormController.getInstance().crudPane.getChildren().clear();
        ManagerGlobalFormController.getInstance().crudPane.setVisible(false);
        ManagerGlobalFormController.getInstance().popupPane.setVisible(false);
    }

    public static void setId(String id){
        ConfirmationPopUpController.id = id;
    }
}

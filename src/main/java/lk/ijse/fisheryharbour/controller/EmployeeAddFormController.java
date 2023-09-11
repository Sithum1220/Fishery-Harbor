package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;

public class EmployeeAddFormController {

    public JFXTextField txtCity;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtMobile;
    public JFXTextField txtEmail;
    public JFXTextField txtNic;
    public JFXComboBox cmbRole;
    public JFXTextField txtHouseNo;
    public JFXTextField txtStreet;

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

package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;

public class AdminAddFormController {
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtMobile;
    public JFXTextField txtNic;
    public JFXComboBox cmbRole;
    public JFXTextField txtHouseNo;
    public JFXTextField txtStreet;
    public JFXTextField txtCity;
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;
    public AnchorPane txtEmail;

    public void closeOnMouseClick(MouseEvent event) {
    }

    public void btnAsAEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(ManagerGlobalFormController.getInstance().crudPane, "EmployeeAddForm.fxml");
    }

    public void btnEmployeeAddOnAction(ActionEvent actionEvent) throws IOException {

    }
}

package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import lk.ijse.fisheryharbour.model.EmployeeModel;
import lk.ijse.fisheryharbour.utill.Navigation;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {

    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;

    EmployeeModel employeeModel = new EmployeeModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void closeOnMouseClick(MouseEvent event) {
        Navigation.exit();
    }

    public void minimizeOnMouseClick(MouseEvent event) {

    }

    public void btnLoginOnAction(ActionEvent actionEvent) {
        try {
            if (employeeModel.checkUsernameAndPassword(txtUserName.getText(), txtPassword.getText()).equals("Manager")) {
                Navigation.switchNavigation("ManagerGlobalForm.fxml", actionEvent);
            } else if (employeeModel.checkUsernameAndPassword(txtUserName.getText(), txtPassword.getText()).equals("Admin")) {
                Navigation.switchNavigation("AdminGlobalForm.fxml", actionEvent);
            } else {
                new Alert(Alert.AlertType.ERROR, "Wrong User Name Or Password!!").show();
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

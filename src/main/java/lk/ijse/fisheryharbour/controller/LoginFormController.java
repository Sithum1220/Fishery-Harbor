package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import lk.ijse.fisheryharbour.utill.Navigation;


import java.net.URL;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {

    public JFXTextField txtUserName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void closeOnMouseClick(MouseEvent event) {
        Navigation.exit();
    }

    public void minimizeOnMouseClick(MouseEvent event) {

    }
}

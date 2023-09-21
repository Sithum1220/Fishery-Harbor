package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.fisheryharbour.utill.Navigation;

public class FrogotPasswordFormController {

    public JFXTextField txtUserName;
    public JFXButton btnReset;
    public AnchorPane mainPain;

    public void resetBtnOnAction(ActionEvent actionEvent) {

    }

    public void closeOnMouseClick(MouseEvent mouseEvent) {
        System.exit(0);
    }

//    public void setMaximized(boolean b) {
//        designerRoot.getMainStage().setMaximized(!b); // trigger change listener anyway
//        designerRoot.getMainStage().setMaximized(b);
//    }

    public void minimizeOnMouseClick(MouseEvent mouseEvent) {

    }
}

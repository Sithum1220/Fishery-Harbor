package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;

public class AttendanceFormController {
    public JFXButton btnEnterID;
    public VBox vBox;

    public void btnEnterIdAddOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.AdminPopupPane("AttendanceAddForm.fxml");
    }

}

package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.utill.Navigation;

public class BoatUpdateFormController {
    public ImageView closeImg;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtMobile;
    public JFXComboBox cmbRole;
    public Text txtCancel;
    public Text txtBlueCancel;

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Navigation.closePane();
    }

    public void btnCancelOnMouseEnterd(MouseEvent mouseEvent) {
        txtCancel.setVisible(false);
        txtBlueCancel.setVisible(true);
    }

    public void btnBoatUpdateOnAction(ActionEvent actionEvent) {
    }

    public void closeOnMouseClick(MouseEvent mouseEvent) {
        Navigation.closePane();
    }

    public void closeOnMouseEnterd(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/PropertyHover.jpg"));
    }

    public void closeOnMouseExit(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/close-btn.png"));
    }

    public void btnCancelOnMouseExit(MouseEvent mouseEvent) {
        txtCancel.setVisible(true);
        txtBlueCancel.setVisible(false);
    }
}

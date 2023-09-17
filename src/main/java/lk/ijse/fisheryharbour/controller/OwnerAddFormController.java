package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.utill.Navigation;

public class OwnerAddFormController {
    public ImageView closeImg;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtMobile;
    public JFXTextField txtEmail;
    public JFXTextField txtNic;
    public JFXComboBox cmbRole;
    public JFXTextField txtHouseNo;
    public JFXTextField txtStreet;
    public Text txtCancel;
    public Text txtBlueCancel;
    public JFXTextField txtCity;

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Navigation.closePane();
    }

    public void btnCancelOnMouseEnterd(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/PropertyHover.jpg"));
    }

    public void btnCancelOnMouseExit(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/close-btn.png"));
    }

    public void btnOwnerAddOnAction(ActionEvent actionEvent) {
    }
}

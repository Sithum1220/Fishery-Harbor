package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.OwnerDTO;
import lk.ijse.fisheryharbour.model.OwnerModel;
import lk.ijse.fisheryharbour.utill.Navigation;
import lk.ijse.fisheryharbour.utill.NewId;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OwnerAddFormController implements Initializable {
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
    OwnerModel ownerModel = new OwnerModel();

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Navigation.closePane();
    }

    public void btnCancelOnMouseEnterd(MouseEvent mouseEvent) {
        txtCancel.setVisible(false);
        txtBlueCancel.setVisible(true);
    }

    public void btnCancelOnMouseExit(MouseEvent mouseEvent) {
        txtCancel.setVisible(true);
        txtBlueCancel.setVisible(false);
    }

    public void btnOwnerAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        OwnerDTO ownerDTO = new OwnerDTO();
        ArrayList<String> list = ownerModel.getAllOwnerId();

        ownerDTO.setOwner_Id(NewId.newId(list, NewId.GetType.OWNER));
        ownerDTO.setEmail(txtEmail.getText());
        ownerDTO.setFirst_Name(txtFirstName.getText());
        ownerDTO.setLast_Name(txtLastName.getText());
        ownerDTO.setContact_No(txtMobile.getText());
        ownerDTO.setNic(txtNic.getText());
        ownerDTO.setOwner_Role(getRole());
        ownerDTO.setHouse_No(txtHouseNo.getText());
        ownerDTO.setStreet(txtStreet.getText());
        ownerDTO.setCity(txtCity.getText());

        boolean save = ownerModel.save(ownerDTO);
        OwnerManageFormController.getInstance().allOwnerId();
        Navigation.closePane();
    }

    public void closeOnMouseClick(MouseEvent mouseEvent) {
        Navigation.closePane();
    }

    public String getRole() {
        return String.valueOf(cmbRole.getSelectionModel().getSelectedItem());
    }

    public void setdataInComboBox() {
        ArrayList<String> roles = new ArrayList<>();
        roles.add("Boat Owner");
        cmbRole.getItems().addAll(roles);
    }

    public void closeOnMouseEnterd(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/PropertyHover.jpg"));
    }

    public void closeOnMouseExit(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/close-btn.png"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setdataInComboBox();
    }
}

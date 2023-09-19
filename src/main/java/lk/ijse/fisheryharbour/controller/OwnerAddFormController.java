package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
<<<<<<< Updated upstream
=======
import lk.ijse.fisheryharbour.dto.OwnerDTO;
import lk.ijse.fisheryharbour.model.OwnerModel;
import lk.ijse.fisheryharbour.utill.DateTimeUtil;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
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
        ownerDTO.setTime(DateTimeUtil.timeNow());
        ownerDTO.setDate(DateTimeUtil.dateNow());

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
        roles.add("Canteen Owner");
        roles.add("Market Owner");
        roles.add("Ice-Mill Owner");
        cmbRole.getItems().addAll(roles);
    }

    public void closeOnMouseEnterd(MouseEvent mouseEvent) {
>>>>>>> Stashed changes
        closeImg.setImage(new Image("img/PropertyHover.jpg"));
    }

    public void btnCancelOnMouseExit(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/close-btn.png"));
    }

    public void btnOwnerAddOnAction(ActionEvent actionEvent) {
    }
}

package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.EmployeeDTO;
import lk.ijse.fisheryharbour.dto.OwnerDTO;
import lk.ijse.fisheryharbour.model.EmployeeModel;
import lk.ijse.fisheryharbour.model.OwnerModel;
import lk.ijse.fisheryharbour.utill.DateTimeUtil;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OwnerUpdateFormController implements Initializable {
    private static String id;
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

    public static void getId(String id) {
        OwnerUpdateFormController.id = id;
    }

    public void btnOwnerUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        OwnerDTO ownerDTO = new OwnerDTO();
        System.out.println(id);
        ownerDTO.setOwner_Id(id);
        ownerDTO.setFirst_Name(txtFirstName.getText());
        ownerDTO.setLast_Name(txtLastName.getText());
        ownerDTO.setCity(txtEmail.getText());
        ownerDTO.setStreet(txtStreet.getText());
        ownerDTO.setHouse_No(txtHouseNo.getText());
        ownerDTO.setOwner_Role(getRole());
        ownerDTO.setNic(txtNic.getText());
        ownerDTO.setEmail(txtEmail.getText());
        ownerDTO.setContact_No(txtMobile.getText());
        ownerDTO.setDate(DateTimeUtil.dateNow());
        ownerDTO.setTime(DateTimeUtil.timeNow());

        boolean update = ownerModel.update(ownerDTO);

        OwnerManageFormController.getInstance().allOwnerId();
        Navigation.closePane();
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

    private String getRole() {
        return String.valueOf(cmbRole.getSelectionModel().getSelectedItem());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

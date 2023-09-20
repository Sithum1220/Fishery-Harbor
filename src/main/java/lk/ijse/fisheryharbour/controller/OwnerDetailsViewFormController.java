package lk.ijse.fisheryharbour.controller;

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
import lk.ijse.fisheryharbour.utill.Navigation;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OwnerDetailsViewFormController implements Initializable {
    private static String id;
    public ImageView closeImg;
    public JFXTextField txtName;
    public JFXTextField txtMobile;
    public JFXTextField txtEmail;
    public JFXTextField txtNic;
    public JFXTextField txtAddress;
    public JFXTextField txtRole;
    public Text txtBlueCancel;
    public Text txtCancel;

    OwnerModel ownerModel = new OwnerModel();

    public static void setId(String id) {
        OwnerDetailsViewFormController.id = id;
    }

    public void closeOnMouseExit(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/close-btn.png"));
    }

    public void closeOnMouseEnterd(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/PropertyHover.jpg"));
    }

    public void closeOnMouseClick(MouseEvent mouseEvent) {
        Navigation.closePane();
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Navigation.closePane();
    }

    public void btnCancelOnMouseExit(MouseEvent mouseEvent) {
        txtCancel.setVisible(true);
        txtBlueCancel.setVisible(false);
    }

    public void btnCancelOnMouseEnterd(MouseEvent mouseEvent) {
        txtCancel.setVisible(false);
        txtBlueCancel.setVisible(true);
    }

    public void setData() throws SQLException, ClassNotFoundException {
        OwnerDTO ownerDTO =  ownerModel.getData(id);
        txtName.setText(ownerDTO.getFirst_Name()+" "+ownerDTO.getLast_Name());
        txtMobile.setText(ownerDTO.getContact_No());
        txtEmail.setText(ownerDTO.getEmail());
        txtNic.setText(ownerDTO.getNic());
        txtRole.setText(ownerDTO.getOwner_Role());
        txtAddress.setText(ownerDTO.getHouse_No()+" "+ownerDTO.getStreet()+", "+ownerDTO.getCity());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            setData();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

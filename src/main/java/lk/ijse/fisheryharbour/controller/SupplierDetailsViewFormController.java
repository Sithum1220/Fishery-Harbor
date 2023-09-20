package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.OwnerDTO;
import lk.ijse.fisheryharbour.dto.SupplierDTO;
import lk.ijse.fisheryharbour.model.SupplierModel;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SupplierDetailsViewFormController implements Initializable {
    private static String id;
    public ImageView closeImg;;
    public Text txtCancel;
    public Text txtBlueCancel;
    public JFXTextField txtCompanyName;
    public JFXTextField txtCompanyMobile;
    public JFXTextField txtCompanyEmail;
    public JFXTextField txtCompanyAddress;

    SupplierModel supplierModel = new SupplierModel();

    public static void setId(String id) {
        SupplierDetailsViewFormController.id = id;
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

    public void closeOnMouseClick(MouseEvent mouseEvent) {
        Navigation.closePane();
    }

    public void closeOnMouseEnterd(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/PropertyHover.jpg"));
    }

    public void closeOnMouseExit(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/close-btn.png"));
    }

    public void setData() throws SQLException, ClassNotFoundException {
        SupplierDTO supplierDTO = supplierModel.getData(id);
        txtCompanyName.setText(supplierDTO.getCompany_name());
        txtCompanyMobile.setText(supplierDTO.getCompany_no());
        txtCompanyEmail.setText(supplierDTO.getCompany_email());
        txtCompanyAddress.setText(supplierDTO.getCompany_location());
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

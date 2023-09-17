package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.SupplierDTO;
import lk.ijse.fisheryharbour.model.SupplierModel;
import lk.ijse.fisheryharbour.utill.Navigation;
import lk.ijse.fisheryharbour.utill.NewId;

import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierAddFormController {
    public ImageView closeImg;
    public JFXTextField txtMobile;
    public JFXTextField txtEmail;
    public Text txtCancel;
    public Text txtBlueCancel;
    public JFXTextField txtCompanyName;
    public JFXTextField txtLocation;

    SupplierModel supplierModel = new SupplierModel();

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

    public void btnSupplierAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        SupplierDTO supplierDto = new SupplierDTO();
        ArrayList<String> list = supplierModel.getAllSupplierId();

        supplierDto.setSupplier_id(NewId.newId(list, NewId.GetType.SUPPLIER));
        supplierDto.setCompany_name(txtCompanyName.getText());
        supplierDto.setCompany_email(txtEmail.getText());
        supplierDto.setCompany_no(txtMobile.getText());
        supplierDto.setCompany_location(txtLocation.getText());

        boolean save = supplierModel.save(supplierDto);
        SupplierManageFormController.getInstance().allSupplierId();
        Navigation.closePane();
    }
}

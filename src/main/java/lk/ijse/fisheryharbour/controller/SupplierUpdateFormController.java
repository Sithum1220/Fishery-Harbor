package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.EmployeeDTO;
import lk.ijse.fisheryharbour.dto.SupplierDTO;
import lk.ijse.fisheryharbour.model.SupplierModel;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SupplierUpdateFormController implements Initializable {
    public ImageView closeImg;
    public Text txtBlueCancel;
    public Text txtCancel;
    public JFXTextField txtCompanyName;
    public JFXTextField txtLocation;
    public JFXTextField txtMobile;
    public JFXTextField txtEmail;

    private static String id;

    SupplierModel supplierModel = new SupplierModel();

    public void closeOnMouseExit(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/close-btn.png"));
    }

    public void closeOnMouseClick(MouseEvent mouseEvent) {
        Navigation.closePane();
    }

    public void btnSupplierUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setSupplier_id(id);
        supplierDTO.setCompany_name(txtCompanyName.getText());
        supplierDTO.setCompany_email(txtEmail.getText());
        supplierDTO.setCompany_location(txtLocation.getText());
        supplierDTO.setCompany_no(txtMobile.getText());

        boolean update = supplierModel.update(supplierDTO);
        SupplierManageFormController.getInstance().allSupplierId();
        Navigation.closePane();
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

    public void closeOnMouseEnterd(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/PropertyHover.jpg"));
    }

    public static void setId(String id) {
        SupplierUpdateFormController.id = id;
    }

    public void setData(){
        try {
            SupplierDTO supplierDTO = supplierModel.getData(id);
            txtCompanyName.setText(supplierDTO.getCompany_name());
            txtEmail.setText(supplierDTO.getCompany_email());
            txtMobile.setText(supplierDTO.getCompany_no());
            txtLocation.setText(supplierDTO.getCompany_location());

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }
}

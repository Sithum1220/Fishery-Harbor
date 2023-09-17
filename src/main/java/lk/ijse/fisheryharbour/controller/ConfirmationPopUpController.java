package lk.ijse.fisheryharbour.controller;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.model.EmployeeModel;
import lk.ijse.fisheryharbour.model.SupplierModel;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.sql.SQLException;

public class ConfirmationPopUpController {

    private static String id;
    public Text txtCancel;
    public Text txtBlueCancel;
    public ImageView closeImg;
    EmployeeModel employeeModel = new EmployeeModel();
    SupplierModel supplierModel = new SupplierModel();

    public static void setId(String id) {
        ConfirmationPopUpController.id = id;
    }

    public void closeOnMouseClick(MouseEvent event) {
        Navigation.closePane();
    }

    public void btnConfirmOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (id.startsWith("E")) {
            boolean delete = employeeModel.delete(id);
            EmployeeManageFormController.getInstance().getAllId();
        } else if (id.startsWith("S")) {
            boolean delete = supplierModel.delete(id);
            SupplierManageFormController.getInstance().allSupplierId();
        }
        Navigation.closePane();
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Navigation.closePane();
    }

    public void btnCancelOnMouseEntered(MouseEvent mouseEvent) {
        txtCancel.setVisible(false);
        txtBlueCancel.setVisible(true);
    }

    public void btnCancelOnMouseExited(MouseEvent mouseEvent) {
        txtCancel.setVisible(true);
        txtBlueCancel.setVisible(false);
    }

    public void closeOnMouseEntered(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/PropertyHover.jpg"));
    }

    public void closeOnMouseExited(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/close-btn.png"));
    }
}

package lk.ijse.fisheryharbour.controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.SupplierDTO;
import lk.ijse.fisheryharbour.model.SupplierModel;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class SupplierDetailsBarFormController {
    public Text id;
    public Text CompanyName;
    public Text Location;
    public Text email;
    public Text mobile;
    public ImageView updateImg;
    public ImageView deleteImg;
    public ImageView viewImg;

    public void updateOnMouseClick(MouseEvent mouseEvent) throws IOException {
        EmployeeUpdateFormController.getId(id.getText());
        Navigation.popupPane("SupplierUpdateForm.fxml");
    }

    public void updateOnMouseEntered(MouseEvent mouseEvent) {
        updateImg.setImage(new Image("img/icon/update-blue.png"));
    }

    public void updateOnMouseExited(MouseEvent mouseEvent) {
        updateImg.setImage(new Image("img/icon/action-btn.png"));
    }

    public void deleteOnMouseClick(MouseEvent mouseEvent) throws IOException {
        ConfirmationPopUpController.setId(id.getText());
        Navigation.popupPane("ConfirmationPopUp.fxml");
    }

    public void deleteOnMouseEntered(MouseEvent mouseEvent) {
        deleteImg.setImage(new Image("img/icon/delete-red.png"));
    }

    public void deleteOnMouseExited(MouseEvent mouseEvent) {
        deleteImg.setImage(new Image("img/icon/action-delete-btn.png"));
    }

    public void detailsOnMouseClick(MouseEvent mouseEvent) throws IOException {
        EmployeeDetailsViewFormController.setId(id.getText());
        Navigation.popupPane("SupplierDetailsViewForm.fxml");
    }

    public void viewOnMouseEntered(MouseEvent mouseEvent) {
        viewImg.setImage(new Image("img/icon/Frame-23.jpg"));
    }

    public void viewOnMouseExited(MouseEvent mouseEvent) {
        viewImg.setImage(new Image("img/icon/action-btn-details.png"));
    }

    public void setData(String id) throws SQLException, ClassNotFoundException {
        SupplierModel supplierModel = new SupplierModel();
        SupplierDTO supplierDTO = supplierModel.getData(id);

        this.id.setText(supplierDTO.getSupplier_id());
        CompanyName.setText(supplierDTO.getCompany_name());
        email.setText(supplierDTO.getCompany_email());
        mobile.setText(supplierDTO.getCompany_no());
        Location.setText(supplierDTO.getCompany_location());
    }
}

package lk.ijse.fisheryharbour.controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.OwnerDTO;
import lk.ijse.fisheryharbour.model.EmployeeModel;
import lk.ijse.fisheryharbour.model.OwnerModel;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class OwnerDetailsBarFormController {
    public ImageView viewImg;
    public ImageView deleteImg;
    public ImageView updateImg;
    public Text role;
    public Text email;
    public Text mobile;
    public Text ownerName;
    public Text id;

    OwnerModel ownerModel = new OwnerModel();

    public void detailsOnMouseClick(MouseEvent mouseEvent) throws IOException {
        OwnerDetailsViewFormController.setId(id.getText());
        Navigation.popupPane("OwnerDetailsViewForm.fxml");
    }

    public void viewOnMouseEntered(MouseEvent mouseEvent) {
        viewImg.setImage(new Image("img/icon/Frame-23.jpg"));
    }

    public void viewOnMouseExited(MouseEvent mouseEvent) {
        viewImg.setImage(new Image("img/icon/action-btn-details.png"));
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

    public void updateOnMouseExited(MouseEvent mouseEvent) {
        updateImg.setImage(new Image("img/icon/action-btn.png"));
    }

    public void updateOnMouseEntered(MouseEvent mouseEvent) {
        updateImg.setImage(new Image("img/icon/update-blue.png"));
    }

    public void updateOnMouseClick(MouseEvent mouseEvent) throws IOException {
        OwnerUpdateFormController.getId(id.getText());
        Navigation.popupPane("OwnerUpdateForm.fxml");
    }

    public void setData(String id) throws SQLException, ClassNotFoundException {
        OwnerModel ownerModel = new OwnerModel();
        OwnerDTO ownerDTO =  ownerModel.getData(id);
        role.setText(ownerDTO.getOwner_Role());
        email.setText(ownerDTO.getEmail());
        mobile.setText(ownerDTO.getContact_No());
        ownerName.setText(ownerDTO.getFirst_Name()+ " "+ownerDTO.getLast_Name() );
        this.id.setText(ownerDTO.getOwner_Id());
    }
}

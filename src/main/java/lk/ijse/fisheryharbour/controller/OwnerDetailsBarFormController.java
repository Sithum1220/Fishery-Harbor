package lk.ijse.fisheryharbour.controller;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.OwnerDTO;
import lk.ijse.fisheryharbour.dto.SupplierDTO;
import lk.ijse.fisheryharbour.model.OwnerModel;
import lk.ijse.fisheryharbour.model.SupplierModel;

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

    public void detailsOnMouseClick(MouseEvent mouseEvent) {
    }

    public void viewOnMouseEntered(MouseEvent mouseEvent) {
    }

    public void viewOnMouseExited(MouseEvent mouseEvent) {
    }

    public void deleteOnMouseClick(MouseEvent mouseEvent) {
    }

    public void deleteOnMouseEntered(MouseEvent mouseEvent) {
    }

    public void deleteOnMouseExited(MouseEvent mouseEvent) {
    }

    public void updateOnMouseExited(MouseEvent mouseEvent) {
    }

    public void updateOnMouseEntered(MouseEvent mouseEvent) {
    }

    public void updateOnMouseClick(MouseEvent mouseEvent) {
    }

    public void setData(String id) throws SQLException, ClassNotFoundException {
        OwnerModel ownerModel = new OwnerModel();
        OwnerDTO ownerDTO = ownerModel.getData(id);

        this.id.setText(ownerDTO.getOwner_Id());
        ownerName.setText(ownerDTO.getFirst_Name() + " " + ownerDTO.getLast_Name());
        email.setText(ownerDTO.getEmail());
        mobile.setText(ownerDTO.getContact_No());
    }
}

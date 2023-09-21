package lk.ijse.fisheryharbour.controller;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.RentDTO;
import lk.ijse.fisheryharbour.dto.SupplierDTO;
import lk.ijse.fisheryharbour.model.RentModel;
import lk.ijse.fisheryharbour.model.SupplierModel;

import java.sql.SQLException;

public class RentDetailsBarFormController {
    public Text txtID;
    public Text txtOwnerID;
    public Text txtRentType;
    public Text txtFee;
    public Text txtDate;
    public ImageView updateImg;
    public ImageView deleteImg;
    public ImageView viewImg;

    public void updateOnMouseClick(MouseEvent mouseEvent) {
    }

    public void updateOnMouseEntered(MouseEvent mouseEvent) {
    }

    public void updateOnMouseExited(MouseEvent mouseEvent) {
    }

    public void deleteOnMouseClick(MouseEvent mouseEvent) {
    }

    public void deleteOnMouseEntered(MouseEvent mouseEvent) {
    }

    public void deleteOnMouseExited(MouseEvent mouseEvent) {
    }

    public void detailsOnMouseClick(MouseEvent mouseEvent) {
    }

    public void viewOnMouseEntered(MouseEvent mouseEvent) {
    }

    public void viewOnMouseExited(MouseEvent mouseEvent) {
    }

    public void setData(String id) throws SQLException, ClassNotFoundException {
        RentModel rentModel = new RentModel();
        RentDTO rentDTO = rentModel.getData(id);

        this.txtID.setText(rentDTO.getRent_Id());
        txtRentType.setText(rentDTO.getRent_Type());
        txtFee.setText(rentDTO.getFee());
        txtOwnerID.setText(rentDTO.getOwner_Id());
        txtDate.setText(rentDTO.getDate());
    }
}

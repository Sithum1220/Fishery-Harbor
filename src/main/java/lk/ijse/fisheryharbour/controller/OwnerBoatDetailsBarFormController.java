package lk.ijse.fisheryharbour.controller;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.BoatDTO;
import lk.ijse.fisheryharbour.dto.SupplierDTO;
import lk.ijse.fisheryharbour.model.BoatModel;
import lk.ijse.fisheryharbour.model.SupplierModel;

import java.sql.SQLException;

public class OwnerBoatDetailsBarFormController {
    public Text txtID;
    public Text txtOwnerName;
    public Text txtOwnerID;
    public Text txtEmail;
    public Text txtBoatType;
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
//    public void setData(String id) throws SQLException, ClassNotFoundException {
//        BoatModel boatModel = new BoatModel();
//        BoatDTO supplierDTO = boatModel.getData(id);
//
//        this.txtID.setText(supplierDTO.getBoat_Id());
//        t.setText(supplierDTO.getCompany_name());
//        email.setText(supplierDTO.getCompany_email());
//        mobile.setText(supplierDTO.getCompany_no());
//        Location.setText(supplierDTO.getCompany_location());
//    }
}

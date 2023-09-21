package lk.ijse.fisheryharbour.controller;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.SupplierDTO;
import lk.ijse.fisheryharbour.dto.TaxDTO;
import lk.ijse.fisheryharbour.model.SupplierModel;
import lk.ijse.fisheryharbour.model.TaxModel;

import java.sql.SQLException;

public class TaxDetailsBarFormController {
    public Text txtID;
    public Text txtBoatID;
    public Text txtTaxType;
    public Text txtTaxFee;
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
        TaxModel taxModel = new TaxModel();
        TaxDTO taxDTO = taxModel.getData(id);

        this.txtID.setText(taxDTO.getTax_Id());
        txtTaxFee.setText(taxDTO.getFee());
        txtTaxFee.setText(taxDTO.getFee());
        txtBoatID.setText(taxDTO.getBoat_Id());
    }
}

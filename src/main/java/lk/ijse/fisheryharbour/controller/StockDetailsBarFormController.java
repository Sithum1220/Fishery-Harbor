package lk.ijse.fisheryharbour.controller;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.StockDTO;
import lk.ijse.fisheryharbour.dto.SupplierDTO;
import lk.ijse.fisheryharbour.model.StockModel;
import lk.ijse.fisheryharbour.model.SupplierModel;

import java.sql.SQLException;

public class StockDetailsBarFormController {
    public Text id;
    public Text CompanyName;
    public Text Location;
    public Text email;
    public ImageView updateImg;
    public ImageView deleteImg;
    public ImageView viewImg;

    public void detailsOnMouseClick(MouseEvent mouseEvent) {
    }

    public void viewOnMouseEntered(MouseEvent mouseEvent) {
    }

    public void viewOnMouseExited(MouseEvent mouseEvent) {
    }

    public void deleteOnMouseClick(MouseEvent mouseEvent) {
    }

    public void deleteOnMouseExited(MouseEvent mouseEvent) {
    }

    public void deleteOnMouseEntered(MouseEvent mouseEvent) {
    }
    public void setData(String id) throws SQLException, ClassNotFoundException {
        StockModel stockModel = new StockModel();
        StockDTO stockDTO = stockModel.getData(id);

//        this.id.setText(stockDTO.getItem_Code());
//        .setText(stockDTO.getCompany_name());
//        email.setText(stockDTO.getCompany_email());
//        mobile.setText(stockDTO.getCompany_no());
//        Location.setText(stockDTO.getCompany_location());
    }

}

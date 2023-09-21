package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.StockDTO;
import lk.ijse.fisheryharbour.dto.SupplierDTO;
import lk.ijse.fisheryharbour.model.StockModel;
import lk.ijse.fisheryharbour.utill.Navigation;
import lk.ijse.fisheryharbour.utill.NewId;

import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.fisheryharbour.utill.Navigation;

public class
StockAddFormController {
    public ImageView closeImg;
    public JFXTextField txtProductName;
    public JFXTextField txtQuantityOnHand;
    public JFXTextField txtUnitPrice;
    public Text txtCancel;
    public Text txtBlueCancel;

    StockModel stockModel = new StockModel();

    public void closeOnMouseClick(MouseEvent mouseEvent) {
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

    public void closeOnMouseExit(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/close-btn.png"));
    }

    public void btnSupplierAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        StockDTO stockDTO = new StockDTO();
        ArrayList<String> list =stockModel.getAllStockId();

        stockDTO.setItem_Code(NewId.newId(list, NewId.GetType.STOCK));
        stockDTO.setDescription(txtProductName.getText());
        stockDTO.setUnit_Price(txtUnitPrice.getText());
        stockDTO.setQty(txtQuantityOnHand.getText());

        boolean save = stockModel.save(stockDTO);
        StockManageFormController.getInstance().allStockId();
        Navigation.closePane();
    }
}

package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.utill.Navigation;

public class
StockAddFormController {
    public ImageView closeImg;
    public JFXTextField txtProductName;
    public JFXTextField txtQuantityOnHand;
    public JFXTextField txtUnitPrice;
    public Text txtCancel;
    public Text txtBlueCancel;

    public void closeOnMouseClick(MouseEvent mouseEvent) {
        Navigation.closePane();
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {

    }

    public void btnCancelOnMouseEnterd(MouseEvent mouseEvent) {
    }

    public void btnCancelOnMouseExit(MouseEvent mouseEvent) {
    }

    public void closeOnMouseEnterd(MouseEvent mouseEvent) {
    }

    public void closeOnMouseExit(MouseEvent mouseEvent) {
    }

    public void btnSupplierAddOnAction(ActionEvent actionEvent) {
    }
}

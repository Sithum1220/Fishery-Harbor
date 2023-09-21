package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.OwnerDTO;
import lk.ijse.fisheryharbour.dto.TaxDTO;
import lk.ijse.fisheryharbour.model.TaxModel;
import lk.ijse.fisheryharbour.utill.DateTimeUtil;
import lk.ijse.fisheryharbour.utill.Navigation;
import lk.ijse.fisheryharbour.utill.NewId;

import java.sql.SQLException;
import java.util.ArrayList;

public class TaxAddFormController {
    public ImageView closeImg;
    public JFXTextField txtBoatID;
    public JFXTextField txtTaxType;
    public JFXTextField txtTaxFee;
    public Text txtCancel;
    public Text txtBlueCancel;
    public GridPane txtAdd;

    TaxModel taxModel = new TaxModel();

    public void closeOnMouseClick(MouseEvent mouseEvent) {
        Navigation.adminClosePane();
    }

    public void closeOnMouseEnterd(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/PropertyHover.jpg"));
    }

    public void closeOnMouseExit(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/close-btn.png"));
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Navigation.adminClosePane();
    }

    public void btnCancelOnMouseEnterd(MouseEvent mouseEvent) {
        txtCancel.setVisible(false);
        txtBlueCancel.setVisible(true);
    }

    public void btnCancelOnMouseExit(MouseEvent mouseEvent) {
        txtCancel.setVisible(true);
        txtBlueCancel.setVisible(false);
    }

    public void btnTaxAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        TaxDTO taxDTO = new TaxDTO();
        ArrayList<String> list = taxModel.getAllTaxId();

        taxDTO.setTax_Id(NewId.newId(list, NewId.GetType.TAX));
        taxDTO.setFee(txtTaxFee.getText());
        taxDTO.setTax_Type(txtTaxType.getText());
        taxDTO.setBoat_Id(txtBoatID.getText());

        boolean save = taxModel.save(taxDTO);
        TaxManageFormController.getInstance().allTaxId();
        Navigation.closePane();
    }
}

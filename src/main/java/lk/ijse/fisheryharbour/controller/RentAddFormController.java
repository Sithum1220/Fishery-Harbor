package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.RentDTO;
import lk.ijse.fisheryharbour.dto.SupplierDTO;
import lk.ijse.fisheryharbour.model.RentModel;
import lk.ijse.fisheryharbour.utill.DateTimeUtil;
import lk.ijse.fisheryharbour.utill.Navigation;
import lk.ijse.fisheryharbour.utill.NewId;

import java.sql.SQLException;
import java.util.ArrayList;

public class RentAddFormController {
    public ImageView closeImg;
    public JFXTextField txtOwnerID;
    public JFXTextField txtRentType;
    public Text txtCancel;
    public Text txtBlueCancel;
    public GridPane txtAdd;
    public JFXTextField txtRentFee;
    RentModel rentModel = new RentModel();

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

    public void btnRentAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        RentDTO rentDTO = new RentDTO();
        ArrayList<String> list = rentModel.getAllRentId();

        rentDTO.setRent_Id(NewId.newId(list, NewId.GetType.RENT));
        rentDTO.setRent_Type(txtRentType.getText());
        rentDTO.setFee(txtRentFee.getText());
        rentDTO.setDate(DateTimeUtil.dateNow());
        rentDTO.setTime(DateTimeUtil.timeNow());
        rentDTO.setOwner_Id(txtOwnerID.getText());

        boolean save = rentModel.save(rentDTO);
        RentDetailsFormController.getInstance().allRentId();
        Navigation.closePane();
    }
}

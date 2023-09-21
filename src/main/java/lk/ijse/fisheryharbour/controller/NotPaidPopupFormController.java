package lk.ijse.fisheryharbour.controller;

import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.BoatDTO;
import lk.ijse.fisheryharbour.dto.OwnerDTO;
import lk.ijse.fisheryharbour.model.BoatModel;
import lk.ijse.fisheryharbour.model.OwnerModel;
import lk.ijse.fisheryharbour.utill.DateTimeUtil;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NotPaidPopupFormController implements Initializable {
    public Text txtBoatId;
    public Text txtBoatName;
    public Text txtOwnerName;
    public Text txtDate;

    public void closeOnMouseClicked(MouseEvent mouseEvent) {
        TaxManageFormController.getInstance().innovativePopupPane.getChildren().clear();
        TaxManageFormController.getInstance().innovativePopupPane.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BoatModel boatModel = new BoatModel();
        OwnerModel ownerModel = new OwnerModel();
        try {
            BoatDTO boatDTO = boatModel.getData(TaxManageFormController.getInstance().innovativeBoatId);
            OwnerDTO ownerDTO = ownerModel.getData(boatDTO.getOwner_Id());
            txtBoatId.setText(TaxManageFormController.getInstance().innovativeBoatId);
            txtBoatName.setText(boatDTO.getBoat_name());
            txtOwnerName.setText(ownerDTO.getFirst_Name()+" "+ownerDTO.getLast_Name());
            txtDate.setText(DateTimeUtil.dateNow());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

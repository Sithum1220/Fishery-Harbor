package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.model.BoatModel;
import lk.ijse.fisheryharbour.utill.Navigation;
import lk.ijse.fisheryharbour.utill.NewId;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BoatAddFormController implements Initializable {
    private static BoatAddFormController controller;
    public ImageView closeImg;
    public Text txtCancel;
    public Text txtBlueCancel;
    public JFXTextField txtOwnerId;
    public JFXTextField txtBoatName;
    public JFXComboBox cmbBoatType;
    BoatModel boatModel = new BoatModel();
    String id;

    public BoatAddFormController() {
        controller = this;
    }

    public static BoatAddFormController getInstance() {
        return controller;
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

    public void btnBoatAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        Navigation.closePane();
        Navigation.popupPane("FileChooserPopupForm.fxml");

    }

    public String getRole() {
        return String.valueOf(cmbBoatType.getSelectionModel().getSelectedItem());
    }

    public void setdataInComboBox() {
        ArrayList<String> roles = new ArrayList<>();
        roles.add("6 Tanks");
        roles.add("4 Tanks");
        cmbBoatType.getItems().addAll(roles);
    }

    public void closeOnMouseClick(MouseEvent mouseEvent) {
        Navigation.closePane();
    }

    public void closeOnMouseEnterd(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/PropertyHover.jpg"));
    }

    public void closeOnMouseExit(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/close-btn.png"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setdataInComboBox();
        ArrayList<String> list = null;
        try {
            list = boatModel.getAllBoatId();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        id = NewId.newId(list, NewId.GetType.BOAT);
        FileChooserPopupFormController.setId(id);
    }
}

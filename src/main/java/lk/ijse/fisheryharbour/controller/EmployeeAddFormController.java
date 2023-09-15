package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.model.EmployeeModel;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EmployeeAddFormController implements Initializable {

    public JFXTextField txtCity;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtMobile;
    public JFXTextField txtEmail;
    public JFXTextField txtNic;
    public JFXComboBox cmbRole;
    public JFXTextField txtHouseNo;
    public JFXTextField txtStreet;
    public Text txtCancel;
    public ImageView closeImg;
    public Text txtBlueCancel;
    public Text txtasAdmin;
    public Text txtasBlueAdmin;
    private static EmployeeAddFormController controller;

    public EmployeeAddFormController(){
        controller = this;
    }

    public static EmployeeAddFormController getInstance(){
        return controller;
    }
    public void closeOnMouseClick(MouseEvent event) {
        ManagerGlobalFormController.getInstance().crudPane.getChildren().clear();
        ManagerGlobalFormController.getInstance().crudPane.setVisible(false);
        ManagerGlobalFormController.getInstance().popupPane.setVisible(false);
    }

    public void btnEmployeeAddOnAction(ActionEvent actionEvent) throws IOException {
        ManagerGlobalFormController.getInstance().popupPane.setVisible(true);
        ManagerGlobalFormController.getInstance().crudPane.setVisible(true);
        Navigation.switchPaging(ManagerGlobalFormController.getInstance().crudPane, "FileChooserPopupForm.fxml");

    }


    public void btnAsAAdminOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(ManagerGlobalFormController.getInstance().crudPane, "AdminAddForm.fxml");
    }

    public String getRole() {
        return String.valueOf(cmbRole.getSelectionModel().getSelectedItem());
    }

    public void setdataInComboBox() {
        ArrayList<String> roles = new ArrayList<>();
        roles.add("Security");
        roles.add("Minor Staff");
        roles.add("Reception");
        roles.add("Clerk");
        roles.add("Other");
        cmbRole.getItems().addAll(roles);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setdataInComboBox();
    }

    public void btnCancelOnMouseEnterd(MouseEvent event) {
        txtCancel.setVisible(false);
        txtBlueCancel.setVisible(true);
    }

    public void btnCancelOnMouseExit(MouseEvent event) {
        txtCancel.setVisible(true);
        txtBlueCancel.setVisible(false);
    }

    public void closeOnMouseEnterd(MouseEvent event) {
        closeImg.setImage(new Image("img/PropertyHover.jpg"));
    }

    public void closeOnMouseExit(MouseEvent event) {
        closeImg.setImage(new Image("img/close-btn.png"));
    }

    public void asAdminOnMouseEnterd(MouseEvent event) {
        txtasAdmin.setVisible(false);
        txtasBlueAdmin.setVisible(true);
    }

    public void asAdminOnMouseExit(MouseEvent event) {
        txtasAdmin.setVisible(true);
        txtasBlueAdmin.setVisible(false);
    }


    public void btnCancelOnAction(ActionEvent actionEvent) {
        ManagerGlobalFormController.getInstance().crudPane.getChildren().clear();
        ManagerGlobalFormController.getInstance().crudPane.setVisible(false);
        ManagerGlobalFormController.getInstance().popupPane.setVisible(false);
    }
}

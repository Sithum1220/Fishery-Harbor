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
import lk.ijse.fisheryharbour.utill.NewId;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EmployeeAddFormController implements Initializable {

    private static EmployeeAddFormController controller;
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
    private String id;
    EmployeeModel employeeModel = new EmployeeModel();

    public EmployeeAddFormController() {
        controller = this;
    }

    public static EmployeeAddFormController getInstance() {
        return controller;
    }

    public void closeOnMouseClick(MouseEvent event) {
        Navigation.closePane();
    }

    public void btnEmployeeAddOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupPane("FileChooserPopupForm.fxml");

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
        ArrayList<String> list = null;
        try {
            list = employeeModel.getAllEmployeeId();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        id = NewId.newId(list, NewId.GetType.EMPLOYEE);
        FileChooserPopupFormController.setId(id);
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
       Navigation.closePane();
    }
}

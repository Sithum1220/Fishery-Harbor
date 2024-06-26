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

public class AdminAddFormController implements Initializable {
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtMobile;
    public JFXTextField txtNic;
    public JFXComboBox cmbRole;
    public JFXTextField txtHouseNo;
    public JFXTextField txtStreet;
    public JFXTextField txtCity;
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;
    public JFXTextField txtEmail;
    public Text asEmployee;
    public Text asBlueEmployee;
    public ImageView closeImg;
    public Text txtCancel;
    public Text txtBlueCancel;
    String id;
    EmployeeModel employeeModel = new EmployeeModel();
    private static AdminAddFormController controller;

    public AdminAddFormController(){
        controller = this;
    }

    public static AdminAddFormController getInstance(){
        return controller;
    }
    public void closeOnMouseClick(MouseEvent event) {
       Navigation.closePane();
    }

    public void btnAsAEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(ManagerGlobalFormController.getInstance().crudPane, "EmployeeAddForm.fxml");
    }

    public void btnEmployeeAddOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        Navigation.popupPane("FileChooserPopupForm.fxml");
        FileChooserPopupFormController.getInstance().adminAddPane.setVisible(true);
    }
    public String getRole() {
        return String.valueOf(cmbRole.getSelectionModel().getSelectedItem());
    }

    private void setdataInComboBox() {
        ArrayList<String> roles = new ArrayList<>();
        roles.add("Manager");
        roles.add("Admin");
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

    public void asAEmployeeOnMouseEnterd(MouseEvent event) {
        asEmployee.setVisible(false);
        asBlueEmployee.setVisible(true);
    }

    public void asAEmployeeOnMouseExit(MouseEvent event) {
        asEmployee.setVisible(true);
        asBlueEmployee.setVisible(false);
    }

    public void closeOnMouseEnterd(MouseEvent event) {
        closeImg.setImage(new Image("img/PropertyHover.jpg"));
    }

    public void closeOnMouseExit(MouseEvent event) {
        closeImg.setImage(new Image("img/close-btn.png"));
    }

    public void btnCancelOnMouseEnterd(MouseEvent event) {
        txtCancel.setVisible(false);
        txtBlueCancel.setVisible(true);
    }

    public void btnCancelOnMouseExit(MouseEvent event) {
        txtCancel.setVisible(true);
        txtBlueCancel.setVisible(false);
    }

    public void btnCancelOnMouseClicked(MouseEvent mouseEvent) {
      Navigation.closePane();
    }
}

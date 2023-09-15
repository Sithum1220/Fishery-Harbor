package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.EmployeeDTO;
import lk.ijse.fisheryharbour.model.EmployeeModel;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EmployeeUpdateFormController implements Initializable {
    private static String id;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtMobile;
    public JFXTextField txtEmail;
    public JFXTextField txtNic;
    public JFXComboBox cmbRole;
    public JFXTextField txtHouseNo;
    public JFXTextField txtStreet;
    public JFXTextField txtCity;
    public Text txtCancel;
    public Text txtBlueCancel;
    public ImageView closeImg;

    EmployeeModel employeeModel = new EmployeeModel();

    public static void getId(String id) {
        EmployeeUpdateFormController.id = id;
    }

    public void btnAsAAdminOnAction(ActionEvent actionEvent) {
    }

    public void btnEmployeeUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        System.out.println(id);
        employeeDTO.setEmployee_Id(id);
        employeeDTO.setFirst_Name(txtFirstName.getText());
        employeeDTO.setLast_Name(txtLastName.getText());
        employeeDTO.setCity(txtCity.getText());
        employeeDTO.setStreet(txtStreet.getText());
        employeeDTO.setHouse_No(txtHouseNo.getText());
        employeeDTO.setRole(getRole());
        employeeDTO.setNic(txtNic.getText());
        employeeDTO.setEmail(txtEmail.getText());
        employeeDTO.setContact_No(txtMobile.getText());

        boolean update = employeeModel.update(employeeDTO);

        EmployeeManageFormController.getInstance().getAllId();
        Navigation.closePane();
    }

    public void closeOnMouseClick(MouseEvent mouseEvent) {
        Navigation.closePane();
    }

    public void setData() {
        EmployeeDTO employeeDTO = null;
        try {
            System.out.println(id);
            employeeDTO = employeeModel.getData(id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        txtCity.setText(employeeDTO.getCity());
        txtEmail.setText(employeeDTO.getEmail());
        txtNic.setText(employeeDTO.getNic());
        txtStreet.setText(employeeDTO.getStreet());
        txtHouseNo.setText(employeeDTO.getHouse_No());
        txtMobile.setText(employeeDTO.getContact_No());
        cmbRole.setValue(employeeDTO.getRole());
        txtFirstName.setText(employeeDTO.getFirst_Name());
        txtLastName.setText(employeeDTO.getLast_Name());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
        setdataInComboBox();
    }

    private String getRole() {
        return String.valueOf(cmbRole.getSelectionModel().getSelectedItem());
    }

    private void setdataInComboBox() {
        ArrayList<String> roles = new ArrayList<>();
        roles.add("Manager");
        roles.add("Admin");
        roles.add("Security");
        roles.add("Minor Staff");
        roles.add("Reception");
        roles.add("Clerk");
        roles.add("Other");
        cmbRole.getItems().addAll(roles);
    }

    public void closeOnMouseEntered(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/PropertyHover.jpg"));
    }

    public void closeOnMouseExited(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/close-btn.png"));
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Navigation.closePane();
    }

    public void btnCancelOnMouseEntered(MouseEvent mouseEvent) {
        txtCancel.setVisible(false);
        txtBlueCancel.setVisible(true);
    }

    public void btnCancelOnMouseExited(MouseEvent mouseEvent) {
        txtCancel.setVisible(true);
        txtBlueCancel.setVisible(false);
    }
}

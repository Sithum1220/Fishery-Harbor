package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.fisheryharbour.dto.EmployeeDTO;
import lk.ijse.fisheryharbour.model.EmployeeModel;
import lk.ijse.fisheryharbour.utill.Navigation;

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

    EmployeeModel employeeModel = new EmployeeModel();

    public void closeOnMouseClick(MouseEvent event) {
        Navigation.exit();
    }

    public void btnAsAEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(ManagerGlobalFormController.getInstance().crudPane, "EmployeeAddForm.fxml");
    }

    public void btnEmployeeAddOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        ManagerGlobalFormController.getInstance().crudPane.getChildren().clear();
        ManagerGlobalFormController.getInstance().crudPane.setVisible(false);
        ManagerGlobalFormController.getInstance().popupPane.setVisible(false);

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setEmployee_Id(genarateNewId());
        employeeDTO.setCity(txtCity.getText());
        employeeDTO.setContact_No(txtMobile.getText());
        employeeDTO.setEmail(txtEmail.getText());
        employeeDTO.setNic(txtNic.getText());
        employeeDTO.setFirst_Name(txtFirstName.getText());
        employeeDTO.setLast_Name(txtLastName.getText());
        employeeDTO.setHouse_No(txtHouseNo.getText());
        employeeDTO.setRole(getRole());
        employeeDTO.setStreet(txtStreet.getText());
        employeeDTO.setPassword(txtPassword.getText());
        employeeDTO.setUser_Name(txtUserName.getText());

        employeeModel.save(employeeDTO);
    }

    private String genarateNewId(){
        try {
            ArrayList<String> id = employeeModel.getAllEmployeeId();

            String lastId = null;

            for (int i = 0; i < id.size(); i++) {
                lastId = id.get(i);
            }

            String[] split = lastId.split("E-0");
            int idIndex = Integer.parseInt(split[1]);
            idIndex++;
            return "E-0"+idIndex;

        } catch (Exception e) {
            return "E-01";
        }
    }
    private String getRole() {
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
    }
}

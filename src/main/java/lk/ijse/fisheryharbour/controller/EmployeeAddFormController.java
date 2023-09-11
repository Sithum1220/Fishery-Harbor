package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import lk.ijse.fisheryharbour.dto.EmployeeDTO;
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

    EmployeeModel employeeModel = new EmployeeModel();

    public void closeOnMouseClick(MouseEvent event) {
        ManagerGlobalFormController.getInstance().crudPane.getChildren().clear();
        ManagerGlobalFormController.getInstance().crudPane.setVisible(false);
        ManagerGlobalFormController.getInstance().popupPane.setVisible(false);
    }

    public void btnEmployeeAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
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

        employeeModel.save(employeeDTO);
    }


    public void btnAsAAdminOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(ManagerGlobalFormController.getInstance().crudPane, "AdminAddForm.fxml");
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
}

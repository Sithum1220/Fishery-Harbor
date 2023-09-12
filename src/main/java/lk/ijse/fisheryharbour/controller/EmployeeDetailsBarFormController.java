package lk.ijse.fisheryharbour.controller;

import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.EmployeeDTO;
import lk.ijse.fisheryharbour.model.EmployeeModel;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class EmployeeDetailsBarFormController {
    public Text id;
    public Text name;
    public Text role;
    public Text email;
    public Text mobile;

    EmployeeModel employeeModel = new EmployeeModel();
    public void updateOnMouseClick(MouseEvent event) throws IOException {
        EmployeeUpdateFormController.getId(id.getText());
        ManagerGlobalFormController.getInstance().popupPane.setVisible(true);
        ManagerGlobalFormController.getInstance().crudPane.setVisible(true);
        Navigation.switchPaging(ManagerGlobalFormController.getInstance().crudPane, "EmployeeUpdateForm.fxml");

    }

    public void deleteOnMouseClick(MouseEvent event) {
    }

    public void detailsOnMouseClick(MouseEvent event) {
    }

    public void setData(String id) {
        try {
            EmployeeDTO employeeDTO = employeeModel.getData(id);

            this.id.setText(employeeDTO.getEmployee_Id());
            name.setText(employeeDTO.getFirst_Name()+" "+employeeDTO.getLast_Name());
            role.setText(employeeDTO.getRole());
            email.setText(employeeDTO.getEmail());
            mobile.setText(employeeDTO.getContact_No());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

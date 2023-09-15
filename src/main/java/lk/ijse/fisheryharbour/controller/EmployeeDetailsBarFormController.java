package lk.ijse.fisheryharbour.controller;

import javafx.scene.image.ImageView;
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
    public ImageView viewImg;

    EmployeeModel employeeModel = new EmployeeModel();

    public void updateOnMouseClick(MouseEvent event) throws IOException {
        EmployeeUpdateFormController.getId(id.getText());
        Navigation.popupPane("EmployeeUpdateForm.fxml");

    }

    public void deleteOnMouseClick(MouseEvent event) throws IOException {
        ConfirmationPopUpController.setId(id.getText());
        Navigation.popupPane("ConfirmationPopUp.fxml");
    }

    public void detailsOnMouseClick(MouseEvent event) throws IOException {
        EmployeeDetailsViewFormController.setId(id.getText());
        Navigation.popupPane("EmployeeDetailsViewForm.fxml");
    }

    public void setData(String id) {
        try {
            EmployeeDTO employeeDTO = employeeModel.getData(id);

            this.id.setText(employeeDTO.getEmployee_Id());
            name.setText(employeeDTO.getFirst_Name() + " " + employeeDTO.getLast_Name());
            role.setText(employeeDTO.getRole());
            email.setText(employeeDTO.getEmail());
            mobile.setText(employeeDTO.getContact_No());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

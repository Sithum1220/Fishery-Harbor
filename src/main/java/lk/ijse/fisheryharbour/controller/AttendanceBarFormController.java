package lk.ijse.fisheryharbour.controller;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.EmployeeDTO;
import lk.ijse.fisheryharbour.model.EmployeeModel;

import java.sql.SQLException;

public class AttendanceBarFormController {
    public Text txtId;
    public Text txtName;
    public Text txtRole;
    public Text txtMobile;
    public Text txtEmail;
    public ImageView updateImg;
    public ImageView deleteImg;
    public ImageView viewImg;
    public void updateOnMouseClick(MouseEvent mouseEvent) {
    }

    public void updateOnMouseEntered(MouseEvent mouseEvent) {
    }

    public void updateOnMouseExited(MouseEvent mouseEvent) {
    }

    public void deleteOnMouseClick(MouseEvent mouseEvent) {
    }

    public void deleteOnMouseEntered(MouseEvent mouseEvent) {
    }

    public void deleteOnMouseExited(MouseEvent mouseEvent) {
    }

    public void detailsOnMouseClick(MouseEvent mouseEvent) {
    }

    public void viewOnMouseEntered(MouseEvent mouseEvent) {
    }

    public void viewOnMouseExited(MouseEvent mouseEvent) {
    }
    public void setData(String id) throws SQLException, ClassNotFoundException {
        EmployeeModel employeeModel = new EmployeeModel();
        EmployeeDTO employeeDTO = employeeModel.getData(id);
        txtId.setText(id);
        txtRole.setText(employeeDTO.getRole());
        txtName.setText(employeeDTO.getFirst_Name()+" "+employeeDTO.getLast_Name());
        txtEmail.setText(employeeDTO.getEmail());
        txtMobile.setText(employeeDTO.getContact_No());
    }
}

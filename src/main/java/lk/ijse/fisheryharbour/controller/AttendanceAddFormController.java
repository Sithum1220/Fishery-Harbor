package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.EmployeeAttendanceDTO;
import lk.ijse.fisheryharbour.model.EmployeeAttendanceModel;
import lk.ijse.fisheryharbour.utill.DateTimeUtil;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.sql.SQLException;

public class AttendanceAddFormController {
    public ImageView closeImg;
    public Text txtBlueCancel;
    public Text txtCancel;
    public JFXTextField EmployeeID;

    public void btnMarkAttendenceOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        EmployeeAttendanceModel employeeAttendanceModel = new EmployeeAttendanceModel();
        boolean isEmployeeExist = employeeAttendanceModel.isEmployeeExsist(EmployeeID.getText());
        boolean isEmployeeTodayExist = employeeAttendanceModel.isEmployeeTodayExsist(EmployeeID.getText());
        if (isEmployeeExist) {
            if (isEmployeeTodayExist) {

                EmployeeAttendanceDTO employeeAttendanceDTO = new EmployeeAttendanceDTO();
                employeeAttendanceDTO.setEmployee_Id(EmployeeID.getText());
                employeeAttendanceDTO.setDate(DateTimeUtil.dateNow());
                employeeAttendanceDTO.setTime(DateTimeUtil.timeNow());
                boolean save = employeeAttendanceModel.save(employeeAttendanceDTO);

                Navigation.adminClosePane();

            } else {
                new Alert(Alert.AlertType.ERROR, "This Employee is Today Exist").showAndWait();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Invalid Employee Id").showAndWait();
        }
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Navigation.adminClosePane();
    }

    public void btnCancelOnMouseEnterd(MouseEvent mouseEvent) {

    }

    public void btnCancelOnMouseExit(MouseEvent mouseEvent) {
    }

    public void closeOnMouseClick(MouseEvent mouseEvent) {
        Navigation.adminClosePane();

    }

    public void closeOnMouseEnterd(MouseEvent mouseEvent) {
    }

    public void closeOnMouseExit(MouseEvent mouseEvent) {
    }
}

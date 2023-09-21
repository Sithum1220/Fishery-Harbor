package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import lk.ijse.fisheryharbour.model.EmployeeAttendanceModel;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceFormController {
    public JFXButton btnEnterID;
    public VBox vBox;

    public void btnEnterIdAddOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.AdminPopupPane("AttendanceAddForm.fxml");
    }

    public void getAllId() {
        EmployeeAttendanceModel employeeAttendanceModel = new EmployeeAttendanceModel();
        ArrayList<String> list = null;
        try {
            list = employeeAttendanceModel.getAllId();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        vBox.getChildren().clear();
        for (int i = 0; i < list.size(); i++) {
            loadDataTable(list.get(i));
        }
    }

    private void loadDataTable(String id) {
        try {
            FXMLLoader loader = new FXMLLoader(EmployeeManageFormController.class.getResource("/view/"));
            Parent root = loader.load();
            EmployeeDetailsBarFormController controller = loader.getController();
            controller.setData(id);
            vBox.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

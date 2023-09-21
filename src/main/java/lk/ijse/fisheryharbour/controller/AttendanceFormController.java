package lk.ijse.fisheryharbour.controller;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.ijse.fisheryharbour.model.EmployeeAttendanceModel;
import lk.ijse.fisheryharbour.model.QueryModel;
import lk.ijse.fisheryharbour.utill.Navigation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AttendanceFormController implements Initializable {
    public JFXButton btnEnterID;
    public VBox vBox;


    private static AttendanceFormController controller;



    public AttendanceFormController(){
        controller = this;
    }

    public static AttendanceFormController getInstance(){
        return controller;
    }
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
            FXMLLoader loader = new FXMLLoader(AttendanceFormController.class.getResource("/view/AttendanceBarForm.fxml"));
            Parent root = loader.load();
            AttendanceBarFormController controller = loader.getController();
            controller.setData(id);
            vBox.getChildren().add(root);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAllId();
    }
}

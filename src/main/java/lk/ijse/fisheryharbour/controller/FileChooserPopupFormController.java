package lk.ijse.fisheryharbour.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import lk.ijse.fisheryharbour.dto.EmployeeDTO;
import lk.ijse.fisheryharbour.model.EmployeeModel;
import lk.ijse.fisheryharbour.utill.NewId;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FileChooserPopupFormController implements Initializable {
    private static FileChooserPopupFormController controller;
    public Text txtPath;
    public Pane adminAddPane;
    EmployeeModel employeeModel = new EmployeeModel();

    private String path;
    private String id;
    public FileChooserPopupFormController() {
        controller = this;
    }

    public static FileChooserPopupFormController getInstance() {
        return controller;
    }

    public void closeOnMouseClick(MouseEvent event) {
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
    }

    public void btnConfirmOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, WriterException, IOException {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployee_Id(id);
        employeeDTO.setCity(EmployeeAddFormController.getInstance().txtCity.getText());
        employeeDTO.setContact_No(EmployeeAddFormController.getInstance().txtMobile.getText());
        employeeDTO.setEmail(EmployeeAddFormController.getInstance().txtEmail.getText());
        employeeDTO.setNic(EmployeeAddFormController.getInstance().txtNic.getText());
        employeeDTO.setFirst_Name(EmployeeAddFormController.getInstance().txtFirstName.getText());
        employeeDTO.setLast_Name(EmployeeAddFormController.getInstance().txtLastName.getText());
        employeeDTO.setHouse_No(EmployeeAddFormController.getInstance().txtHouseNo.getText());
        employeeDTO.setRole(EmployeeAddFormController.getInstance().getRole());
        employeeDTO.setStreet(EmployeeAddFormController.getInstance().txtStreet.getText());

        boolean save = employeeModel.save(employeeDTO);

        if (save) {
            new Alert(Alert.AlertType.CONFIRMATION, "Successfully Added !!").showAndWait();
            EmployeeManageFormController.getInstance().getAllId();

            BitMatrix bitMatrix = new MultiFormatWriter().encode(id, BarcodeFormat.QR_CODE,500,500);
            MatrixToImageWriter.writeToPath(bitMatrix,"jpg", Paths.get(path));

            ManagerGlobalFormController.getInstance().crudPane.getChildren().clear();
            ManagerGlobalFormController.getInstance().crudPane.setVisible(false);
            ManagerGlobalFormController.getInstance().popupPane.setVisible(false);
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Error. Please Try Again !!").showAndWait();
        }
    }

    public void btnChooseOnAction(ActionEvent actionEvent) {

        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select Directory");
        chooser.setInitialDirectory(new File("/Users"));
        Stage stage = (Stage) txtPath.getScene().getWindow();
        File file = chooser.showDialog(stage);
        txtPath.setText(String.valueOf(file));

        path = txtPath.getText()+"/"+id+".jpg";
    }

    public void adminAddPaneOnMouseClick(MouseEvent event) throws SQLException, ClassNotFoundException, WriterException, IOException {
        EmployeeDTO employeeDTO = new EmployeeDTO();



        employeeDTO.setEmployee_Id(id);
        employeeDTO.setCity(AdminAddFormController.getInstance().txtCity.getText());
        employeeDTO.setContact_No(AdminAddFormController.getInstance().txtMobile.getText());
        employeeDTO.setEmail(AdminAddFormController.getInstance().txtEmail.getText());
        employeeDTO.setNic(AdminAddFormController.getInstance().txtNic.getText());
        employeeDTO.setFirst_Name(AdminAddFormController.getInstance().txtFirstName.getText());
        employeeDTO.setLast_Name(AdminAddFormController.getInstance().txtLastName.getText());
        employeeDTO.setHouse_No(AdminAddFormController.getInstance().txtHouseNo.getText());
        employeeDTO.setRole(AdminAddFormController.getInstance().getRole());
        employeeDTO.setStreet(AdminAddFormController.getInstance().txtStreet.getText());
        employeeDTO.setPassword(AdminAddFormController.getInstance().txtPassword.getText());
        employeeDTO.setUser_Name(AdminAddFormController.getInstance().txtUserName.getText());

        boolean save = employeeModel.save(employeeDTO);

        if (save) {
            new Alert(Alert.AlertType.CONFIRMATION, "Successfully Added !!").showAndWait();
            EmployeeManageFormController.getInstance().getAllId();

            BitMatrix bitMatrix = new MultiFormatWriter().encode(id, BarcodeFormat.QR_CODE,500,500);
            MatrixToImageWriter.writeToPath(bitMatrix,"jpg", Paths.get(path));

            ManagerGlobalFormController.getInstance().crudPane.getChildren().clear();
            ManagerGlobalFormController.getInstance().crudPane.setVisible(false);
            ManagerGlobalFormController.getInstance().popupPane.setVisible(false);
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Error. Please Try Again !!").showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> list = null;
        try {
            list = employeeModel.getAllEmployeeId();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        id = NewId.newId(list, NewId.GetType.EMPLOYEE);
    }
}

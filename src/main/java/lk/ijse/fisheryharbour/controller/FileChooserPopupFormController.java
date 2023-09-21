package lk.ijse.fisheryharbour.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import lk.ijse.fisheryharbour.dto.BoatDTO;
import lk.ijse.fisheryharbour.dto.EmployeeDTO;
import lk.ijse.fisheryharbour.model.BoatModel;
import lk.ijse.fisheryharbour.model.EmployeeModel;
import lk.ijse.fisheryharbour.utill.Navigation;
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
    public ImageView closeImg;
    public Text txtCancel;
    public Text txtBlueCancel;
    public Text txtChoose;
    public Text txtBlueChoose;
    public JFXButton btnSave;
    EmployeeModel employeeModel = new EmployeeModel();

    private String path;
    private static String id;

    public FileChooserPopupFormController() {
        controller = this;
    }

    public static FileChooserPopupFormController getInstance() {
        return controller;
    }

    public void closeOnMouseClick(MouseEvent event) {
        Navigation.closePane();

    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Navigation.closePane();

    }

    public void btnConfirmOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, WriterException, IOException {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        if (id.startsWith("E")){
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

            EmployeeManageFormController.getInstance().getAllId();
        }else if (id.startsWith("B")){
            BoatModel boatModel = new BoatModel();
            BoatDTO boatDTO = new BoatDTO();
            boatDTO.setBoat_Id(id);
            boatDTO.setBoat_name(BoatAddFormController.getInstance().txtBoatName.getText());
            boatDTO.setOwner_Id(BoatAddFormController.getInstance().txtOwnerId.getText());
            boatDTO.setBoat_Type(BoatAddFormController.getInstance().getRole());

            boolean save = boatModel.save(boatDTO);
            BoatManageFormController.getInstance().allBoatId();
        }

        BitMatrix bitMatrix = new MultiFormatWriter().encode(id, BarcodeFormat.QR_CODE, 500, 500);
        MatrixToImageWriter.writeToPath(bitMatrix, "jpg", Paths.get(path));

        Navigation.closePane();

    }


    public void btnChooseOnAction(ActionEvent actionEvent) {

        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select Directory");
        chooser.setInitialDirectory(new File("/"));
        Stage stage = (Stage) txtPath.getScene().getWindow();
        File file = chooser.showDialog(stage);
        txtPath.setText(String.valueOf(file));
        path = txtPath.getText() + "/" + id + ".jpg";

        if (txtPath.getText().equals("") || txtPath.getText().equals("null")) {
            btnSave.setDisable(true);
            adminAddPane.setDisable(true);
            txtPath.setText(" ");
        } else {
            btnSave.setDisable(false);
            adminAddPane.setDisable(false);
        }
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

        EmployeeManageFormController.getInstance().getAllId();

        BitMatrix bitMatrix = new MultiFormatWriter().encode(id, BarcodeFormat.QR_CODE, 500, 500);
        MatrixToImageWriter.writeToPath(bitMatrix, "jpg", Paths.get(path));

        Navigation.closePane();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        btnSave.setDisable(true);
        adminAddPane.setDisable(true);
    }

    public void closeOnMouseEntered(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/PropertyHover.jpg"));
    }

    public void closeOnMouseExited(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/close-btn.png"));
    }

    public void btnCancelOnMouseEntered(MouseEvent mouseEvent) {
        txtCancel.setVisible(false);
        txtBlueCancel.setVisible(true);
    }

    public void btnCancelOnMouseExited(MouseEvent mouseEvent) {
        txtCancel.setVisible(true);
        txtBlueCancel.setVisible(false);
    }

    public void btnChooseOnMouseEntered(MouseEvent mouseEvent) {
        txtChoose.setVisible(false);
        txtBlueChoose.setVisible(true);
    }

    public void btnChooseOnMouseExited(MouseEvent mouseEvent) {
        txtChoose.setVisible(true);
        txtBlueChoose.setVisible(false);
    }

    public void adminAddPaneMouseEnterd(MouseEvent event) {
        btnSave.setStyle("-fx-background-color: #2F75FF;");
    }

    public void adminAddPaneMouseExit(MouseEvent event) {
        btnSave.setStyle("-fx-background-color: #1351CB;");

    }

    public static void setId(String id){
        FileChooserPopupFormController.id = id;
    }
}

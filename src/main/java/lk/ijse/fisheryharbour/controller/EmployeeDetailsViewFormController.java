package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.EmployeeDTO;
import lk.ijse.fisheryharbour.model.EmployeeModel;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeeDetailsViewFormController implements Initializable {
    private static String id;
    public ImageView closeImg;
    public JFXTextField txtName;
    public JFXTextField txtMobile;
    public JFXTextField txtEmail;
    public JFXTextField txtNic;
    public Text txtCancel;
    public Text txtBlueCancel;
    public JFXTextField txtRole;
    public JFXTextField txtAddress;

    EmployeeModel employeeModel = new EmployeeModel();
    public static void setId(String id) {
        EmployeeDetailsViewFormController.id = id;
    }

    public void closeOnMouseClick(MouseEvent event) {
        Navigation.closePane();
    }

    public void closeOnMouseEnterd(MouseEvent event) {
        closeImg.setImage(new Image("img/PropertyHover.jpg"));
    }

    public void closeOnMouseExit(MouseEvent event) {
        closeImg.setImage(new Image("img/close-btn.png"));
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Navigation.closePane();
    }

    public void btnCancelOnMouseEnterd(MouseEvent event) {
        txtCancel.setVisible(false);
        txtBlueCancel.setVisible(true);
    }

    public void btnCancelOnMouseExit(MouseEvent event) {
        txtCancel.setVisible(true);
        txtBlueCancel.setVisible(false);

    }

    public void setData() throws SQLException, ClassNotFoundException {
       EmployeeDTO employeeDTO =  employeeModel.getData(id);
        txtName.setText(employeeDTO.getFirst_Name()+" "+employeeDTO.getLast_Name());
        txtMobile.setText(employeeDTO.getContact_No());
        txtEmail.setText(employeeDTO.getEmail());
        txtNic.setText(employeeDTO.getNic());
        txtRole.setText(employeeDTO.getRole());
        txtAddress.setText(employeeDTO.getHouse_No()+" "+employeeDTO.getStreet()+", "+employeeDTO.getCity());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            setData();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

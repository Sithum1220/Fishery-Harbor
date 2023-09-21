package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminGlobalFormController implements Initializable {
    public Pane pagingPane;
    public JFXButton btnDashboard;
    public ImageView btnDashboardImg;
    public Label btnDashboardText;
    public JFXButton btnAttendance;
    public ImageView btnEmployeeImg;
    public Label btnEmployeeText;
    public JFXButton btnBoatManage;
    public ImageView btnSupplierImg;
    public Label btnSupplierText;
    public JFXButton btnRent;
    public ImageView btnOwnerImg;
    public Label btnOwnerText;
    public JFXButton btnStock;
    public ImageView btnStockImg;
    public Label btnStockText;
    public JFXButton btnLogout;
    public ImageView btnLogoutImg;
    public Label btnLogoutText;
    public Pane crudPane;
    public ImageView popupPane;

    private static  AdminGlobalFormController controller;

    public AdminGlobalFormController(){
        controller = this;
    }

    public static AdminGlobalFormController getInstance(){
        return controller;
    }

    public void dashboardOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(pagingPane,"AdminDashboardForm.fxml");
    }

    public void btnAttendenceOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(pagingPane,"AttendanceForm.fxml");

    }

    public void btnBoatManageOnAction(ActionEvent actionEvent) {
    }

    public void btnRentAddOnAction(ActionEvent actionEvent) {
    }

    public void btnStockOnAction(ActionEvent actionEvent) {
    }

    public void btnLogoutOnMouseEntered(MouseEvent mouseEvent) {
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) {
    }

    public void btnLogoutOnMouseExit(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Navigation.switchPaging(pagingPane,"AdminDashboardForm.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

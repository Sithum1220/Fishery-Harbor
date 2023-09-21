package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
        btnSelected(btnDashboard, btnDashboardText, btnDashboardImg, "category.png");
        btnUnselected(btnAttendance, btnEmployeeText, btnEmployeeImg, "attendence-btn.png");
        btnUnselected(btnBoatManage, btnSupplierText, btnSupplierImg, "boat-btn.png");
        btnUnselected(btnRent, btnOwnerText, btnOwnerImg, "user.png");
        btnUnselected(btnStock, btnStockText, btnStockImg, "box.png");

        Navigation.switchPaging(pagingPane,"AdminDashboardForm.fxml");
    }

    public void btnAttendenceOnAction(ActionEvent actionEvent) throws IOException {
        btnUnselected(btnDashboard, btnDashboardText, btnDashboardImg, "category-2.png");
        btnSelected(btnAttendance, btnEmployeeText, btnEmployeeImg, "calendar-2.png");
        btnUnselected(btnBoatManage, btnSupplierText, btnSupplierImg, "boat-btn.png");
        btnUnselected(btnRent, btnOwnerText, btnOwnerImg, "user.png");
        btnUnselected(btnStock, btnStockText, btnStockImg, "box.png");

        Navigation.switchPaging(pagingPane,"AttendanceForm.fxml");

    }

    void btnSelected(JFXButton button, Label label, ImageView imageView, String path) {
        button.setStyle(
                "-fx-background-color: #EDF3FF;" +
                        "-fx-background-radius: 12px;");
        label.setStyle("-fx-text-fill: #1351CB;" +
                "-fx-font-size: 16px");
        imageView.setImage(new Image("img/icon/" + path));
    }

    void btnUnselected(JFXButton button, Label label, ImageView imageView, String path) {
        button.setStyle(
                "-fx-background-radius: 12px;");
        label.setStyle("-fx-font-weight: 500;" +
                "-fx-font-size: 16px;" +
                "-fx-text-fill: #A3A3A3;");
        imageView.setImage(new Image("img/icon/" + path));
    }

    void logoutBtnSelected(JFXButton button, Label label, ImageView imageView, String path) {
        button.setStyle(
                "-fx-background-color: #FFE1E1;" +
                        "-fx-background-radius: 12px;");
        label.setStyle("-fx-text-fill: #FF2626;" +
                "-fx-font-size: 16px");
        imageView.setImage(new Image("img/icon/" + path));
    }

    public void btnBoatManageOnAction(ActionEvent actionEvent) throws IOException {
        btnUnselected(btnDashboard, btnDashboardText, btnDashboardImg, "category-2.png");
        btnUnselected(btnAttendance, btnEmployeeText, btnEmployeeImg, "attendence-btn.png");
        btnSelected(btnBoatManage, btnSupplierText, btnSupplierImg, "boat.png");
        btnUnselected(btnRent, btnOwnerText, btnOwnerImg, "user.png");
        btnUnselected(btnStock, btnStockText, btnStockImg, "box.png");

        Navigation.switchPaging(pagingPane,"BoatJourneyForm.fxml");
    }

    public void btnRentAddOnAction(ActionEvent actionEvent) throws IOException {
        btnUnselected(btnDashboard, btnDashboardText, btnDashboardImg, "category-2.png");
        btnUnselected(btnAttendance, btnEmployeeText, btnEmployeeImg, "attendence-btn.png");
        btnUnselected(btnBoatManage, btnSupplierText, btnSupplierImg, "boat-btn.png");
        btnSelected(btnRent, btnOwnerText, btnOwnerImg, "user2.png");
        btnUnselected(btnStock, btnStockText, btnStockImg, "box.png");

        Navigation.switchPaging(pagingPane,"RentDetailsForm.fxml");
    }

    public void btnStockOnAction(ActionEvent actionEvent) throws IOException {
        btnUnselected(btnDashboard, btnDashboardText, btnDashboardImg, "category-2.png");
        btnUnselected(btnAttendance, btnEmployeeText, btnEmployeeImg, "attendence-btn.png");
        btnUnselected(btnBoatManage, btnSupplierText, btnSupplierImg, "boat-btn.png");
        btnUnselected(btnRent, btnOwnerText, btnOwnerImg, "user.png");
        btnSelected(btnStock, btnStockText, btnStockImg, "box-2.png");

        Navigation.switchPaging(pagingPane,"RentDetailsForm.fxml");
    }

    public void btnLogoutOnMouseEntered(MouseEvent mouseEvent) {
        logoutBtnSelected(btnLogout, btnLogoutText, btnLogoutImg, "logout2.png");
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        logoutBtnSelected(btnLogout, btnLogoutText, btnLogoutImg, "logout2.png");
        Navigation.switchNavigation("LoginForm.fxml", actionEvent);
    }

    public void btnLogoutOnMouseExit(MouseEvent mouseEvent) {
        btnUnselected(btnLogout, btnLogoutText, btnLogoutImg, "logout.png");
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

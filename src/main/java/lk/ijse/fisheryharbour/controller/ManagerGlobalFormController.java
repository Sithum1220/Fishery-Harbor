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

public class ManagerGlobalFormController implements Initializable {


    private static ManagerGlobalFormController controller;
    public JFXButton btnDashboard;
    public ImageView btnDashboardImg;
    public Label btnDashboardText;
    public JFXButton btnEmployee;
    public ImageView btnEmployeeImg;
    public Label btnEmployeeText;
    public JFXButton btnSupplier;
    public ImageView btnSupplierImg;
    public Label btnSupplierText;
    public JFXButton btnOwner;
    public Label btnOwnerText;
    public JFXButton btnStock;
    public ImageView btnStockImg;
    public Label btnStockText;
    public JFXButton btnReport;
    public Pane pagingPane;
    public Label btnReportText;
    public ImageView btnReportImg;
    public ImageView btnOwnerImg;
    public ImageView btnLogoutImg;
    public Label btnLogoutText;
    public JFXButton btnLogout;
    public ImageView popupPane;
    public Pane crudPane;


    public ManagerGlobalFormController() {
        controller = this;
    }

    public static ManagerGlobalFormController getInstance() {
        return controller;
    }

    public void dashboardOnAction(ActionEvent actionEvent) throws IOException {
        btnSelected(btnDashboard, btnDashboardText, btnDashboardImg, "category.png");
        btnUnselected(btnEmployee, btnEmployeeText, btnEmployeeImg, "profile-2user.png");
        btnUnselected(btnSupplier, btnSupplierText, btnSupplierImg, "truck-fast.png");
        btnUnselected(btnOwner, btnOwnerText, btnOwnerImg, "user.png");
        btnUnselected(btnStock, btnStockText, btnStockImg, "box.png");
        btnUnselected(btnReport, btnReportText, btnReportImg, "chart.png");

        Navigation.switchPaging(pagingPane, "ManagerdashboardForm.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnSelected(btnDashboard, btnDashboardText, btnDashboardImg, "category.png");
        try {
            Navigation.switchPaging(pagingPane, "ManagerdashboardForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void btnEmployeeOnAction(ActionEvent actionEvent) {
        btnSelected(btnEmployee, btnEmployeeText, btnEmployeeImg, "profile-2user-2.png");
        btnUnselected(btnDashboard, btnDashboardText, btnDashboardImg, "category-2.png");
        btnUnselected(btnSupplier, btnSupplierText, btnSupplierImg, "truck-fast.png");
        btnUnselected(btnOwner, btnOwnerText, btnOwnerImg, "user.png");
        btnUnselected(btnStock, btnStockText, btnStockImg, "box.png");
        btnUnselected(btnReport, btnReportText, btnReportImg, "chart.png");

        try {
            Navigation.switchPaging(pagingPane, "EmployeeManageForm.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnSupplierOnAction(ActionEvent actionEvent) throws IOException {
        btnSelected(btnSupplier, btnSupplierText, btnSupplierImg, "truck-fast2.png");
        btnUnselected(btnEmployee, btnEmployeeText, btnEmployeeImg, "profile-2user.png");
        btnUnselected(btnDashboard, btnDashboardText, btnDashboardImg, "category-2.png");
        btnUnselected(btnOwner, btnOwnerText, btnOwnerImg, "user.png");
        btnUnselected(btnStock, btnStockText, btnStockImg, "box.png");
        btnUnselected(btnReport, btnReportText, btnReportImg, "chart.png");

        Navigation.switchPaging(pagingPane, "SupplierManageForm.fxml");
    }

    public void btnOwnerOnAction(ActionEvent actionEvent) throws IOException {
        btnSelected(btnOwner, btnOwnerText, btnOwnerImg, "user2.png");
        btnUnselected(btnEmployee, btnEmployeeText, btnEmployeeImg, "profile-2user.png");
        btnUnselected(btnDashboard, btnDashboardText, btnDashboardImg, "category-2.png");
        btnUnselected(btnSupplier, btnSupplierText, btnSupplierImg, "truck-fast.png");
        btnUnselected(btnStock, btnStockText, btnStockImg, "box.png");
        btnUnselected(btnReport, btnReportText, btnReportImg, "chart.png");

        Navigation.switchPaging(pagingPane, "OwnerManageForm.fxml");
    }

    public void btnStockOnAction(ActionEvent actionEvent) throws IOException {
        btnSelected(btnStock, btnStockText, btnStockImg, "box-2.png");
        btnUnselected(btnEmployee, btnEmployeeText, btnEmployeeImg, "profile-2user.png");
        btnUnselected(btnDashboard, btnDashboardText, btnDashboardImg, "category-2.png");
        btnUnselected(btnSupplier, btnSupplierText, btnSupplierImg, "truck-fast.png");
        btnUnselected(btnOwner, btnOwnerText, btnOwnerImg, "user.png");
        btnUnselected(btnReport, btnReportText, btnReportImg, "chart.png");

        Navigation.switchPaging(pagingPane, "StockManageForm.fxml");
    }

    public void btnReportOnAction(ActionEvent actionEvent) throws IOException {
        btnSelected(btnReport, btnReportText, btnReportImg, "report.png");
        btnUnselected(btnEmployee, btnEmployeeText, btnEmployeeImg, "profile-2user.png");
        btnUnselected(btnDashboard, btnDashboardText, btnDashboardImg, "category-2.png");
        btnUnselected(btnSupplier, btnSupplierText, btnSupplierImg, "truck-fast.png");
        btnUnselected(btnOwner, btnOwnerText, btnOwnerImg, "user.png");
        btnUnselected(btnStock, btnStockText, btnStockImg, "box.png");

        Navigation.switchPaging(pagingPane, "ReportRentManagementForm.fxml");
    }

    void logoutBtnSelected(JFXButton button, Label label, ImageView imageView, String path) {
        button.setStyle(
                "-fx-background-color: #FFE1E1;" +
                        "-fx-background-radius: 12px;");
        label.setStyle("-fx-text-fill: #FF2626;" +
                "-fx-font-size: 16px");
        imageView.setImage(new Image("img/icon/" + path));
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        logoutBtnSelected(btnLogout, btnLogoutText, btnLogoutImg, "logout2.png");
        Navigation.switchNavigation("LoginForm.fxml", actionEvent);
    }

    public void btnLogoutOnMouseExit(MouseEvent mouseEvent) {
        btnUnselected(btnLogout, btnLogoutText, btnLogoutImg, "logout.png");
    }

    public void btnLogoutOnMouseEntered(MouseEvent mouseEvent) {
        logoutBtnSelected(btnLogout, btnLogoutText, btnLogoutImg, "logout2.png");
    }
}

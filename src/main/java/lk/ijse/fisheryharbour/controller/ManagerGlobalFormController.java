package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerGlobalFormController implements Initializable {


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


    public void dashboardOnAction(ActionEvent actionEvent) {
        btnSelected(btnDashboard,btnDashboardText,btnDashboardImg,"category.png");
        btnUnselected(btnEmployee,btnEmployeeText,btnEmployeeImg,"profile-2user.png");
        btnUnselected(btnSupplier,btnSupplierText,btnSupplierImg,"truck-fast.png");
        btnUnselected(btnOwner,btnOwnerText,btnOwnerImg,"truck-fast.png");
        btnUnselected(btnStock,btnStockText,btnStockImg,"truck-fast.png");
        btnUnselected(btnReport,btnReportText,btnReportImg,"truck-fast.png");

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnSelected(btnDashboard,btnDashboardText,btnDashboardImg,"category.png");
        try {
            Navigation.switchPaging(pagingPane,"ManagerdashboardForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void btnSelected(JFXButton button,Label label,ImageView imageView,String path){
        button.setStyle(
                "-fx-background-color: #EDF3FF;" +
                "-fx-background-radius: 12px;");
        label.setStyle("-fx-text-fill: #1351CB;" +
                "-fx-font-size: 16px");
        imageView.setImage(new Image("img/icon/"+path));
    }
    void btnUnselected(JFXButton button,Label label,ImageView imageView,String path){
        button.setStyle(
                "-fx-background-radius: 12px;");
        label.setStyle("-fx-font-weight: 500;" +
                "-fx-font-size: 16px;" +
                "-fx-text-fill: #A3A3A3;");
        imageView.setImage(new Image("img/icon/"+path));
    }

    public void btnEmployeeOnAction(ActionEvent actionEvent) {
        btnSelected(btnEmployee,btnEmployeeText,btnEmployeeImg,"profile-2user-2.png");
        btnUnselected(btnDashboard,btnDashboardText,btnDashboardImg,"category-2.png");
    }

    public void btnSupplierOnAction(ActionEvent actionEvent) {
    }

    public void btnOwnerOnAction(ActionEvent actionEvent) {
    }

    public void btnStockOnAction(ActionEvent actionEvent) {
    }

    public void btnReportOnAction(ActionEvent actionEvent) {

    }
}

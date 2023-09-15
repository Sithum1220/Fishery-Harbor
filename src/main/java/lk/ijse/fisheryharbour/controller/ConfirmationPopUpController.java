package lk.ijse.fisheryharbour.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.model.EmployeeModel;

import java.sql.SQLException;

public class ConfirmationPopUpController {

    private static String id;
    public Text txtCancel;
    public Text txtBlueCancel;
    public ImageView closeImg;
    EmployeeModel employeeModel = new EmployeeModel();
    public void closeOnMouseClick(MouseEvent event) {
        ManagerGlobalFormController.getInstance().crudPane.getChildren().clear();
        ManagerGlobalFormController.getInstance().crudPane.setVisible(false);
        ManagerGlobalFormController.getInstance().popupPane.setVisible(false);
    }

    public void btnConfirmOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (id.startsWith("E")){
            boolean delete = employeeModel.delete(id);
            if (delete){
                EmployeeManageFormController.getInstance().getAllId();
                ManagerGlobalFormController.getInstance().crudPane.getChildren().clear();
                ManagerGlobalFormController.getInstance().crudPane.setVisible(false);
                ManagerGlobalFormController.getInstance().popupPane.setVisible(false);
            }else {
                new Alert(Alert.AlertType.CONFIRMATION,"Error. Please Try Again !!").showAndWait();
            }
        }

    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        ManagerGlobalFormController.getInstance().crudPane.getChildren().clear();
        ManagerGlobalFormController.getInstance().crudPane.setVisible(false);
        ManagerGlobalFormController.getInstance().popupPane.setVisible(false);
    }

    public static void setId(String id){
        ConfirmationPopUpController.id = id;
    }


    public void btnCancelOnMouseEntered(MouseEvent mouseEvent) {
        txtCancel.setVisible(false);
        txtBlueCancel.setVisible(true);
    }

    public void btnCancelOnMouseExited(MouseEvent mouseEvent) {
        txtCancel.setVisible(true);
        txtBlueCancel.setVisible(false);
    }

    public void closeOnMouseEntered(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/PropertyHover.jpg"));
    }

    public void closeOnMouseExited(MouseEvent mouseEvent) {
        closeImg.setImage(new Image("img/close-btn.png"));
    }
}

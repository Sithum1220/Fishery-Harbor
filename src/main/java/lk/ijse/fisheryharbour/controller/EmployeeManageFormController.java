package lk.ijse.fisheryharbour.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import lk.ijse.fisheryharbour.model.EmployeeModel;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class EmployeeManageFormController implements Initializable {

    public VBox vBox;
    EmployeeModel employeeModel = new EmployeeModel();
    public void btnEmployeeAddOnAction(ActionEvent actionEvent) throws IOException {
        ManagerGlobalFormController.getInstance().popupPane.setVisible(true);
        ManagerGlobalFormController.getInstance().crudPane.setVisible(true);
        Navigation.switchPaging(ManagerGlobalFormController.getInstance().crudPane, "EmployeeAddForm.fxml");
    }

    private void getAllId()  {
        ArrayList<String> list = null;
        try {
            list = employeeModel.getAllEmployeeId();
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
            FXMLLoader loader = new FXMLLoader(EmployeeManageFormController.class.getResource("/view/EmployeeDetailsBarForm.fxml"));
            Parent root = loader.load();
            EmployeeDetailsBarFormController controller = loader.getController();
            controller.setData(id);
            vBox.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAllId();
    }
}

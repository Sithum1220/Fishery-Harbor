package lk.ijse.fisheryharbour.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import lk.ijse.fisheryharbour.model.BoatModel;
import lk.ijse.fisheryharbour.model.SupplierModel;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BoatManageFormController implements Initializable {
    public VBox vBox;
    BoatModel boatModel = new BoatModel();
    private static BoatManageFormController controller;

    public BoatManageFormController() {
        controller = this;
    }

    public void btnOwnerDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(ManagerGlobalFormController.getInstance().pagingPane, "OwnerManageForm.fxml");
    }

    public void btnBoatAddOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupPane("BoatAddForm.fxml");
    }

    public void allBoatId() throws SQLException, ClassNotFoundException {
        vBox.getChildren().clear();
        BoatModel boatModel = new BoatModel();
        ArrayList<String> list = boatModel.getAllBoatId();

        for (int i = 0; i < list.size(); i++) {
            loadDataTable(list.get(i));
        }
    }

    private void loadDataTable(String id) {
        try {
            FXMLLoader loader = new FXMLLoader(SupplierManageFormController.class.getResource("/view/OwnerBoatDetailsBarForm.fxml"));
            Parent root = loader.load();
            OwnerBoatDetailsBarFormController controller = loader.getController();
            controller.setData(id);
            vBox.getChildren().add(root);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static BoatManageFormController getInstance() {
        return controller;
    }

    public void getAllId() {
        ArrayList<String> list = null;
        try {
            list = boatModel.getAllBoatId();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        vBox.getChildren().clear();
        for (int i = 0; i < list.size(); i++) {
            loadDataTable(list.get(i));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAllId();
    }
}

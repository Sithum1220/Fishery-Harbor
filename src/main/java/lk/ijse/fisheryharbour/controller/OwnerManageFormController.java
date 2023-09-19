package lk.ijse.fisheryharbour.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import lk.ijse.fisheryharbour.model.OwnerModel;
import lk.ijse.fisheryharbour.model.SupplierModel;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class OwnerManageFormController {

    private static OwnerManageFormController controller;
    public VBox vBox;

    public void btnOwnerAddOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupPane("OwnerAddForm.fxml");
    }

    public void btnBoatDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(ManagerGlobalFormController.getInstance().pagingPane, "BoatManageForm.fxml");
    }

    public static OwnerManageFormController getInstance() {
        return controller;
    }

    public void allOwnerId() throws SQLException, ClassNotFoundException {
        vBox.getChildren().clear();
        OwnerModel ownerModel = new OwnerModel();
        ArrayList<String> list = ownerModel.getAllOwnerId();

        for (int i = 0; i < list.size(); i++) {
            loadDataTable(list.get(i));
        }
    }

    private void loadDataTable(String id) {
        try {
            FXMLLoader loader = new FXMLLoader(OwnerManageFormController.class.getResource("/view/SupplierDetailsBarForm.fxml"));
            Parent root = loader.load();
            SupplierDetailsBarFormController controller = loader.getController();
            controller.setData(id);
            vBox.getChildren().add(root);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

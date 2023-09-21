package lk.ijse.fisheryharbour.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import lk.ijse.fisheryharbour.model.StockModel;
import lk.ijse.fisheryharbour.model.SupplierModel;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class StockManageFormController {

    private static StockManageFormController controller;
    public JFXButton btnAddStock;
    public VBox vBox;

    public StockManageFormController() {
        controller = this;
    }

    public static StockManageFormController getInstance() {
        return controller;
    }

    public void allStockId() throws SQLException, ClassNotFoundException {
        vBox.getChildren().clear();
        StockModel stockModel = new StockModel();
        ArrayList<String> list = stockModel.getAllStockId();

        for (int i = 0; i < list.size(); i++) {
            loadDataTable(list.get(i));
        }
    }

    private void loadDataTable(String id) {
        try {
            FXMLLoader loader = new FXMLLoader(StockManageFormController.class.getResource("/view/StockDetailsBarForm.fxml"));
            Parent root = loader.load();
            StockDetailsBarFormController controller = loader.getController();
            controller.setData(id);
            vBox.getChildren().add(root);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnStockAddOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupPane("StockAddForm.fxml");
    }
}

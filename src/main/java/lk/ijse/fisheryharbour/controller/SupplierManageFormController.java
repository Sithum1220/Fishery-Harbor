package lk.ijse.fisheryharbour.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import lk.ijse.fisheryharbour.model.SupplierModel;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SupplierManageFormController implements Initializable {

    private static SupplierManageFormController controller;
    public VBox vBox;

    public SupplierManageFormController() {
        controller = this;
    }

    public static SupplierManageFormController getInstance() {
        return controller;
    }

    public void btnSupplierAddOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupPane("SupplierAddForm.fxml");
    }

    public void allSupplierId() throws SQLException, ClassNotFoundException {
        SupplierModel supplierModel = new SupplierModel();
        ArrayList<String> list = supplierModel.getAllSupplierId();

        for (int i = 0; i < list.size(); i++) {
            loadDataTable(list.get(i));
        }
    }

    private void loadDataTable(String id) {
        try {
            FXMLLoader loader = new FXMLLoader(SupplierManageFormController.class.getResource("/view/SupplierDetailsBarForm.fxml"));
            Parent root = loader.load();
            SupplierDetailsBarFormController controller = loader.getController();
            controller.setData(id);
            vBox.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            allSupplierId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

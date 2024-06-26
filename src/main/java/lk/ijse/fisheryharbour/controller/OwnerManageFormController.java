package lk.ijse.fisheryharbour.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import lk.ijse.fisheryharbour.model.OwnerModel;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OwnerManageFormController implements Initializable {

    private static OwnerManageFormController controller;
    public VBox vBox;

    public OwnerManageFormController() {
        controller = this;
    }

    public static OwnerManageFormController getInstance() {
        return controller;
    }

    public void btnOwnerAddOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupPane("OwnerAddForm.fxml");
    }

    public void btnBoatDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(ManagerGlobalFormController.getInstance().pagingPane, "BoatManageForm.fxml");
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
            FXMLLoader loader = new FXMLLoader(OwnerManageFormController.class.getResource("/view/OwnerBarDetailsForm.fxml"));
            Parent root = loader.load();
            OwnerDetailsBarFormController controller = loader.getController();
            controller.setData(id);
            vBox.getChildren().add(root);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            allOwnerId();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

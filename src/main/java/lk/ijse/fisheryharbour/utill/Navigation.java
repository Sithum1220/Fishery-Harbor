package lk.ijse.fisheryharbour.utill;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.fisheryharbour.controller.AdminGlobalFormController;
import lk.ijse.fisheryharbour.controller.ManagerGlobalFormController;

import java.io.IOException;
import java.net.URL;

public class Navigation {
    private static Stage stage;
    private static Scene scene;
    private static Parent parent;



    public static void switchNavigation(String link, ActionEvent event) throws IOException {
        parent = FXMLLoader.load(Navigation.class.getResource("/view/" + link));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void switchNavigation(String link, javafx.scene.input.MouseEvent event) throws IOException {
        parent = FXMLLoader.load(Navigation.class.getResource("/view/" + link));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void popupNavigation(String link) throws IOException {
        URL resource = Navigation.class.getResource("/view/" + link);
        Parent parent = FXMLLoader.load(resource);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setAlwaysOnTop(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void exit() {
        System.exit(0);
    }

    public static void close(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    public static void close(javafx.scene.input.MouseEvent mouseEvent) {
        Node node = (Node) mouseEvent.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    public static void switchPaging(Pane pane, String path) throws IOException {
        pane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/view/"+path));
        Parent root = loader.load();
        pane.getChildren().add(root);
    }

    public static void closePane(){
        ManagerGlobalFormController.getInstance().crudPane.getChildren().clear();
        ManagerGlobalFormController.getInstance().crudPane.setVisible(false);
        ManagerGlobalFormController.getInstance().popupPane.setVisible(false);
    }

    public static void popupPane(String path) throws IOException {
        ManagerGlobalFormController.getInstance().popupPane.setVisible(true);
        ManagerGlobalFormController.getInstance().crudPane.setVisible(true);
        switchPaging(ManagerGlobalFormController.getInstance().crudPane, path);
    }

    public static void adminClosePane(){
        AdminGlobalFormController.getInstance().crudPane.getChildren().clear();
        AdminGlobalFormController.getInstance().crudPane.setVisible(false);
        AdminGlobalFormController.getInstance().popupPane.setVisible(false);
    }

    public static void AdminPopupPane(String path) throws IOException {
        AdminGlobalFormController.getInstance().popupPane.setVisible(true);
        AdminGlobalFormController.getInstance().crudPane.setVisible(true);
        switchPaging(AdminGlobalFormController.getInstance().crudPane, path);
    }
}

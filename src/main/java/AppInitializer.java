import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.fisheryharbour.controller.TaxManageFormController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;

public class AppInitializer extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/ManagerGlobalForm.fxml"));
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        Thread thread = new Thread(()->{
            while (true){
                renameImgPhone();
                imgTranfer();
                qrDecode();
                deleteImgPhone();
                deleteImgLap();
            }
        });
        thread.start();
    }

    public static void renameImgPhone() {
        String folderPath = "/storage/30A6-324B/DCIM/Camera/";

        String adbListCommand = "adb shell ls " + folderPath;

        boolean isImageFound = false;
        while (!isImageFound) {
            try {
                Process process = Runtime.getRuntime().exec(adbListCommand);
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Check if the file is an image (you can use a more specific condition)
                    if (line.endsWith(".jpg") || line.endsWith(".png") || line.endsWith(".jpeg")) {
                        // Rename the image file
                        String oldFilePath = folderPath + line;
                        String newFilePath = folderPath + "B001.jpg"; // Replace with the new file name

                        String adbRenameCommand = "adb shell mv " + oldFilePath + " " + newFilePath;
                        Process renameProcess = Runtime.getRuntime().exec(adbRenameCommand);
                        int exitCode = renameProcess.waitFor();

                        if (exitCode == 0) {
                            System.out.println("Image renamed successfully!");
                            isImageFound = true;
                            break; // Exit the loop after renaming the first image found
                        } else {
                            System.err.println("Image renaming failed. Exit code: " + exitCode);
                        }
                    }
                }

                reader.close();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void imgTranfer() {

        String adbCommand = "adb pull /storage/30A6-324B/DCIM/Camera/B001.jpg D:\\Solution99";
        boolean imageFound = false;

        try {
            while (!imageFound) {
                Process process = Runtime.getRuntime().exec(adbCommand);
                int exitCode = process.waitFor();
                if (exitCode == 0) {
                    System.out.println("File transfer successful!");
                    imageFound = true;
                    System.out.println(adbCommand);
                } else {
                    System.err.println("File transfer failed. Exit code: " + exitCode);
                }
                Thread.sleep(2000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void qrDecode(){
        try {
            File qrCodeImage = new File("D:\\Solution99\\B001.jpg");
            BufferedImage bufferedImage = ImageIO.read(qrCodeImage);

            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            Result result = new MultiFormatReader().decode(bitmap);
            String decodedText = result.getText();
            System.out.println(decodedText);

            TaxManageFormController.getInstance().setInnovativeBoatId(decodedText);

        } catch (IOException | NotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void deleteImgPhone() {
        String adbCommand = "adb shell rm /storage/30A6-324B/DCIM/Camera/B001.jpg";

        try {
            Process process = Runtime.getRuntime().exec(adbCommand);
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("File deleted successfully!");
            } else {
                System.err.println("File deletion failed. Exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void deleteImgLap() {
        String imagePath = "D:\\Solution99\\B001.jpg"; // Replace with the actual path of your image

        try {
            Path path = Paths.get(imagePath);
            Files.deleteIfExists(path);
            System.out.println("Image deleted successfully.");
        } catch (NoSuchFileException e) {
            System.out.println("The image does not exist.");
        } catch (DirectoryNotEmptyException e) {
            System.out.println("The specified path is a directory.");
        } catch (IOException e) {
            System.out.println("An I/O error occurred.");
            e.printStackTrace();
        }
    }
}

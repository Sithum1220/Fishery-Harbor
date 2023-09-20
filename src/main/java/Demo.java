import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    public static void main(String[] args) {



        // Specify the folder path where the image is located


//        ============================================================================

    }

    public static void deleteImgPhone() {
        // Specify the ADB command to delete the file
        String adbCommand = "adb shell rm /storage/30A6-324B/DCIM/Camera/B001.jpg"; // Replace with the actual file path

        try {
            // Execute the ADB command
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

    public static void renameImgPhone() {
        String folderPath = "/storage/30A6-324B/DCIM/Camera/"; // Replace with the actual folder path

        // Run the ADB command to list files in the folder
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
                        // Add code here to check if the image is present in the destination folder
                        // If the image is found, set imageFound to true
                        // For example, you can use the java.nio.file.Files class to check if a file exists
                        // For simplicity, let's assume we found the image for this example
                        imageFound = true;
                        System.out.println(adbCommand);
                        deleteImgPhone();
                        renameImgPhone();
                    } else {
                        System.err.println("File transfer failed. Exit code: " + exitCode);
                    }
                    // Sleep for a while before checking again (you can adjust the interval)
                    Thread.sleep(2000); // Sleep for 5 seconds (5000 milliseconds)
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
    }

    public static void imgOcr(){
        File imageFile = new File("D:\\Solution99\\B001.jpg"); // Replace with the path to your image file

        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Users\\GIT\\Downloads\\Tess4J-3.4.8-src\\Tess4J\\tessdata"); // Replace with the path to the tessdata directory (where language data files are located)

        try {
            String result = tesseract.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}

//        L1:
//        while (true) {
//
//            String adbCommand = "adb pull /storage/30A6-324B/DCIM/Camera/B00" + num + ".jpg D:\\Solution99";
//
//            System.out.println(num);
//            boolean imageFound = false;
//
//            try {
//                while (!imageFound) {
//                    Process process = Runtime.getRuntime().exec(adbCommand);
//                    int exitCode = process.waitFor();
//                    if (exitCode == 0) {
//                        System.out.println("File transfer successful!");
//                        // Add code here to check if the image is present in the destination folder
//                        // If the image is found, set imageFound to true
//                        // For example, you can use the java.nio.file.Files class to check if a file exists
//                        // For simplicity, let's assume we found the image for this example
//
//                        rename();
//                        imageFound = true;
//                        num = num + 1;
//                        System.out.println(adbCommand);
//                    } else {
//                        System.err.println("File transfer failed. Exit code: " + exitCode);
//                    }
//                    // Sleep for a while before checking again (you can adjust the interval)
//                    Thread.sleep(2000); // Sleep for 5 seconds (5000 milliseconds)
//                }
//            } catch (IOException | InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

//    }


//    public static void rename() {
//        String directoryPath = "adb pull /storage/30A6-324B/DCIM/Camera/"; // Replace with your actual directory path
//        File directory = new File(directoryPath);
//
//        // Filter to accept only image files (you can adjust this if needed)
//        FilenameFilter imageFilter = (dir, name) -> name.endsWith(".jpg") || name.endsWith(".png");
//
//        File[] imageFiles = directory.listFiles(imageFilter);
//
//        if (imageFiles != null && imageFiles.length > 0) {
//            File firstImage = imageFiles[0];
//
//            // Assuming you want to rename the first image to "new_image_name.jpg"
//            String newFileName = "Sithum.jpg"; // Replace with the desired new file name
//
//            File newFile = new File(firstImage.getParent(), newFileName);
//
//            if (firstImage.renameTo(newFile)) {
//                System.out.println("File renamed successfully.");
//            } else {
//                System.out.println("Failed to rename the file.");
//            }
//        } else {
//            System.out.println("No image files found in the directory.");
//        }
//
//
//    }
//}
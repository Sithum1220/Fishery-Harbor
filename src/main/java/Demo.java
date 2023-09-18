
import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

public class Demo {

    public static void main(String[] args) {
        try {
            // Define the directory to watch for new images on the Android device
            String watchDir = "/path/to/watch/directory/on/android/device/";

            // Define the directory on the computer to save received images
            String saveDir = "/path/to/save/directory/on/computer/";

            // Create a WatchService
            WatchService watchService = FileSystems.getDefault().newWatchService();

            // Register the watch service for the directory
            Path dir = Paths.get(watchDir);
            dir.register(watchService, ENTRY_CREATE);

            System.out.println("Watching directory for new images...");

            // Start an infinite loop to monitor for new images
            while (true) {
                WatchKey key = watchService.take(); // Wait for events

                for (WatchEvent<?> event : key.pollEvents()) {
                    // Check if the event is a new file creation event
                    if (event.kind() == ENTRY_CREATE) {
                        // Get the filename of the new file
                        String fileName = event.context().toString();

                        // Copy the file from Android device to computer
                        Path source = Paths.get(watchDir + fileName);
                        Path destination = Paths.get(saveDir + fileName);
                        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);

                        System.out.println("Image '" + fileName + "' copied to computer.");
                    }
                }

                // Reset the key
                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
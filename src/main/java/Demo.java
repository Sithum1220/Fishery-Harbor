import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class Demo {


    public static void main(String[] args) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select Directory");
        chooser.setInitialDirectory(new File("/Users"));

    }
}

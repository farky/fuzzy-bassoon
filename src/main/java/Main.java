import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamSlicer iss = new InputStreamSlicer(System.in);
        iss.process();

        List<File> outputFiles = iss.getOutputFileListing();
        System.out.println(String.format("Process completed. [%d] files were created.", outputFiles.size()));
        for (File file : outputFiles) {
            System.out.println(file.getName());
        }
    }

}

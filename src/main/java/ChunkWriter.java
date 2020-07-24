import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class ChunkWriter {

    private final File outputDir;
    private int chunkCounter = 0;

    public ChunkWriter() {
        outputDir = clearOrCreateOutputDirectory();
    }

    private File clearOrCreateOutputDirectory() {
        File outDir = new File(AppProperties.getString(AppProperties.PROP_OUTPUT_DIRECTORY));
        if (!outDir.exists()) {
            outDir.mkdir();
        } else {
            for (File file : outDir.listFiles()) {
                file.delete();
            }
        }

        return outDir;
    }

    public void write(String chunk) throws FileNotFoundException {
        String fileName = String.format(AppProperties.getString(AppProperties.PROP_OUTPUT_FILE_NAME_PATTERN), chunkCounter++);
        File file = new File(outputDir, fileName);

        PrintStream out = new PrintStream(new FileOutputStream(file));
        out.println(chunk);

        out.close();
    }

    public List<File> getOutputFileListing() {
        return Arrays.asList(outputDir.listFiles());
    }
}

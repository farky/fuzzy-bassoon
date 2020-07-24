import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class InputStreamSlicer {

    private final InputStream inputStream;
    private final ChunkWriter chunkWriter = new ChunkWriter();

    public InputStreamSlicer(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void process() throws IOException {
        Scanner inScanner = new Scanner(inputStream);

        String line;
        String chunk = "";
        do {
            line = inScanner.nextLine();
            chunk = chunk.concat(line);

            if (chunk.length() >= AppProperties.getInt(AppProperties.PROP_MAX_CHUNK_LENGTH)) {
                chunkWriter.write(chunk);
                chunk = "";
            }

        } while (!line.isEmpty());
    }

    public List<File> getOutputFileListing() {
        return chunkWriter.getOutputFileListing();
    }

}


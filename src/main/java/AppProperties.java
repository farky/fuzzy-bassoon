import java.util.Properties;

public class AppProperties {

    private static Properties properties;

    public static final String PROP_OUTPUT_FILE_NAME_PATTERN = "prop.output.file.name.pattern";
    public static final String PROP_OUTPUT_DIRECTORY = "prop.output.directory";
    public static final String PROP_MAX_CHUNK_LENGTH = "prop.max.chunk.length";

    public static String getString(String propertyName) {
        return getProperties().getProperty(propertyName);
    }

    public static int getInt(String propertyName) {
        // todo: handle non numeric values and return some default value
        return Integer.parseInt(getProperties().getProperty(propertyName));
    }

    private static Properties getProperties() {
        if (properties == null) {
            fillProperties();
        }
        return properties;
    }

    private static void fillProperties() {
        // todo: read properties from external configuration file
        properties = new Properties();
        properties.setProperty(PROP_OUTPUT_FILE_NAME_PATTERN, "out-%03d.txt");
        properties.setProperty(PROP_OUTPUT_DIRECTORY, "./chunks");
        properties.setProperty(PROP_MAX_CHUNK_LENGTH, String.valueOf(5));
    }
}

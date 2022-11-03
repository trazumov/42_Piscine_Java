import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProgramUtils {
    public static long directorySize(Path directory) {
        long size = 0;

        try (DirectoryStream<Path> files = Files.newDirectoryStream(directory)) {
            for (Path item : files) {
                if (Files.isDirectory(item)) {
                    size += directorySize(item);
                } else {
                    size += Files.size(item);
                }
            }
        } catch (IOException e) {
            System.out.println("Exception in method: directorySize");
            System.out.println(e.getMessage());
        }
        return size;
    }

    public static String getSize(long size) {
        return "" + (size / 1000) + " KB";
    }

    public static void checkAbsolutePath(Path path) {
        if (!path.isAbsolute()) {
            System.out.println("The current path is not absolute");
            System.exit(-1);
        }

        if (!Files.isDirectory(path)) {
            System.out.println("The current path is not a directory");
            System.exit(-1);
        }
    }
}
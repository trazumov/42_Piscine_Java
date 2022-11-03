import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    private static Scanner scanner = new Scanner(System.in);
    private static List<String> inputList;
    private static Path path, cdPath;

    public static void main(String[] args) {
        if (args.length != 1 || !args[0].startsWith("--current-folder=")) {
            System.out.println("Enter absolute path '--current-folder=' as argument");
            System.exit(-1);
        }
        String absolutePath = args[0].substring("--current-folder=".length());
        path = Paths.get(absolutePath);
        Utils.checkAbsolutePath(path);
        System.out.println(path);

        while (true) {
            exeCommand();
        }
    }

    private static void exeCommand() {
        String input = scanner.nextLine();
        inputList = Arrays.stream(input.trim().split("\\s+")).collect(Collectors.toList());

        if (inputList.size() == 1 && "exit".equals(inputList.get(0))) {
            System.exit(0);
        } else if (inputList.size() == 1 && "ls".equals(inputList.get(0))) {
            commandLS();
        } else if (inputList.size() == 2 && "cd".equals(inputList.get(0))) {
            commandCD();
        } else if (inputList.size() == 3 && "mv".equals(inputList.get(0))) {
            commandMV();
        } else {
            System.out.println("UNKNOWN COMMAND");
        }
    }

    private static void commandMV() {
        Path source = null;

        try (DirectoryStream<Path> files = Files.newDirectoryStream(path)) {
            for (Path item : files) {
                if (item.getFileName().toString().equals(inputList.get(1))
                        && Files.isRegularFile(item)) {
                    source = item;
                    break;
                }
            }

            if (source == null) {
                System.out.println("mv: no such file: " + inputList.get(1));
                return;
            }

            if (isDirectory(inputList.get(2))) {
                Files.move(source, cdPath.resolve(source.getFileName()),
                        StandardCopyOption.REPLACE_EXISTING);
            } else {
                Files.move(source, source.resolveSibling(Paths.get(inputList.get(2))));
            }
        } catch(IOException e) {
            System.out.println("Exception in method: commandMV");
            System.out.println(e.getMessage());
        }

    }

    private static void commandLS() {
        try (DirectoryStream<Path> files = Files.newDirectoryStream(path)) {
            for (Path item : files) {
                long size;

                if (Files.isDirectory(item)) {
                    size = Utils.directorySize(item);
                } else {
                    size = Files.size(item);
                }
                System.out.println(item.getFileName() + " " + Utils.getSize(size));
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void commandCD() {
        if (isDirectory(inputList.get(1))) {
            path = cdPath;
        } else {
            System.out.println("cd: no such directory: " + inputList.get(1));
        }
        System.out.println(path);
    }

    private static boolean isDirectory(String directory) {
        cdPath = Paths.get(directory);
        cdPath = path.resolve(cdPath).normalize();

        if (Files.isDirectory(cdPath)) {
            return true;
        }
        return false;
    }
}
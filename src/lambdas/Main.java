package lambdas;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;


public class Main {
    private static String getSubdirectories(String directoryName) {
        File directory = new File(directoryName);
        StringBuffer subdirectories = new StringBuffer(directoryName + " isn't a directory");
        if (directory.isDirectory()) {
            subdirectories.setLength(0);
            File[] files = directory.listFiles(File::isDirectory);
            if (files != null)
                for (File f : files) {
                    subdirectories = subdirectories.append(f.getPath()).append("\n");
                }
        }
        return subdirectories.toString();

    }

    public static void main(String[] args) {
        System.out.println(getSubdirectories("C:\\"));
        System.out.println(getSubdirectories("abc"));
    }
}

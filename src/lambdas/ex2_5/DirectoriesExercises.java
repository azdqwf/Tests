package lambdas.ex2_5;

import java.io.File;
import java.util.Arrays;

/**
        2 Using the listFiles(FileFilter) and isDirectory methods of the java.io.File class,
        write a method that returns all subdirectories of a given directory. Use a
        lambda expression instead of a FileFilter object. Repeat with a method
        expression.
        3. Using the list(FilenameFilter) method of the java.io.File class, write a method
        that returns all files in a given directory with a given extension. Use a lambda
        expression, not a FilenameFilter. Which variables from the enclosing scope does
        it capture?
        4. Given an array of File objects, sort it so that the directories come before the
        files, and within each group, elements are sorted by path name. Use a lambda
        expression, not a Comparator.
**/
public class DirectoriesExercises {
    //ex2
    private static File[] getSubdirectories(String directoryName) {
        File directory = new File(directoryName);
        File[] result = directory.listFiles(File::isDirectory);
        return (result != null) ? result : new File[]{};
    }

    //ex3
    private static File[] getFilesWithGivenExtension(String directoryName, String extension) {
        File directory = new File(directoryName);
        File[] result = directory.listFiles((dir, filename) -> filename.endsWith("." + extension));
        return (result != null) ? result : new File[]{};
    }

    //ex4
    private static void sortDir(File[] files) {
        Arrays.asList(files).sort(File::compareTo);// or (f1,f2) -> f1.compareTo(f2);
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSubdirectories("C:\\")));
        System.out.println(Arrays.toString(getSubdirectories("abc")));
        System.out.println(Arrays.toString(getFilesWithGivenExtension("C:\\", "ini")));
        System.out.println(Arrays.toString(getFilesWithGivenExtension("abc", "abc")));
        File[] files = new File[]{new File("b"), new File("a")};
        sortDir(files);
        System.out.println(Arrays.toString(files));

    }
}

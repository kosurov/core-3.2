import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {
        List<GameProgress> gameProgresses = new ArrayList<>();
        gameProgresses.add(new GameProgress(90, 3, 45, 390.5));
        gameProgresses.add(new GameProgress(15, 6, 48, 880.9));
        gameProgresses.add(new GameProgress(46, 11, 56, 1690.0));

        List<String> filePaths = new ArrayList<>();
        filePaths.add("D:\\Games\\GameOfTheYear\\savegames\\save1.dat");
        filePaths.add("D:\\Games\\GameOfTheYear\\savegames\\save2.dat");
        filePaths.add("D:\\Games\\GameOfTheYear\\savegames\\save3.dat");

        saveGame(filePaths.get(0), gameProgresses.get(0));
        saveGame(filePaths.get(1), gameProgresses.get(1));
        saveGame(filePaths.get(2), gameProgresses.get(2));

        zipFiles("D:\\Games\\GameOfTheYear\\savegames\\saves.zip", filePaths);

    }

    public static void saveGame(String filePath, GameProgress gameProgress) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(gameProgress);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void zipFiles(String zipFilePath, List<String> filePathsToPack) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFilePath))) {
            for (String filePath : filePathsToPack) {
                File file = new File(filePath);
                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    ZipEntry entry = new ZipEntry(file.getName());
                    zipOutputStream.putNextEntry(entry);
                    byte[] bytes = new byte[fileInputStream.available()];
                    fileInputStream.read(bytes);
                    zipOutputStream.write(bytes);
                    zipOutputStream.closeEntry();
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
                file.delete();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}

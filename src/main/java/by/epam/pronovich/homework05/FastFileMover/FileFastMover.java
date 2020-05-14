package by.epam.pronovich.homework05.FastFileMover;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FileFastMover {

    public static void copyFileWithFilesStream(Path sourceFilePath, Path moveFilePath) {
        Path fileName = sourceFilePath.getFileName();
        File sourceFile = sourceFilePath.toFile();
        File moveFileDir = moveFilePath.toFile();

        try (InputStream inputStream = new FileInputStream(sourceFile);
             FileOutputStream outputStream = new FileOutputStream(moveFileDir + File.separator + fileName)) {

            int read = inputStream.read();
            while (read != -1) {
                outputStream.write(read);
                read = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFileWithBuffer(Path sourceFilePath, Path moveFilePath) {
        Path fileName = sourceFilePath.getFileName();
        File sourceFile = sourceFilePath.toFile();
        File moveFileDir = moveFilePath.toFile();

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(sourceFile), 100 * 1024);
             BufferedOutputStream outputStream = new BufferedOutputStream(
                     new FileOutputStream(moveFileDir + File.separator + fileName), 100 * 1024)) {

            int read = inputStream.read();
            while (read != -1) {
                outputStream.write(read);
                read = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFileWithChanel(Path sourceFilePath, Path moveFilePath) {
        Path fileName = sourceFilePath.getFileName();
        File sourceFile = sourceFilePath.toFile();
        File moveFileDir = moveFilePath.toFile();

        try (FileInputStream inputStream = new FileInputStream(sourceFile);
             FileOutputStream outputStream = new FileOutputStream(moveFileDir + File.separator + fileName)) {

            FileChannel inputStreamChannel = inputStream.getChannel();
            FileChannel outputStreamChannel = outputStream.getChannel();

            inputStreamChannel.transferTo(0, inputStreamChannel.size(), outputStreamChannel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFileWithNIO(Path sourceFilePath, Path moveFilePath) {
        Path fileName = sourceFilePath.getFileName();
        File sourceFile = sourceFilePath.toFile();
        File moveFileDir = moveFilePath.toFile();
        Path pathTo = Paths.get(moveFileDir + File.separator + fileName);
        try {
            Files.copy(sourceFilePath, pathTo, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void moveFile(Path sourceFilePath, Path moveFilePath) {
        Path fileName = sourceFilePath.getFileName();
        File source = sourceFilePath.toFile();
        File copyToDir = new File(moveFilePath + File.separator + fileName);
        source.renameTo(copyToDir);
    }
}

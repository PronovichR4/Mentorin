package by.epam.pronovich.homework05.FastFileMover;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;


import static java.util.concurrent.TimeUnit.NANOSECONDS;

public class Runner {

    private static final int BYTES_IN_MB = 1000000;

    public static void main(String[] args) {
        Path fileFrom = Paths.get("D:", "161mb.mp4");
        Path copyToPath = Paths.get("D:", "JavaFile");


       // testInputStreamCopy(fileFrom,copyToPath);
        testBufferedInputStreamCopy(fileFrom,copyToPath);
        testFileChanelCopy(fileFrom,copyToPath);
        testNIO2Copy(fileFrom, copyToPath);
    }

    private static void testNIO2Copy(Path fileFrom, Path copyToPath) {
        Instant start = Instant.now();
        for (int i = 0; i < 1; i++) {
            FileFastMover.copyFileWithNIO(fileFrom, copyToPath);
        }
        Instant end = Instant.now();
        System.out.println("Copy file with NIO2, FileName - " + fileFrom.getFileName() + " "+ fileSizeInMB(fileFrom)
                + " " +  NANOSECONDS.toMillis(Duration.between(start, end).getNano())+" "+NANOSECONDS.name()) ;
    }

    private static void testInputStreamCopy(Path fileFrom, Path copyToPath) {
        Instant start = Instant.now();
        for (int i = 0; i < 1; i++) {
            FileFastMover.copyFileWithFilesStream(fileFrom, copyToPath);
        }
        Instant end = Instant.now();
        System.out.println("Copy file with InputStream, FileName - " + fileFrom.getFileName() + " "+ fileSizeInMB(fileFrom)
                + " " +  NANOSECONDS.toMillis(Duration.between(start, end).getNano())+" "+NANOSECONDS.name()) ;
    }

    private static void testBufferedInputStreamCopy(Path fileFrom, Path copyToPath) {
        Instant start = Instant.now();
        for (int i = 0; i < 1; i++) {
            FileFastMover.copyFileWithBuffer(fileFrom, copyToPath);
        }
        Instant end = Instant.now();
        System.out.println("Copy file with BufferedInputStream, FileName - " + fileFrom.getFileName() + " "+ fileSizeInMB(fileFrom)
                + " " +  NANOSECONDS.toMillis(Duration.between(start, end).getNano())+" "+NANOSECONDS.name()) ;
    }

    private static void testFileChanelCopy(Path fileFrom, Path copyToPath) {
        Instant start = Instant.now();
        for (int i = 0; i < 1; i++) {
            FileFastMover.copyFileWithChanel(fileFrom, copyToPath);
        }
        Instant end = Instant.now();
        System.out.println("Copy file with FileChanelCopy, FileName - " + fileFrom.getFileName() + " "+ fileSizeInMB(fileFrom)
                + " " +  NANOSECONDS.toMillis(Duration.between(start, end).getNano())+" "+NANOSECONDS.name()) ;
    }

    private static String fileSizeInMB(Path path){
        long value = path.toFile().length() / BYTES_IN_MB;
        return value+"MB";
    }
}

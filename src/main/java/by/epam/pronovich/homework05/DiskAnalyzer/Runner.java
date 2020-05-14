package by.epam.pronovich.homework05.DiskAnalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Runner {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("D:", "JavaFile");

        System.out.println("Поиск имени файла с максимальным количеством букв ‘s’ в имени:");
        System.out.println(DiskAnalyzer.findFileWithMaxLetterS(path));

        System.out.println("5 самых больших файлов:");
        DiskAnalyzer.findFiveBiigestFiles(path).forEach(System.out::println);

        System.out.println("Средний размер файла в указанной директории:");
        System.out.println(DiskAnalyzer.calculateAverageSizeFiles(path) + " байт");

        Map<Character, Map<Boolean, Long>> grouping = DiskAnalyzer.groupingByFirstLetter(path);
        DiskAnalyzer.printGroup(grouping);


    }
}

package by.epam.pronovich.homework05.DiskAnalyzer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DiskAnalyzer {

    public static String findFileWithMaxLetterS(Path path) throws IOException {
        String result = null;
        try (Stream<Path> list = Files.list(path)) {
            Optional<String> first = list.map(Path::toFile)
                    .filter(File::isFile)
                    .filter(it -> it.getName().toLowerCase().contains("s"))
                    .sorted(Comparator.comparingInt(o -> countStringInString("s", o.toString())).reversed())
                    .map(File::toString)
                    .findFirst();
            if (first.isPresent()) {
                result = first.get();
            }
        }
        return result;
    }

    public static List<String> findFiveBiigestFiles(Path path) throws IOException {
        try (Stream<Path> list = Files.list(path)) {
            return list.map(Path::toFile)
                    .filter(File::isFile)
                    .sorted(Comparator.comparing(File::length).reversed())
                    .limit(5)
                    .map(File::getName)
                    .collect(Collectors.toList());
        }
    }

    public static BigDecimal calculateAverageSizeFiles(Path path) throws IOException {
        BigDecimal result = new BigDecimal(0);
        try (Stream<Path> walk = Files.walk(path, 1, FileVisitOption.FOLLOW_LINKS)) {
            OptionalDouble average = walk.map(Path::toFile)
                    .filter(File::isFile)
                    .mapToLong(File::length)
                    .average();
            if (average.isPresent()) {
                result = BigDecimal.valueOf(average.getAsDouble());
            }
            return result;
        }
    }


    public static Map<Character, Map<Boolean, Long>> groupingByFirstLetter(Path path) throws IOException {
        try (Stream<Path> list = Files.list(path)) {
            Map<Character, Map<Boolean, Long>> collect = list.map(Path::toFile)
                    .collect(Collectors.groupingBy(it -> it.getName().toUpperCase().charAt(0),
                            Collectors.groupingBy(File::isFile, Collectors.counting())));
            return new TreeMap<>(collect);
        }
    }

    public static void printGroup(Map<Character, Map<Boolean, Long>> sorted) {
        for (Map.Entry<Character, Map<Boolean, Long>> entry : sorted.entrySet()) {
            Map<Boolean, Long> value = entry.getValue();
            System.out.print("На букву " + entry.getKey() + " ");
            Set<Map.Entry<Boolean, Long>> entries = value.entrySet();
            for (Map.Entry<Boolean, Long> key : value.entrySet()) {
                System.out.print(key.getKey() ? " файлов " : " папок ");
                System.out.print(key.getValue());
            }
            System.out.println();
        }
    }


    private static int countStringInString(String search, String text) {
        Pattern pattern = Pattern.compile(search);
        Matcher matcher = pattern.matcher(text);

        int stringOccurrences = 0;
        while (matcher.find()) {
            stringOccurrences++;
        }
        return stringOccurrences;
    }
}

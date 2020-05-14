package by.epam.pronovich.homework05.task01.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.*;
import java.nio.file.Path;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SerializationUtil {

    public static void serializeObject(Path path, Object object) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            outputStream.writeObject(object);
        }
    }

    public static <T> T desirializeObjext(Path path) throws IOException, ClassNotFoundException {
        T result = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            result = (T) inputStream.readObject();
        }
        return result;
    }
}

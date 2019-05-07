package tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Renamer {

    public static void replaceLocalNumber(List<Path> files, int start, int end, int value) throws IOException {
        for (Path file : files) {
            Console.log("-------------");
            String fileName = file.getFileName().toString();
            Console.log(fileName);
            if (!extansionIsBold(fileName))
                continue;
            String data = fileName.substring(start, end + 1);
            Console.log(data);
            String newName = fileName.substring(0, start) + (Integer.parseInt(data) + value) + fileName.substring(end + 1);

            Console.log(newName);
            Files.move(file, file.resolveSibling(newName));
        }
    }

    public static boolean extansionIsBold(String fileName) {
        String extansion = fileName.substring(fileName.indexOf(".") + 1);
        return extansion.equals(extansion.toUpperCase());
    }
}

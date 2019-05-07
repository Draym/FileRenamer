package tools;

import javafx.util.Pair;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Renamer {

    public static void replaceLocalNumber(List<Path> files, int start, int end, int value) throws IOException {
        for (Path file : files) {
            Console.log("-------------");
            String fileName = file.getFileName().toString();
            Console.log(fileName);
            if (!extensionIsBold(fileName))
                continue;
            String data = fileName.substring(start, end + 1);
            Console.log(data);
            String newName = fileName.substring(0, start) + (Integer.parseInt(data) + value) + fileName.substring(end + 1);

            Console.log(newName);
            Files.move(file, file.resolveSibling(newName));
        }
    }

    public static void replaceLocalDate(List<Path> files, String format, String etx, int addHour) throws IOException, ParseException {
        int i = 0;


        for (Path file : files) {
            Console.log("-------------");
            new File(file.getParent() + "/rename").mkdirs();
            String fileName = file.getFileName().toString();
            Console.log(fileName);
            if (!extensionIsBold(fileName) || (etx != null && !etx.equals(FileTools.getFileExtension(fileName))))
                continue;
            String nameData = fileName.substring(0, 16);
            String nameIndex = fileName.substring(16, fileName.indexOf("."));
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            Date date = formatter.parse(nameData);
            Console.log(date);
            date = DateTools.addHour(date, addHour);

            String newName = formatter.format(date) + nameIndex + "." + FileTools.getFileExtension(fileName);

            Console.log(nameData);
            Console.log(nameIndex);
            Console.log(newName);
            SaveChanges.addLog(new Pair<>(fileName, newName));
            Files.move(file, file.resolveSibling("rename/" + newName));
            if (i == 5)
                //break;
            ++i;
        }
    }

    public static boolean extensionIsBold(String fileName) {
        String extension = FileTools.getFileExtension(fileName);
        Console.log(extension);
        return extension.equals(extension.toUpperCase());
    }
}

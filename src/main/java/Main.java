import tools.FileTools;
import tools.Renamer;
import tools.SaveChanges;

import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            List<Path> files = FileTools.getAllFiles("D:\\kevin\\My Library\\Photo\\Voyage\\Cami - 2018.06 - Greece\\Zante");

            for (Path path : files) {
                System.out.println(path.toString());
            }
//            Renamer.replaceLocalDate(files, "yyyy_MMdd_HHmmss", "JPG", 1);
  //          Renamer.replaceLocalDate(files, "yyyy_MMdd_HHmmss", "MOV", 1);
            Renamer.replaceLocalDate(files, "yyyy_MMdd_HHmmss", "RAF", 1);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } finally {
            SaveChanges.save();
        }
    }
}

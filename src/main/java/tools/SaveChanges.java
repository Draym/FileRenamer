package tools;

import com.google.gson.Gson;
import javafx.util.Pair;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaveChanges {
    private static List<Pair<String, String>> history = new ArrayList<>();

    public static void save() {

        String json = new Gson().toJson(history);
        String fileName = "log_" + new SimpleDateFormat("yyyy_MMdd_HHmmss").format(new Date()) + ".json";
        Console.log(fileName);
        FileTools.writeInFile(fileName, json);
    }

    public static void addLog(Pair<String, String> log) {
        history.add(log);
    }

    public static List<Pair<String, String>> getHistory() {
        return history;
    }

    public static void revert(List<Pair<String, String>> logs) {

    }

    public static void revert(String logFile) {

    }
}

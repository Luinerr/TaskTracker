import Manager.FileBackedTasksManager;
import Manager.Managers;
import Manager.TaskManager;
import Manager.TaskLevel;
import Tasks.*;

import java.io.File;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        File file = Paths.get("src\\Tasks.csv").toFile();
        TaskManager manager = Managers.getDefaultBacked(file);

        System.out.println(manager.getAllEpicTasks());
        System.out.println(manager.getAllSubTasks());

        System.out.println(manager.getHistory());
    }
}
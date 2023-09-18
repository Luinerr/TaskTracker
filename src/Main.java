import Manager.Managers;
import Manager.TaskManager;
import Manager.TaskLevel;
import Tasks.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = Managers.getDefault();

        EpicTask epicTask1 = new EpicTask("эпик1", "описание1");
        manager.createTask(TaskLevel.EPIC_TASK, epicTask1);

        EpicTask epicTask2 = new EpicTask("эпик2", "описание2");
        SubTask subTask1 = new SubTask("Суб1", "описание1");
        SubTask subTask2 = new SubTask("Суб2", "описание2");
        SubTask subTask3 = new SubTask("Суб3", "описание3");
        manager.createTask(TaskLevel.EPIC_TASK, epicTask2);
        manager.createTask(TaskLevel.SUB_TASK, subTask1);
        manager.createTask(TaskLevel.SUB_TASK, subTask2);
        manager.createTask(TaskLevel.SUB_TASK, subTask3);

        manager.setSubTaskEpicTask(subTask1, epicTask2.getId());
        manager.setSubTaskEpicTask(subTask2, epicTask2.getId());
        manager.setSubTaskEpicTask(subTask3, epicTask2.getId());

        manager.getById(TaskLevel.EPIC_TASK, 2);
        manager.getById(TaskLevel.EPIC_TASK, 1);
        manager.getById(TaskLevel.SUB_TASK, 3);
        manager.getById(TaskLevel.EPIC_TASK, 2);

        manager.deleteById(TaskLevel.EPIC_TASK, 1);
        manager.getById(TaskLevel.EPIC_TASK, 1);

        manager.deleteById(TaskLevel.EPIC_TASK, 2);

        System.out.println(manager.getHistory());
    }
}
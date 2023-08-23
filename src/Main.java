import Manager.Managers;
import Manager.TaskManager;
import Manager.TaskLevel;
import Tasks.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = Managers.getDefault();
        Task task = new Task("name", "abc");
        manager.createTask(TaskLevel.SIMPLE_TASK, task);

        SubTask subTask = new SubTask("sub", "abc");
        manager.createTask(TaskLevel.SUB_TASK, subTask);
        SubTask subTask1 = new SubTask("sub2", "abc");
        manager.createTask(TaskLevel.SUB_TASK, subTask1);

        EpicTask epicTask = new EpicTask("Epic", "epicTask");
        manager.createTask(TaskLevel.EPIC_TASK, epicTask);
        manager.setSubTaskEpicTask(subTask, 4);
        manager.setSubTaskEpicTask(subTask1, 4);

        System.out.println(manager.getById(TaskLevel.SIMPLE_TASK, 1));
        System.out.println(manager.getById(TaskLevel.SUB_TASK, 2));
        System.out.println(manager.getById(TaskLevel.SUB_TASK, 3));
        System.out.println(manager.getById(TaskLevel.EPIC_TASK, 4));

        System.out.println(manager.getHistory());
    }
}
import Manager.Managers;
import Manager.TaskManager;
import Manager.TaskLevel;
import Tasks.*;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = Managers.getDefaultBacked();

        EpicTask epicTask1 = new EpicTask("эпик1", "описание1");
        manager.addEpicTask(epicTask1);

        EpicTask epicTask2 = new EpicTask("эпик2", "описание2");
        SubTask subTask1 = new SubTask("Суб1", "описание1");
        SubTask subTask2 = new SubTask("Суб2", "описание2");
        SubTask subTask3 = new SubTask("Суб3", "описание3");
        manager.addEpicTask(epicTask2);
        manager.addSubTask(subTask1);
        manager.addSubTask(subTask2);
        manager.addSubTask(subTask3);

        manager.setSubTaskEpicTask(subTask1, epicTask2.getId());
        manager.setSubTaskEpicTask(subTask2, epicTask2.getId());
        manager.setSubTaskEpicTask(subTask3, epicTask2.getId());

        manager.getEpicTask(2);
        manager.getEpicTask(1);
        manager.getSubTask(3);
        manager.getEpicTask(2);

        //manager.removeEpicTask(1);
        manager.getEpicTask(1);

        manager.removeEpicTask(2);

        System.out.println(manager.getHistory());
    }
}
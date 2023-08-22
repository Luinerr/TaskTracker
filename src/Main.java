import Tasks.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        InMemoryTaskManager inMemoryTaskManager = new InMemoryTaskManager();
        Task task = new Task("name", "abc", 1);
        inMemoryTaskManager.createTask(1, task);
        task = new Task("name1", "abc1", 1);
        inMemoryTaskManager.createTask(1, task);
        task = new Task("name2", "abc2", 1);
        inMemoryTaskManager.createTask(1, task);
        task = new Task("name3", "abc3", 1);
        inMemoryTaskManager.createTask(1, task);
        inMemoryTaskManager.takeAllDataTask(1);
        inMemoryTaskManager.deleteById(1, 2);
        inMemoryTaskManager.takeAllDataTask(1);
        inMemoryTaskManager.removeAllDataTask(1);
        inMemoryTaskManager.takeAllDataTask(1);
        EpicTask epicTask = new EpicTask("name", "abc", 1);

        SubTask subTask = new SubTask("sub1", "123", 1);
        SubTask subTask1 = new SubTask("sub2", "123", 1);
        ArrayList<SubTask> sub = new ArrayList<>();
        sub.add(subTask);
        sub.add(subTask1);
        inMemoryTaskManager.createTask(3, epicTask);
        epicTask.setSubTasks(sub, inMemoryTaskManager.takeId(3, epicTask));


        inMemoryTaskManager.createTask(2, subTask);
        inMemoryTaskManager.createTask(2, subTask1);

    }
}
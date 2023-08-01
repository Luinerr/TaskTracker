import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Task task = new Task("name", "abc", 1);
        manager.createTask(1, task);
        task = new Task("name1", "abc1", 1);
        manager.createTask(1, task);
        task = new Task("name2", "abc2", 1);
        manager.createTask(1, task);
        task = new Task("name3", "abc3", 1);
        manager.createTask(1, task);
        manager.takeDataTask(1);
        manager.deleteById(1, 2);
        manager.takeDataTask(1);
        manager.removeAllDataTask(1);
        manager.takeDataTask(1);
        EpicTask epicTask = new EpicTask("name", "abc", 1);

        SubTask subTask = new SubTask("sub1", "123", 1);
        SubTask subTask1 = new SubTask("sub2", "123", 1);
        ArrayList<SubTask> sub = new ArrayList<>();
        sub.add(subTask);
        sub.add(subTask1);
        manager.createTask(3, epicTask);
        epicTask.setSubTasks(sub, manager.takeId(3, epicTask));


        manager.createTask(2, subTask);
        manager.createTask(2, subTask1);

        /*
        Task task = new Task("name", "abc", 1);
        Tasks tasks = new Tasks();
        tasks.dataTask.put(1, task);
        task = new Task("name", "abc", 2);
        tasks.dataTask.put(2, task);
        tasks.takeDataTask(1);
        tasks.takeDataTask(2);
        System.out.println();
        System.out.println(tasks.getById(1, 1));
        tasks.takeDataTask(1);
        tasks.deleteById(1, 2);
        tasks.takeDataTask(1);
        */
    }
}
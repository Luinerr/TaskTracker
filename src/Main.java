public class Main {
    public static void main(String[] args) {
        Tasks tasks = new Tasks();
        Task task = new Task("name", "abc", 1);
        tasks.createTask(1, task);
        task = new Task("name1", "abc1", 1);
        tasks.createTask(1, task);
        task = new Task("name2", "abc2", 1);
        tasks.createTask(1, task);
        task = new Task("name3", "abc3", 1);
        tasks.createTask(1, task);
        tasks.takeDataTask(1);
        tasks.deleteById(1, 2);
        tasks.takeDataTask(1);
        tasks.removeAllDataTask(1);
        tasks.takeDataTask(1);

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
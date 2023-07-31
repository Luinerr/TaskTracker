import java.util.HashMap;

public class Tasks {
    private int taskId = 1;
    HashMap<Integer, Task> dataTask;
    HashMap<Integer, SubTask> dataSubTask;
    HashMap<Integer, EpicTask> dataEpicTask;
    Tasks() {
        dataTask = new HashMap<>();
        dataSubTask = new HashMap<>();
        dataEpicTask = new HashMap<>();
    }

    void takeDataTask(int item) {
        if (item == 1 || !dataTask.isEmpty()) {
            for (Integer integer : dataTask.keySet()) {
                System.out.println(dataTask.get(integer).toString());
            }
        } else if (item == 2 || !dataSubTask.isEmpty()) {
            for (Integer integer : dataSubTask.keySet()) {
                System.out.println(dataSubTask.get(integer).toString());
            }
        } else if (item == 3 || !dataEpicTask.isEmpty()) {
            for (Integer integer : dataEpicTask.keySet()) {
                System.out.println(dataEpicTask.get(integer).toString());
            }
        } else {
            return;
        }
    }

    void removeAllDataTask(int item) {
        if (item == 1 || !dataTask.isEmpty()) {
            dataTask.clear();
        } else if (item == 2 || !dataSubTask.isEmpty()) {
            dataSubTask.clear();
        } else if (item == 3 || !dataEpicTask.isEmpty()) {
            dataEpicTask.clear();
        } else {
            return;
        }
    }

    String getById(int item, int id) {
        if (item == 1 || !dataTask.isEmpty()) {
            if (dataTask.containsKey(id)) {
                return dataTask.get(id).toString();
            }
        } else if (item == 2 || !dataSubTask.isEmpty()) {
            if (dataSubTask.containsKey(id)) {
                return dataSubTask.get(id).toString();
            }
        } else if (item == 3 || !dataEpicTask.isEmpty()) {
            if (dataEpicTask.containsKey(id)) {
                return dataEpicTask.get(id).toString();
            }
        }
        return "";
    }
    void deleteById(int item, int id) {
        if (item == 1 || !dataTask.isEmpty()) {
            if (dataTask.containsKey(id)) {
                dataTask.remove(id);
            }
        } else if (item == 2 || !dataSubTask.isEmpty()) {
            if (dataSubTask.containsKey(id)) {
                dataSubTask.remove(id);
            }
        } else if (item == 3 || !dataEpicTask.isEmpty()) {
            if (dataEpicTask.containsKey(id)) {
                dataEpicTask.remove(id);
            }
        } else {
            return;
        }
    }

    String status(int statusId) {
        if (statusId == 1) {
            return "NEW";
        } else if (statusId == 2) {
            return "IN_PROGRESS";
        } else if (statusId == 3) {
            return "DONE";
        }
        return "";
    }

    void createTask(int item, Object obj) {
        if (item == 1) {
            dataTask.put(taskId, (Task) obj);
            taskId++;
        } else if (item == 2) {
            dataSubTask.put(taskId, (SubTask) obj);
            taskId++;
        } else if (item == 3) {
            dataEpicTask.put(taskId, (EpicTask) obj);
            taskId++;
        } else {
            return;
        }
    }
}

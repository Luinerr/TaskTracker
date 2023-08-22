import Tasks.*;
import java.util.HashMap;

public class InMemoryTaskManager implements TaskManager {
    private int taskId = 1;
    protected HashMap<Integer, Task> dataTask;
    protected HashMap<Integer, SubTask> dataSubTask;
    protected HashMap<Integer, EpicTask> dataEpicTask;
    InMemoryTaskManager() {
        dataTask = new HashMap<>();
        dataSubTask = new HashMap<>();
        dataEpicTask = new HashMap<>();
    }

    @Override
    public void takeAllDataTask(int item) {
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

    @Override
    public void removeAllDataTask(int item) {
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

    @Override
    public String getById(int item, int id) {
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

    @Override
    public void deleteById(int item, int id) {
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


    public String status(int statusId) {
        if (statusId == 1) {
            return "NEW";
        } else if (statusId == 2) {
            return "IN_PROGRESS";
        } else if (statusId == 3) {
            return "DONE";
        }
        return "";
    }

    @Override
    public void createTask(int item, Object obj) {
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

    @Override
    public int takeId(int item, Object obj) {
        
        if (item == 1) {
            for (int i : dataTask.keySet()) {
                if (dataTask.get(i).equals(obj)) {
                    return i;
                }
                return 0;
            }
        } else if (item == 2) {
            for (int i : dataSubTask.keySet()) {
                if(dataSubTask.get(i).equals(obj)) {
                    return i;
                }
                return 0;
            }
        } else if (item == 3) {
            for (int i : dataEpicTask.keySet()) {
                if(dataEpicTask.get(i).equals(obj)) {
                    return i;
                }
                return 0;
            }
        } else {
            return 0;
        }
        return 0;
    }

    @Override
    public void takeSubTaskOfEpic() {

    }
}

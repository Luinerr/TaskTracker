package Manager;

import Tasks.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTaskManager implements TaskManager {
    private int taskId = 1;
    private Map<Integer, Task> dataTask = new HashMap<>();
    private Map<Integer, SubTask> dataSubTask = new HashMap<>();
    private Map<Integer, EpicTask> dataEpicTask = new HashMap<>();
    HistoryManager historyManager = Managers.getDefaultHistory();;

    @Override
    public List<Task> takeAllDataTask(TaskLevel taskLevel) {
        if (taskLevel.equals(TaskLevel.SIMPLE_TASK) && !dataTask.isEmpty()) {
            return new ArrayList<>(dataTask.values());
        } else if (taskLevel.equals(TaskLevel.SUB_TASK) && !dataSubTask.isEmpty()) {
            return new ArrayList<>(dataSubTask.values());
        } else if (taskLevel.equals(TaskLevel.EPIC_TASK) && !dataEpicTask.isEmpty()) {
            return new ArrayList<>(dataEpicTask.values());
        } else {
            return null;
        }
    }

    @Override
    public Task getById(TaskLevel taskLevel, int id) {
        if (taskLevel.equals(TaskLevel.SIMPLE_TASK) && !dataTask.isEmpty()) {
            if (dataTask.containsKey(id)) {
                historyManager.add(dataTask.get(id));
                return dataTask.get(id);
            }
        } else if (taskLevel.equals(TaskLevel.SUB_TASK) && !dataSubTask.isEmpty()) {
            if (dataSubTask.containsKey(id)) {
                historyManager.add(dataSubTask.get(id));
                return dataSubTask.get(id);
            }
        } else if (taskLevel.equals(TaskLevel.EPIC_TASK) && !dataEpicTask.isEmpty()) {
            if (dataEpicTask.containsKey(id)) {
                historyManager.add(dataEpicTask.get(id));
                return dataEpicTask.get(id);
            }
        }
        return null;
    }


    @Override
    public void removeAllDataTask(TaskLevel taskLevel) {
        if (taskLevel.equals(TaskLevel.SIMPLE_TASK) && !dataTask.isEmpty()) {
            dataTask.clear();
        } else if (taskLevel.equals(TaskLevel.SUB_TASK) && !dataSubTask.isEmpty()) {
            dataSubTask.clear();
        } else if (taskLevel.equals(TaskLevel.EPIC_TASK) && !dataEpicTask.isEmpty()) {
            dataEpicTask.clear();
        } else {
            return;
        }
    }

    @Override
    public void deleteById(TaskLevel taskLevel, int id) {
        if (taskLevel.equals(TaskLevel.SIMPLE_TASK) && !dataTask.isEmpty()) {
            if (dataTask.containsKey(id)) {
                dataTask.remove(id);
            }
        } else if (taskLevel.equals(TaskLevel.SUB_TASK) && !dataSubTask.isEmpty()) {
            if (dataSubTask.containsKey(id)) {
                dataSubTask.remove(id);
            }
        } else if (taskLevel.equals(TaskLevel.EPIC_TASK) && !dataEpicTask.isEmpty()) {
            if (dataEpicTask.containsKey(id)) {
                dataEpicTask.remove(id);
            }
        } else {
            return;
        }
    }

    @Override
    public void createTask(TaskLevel taskLevel, Object obj) {
        if (taskLevel.equals(TaskLevel.SIMPLE_TASK)) {
            dataTask.put(taskId, (Task) obj);
            taskId++;
        } else if (taskLevel.equals(TaskLevel.SUB_TASK)) {
            dataSubTask.put(taskId, (SubTask) obj);
            taskId++;
        } else if (taskLevel.equals(TaskLevel.EPIC_TASK)) {
            dataEpicTask.put(taskId, (EpicTask) obj);
            taskId++;
        } else {
            return;
        }
    }

    @Override
    public int takeId(TaskLevel taskLevel, Object obj) {
        if (taskLevel.equals(TaskLevel.SIMPLE_TASK)) {
            for (int i : dataTask.keySet()) {
                if (dataTask.get(i).equals(obj)) {
                    return i;
                }
                return 0;
            }
        } else if (taskLevel.equals(TaskLevel.SUB_TASK)) {
            for (int i : dataSubTask.keySet()) {
                if(dataSubTask.get(i).equals(obj)) {
                    return i;
                }
                return 0;
            }
        } else if (taskLevel.equals(TaskLevel.EPIC_TASK)) {
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
    public void updateTask(TaskLevel taskLevel, int id) {
        if (taskLevel.equals(TaskLevel.SIMPLE_TASK)) {
            dataTask.get(id).updateStatus();
        } else if (taskLevel.equals(TaskLevel.SUB_TASK)) {
            dataSubTask.get(id).updateStatus();
        } else if (taskLevel.equals(TaskLevel.EPIC_TASK)) {
            dataEpicTask.get(id).updateStatus();
        } else {
            return;
        }
    }

    @Override
    public void setSubTaskEpicTask(SubTask subTask, int id) {
        if (dataEpicTask.containsKey(id)){
            dataEpicTask.get(id).setSubTasks(subTask, id);
        }
    }

    @Override
    public ArrayList<SubTask> takeSubTaskOfEpic(EpicTask epicTask) {
        return epicTask.getSubTasks(epicTask);
    }

    public ArrayList<Task> getHistory() {
        return historyManager.getHistory();
    }
}

package Manager;

import Tasks.*;

import javax.swing.plaf.nimbus.NimbusStyle;
import java.util.*;

public class InMemoryTaskManager implements TaskManager {
    private int taskId = 1;
    private final Map<Integer, Task> dataTask = new HashMap<>();
    private final Map<Integer, SubTask> dataSubTask = new HashMap<>();
    private final Map<Integer, EpicTask> dataEpicTask = new HashMap<>();
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
                historyManager.add(dataTask.get(id), id);
                return dataTask.get(id);
            }
        } else if (taskLevel.equals(TaskLevel.SUB_TASK) && !dataSubTask.isEmpty()) {
            if (dataSubTask.containsKey(id)) {
                historyManager.add(dataSubTask.get(id), id);
                return dataSubTask.get(id);
            }
        } else if (taskLevel.equals(TaskLevel.EPIC_TASK) && !dataEpicTask.isEmpty()) {
            if (dataEpicTask.containsKey(id)) {
                historyManager.add(dataEpicTask.get(id), id);
                return dataEpicTask.get(id);
            }
        }
        return null;
    }


    @Override
    public void removeAllDataTask(TaskLevel taskLevel) {
        if (taskLevel.equals(TaskLevel.SIMPLE_TASK) && !dataTask.isEmpty()) {
            for(Integer id : dataTask.keySet()) {
                historyManager.remove(id);
            }
            dataTask.clear();
        } else if (taskLevel.equals(TaskLevel.SUB_TASK) && !dataSubTask.isEmpty()) {
            for(Integer id : dataSubTask.keySet()) {
                historyManager.remove(id);
            }
            dataSubTask.clear();
        } else if (taskLevel.equals(TaskLevel.EPIC_TASK) && !dataEpicTask.isEmpty()) {
            for(Integer id : dataEpicTask.keySet()) {
                historyManager.remove(id);
            }
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
                historyManager.remove(id);
            }
        } else if (taskLevel.equals(TaskLevel.SUB_TASK) && !dataSubTask.isEmpty()) {
            if (dataSubTask.containsKey(id)) {
                dataSubTask.remove(id);
                historyManager.remove(id);
            }
        } else if (taskLevel.equals(TaskLevel.EPIC_TASK) && !dataEpicTask.isEmpty()) {
            if (dataEpicTask.containsKey(id)) {
                dataEpicTask.remove(id);
                historyManager.remove(id);
            }
        } else {
            return;
        }
    }

    @Override
    public void createTask(TaskLevel taskLevel, Task task) {
        if (taskLevel.equals(TaskLevel.SIMPLE_TASK)) {
            dataTask.put(taskId, (Task) task);
            task.setId(taskId);
            taskId++;
        } else if (taskLevel.equals(TaskLevel.SUB_TASK)) {
            dataSubTask.put(taskId, (SubTask) task);
            task.setId(taskId);
            taskId++;
        } else if (taskLevel.equals(TaskLevel.EPIC_TASK)) {
            dataEpicTask.put(taskId, (EpicTask) task);
            task.setId(taskId);
            taskId++;
        } else {
            return;
        }
    }

    @Override
    public int takeId(TaskLevel taskLevel, Task task) {
        if (taskLevel.equals(TaskLevel.SIMPLE_TASK)) {
            for (int i : dataTask.keySet()) {
                if (dataTask.get(i).equals(task)) {
                    return i;
                }
                return 0;
            }
        } else if (taskLevel.equals(TaskLevel.SUB_TASK)) {
            for (int i : dataSubTask.keySet()) {
                if(dataSubTask.get(i).equals(task)) {
                    return i;
                }
                return 0;
            }
        } else if (taskLevel.equals(TaskLevel.EPIC_TASK)) {
            for (int i : dataEpicTask.keySet()) {
                if(dataEpicTask.get(i).equals(task)) {
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
    public List<SubTask> takeSubTaskOfEpic(EpicTask epicTask) {
        return epicTask.getSubTasks(epicTask);
    }

    public List<Task> getHistory() {
        return historyManager.getHistory();
    }
}



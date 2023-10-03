package Manager;

import Tasks.*;

import java.util.*;

public class InMemoryTaskManager implements TaskManager {
    protected int taskIdPrivate = 1;
    protected final Map<Integer, SimpleTask> dataTask = new HashMap<>();
    protected final Map<Integer, SubTask> dataSubTask = new HashMap<>();
    protected final Map<Integer, EpicTask> dataEpicTask = new HashMap<>();
    HistoryManager historyManager = Managers.getDefaultHistory();

    @Override
    public List<SimpleTask> getAllSimpleTasks() {
        return new ArrayList<>(dataTask.values());
    }

    @Override
    public List<EpicTask> getAllEpicTasks() {
        return new ArrayList<>(dataEpicTask.values());
    }

    @Override
    public List<SubTask> getAllSubTasks() {
        return new ArrayList<>(dataSubTask.values());
    }


    @Override
    public void removeAllSimpleTask() {
        if (!dataTask.isEmpty()) {
            for (Integer id : dataTask.keySet()) {
                historyManager.remove(id);
            }
        }
    }

    @Override
    public void removeAllEpicTask() {
        if (!dataEpicTask.isEmpty()) {
            for (Integer id : dataEpicTask.keySet()) {
                historyManager.remove(id);
            }
        }
    }

    @Override
    public void removeAllSubTask() {
        if (!dataSubTask.isEmpty()) {
            for (Integer id : dataSubTask.keySet()) {
                historyManager.remove(id);
            }
        }
    }

    @Override
    public SimpleTask getSimpleTask(int taskId) {
        if (!dataTask.isEmpty()) {
            if (dataTask.containsKey(taskId)) {
                historyManager.add(dataTask.get(taskId));
                return dataTask.get(taskId);
            }
        }
        return null;
    }

    @Override
    public EpicTask getEpicTask(int taskId) {
        if (!dataEpicTask.isEmpty()) {
            if (dataEpicTask.containsKey(taskId)) {
                historyManager.add(dataEpicTask.get(taskId));
                return dataEpicTask.get(taskId);
            }
        }
        return null;
    }

    @Override
    public SubTask getSubTask(int taskId) {
        if (!dataSubTask.isEmpty()) {
            if (dataSubTask.containsKey(taskId)) {
                historyManager.add(dataSubTask.get(taskId));
                return dataSubTask.get(taskId);
            }
        }
        return null;
    }

    @Override
    public void removeSimpleTask(int taskId) {
        if (!dataTask.isEmpty()) {
            if (dataTask.containsKey(taskId)) {
                dataTask.remove(taskId);
                historyManager.remove(taskId);
            }
        }
    }

    @Override
    public void removeEpicTask(int taskId) {
        if (!dataEpicTask.isEmpty()) {
            if (dataEpicTask.containsKey(taskId)) {
                if (dataEpicTask.get(taskId).getSubTasks().size() != 0) {
                    List<SubTask> subTask = this.takeSubTaskOfEpic(this.getEpicTask(taskId));
                    for (SubTask sub : subTask) {
                        removeSubTask(sub.getId());
                    }
                }
                dataEpicTask.remove(taskId);
                historyManager.remove(taskId);
            }
        }
    }

    @Override
    public void removeSubTask(int taskId) {
        if (!dataSubTask.isEmpty()) {
            if (dataSubTask.containsKey(taskId)) {
                dataSubTask.remove(taskId);
                historyManager.remove(taskId);
            }
        }
    }

    @Override
    public void addSimpleTask(SimpleTask task) {
        dataTask.put(taskIdPrivate, task);
        task.setId(taskIdPrivate);
        taskIdPrivate++;
    }

    @Override
    public void addEpicTask(EpicTask task) {
        dataEpicTask.put(taskIdPrivate, task);
        task.setId(taskIdPrivate);
        taskIdPrivate++;
    }

    @Override
    public void addSubTask(SubTask task) {
        dataSubTask.put(taskIdPrivate, task);
        task.setId(taskIdPrivate);
        taskIdPrivate++;
    }

    @Override
    public void updateSimpleTask(SimpleTask task) {
        if (dataTask.containsKey(task.getId())) {
            dataTask.get(task.getId()).updateStatus();
        }
    }

    @Override
    public void updateEpicTask(EpicTask task) {
        if (dataEpicTask.containsKey(task.getId())) {
            dataEpicTask.get(task.getId()).updateStatus();
        }
    }

    @Override
    public void updateSubTask(SubTask task) {
        if (dataSubTask.containsKey(task.getId())) {
            dataSubTask.get(task.getId()).updateStatus();
            updateEpicTask(dataEpicTask.get(task.getIdEpic()));
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
        return epicTask.getSubTasks();
    }

    public List<SimpleTask> getHistory() {
        return historyManager.getHistory();
    }
}



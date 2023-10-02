package Manager;

import Tasks.EpicTask;
import Tasks.SubTask;
import Tasks.SimpleTask;

import java.util.List;

public interface TaskManager {

    List<SimpleTask> getAllSimpleTasks();
    List<EpicTask> getAllEpicTasks();
    List<SubTask> getAllSubTasks();

    void removeAllSimpleTask();
    void removeAllEpicTask();
    void removeAllSubTask();

    SimpleTask getSimpleTask(int taskId);
    EpicTask getEpicTask(int taskId);
    SubTask getSubTask(int taskId);

    void removeSimpleTask(int taskId);
    void removeEpicTask(int taskId);
    void removeSubTask(int taskId);

    void addSimpleTask (SimpleTask task);
    void addEpicTask (EpicTask task);
    void addSubTask (SubTask task);

    void updateSimpleTask(SimpleTask task);
    void updateEpicTask(EpicTask task);
    void updateSubTask(SubTask task);

    void setSubTaskEpicTask(SubTask subTask, int id);

    List<SubTask> takeSubTaskOfEpic(EpicTask epicTask);
    List<SimpleTask> getHistory();
}

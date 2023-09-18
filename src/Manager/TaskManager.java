package Manager;

import Tasks.EpicTask;
import Tasks.SubTask;
import Tasks.Task;

import java.util.List;

public interface TaskManager {
    List<Task> takeAllDataTask(TaskLevel taskLevel);

    void removeAllDataTask(TaskLevel taskLevel);

    Task getById(TaskLevel taskLevel, int id);

    void deleteById(TaskLevel taskLevel, int id);

    void createTask(TaskLevel taskLevel, Task task);

    int takeId(TaskLevel taskLevel, Task task);

    void updateTask(TaskLevel taskLevel, int id);

    void setSubTaskEpicTask(SubTask subTask, int id);

    List<SubTask> takeSubTaskOfEpic(EpicTask epicTask);
    List<Task> getHistory();
}

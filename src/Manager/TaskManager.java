package Manager;

import Tasks.EpicTask;
import Tasks.SubTask;
import Tasks.Task;

import java.util.ArrayList;
import java.util.List;

public interface TaskManager {
    List<Task> takeAllDataTask(TaskLevel taskLevel);

    void removeAllDataTask(TaskLevel taskLevel);

    Task getById(TaskLevel taskLevel, int id);

    void deleteById(TaskLevel taskLevel, int id);

    void createTask(TaskLevel taskLevel, Object obj);

    int takeId(TaskLevel taskLevel, Object obj);

    void updateTask(TaskLevel taskLevel, int id);

    void setSubTaskEpicTask(SubTask subTask, int id);

    List<SubTask> takeSubTaskOfEpic(EpicTask epicTask);
    List<Task> getHistory();
}

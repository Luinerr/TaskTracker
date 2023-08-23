package Manager;

import Tasks.EpicTask;
import Tasks.SubTask;
import Tasks.Task;

import java.util.ArrayList;
import java.util.List;

public interface TaskManager {
    public List<Task> takeAllDataTask(TaskLevel taskLevel);

    public void removeAllDataTask(TaskLevel taskLevel);

    public Task getById(TaskLevel taskLevel, int id);

    public void deleteById(TaskLevel taskLevel, int id);

    public void createTask(TaskLevel taskLevel, Object obj);

    int takeId(TaskLevel taskLevel, Object obj);

    public void updateTask(TaskLevel taskLevel, int id);

    public void setSubTaskEpicTask(SubTask subTask, int id);

    public ArrayList<SubTask> takeSubTaskOfEpic(EpicTask epicTask);
    ArrayList<Task> getHistory();
}

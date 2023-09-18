package Manager;

import Tasks.Task;

import java.util.ArrayList;

public interface HistoryManager {
    void add(Task task, int id);
    void remove(int id);
    ArrayList<Task> getHistory();
}

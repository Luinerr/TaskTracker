package Manager;

import Tasks.SimpleTask;

import java.util.ArrayList;

public interface HistoryManager {
    void add(SimpleTask simpleTask);
    void remove(int id);
    ArrayList<SimpleTask> getHistory();
}

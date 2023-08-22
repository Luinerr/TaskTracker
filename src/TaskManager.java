public interface TaskManager {
    public void takeAllDataTask(int item);

    public void removeAllDataTask(int item);

    public String getById(int item, int id);

    public void deleteById(int item, int id);

    public void createTask(int item, Object obj);

    int takeId(int item, Object obj);

    public void takeSubTaskOfEpic();
}

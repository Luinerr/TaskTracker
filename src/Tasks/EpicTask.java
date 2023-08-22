package Tasks;

import java.util.ArrayList;

public class EpicTask extends Task{
    protected ArrayList<SubTask> subTasks;

    public EpicTask(String name, String details, int status) {
        super(name, details, status);
        subTasks = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Tasks.EpicTask{" +
                "idSubTasks=" + subTasks +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", status=" + status +
                '}';
    }

    public void setSubTasks(ArrayList<SubTask> subTasks, int id) {
        this.subTasks = subTasks;
        for (SubTask item : subTasks) {
            item.setIdEpic(id);
        }
    }
}

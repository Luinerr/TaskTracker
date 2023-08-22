package Tasks;

import java.util.ArrayList;

public class EpicTask extends Task{
    protected ArrayList<SubTask> subTasks;

    public EpicTask(String name, String details) {
        super(name, details);
        subTasks = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "EpicTask{" +
                "name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", status=" + status +
                '}';
    }

    public ArrayList<SubTask> getSubTasks(EpicTask epicTask) {
        return subTasks;
    }

    public void setSubTasks(ArrayList<SubTask> subTasks, int id) {
        this.subTasks = subTasks;
        for (SubTask item : subTasks) {
            item.setIdEpic(id);
        }
    }
}

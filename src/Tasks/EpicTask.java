package Tasks;

import java.util.ArrayList;

public class EpicTask extends SimpleTask {
    protected ArrayList<SubTask> subTasks;

    public EpicTask(String name, String details) {
        super(name, details);
        subTasks = new ArrayList<>();
        typeTask = TypeTask.EPICTASK;
    }

    @Override
    public String toString() {
        return "EpicTask{" +
                "id=" + id + '\'' +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", status=" + status +
                '}';
    }

    public ArrayList<SubTask> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(ArrayList<SubTask> subTasks, int id) {
        this.subTasks = subTasks;
        for (SubTask item : subTasks) {
            item.setIdEpic(id);
        }
    }

    public void setSubTasks(SubTask subTask, int id) {
        subTasks.add(subTask);
        subTask.setIdEpic(id);
    }

    public void setSubTasks(SubTask subTask) {
        subTasks.add(subTask);
    }

    @Override
    public void updateStatus() {
        boolean check = false;
        for (SubTask item : subTasks) {
            if (!status.equals(item.getStatus())) {
                check = true;
            } else {
                check = false;
                return;
            }
        }
        if (check) {
            status = subTasks.get(1).getStatus();
        }
    }
}

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
                ", id=" + id +
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

    public void setSubTasks(SubTask subTask, int id) {
        subTasks.add(subTask);
        subTask.setIdEpic(id);
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

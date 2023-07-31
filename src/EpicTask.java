import java.util.ArrayList;

public class EpicTask extends Task{
    ArrayList<SubTask> subTasks;

    public EpicTask(String name, String details, int status, ArrayList<SubTask> idSubTasks) {
        super(name, details, status);
        this.subTasks = idSubTasks;
    }

    @Override
    public String toString() {
        return "EpicTask{" +
                "idSubTasks=" + subTasks +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", status=" + status +
                '}';
    }

}

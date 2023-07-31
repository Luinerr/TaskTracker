import java.util.ArrayList;

public class EpicTask extends Task{
    ArrayList<Integer> idSubTasks;

    public EpicTask(String name, String details, int status, ArrayList<Integer> idSubTasks) {
        super(name, details, status);
        this.idSubTasks = idSubTasks;
    }

    @Override
    public String toString() {
        return "EpicTask{" +
                "idSubTasks=" + idSubTasks +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", status=" + status +
                '}';
    }

}

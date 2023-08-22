package Tasks;

public class SubTask extends Task{
    int idEpic;
    public SubTask(String name, String details, int status) {
        super(name, details, status);

    }

    public void setIdEpic(int idEpic) {
        this.idEpic = idEpic;
    }

    @Override
    public String toString() {
        return "Tasks.SubTask{" +
                "idEpic=" + idEpic +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", status=" + status +
                '}';
    }
}

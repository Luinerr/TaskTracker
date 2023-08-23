package Tasks;

public class SubTask extends Task{
    int idEpic;
    public SubTask(String name, String details) {
        super(name, details);
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

    @Override
    public void updateStatus() {
        super.updateStatus();
    }
}

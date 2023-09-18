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
        return "SubTask{" +
                "idEpic=" + idEpic +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", status=" + status +
                ", id=" + id +
                '}';
    }

    @Override
    public void updateStatus() {
        super.updateStatus();
    }
}

package Tasks;

public class SubTask extends SimpleTask {
    int idEpic;
    public SubTask(String name, String details) {
        super(name, details);
        typeTask = TypeTask.SUBTASK;
    }

    public void setIdEpic(int idEpic) {
        this.idEpic = idEpic;
    }

    public int getIdEpic() {
        return idEpic;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "id=" + id + '\'' +
                ", idEpic=" + idEpic + '\'' +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", status=" + status + '\'' +
                '}';
    }

    @Override
    public void updateStatus() {
        super.updateStatus();
    }
}

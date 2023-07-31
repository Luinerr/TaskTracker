public class SubTask extends Task{
    int idEpic;
    public SubTask(String name, String details, int status, int idEpic) {
        super(name, details, status);
        this.idEpic = idEpic;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "idEpic=" + idEpic +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", status=" + status +
                '}';
    }
}

package Tasks;

public class SimpleTask {
    protected String name;
    protected String details;
    protected Status status;
    protected int id;
    protected TypeTask typeTask;

    public SimpleTask(String name, String details) {
        this.name = name;
        this.details = details;
        this.status = Status.NEW;
        this.typeTask = TypeTask.SIMPLETASK;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id + '\'' +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", status=" + status +
                '}';
    }

    public Status getStatus() {
        return status;
    }

    public TypeTask getTypeTask() {
        return typeTask;
    }

    public void updateStatus() {
        if (status.equals(Status.NEW)) {
            status = Status.IN_PROGRESS;
        } else if (status.equals(Status.IN_PROGRESS)) {
            status = Status.DONE;
        }
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

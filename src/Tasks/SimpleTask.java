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
        this.typeTask = TypeTask.TASK;
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
                "name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", status=" + status +
                ", id=" + id +
                '}';
    }

    public Status getStatus() {
        return status;
    }

    public void updateStatus() {
        if (status.equals(Status.NEW)) {
            status = Status.IN_PROGRESS;
        } else if (status.equals(Status.IN_PROGRESS)) {
            status = Status.DONE;
        }
    }
}

package Tasks;


public class Task {
    protected String name;
    protected String details;
    protected Status status;

    public Task(String name, String details) {
        this.name = name;
        this.details = details;
        this.status = Status.NEW;
    }

    @Override
    public String toString() {
        return "Tasks.Task{" +
                "name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", status=" + status +
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

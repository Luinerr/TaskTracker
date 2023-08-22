package Tasks;

public class Task {
    protected String name;
    protected String details;
    protected int status;

    public Task(String name, String details) {
        this.name = name;
        this.details = details;
        this.status = 1;
    }

    @Override
    public String toString() {
        return "Tasks.Task{" +
                "name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", status=" + status +
                '}';
    }
}

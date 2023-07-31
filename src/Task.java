public class Task {
    String name;
    String details;
    int status;

    public Task(String name, String details, int status) {
        this.name = name;
        this.details = details;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", status=" + status +
                '}';
    }
}

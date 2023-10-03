package Manager;

import ManagerExceptions.ManagerSaveException;
import Tasks.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileBackedTasksManager extends InMemoryTaskManager {
    private final File file;

    FileBackedTasksManager(File file) {
        this.file = file;
        if (file.exists()) {
            loadFromFile();
        }
    }

    @Override
    public void addSimpleTask(SimpleTask task) {
        super.addSimpleTask(task);
        save();
    }

    @Override
    public void addEpicTask(EpicTask task) {
        super.addEpicTask(task);
        save();
    }

    @Override
    public void addSubTask(SubTask task) {
        super.addSubTask(task);
        save();
    }

    @Override
    public void removeAllSimpleTask() {
        super.removeAllSimpleTask();
        save();
    }

    @Override
    public void removeAllEpicTask() {
        super.removeAllEpicTask();
        save();
    }

    @Override
    public void removeAllSubTask() {
        super.removeAllSubTask();
        save();
    }

    @Override
    public void removeSimpleTask(int taskId) {
        super.removeSimpleTask(taskId);
        save();
    }

    @Override
    public void removeEpicTask(int taskId) {
        super.removeEpicTask(taskId);
        save();
    }

    @Override
    public void removeSubTask(int taskId) {
        super.removeSubTask(taskId);
        save();
    }

    @Override
    public void updateSimpleTask(SimpleTask task) {
        super.updateSimpleTask(task);
        save();
    }

    @Override
    public void updateEpicTask(EpicTask task) {
        super.updateEpicTask(task);
        save();
    }

    @Override
    public void updateSubTask(SubTask task) {
        super.updateSubTask(task);
        save();
    }

    @Override
    public void setSubTaskEpicTask(SubTask subTask, int id) {
        super.setSubTaskEpicTask(subTask, id);
        save();
    }

    @Override
    public SimpleTask getSimpleTask(int taskId) {
        SimpleTask task = super.getSimpleTask(taskId);
        save();
        return task;
    }

    @Override
    public EpicTask getEpicTask(int taskId) {
        EpicTask task = super.getEpicTask(taskId);
        save();
        return task;
    }

    @Override
    public SubTask getSubTask(int taskId) {
        SubTask task = super.getSubTask(taskId);
        save();
        return task;
    }

    public void save() { //Исключение обработать

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
            bw.write("id,type,name,status,description,epic");
            bw.write("\n");
        } catch (IOException e) {
            throw new ManagerSaveException();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            for (SimpleTask item : dataTask.values()) {
                String line = this.taskToString(item);
                bw.write(line);
                bw.write(",\n");
            }

            for (SubTask item : dataSubTask.values()) {
                String line = this.taskToString(item);
                bw.write(line);
                bw.write(",\n");
            }

            for (EpicTask item : dataEpicTask.values()) {
                String line = this.taskToString(item);
                bw.write(line);
                bw.write(",\n");
            }

            bw.write("\n");

            for (SimpleTask task : getHistory()) {
                String line = Integer.toString(task.getId());
                bw.write(line + ",");
            }

        } catch (IOException e) {
            throw new ManagerSaveException();
        }
    }

    public void loadFromFile() {
        List<SubTask> listSubTask = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            br.readLine();

            while (br.ready()) {
                String line = br.readLine();

                if (line.isEmpty()) {
                    String stringHistory = br.readLine();
                    historyFromString(stringHistory);
                    continue;
                }

                SimpleTask task = taskFromString(line, listSubTask);

                if (task.getTypeTask().equals(TypeTask.SIMPLETASK)) {
                    dataTask.put(task.getId(), task);
                } else if (task.getTypeTask().equals(TypeTask.SUBTASK)) {
                    dataSubTask.put(task.getId(),(SubTask) task);
                } else if (task.getTypeTask().equals(TypeTask.EPICTASK)) {
                    dataEpicTask.put(task.getId(),(EpicTask) task);
                }

                if (taskIdPrivate <= task.getId()) {
                    taskIdPrivate = task.getId() + 1;
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void historyFromString(String stringHistory) {
        String[] array = stringHistory.split(",");

        for (String item : array) {
            if ((dataTask.containsKey(Integer.parseInt(item)))){
                historyManager.add(dataTask.get(Integer.parseInt(item)));
            } else if (dataSubTask.containsKey(Integer.parseInt(item))) {
                historyManager.add(dataSubTask.get(Integer.parseInt(item)));
            } else if (dataEpicTask.containsKey(Integer.parseInt(item))) {
                historyManager.add(dataEpicTask.get(Integer.parseInt(item)));
            }
        }
    }

    /**
     * Уже подготовленную строку надо кидать
     * @param stringTask
     * @return
     */
    private SimpleTask taskFromString(String stringTask, List<SubTask> listSubTask) {
        String[] array = stringTask.split(",");

        if (array[1].equals(TypeTask.SIMPLETASK.toString())) {
            SimpleTask task = new SimpleTask(array[2], array[4]);
            task.setStatus(Status.valueOf(array[3]));
            task.setId(Integer.parseInt(array[0]));
            return task;
        } else if (array[1].equals(TypeTask.SUBTASK.toString())) {
            SubTask task = new SubTask(array[2], array[4]);
            task.setStatus(Status.valueOf(array[3]));
            task.setId(Integer.parseInt(array[0]));
            if (Integer.parseInt(array[5]) != 0) {
                task.setIdEpic(Integer.parseInt(array[5]));
                listSubTask.add(task);
            }
            return task;
        } else if (array[1].equals(TypeTask.EPICTASK.toString())) {
            EpicTask task = new EpicTask(array[2], array[4]);
            task.setStatus(Status.valueOf(array[3]));
            task.setId(Integer.parseInt(array[0]));

            if (!listSubTask.isEmpty()) {
                for (int i = 0; i < listSubTask.size(); i++) {
                    if (task.getId() == listSubTask.get(i).getIdEpic()) {
                        task.setSubTasks(listSubTask.get(i));
                    }
                }

                for (SubTask item : task.getSubTasks()) {
                    listSubTask.remove(item);
                }
            }
            return task;
        } else {
            return null;
        }
    }

    protected String taskToString(SimpleTask simpleTask) {
        if (simpleTask.getTypeTask().equals(TypeTask.SIMPLETASK)) {
            String line = String.join(",", Integer.toString(simpleTask.getId()), TypeTask.SIMPLETASK.toString(),
                    simpleTask.getName(), simpleTask.getStatus().toString(), simpleTask.getDetails());
            return line;
        } else if (simpleTask.getTypeTask().equals(TypeTask.SUBTASK)) {
            SubTask subTask = (SubTask) simpleTask;
            String line = String.join(",", Integer.toString(subTask.getId()), TypeTask.SUBTASK.toString(),
                    subTask.getName(), subTask.getStatus().toString(), subTask.getDetails(),
                    Integer.toString(subTask.getIdEpic()));
            return line;
        } else if (simpleTask.getTypeTask().equals(TypeTask.EPICTASK)) {
            EpicTask epicTask = (EpicTask) simpleTask;
            String line = String.join(",", Integer.toString(epicTask.getId()), TypeTask.EPICTASK.toString(),
                    epicTask.getName(), epicTask.getStatus().toString(), epicTask.getDetails());
            return line;
        }
        return "";
    }
}

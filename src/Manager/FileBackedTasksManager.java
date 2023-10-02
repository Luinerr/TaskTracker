package Manager;

import Tasks.EpicTask;
import Tasks.SubTask;
import Tasks.SimpleTask;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileBackedTasksManager extends InMemoryTaskManager {
    private Map<Integer, SimpleTask> backedMap;
    private String fileName = "src\\Tasks.txt";

    FileBackedTasksManager(File file) {
        backedMap = new HashMap<>();

        //написать автозагрузку из файла

    }

    @Override
    public void addSimpleTask(SimpleTask task) {
        super.addSimpleTask(task);
        backedMap.put(task.getId(), task);
        save();
    }

    @Override
    public void addEpicTask(EpicTask task) {
        super.addEpicTask(task);
        backedMap.put(task.getId(), task);
        save();
    }

    @Override
    public void addSubTask(SubTask task) {
        super.addSubTask(task);
        backedMap.put(task.getId(), task);
        save();
    }

    public void save() { //Исключение обработать
        Path path = Paths.get(fileName);

        if (!Files.exists(path)) {
            try {
                path = Files.createFile(path);
            } catch (Exception ignored) { } // Ошибку кидать может

        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            for (int item : backedMap.keySet()) {
                String line = this.taskToString(backedMap.get(item));
                bw.write(item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Как приходит строка из файла
    //Стоит глянуть запятую в конце, нужна ли она
    // 1,TASK,Task1,NEW,Description task1,
    // 2,EPIC,Epic2,DONE,Description epic2,
    // 3,SUBTASK,Sub Task2,DONE,Description sub task3,2
    /*private Task stringToTask(String stringTask) {
        List<String> arrayString = Arrays.asList(stringTask.split(","));
        Task task = new Task(Integer.parseInt(arrayString.get(0)),);


    }*/

    private String taskToString(SimpleTask simpleTask) {
        String line = String.join(",", Integer.toString(simpleTask.getId()), simpleTask.getDetails(),
                simpleTask.getStatus().toString());
        return line;
    }

    private String taskToString(SubTask subTask) {
        String line = String.join(",", Integer.toString(subTask.getId()), subTask.getDetails(),
                subTask.getStatus().toString(), Integer.toString(subTask.getIdEpic()));
        return line;
        //Необходимо в конструкторе SubTask сделать установку сразу EpicId
        //А если субтаски сначала созданы, а потом епик?
        //У нас в эпике идет установка суб, и ид для эпика в суб
        //Мы же загружаем просто стринг))
    }

    private String taskToString(EpicTask epicTask) {
        String line = String.join(",", Integer.toString(epicTask.getId()), epicTask.getDetails(),
                epicTask.getStatus().toString());
        return line;
    }
}

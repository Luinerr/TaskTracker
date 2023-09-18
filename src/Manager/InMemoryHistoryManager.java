package Manager;

import Tasks.Task;

import java.util.*;

public class InMemoryHistoryManager implements HistoryManager {

    private final CustomLinkedList historyList;


    public InMemoryHistoryManager() {
        historyList = new CustomLinkedList();
    }

    class CustomLinkedList{
        public class Node{
            public Task task;
            public Node next;
            public Node prev;

            public Node(Node prev, Task task, Node next) {
                this.task = task;
                this.next = next;
                this.prev = prev;
            }
        }

        private final Map<Integer, Node> historyMap = new HashMap<>();;
        private Node head;
        private Node tail;
        private int size = 0;

        void linkLast(Task task) {
            final Node oldTail = tail;
            final Node newNode = new Node(oldTail, task, null);
            tail = newNode;
            if (oldTail == null) {
                head = newNode;
            } else {
                oldTail.next = newNode;
            }

            if(historyMap.containsKey(task.getId())) {
                removeNode(historyMap.get(task.getId()));
            }

            historyMap.put(task.getId(), newNode);
            size++;
        }

        List<Task> getTasks() {
            List<Task> list = new ArrayList<>();
            Node newNode = this.head;
            for(int i = 0; i < this.size; i++) {
                list.add(newNode.task);
                newNode = newNode.next;
            }
            return list;
        }

        public Task getLast() {
            return this.head.task;
        }

        public void removeNode(Node node) {

            if(size == 0) {
                return;
            }

            if(size == 1) {
                tail = null;
                head = null;
                size--;
                node = null;
                return;
            }

            Node prevNode = node.prev;
            Node nextNode = node.next;

            if(prevNode == null) {
                head = nextNode;
                nextNode.prev = null;
                size--;
                node = null;
                return;
            }

            if(nextNode == null) {
                tail = prevNode;
                prevNode.next = null;
                size--;
                node = null;
                return;
            }

            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            node = null;
            size--;
        }

        public void removeNodeById(int id) {
            if(historyMap.containsKey(id)) {
                removeNode(historyMap.get(id));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CustomLinkedList that = (CustomLinkedList) o;
            return size == that.size && Objects.equals(head, that.head) && Objects.equals(tail, that.tail);
        }

        @Override
        public int hashCode() {
            return Objects.hash(head, tail, size);
        }
    }

    @Override
    public void add(Task task, int id) {
        historyList.linkLast(task);
    }

    @Override
    public ArrayList<Task> getHistory() {
        return new ArrayList<>(historyList.getTasks());
    }

    @Override
    public void remove(int id) {
        historyList.removeNodeById(id);
    }
}

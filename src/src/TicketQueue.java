import java.util.LinkedList;
import java.util.Queue;

public class TicketQueue {
    private LinkedList<String> queue = new LinkedList<>();

    public void addCustomer(String name) {
        String trimmedName = name.trim();
        if (trimmedName.startsWith("VIP:")) {
            queue.addFirst(trimmedName);
        } else {
            queue.addLast(trimmedName);
        }
    }

    public String nextCustomer() {
        return queue.pollFirst();
    }

    public String peekCustomer() {
        return queue.peekFirst();
    }

    public int size() {
        return queue.size();
    }

    public void clearQueue() {
        queue.clear();
    }

    public Iterable<String> getAllCustomers() {
        return queue;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

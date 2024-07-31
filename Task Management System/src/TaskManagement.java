
public class TaskManagement {
	 private static class Node {
	        Task task;
	        Node next;

	        Node(Task task) {
	            this.task = task;
	            this.next = null;
	        }
	    }

	    private Node head;

	    // Add a new task to the linked list
	    public void addTask(Task task) {
	        Node newNode = new Node(task);
	        if (head == null) {
	            head = newNode;
	        } else {
	            Node current = head;
	            while (current.next != null) {
	                current = current.next;
	            }
	            current.next = newNode;
	        }
	    }

	    // Search for a task by taskId
	    public Task searchTask(String taskId) {
	        Node current = head;
	        while (current != null) {
	            if (current.task.getTaskId().equals(taskId)) {
	                return current.task;
	            }
	            current = current.next;
	        }
	        return null; // Task not found
	    }

	    // Traverse and print all tasks
	    public void traverseTasks() {
	        Node current = head;
	        while (current != null) {
	            System.out.println(current.task);
	            current = current.next;
	        }
	    }

	    // Delete a task by taskId
	    public boolean deleteTask(String taskId) {
	        if (head == null) {
	            return false; // List is empty
	        }

	        if (head.task.getTaskId().equals(taskId)) {
	            head = head.next;
	            return true;
	        }

	        Node current = head;
	        while (current.next != null && !current.next.task.getTaskId().equals(taskId)) {
	            current = current.next;
	        }

	        if (current.next == null) {
	            return false; // Task not found
	        }

	        current.next = current.next.next;
	        return true;
	    }

	    public static void main(String[] args) {
	        TaskManagement tms = new TaskManagement();

	        // Add tasks
	        tms.addTask(new Task("1", "Design system architecture", "In Progress"));
	        tms.addTask(new Task("2", "Develop login module", "Pending"));
	        tms.addTask(new Task("3", "Test the application", "Pending"));

	        // Traverse tasks
	        System.out.println("All Tasks:");
	        tms.traverseTasks();

	        // Search for a task
	        System.out.println("\nSearch for Task with ID 2:");
	        System.out.println(tms.searchTask("2"));

	        // Delete a task
	        System.out.println("\nDelete Task with ID 2:");
	        tms.deleteTask("2");

	        // Traverse tasks again
	        System.out.println("\nAll Tasks After Deletion:");
	        tms.traverseTasks();
	    }
}

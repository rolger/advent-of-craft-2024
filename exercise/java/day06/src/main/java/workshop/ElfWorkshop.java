package workshop;

import java.util.ArrayList;
import java.util.List;

// Maybe you want to have a look at the warnings from the Code Analysis.
// Warning:(7, 26) Field 'taskList' may be 'final'
// Warning:(35, 29) Can be replaced with 'removeFirst()' call
public class ElfWorkshop {
    private List<String> taskList;

    public ElfWorkshop() {
        this.taskList = new ArrayList<>();
    }

    // Do you intend the task list to be changed outside the class?
    // If not, consider returning an unmodifiable list.
    public List<String> getTaskList() {
        return taskList;
    }

    public void addTask(String task) {
        // Try inverting the condition to reduce nesting.
        // Check if it becomes more readable for you when the bad cases are handled first.
        // This concept is called guard clause.
        if (task != null && !task.isEmpty()) {
            taskList.add(task);
        }
    }

    public String completeTask() {
        // Try inverting the condition to reduce nesting.
        // Check if it becomes more readable for you when the bad cases are handled first.
        // This concept is called guard clause.
        if (!taskList.isEmpty()) {
            // Which element is removed from the list? The first or the last?
            // Do you that there methods in java.util.List that express exactly this?
            return taskList.remove(0);
        }
        return null;
    }
}
## first thoughts
I'm usually neglecting code reviews, so this exercise is going to exceed my comfort zone. 

I dislike code review since 
* they are too late and cost too much time 
* there is always something missing if we don't talk - context
* a review usually focus only on the changes and not the whole picture

I'll start with the tests afterward look at the code. I'm going to use code coverage to see if the tests are good enough.

# step by step
I read the tests and was surprised that there are 3 test for the same thing. I started with adding comments to code, what makes me curious. These comments are a fist guess so don't need to take care about language or grammar.

```java
public class ElfWorkshopTests {
    // extract common setup for ElfWorkshop

    // replace the 3 tests into 1 test
    @Test
    public void addTask_Should_Add_Task() {
        var workshop = new ElfWorkshop();
        workshop.addTask("Build toy train");
        assertThat(workshop.getTaskList()).contains("Build toy train");
    }

    @Test
    public void addTask_Should_Add_Craft_Dollhouse_Task() {
        var workshop = new ElfWorkshop();
        workshop.addTask("Craft dollhouse");
        assertThat(workshop.getTaskList()).contains("Craft dollhouse");
    }

    @Test
    public void addTask_Should_Add_Paint_Bicycle_Task() {
        var workshop = new ElfWorkshop();
        workshop.addTask("Paint bicycle");
        assertThat(workshop.getTaskList()).contains("Paint bicycle");
    }

    // merge these 2 tests into one parameterized test
    // think about names for the test cases: invalid task should not be added
    @Test
    public void addTask_Should_Handle_Empty_Tasks_Correctly() {
        var workshop = new ElfWorkshop();
        workshop.addTask("");
        assertThat(workshop.getTaskList()).isEmpty();
    }

    @Test
    public void addTask_Should_Handle_Null_Tasks_Correctly() {
        var workshop = new ElfWorkshop();
        workshop.addTask(null);
        assertThat(workshop.getTaskList()).isEmpty();
    }

    // split assertion into 2 tests
    // a test to remove the last task from the list and check if the list is empty
    // another test for multiple tasks and removing only the first one
    @Test
    public void completeTask_Should_Remove_Task() {
        var workshop = new ElfWorkshop();
        workshop.addTask("Wrap gifts");
        var removedTask = workshop.completeTask();
        assertThat(removedTask).isEqualTo("Wrap gifts");
        assertThat(workshop.getTaskList()).isEmpty();
    }
}
```

Now I understand the code better and it's purpose. I repeat the process for the code. I'm going to add comments to the code.

```java
public class ElfWorkshop {
    private List<String> taskList;

    public ElfWorkshop() {
        this.taskList = new ArrayList<>();
    }

    // return a copy of the list
    public List<String> getTaskList() {
        return taskList;
    }

    public void addTask(String task) {
        // introduce guard clause and method isInvalidTask
        if (task != null && !task.isEmpty()) {
            taskList.add(task);
        }
    }

    public String completeTask() {
        // introduce guard clause
        if (!taskList.isEmpty()) {
            // maybe add comment about FIFO or LIFO
            // use removeFirst instead of remove(0)
            return taskList.remove(0);
        }
        return null;
    }
}
```

# last step
I'm going to rephrase the comments for example and also ask CoPilot for some polite suggestions. 

```java
// replace the 3 tests into 1 test

// What is the purpose of having three tests? Could you consider combining these 3 tests into a single test to reduce redundancy?
```

The suggestions from the AI tools are helpful but not perfect for me. I'm going to use them as a starting point and rephrase them to my liking.

## final thoughts
Using the AI was fun. I'm not a native speaker and those suggestions are quite helpful. 

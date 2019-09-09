package Model_Class;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {

    ArrayList<Task> testTodoList = new ArrayList<>();

    @Test
    public void todoTest() {
        TaskList testTodo = new TaskList(testTodoList, " TestTodo1");
        assertEquals("Got it. I've added this task:\n" + "[T][\u2718] TestTodo1\n" + "Now you have 1 task(s) in the list.", testTodo.addTodo());
    }
}

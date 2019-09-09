package Model_Class;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {

    ArrayList<Task> testTodoList = new ArrayList<>();

    @Test
    public void eventTest1() {
        TaskList testEvent = new TaskList(testTodoList, " TestEvent1 /2019-09-09 1900");
        assertEquals("Got it. I've added this task:\n" + "[E][\u2718] TestEvent1  (at: Mon Sep 09 19:00:00 CST 2019)\n" + "Now you have 1 task(s) in the list.", testEvent.addEvent());
    }

    @Test
    public void eventTest2() {
        TaskList testEvent2 = new TaskList(testTodoList, " TestEvent2 /Thursday");
        assertEquals("Sorry, please enter the date in the format 'yyyy-MM-dd HHmm', thank you.", testEvent2.addEvent());
    }

}

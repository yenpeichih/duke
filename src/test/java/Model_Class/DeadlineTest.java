package Model_Class;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {

    ArrayList<Task> testTodoList = new ArrayList<>();

    @Test
    public void deadlineTest1() {
        TaskList testDeadline = new TaskList(testTodoList, " TestDeadline1 /2019-09-09 1900");
        assertEquals("Got it. I've added this task:\n" + "[E][\u2718] TestDeadline1  (at: Mon Sep 09 19:00:00 CST 2019)\n" + "Now you have 1 task(s) in the list.", testDeadline.addEvent());
    }

    @Test
    public void deadlineTest2() {
        TaskList testDeadline2 = new TaskList(testTodoList, " TestDeadline2 /Thursday");
        assertEquals("Sorry, please enter the date in the format 'yyyy-MM-dd HHmm', thank you.", testDeadline2.addEvent());
    }

}
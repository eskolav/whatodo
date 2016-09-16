/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.test;

import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import whatodo.logic.Task;
import whatodo.logic.TaskHandler;

/**
 *
 * @author esva
 */
public class TaskHandlerTest {

    private TaskHandler handler;
    private Task task;

    public TaskHandlerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        handler = new TaskHandler();
        task = new Task("Tee tämä", new Date(), 2, "Tämä tämä ja tämä");
        handler.addTask("Tee tämä", new Date(), 2, "Tämä tämä ja tämä");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addingTask() {
        handler.addTask("Tee tämä2", new Date(), 2, "Tämä tämä ja tämä");
        assertEquals(handler.getTask("Tee tämä2").getName(), "Tee tämä2");
    }

    @Test
    public void getTask() {
        Task testTask = handler.getTask("Tee tämä");
        assertEquals(handler.getTask("Tee tämä"), testTask);
    }

    @Test
    public void taskList() {
        handler.addTask("Tee tämä1", new Date(), 2, "Tämä tämä ja tämä");
        handler.addTask("Tee tämä2", new Date(), 2, "Tämä tämä ja tämä");
        handler.addTask("Tee tämä3", new Date(), 2, "Tämä tämä ja tämä");
        handler.addTask("Tee tämä4", new Date(), 2, "Tämä tämä ja tämä");
        handler.addTask("Tee tämä5", new Date(), 2, "Tämä tämä ja tämä");

        List list = handler.getTaskList();
        assertEquals(list.size(), 6);
    }

    @Test
    public void incompleteTasks() {
        handler.addTask("Tee tämä1", new Date(), 4, "Tämä tämä ja tämä");
        assertEquals(handler.getIncompleteTasks().size() == 1, true);
    }

    @Test
    public void completedTasks() {
        handler.addTask("Tee tämä1", new Date(), 4, "Tämä tämä ja tämä");
        handler.addTask("Tee tämä2", new Date(), 1, "Tämä tämä ja tämä");

        assertEquals(handler.getIncompleteTasks().size() == 2, true);
    }

    @Test
    public void sortByPrio() {
        handler.addTask("Tee tämä1", new Date(), 2, "Tämä tämä ja tämä");
        handler.addTask("Tee tämä2", new Date(), 3, "Tämä tämä ja tämä");
        handler.addTask("Tee tämä3", new Date(), 1, "Tämä tämä ja tämä");
        handler.addTask("Tee tämä4", new Date(), 2, "Tämä tämä ja tämä");
        handler.addTask("Tee tämä5", new Date(), 3, "Tämä tämä ja tämä");

        handler.sortByPrio();

        assertEquals(handler.getTaskList().get(0).getPriority(), 1);
    }

    @Test
    public void ChangeDesc() {
        String test = "lolcat";
        task.changeDesc(test);
        assertEquals(test, task.getDescription());
    }
}

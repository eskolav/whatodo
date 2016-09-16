/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.test;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import whatodo.logic.Task;

/**
 *
 * @author esva
 */
public class TaskTest {

    private Task task;

    public TaskTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        task = new Task("Tee tämä", new Date(), 2, "Tämä tämä ja tämä");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void willFinish() {
        task.finish();
        assertEquals(task.getPriority(), 4);
        assertEquals(task.isDone(), true);
    }

    @Test
    public void priorityChanges() {
        Boolean first = task.isDone();
        task.changePriority(4);
        assertEquals(!first, task.isDone());
    }

    @Test
    public void toArray() {
        assertEquals(task.getDescription(), task.toArray()[4]);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

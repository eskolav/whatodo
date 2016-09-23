/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import whatodo.ui.MainUi;
import whatodo.logic.TaskHandler;

/**
 *
 * @author esva
 */
public class MainUiTest {

    private TaskHandler handler;
    private MainUi ui;
    
    public MainUiTest() {
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
        
        handler.addTask("name", new Date(), 2, "description");
        ui = new MainUi();
        ui.setTasks(handler);
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void tasksInPanel() {
        
    }
}

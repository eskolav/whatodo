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
public class UiTest {

    public UiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        TaskHandler handler = null;

        try {

            FileInputStream fin = new FileInputStream("/home/esva/whatodo/file.ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            handler = (TaskHandler) ois.readObject();
            ois.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        MainUi ui = new MainUi();
        ui.setVisible(true);
        ui.setTasks(handler);

        try {

            FileOutputStream fout = new FileOutputStream("/home/esva/whatodo/file.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(handler);
            oos.close();
            System.out.println("Done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

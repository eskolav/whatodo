/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatodo.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import whatodo.ui.MainUi;

/**
 *
 * @author esva
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TaskHandler handler = null;

        try {

            FileInputStream fin = new FileInputStream("file.ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            handler = (TaskHandler) ois.readObject();
            ois.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        MainUi ui = new MainUi();
        ui.setTasks(handler);
        ui.setVisible(true);

    }

}

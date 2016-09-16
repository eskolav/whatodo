/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatodo.logic;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author esva
 */
public class TaskHandler implements Serializable {

    private ArrayList<Task> tasks;

    public TaskHandler() {
        this.tasks = new ArrayList<Task>();
    }

    public void addTask(String name, Date exp, int prior, String description) {
        tasks.add(new Task(name, exp, prior, description));

    }

    public Task getTask(String name) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(name)) {
                return tasks.get(i);
            }
        }
        return null;
    }

    public List<Task> getTaskList() {
        return tasks;
    }

    public List<Task> getIncompleteTasks() {
        ArrayList<Task> list2 = new ArrayList<Task>();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getPriority() < 4) {
                list2.add(tasks.get(i));
            }
        }
        return list2;
    }

    public List<Task> getCompletedTasks() {
        ArrayList<Task> list2 = new ArrayList<Task>();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getPriority() > 3) {
                list2.add(tasks.get(i));
            }
        }
        return list2;
    }

    public void sortByPrio() {
        Collections.sort(tasks);
    }
}

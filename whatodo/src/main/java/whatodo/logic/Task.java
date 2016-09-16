/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatodo.logic;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author esva
 */
public class Task implements Serializable, Comparable<Task> {

    private String name;
    private Date created;
    private Date expirates;
    private int prio;
    private String desc;

    public Task(String name, Date exp, int prior, String description) {
        this.name = name;
        this.expirates = exp;
        this.prio = prior;
        this.desc = description;
        this.created = new Date();
    }

    public void finish() {
        prio = 4;
    }

    public String getName() {
        return name;
    }

    public Date getCreationDate() {
        return created;
    }

    public Date getExpirationDate() {
        return expirates;
    }

    public int getPriority() {
        return prio;
    }

    public String getDescription() {
        return desc;
    }

    public Boolean isDone() {
        if (prio < 4) {
            return false;
        } else {
            return true;
        }
    }

    public String toString() {
        return name + "|" + created + "|" + expirates + "|" + prio + "|" + desc;
    }

    public void changePriority(int i) {
        this.prio = i;
    }

    public void changeDesc(String s) {
        this.desc = s;
    }

    public String[] toArray() {
        String[] string = new String[5];
        string[0] = name;
        string[1] = created.toString();
        string[2] = expirates.toString();
        string[3] = String.valueOf(prio);
        string[4] = desc;
        return string;
    }

    @Override
    public int compareTo(Task t) {
        return prio - t.getPriority();
    }
}

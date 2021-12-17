package dev.boghy933.droolsgenerator.entity;

public class Action {
    private int id;
    private int id_rule;
    private String action;

    public Action(int id, int id_rule, String action) {
        this.id = id;
        this.id_rule = id_rule;
        this.action = action;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_rule() {
        return id_rule;
    }

    public void setId_rule(int id_rule) {
        this.id_rule = id_rule;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}

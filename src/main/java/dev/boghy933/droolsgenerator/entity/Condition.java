package dev.boghy933.droolsgenerator.entity;

public class Condition {
    private int id;
    private int id_rule;
    private String condition;

    public Condition(int id, int id_rule, String condition) {
        this.id = id;
        this.id_rule = id_rule;
        this.condition = condition;
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}

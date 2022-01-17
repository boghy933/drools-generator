package dev.boghy933.droolsgenerator.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class ConditionHandSide {
    @Id
    private int id;
    private String side; // left or right lhs or rhs
    private String rule;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
}

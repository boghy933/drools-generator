package dev.boghy933.droolsgenerator.dto;

import java.sql.Timestamp;

public class Business {
    private Long id;
    private String name;
    private int expense;
    private Timestamp birthDate;
    private BusinessType businessType;
    private String appliedRule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public BusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    public String getAppliedRule() {
        return appliedRule;
    }

    public void setAppliedRule(String appliedRule) {
        this.appliedRule = appliedRule;
    }
}

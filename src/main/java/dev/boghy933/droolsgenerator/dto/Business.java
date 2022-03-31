package dev.boghy933.droolsgenerator.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Business {
    private Long id;
    private String name;
    private int expense;
    private Date birthDate;
    private BusinessType businessType;
    private String appliedRule;
    private List<Integer> activeYears;
    private boolean disabled;

    public Business(Long id, String name, int expense, Date birthDate, BusinessType businessType, String appliedRule, List<Integer> activeYears, boolean disabled) {
        this.id = id;
        this.name = name;
        this.expense = expense;
        this.birthDate = birthDate;
        this.businessType = businessType;
        this.appliedRule = appliedRule;
        this.activeYears = activeYears;
        this.disabled = disabled;
    }

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
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

    public List<Integer> getActiveYears() {
        return activeYears;
    }

    public void setActiveYears(List<Integer> activeYears) {
        this.activeYears = activeYears;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}

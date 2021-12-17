package dev.boghy933.droolsgenerator.entity;

public class Rule {
    private int id;
    private String name;
    private String ruleset;
    private String importData;

    public Rule(int id, String name, String ruleset, String importData) {
        this.id = id;
        this.name = name;
        this.ruleset = ruleset;
        this.importData = importData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuleset() {
        return ruleset;
    }

    public void setRuleset(String ruleset) {
        this.ruleset = ruleset;
    }

    public String getImportData() {
        return importData;
    }

    public void setImportData(String importData) {
        this.importData = importData;
    }
}

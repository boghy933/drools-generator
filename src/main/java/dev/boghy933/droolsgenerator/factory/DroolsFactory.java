package dev.boghy933.droolsgenerator.factory;

import org.drools.compiler.lang.api.*;
import org.drools.mvel.DrlDumper;

import java.util.List;

public class DroolsFactory {

    protected PackageDescrBuilder packageDescr = DescrFactory.newPackage();

    public void DroolsFactory() {
        // Build drools package
    }

    public void setName(String name) {
        packageDescr.name(name);
    }

    public void newImport(String importName) {
        packageDescr.newImport().target(importName).end();
    }

    public void setRule(String ruleName, String pattern, String id, List<String> constraints, List<String> rhs) {
        // Start new rule
        RuleDescrBuilder ruleDescrBuilder = packageDescr.newRule().name(ruleName);
        CEDescrBuilder ceDescrBuilder = ruleDescrBuilder.lhs().and();

        // When
        PatternDescrBuilder patternDescrBuilder = ceDescrBuilder.pattern(pattern).id( id, false );
        buildLhs(patternDescrBuilder, constraints);
        // Then
        ruleDescrBuilder.rhs(buildRhs(rhs)).end();
    }

    public String dump() {
        DrlDumper dumper=new DrlDumper();
        return dumper.dump(packageDescr.getDescr());
    }

    private void buildLhs(PatternDescrBuilder patternDescrBuilder, List<String> constraints) {
        for (String constraint : constraints) {
            patternDescrBuilder = patternDescrBuilder.constraint(constraint);
        }
        patternDescrBuilder.end().end().end();
    }

    private String buildRhs(List<String> rhs) {
        String rhsMerged = "\t";

        for(String singleRhs : rhs) {
            rhsMerged = rhsMerged.concat("\n\t" + singleRhs);
        }
        return rhsMerged;
    }
}

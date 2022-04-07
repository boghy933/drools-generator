package dev.boghy933.droolsgenerator.factory;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.drools.compiler.lang.api.*;
import org.drools.mvel.DrlDumper;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        /* ------------------------------------------------------------------------ */
        /* You should do this ONLY ONCE in the whole application life-cycle:        */

        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        try {
            cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Recommended settings for new projects:
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);

        /* ------------------------------------------------------------------------ */
        /* You usually do these for MULTIPLE TIMES in the application life-cycle:   */

        /* Get the template (uses cache internally) */
        Template template;
        try {
            template = cfg.getTemplate("droolsTemplate.ftlh");
            Writer out = new StringWriter();

            Map internalData = new HashMap();
            internalData.put("package", packageDescr.getDescr().getName());
            System.out.println("PACKAGE: "  + packageDescr.getDescr().getName());
            template.process(internalData, out);
            DrlDumper dumper=new DrlDumper();

            String droolsFile = dumper.dump(packageDescr.getDescr());
            droolsFile = droolsFile.replace("package " + packageDescr.getDescr().getName(), "");
            return out.toString() + droolsFile;

        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return null;
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

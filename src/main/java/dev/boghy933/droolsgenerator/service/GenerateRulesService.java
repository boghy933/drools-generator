package dev.boghy933.droolsgenerator.service;

import dev.boghy933.droolsgenerator.entity.Rule;
import dev.boghy933.droolsgenerator.factory.DroolsFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Important urls:
 * https://stackoverflow.com/questions/53038735/i-need-help-for-implementing-drool-fluent-api-for-dynamically-generated-drl-file
 * https://stackoverflow.com/questions/27522711/is-there-any-api-in-drools-to-create-the-drl-files-dynamically-by-just-passing-v
 * https://docs.jboss.org/drools/release/5.2.0.Final/droolsjbpm-introduction-docs/html/ch02.html
 * https://stackoverflow.com/questions/47343278/adding-multiple-action-statements-in-drools-fluent-api
 *
 * https://github.com/eugenp/tutorials/blob/master/drools/src/main/resources/courseSchedule.drl
 * https://www.baeldung.com/drools-excel
 * https://docs.jboss.org/drools/release/5.2.0.Final/drools-expert-docs/html/ch05.html
 * How to add multiple rules: https://stackoverflow.com/questions/51210009/drools-package-name-fluent-api
 * Example of fluent api: https://github.com/kiegroup/drools/blob/6.3.x/drools-compiler/src/test/java/org/drools/compiler/lang/api/DescrBuilderTest.java#L451-L465
 * Check if list contains: https://stackoverflow.com/questions/28326953/drools-check-if-exists-contains-string-in-a-liststring
 */

public class GenerateRulesService {
    public void generateRules() {
/*        Rule rule = new Rule(1, "Priority: 1.0 - Bronze - business is low profile", null, null);

        // $business:Business
        Condition condition1 = new Condition(1, 1, "$business.getExpense() > 0");
        Condition condition2 = new Condition(2, 1, "$business.getExpense() < 2000");

        Action action1 = new Action(1,1, "$business.setBusinessType(BusinessType.BRONZE)");
        Action action2 = new Action(1,2, "$business.setAppliedRule(1)");*/

        //PackageDescrBuilder rulePackage = DescrFactory.newPackage();

        //rulePackage.name("dev.boghy933.drools.rules");
        //rulePackage.newImport().target("dev.boghy933.droolsgenerator.dto.Business").end();
        //rulePackage.newImport().target("dev.boghy933.droolsgenerator.dto.BusinessType").end();

        // RuleDescrBuilder ruleBuilder =  rulePackage.newRule().name(rule.getName());


        //PatternDescrBuilder patternBuilder = ruleBuilder.lhs().and().pattern("Business").id("$business", false);
        //patternBuilder.constraint("$business.getExpanse() > 2000");
        // patternBuilder.constraint("$business.getExpanse() < 10000");
        // patternBuilder.end().end().end();

        // ruleBuilder.rhs("\t$business.setBusinessType(BusinessType.SILVER); \n \t$business.setAppliedRule(\"2.0\")");

        List<String> constraintsBronze = new ArrayList<String>();
        List<String> rhsBronze = new ArrayList<String>();
        List<String> constraintsSilver = new ArrayList<String>();
        List<String> rhsSilver = new ArrayList<String>();
        List<String> constraintsGold = new ArrayList<String>();
        List<String> rhsGold = new ArrayList<String>();
        List<String> constraintsDiamond = new ArrayList<String>();
        List<String> rhsDiamond = new ArrayList<String>();


        constraintsBronze.add("$business.getExpense() > 0");
        constraintsBronze.add("$business.getExpense() <= 10000");
        constraintsBronze.add("$business.getActiveYears() contains 2020");
        rhsBronze.add("$business.setBusinessType(BusinessType.BRONZE);");
        rhsBronze.add("$business.setAppliedRule(\"1.0-BRONZE\");");

        // It returns the value 0 if the argument Date is equal to this Date.
        // It returns a value less than 0 if this Date is before the Date argument.
        // It returns a value greater than 0 if this Date is after the Date argument.
        constraintsBronze.add("$business.getBirthDate().compareTo(DateUtils.parseDate(\"10-Jul-2019\")) > 0");

        constraintsSilver.add("$business.getExpense() > 10000");
        constraintsSilver.add("$business.getExpense() <= 20000");
        constraintsSilver.add("$business.getExpense() <= 20000");
        constraintsSilver.add("[\"Silver Company\", \"Gold Company\"] contains $business.getName()");
        rhsSilver.add("$business.setBusinessType(BusinessType.SILVER);");
        rhsSilver.add("$business.setAppliedRule(\"2.0-SILVER\");");

        constraintsGold.add("$business.getExpense() > 20000");
        constraintsGold.add("$business.getExpense() <= 30000");
        constraintsGold.add("$business.getName() in (\"Silver Company\", \"Gold Company\")");
        rhsGold.add("$business.setBusinessType(BusinessType.GOLD);");
        rhsGold.add("$business.setAppliedRule(\"3.0-GOLD\");");

        constraintsDiamond.add("$business.getExpense() > 30000");
        rhsDiamond.add("$business.setBusinessType(BusinessType.DIAMOND);");
        rhsDiamond.add("$business.setAppliedRule(\"4.0-DIAMOND\");");


        DroolsFactory droolsFactory = new DroolsFactory();
        droolsFactory.setName("dev.boghy933.drools.rules");
        droolsFactory.newImport("dev.boghy933.droolsgenerator.dto.Business");
        droolsFactory.newImport("dev.boghy933.droolsgenerator.dto.BusinessType");
        droolsFactory.newImport("org.drools.core.util.DateUtils");

        droolsFactory.setRule("Set Bronze", "Business", "$business", constraintsBronze, rhsBronze);
        droolsFactory.setRule("Set Silver", "Business", "$business", constraintsSilver, rhsSilver);
        droolsFactory.setRule("Set Gold", "Business", "$business", constraintsGold, rhsGold);
        droolsFactory.setRule("Set Diamond", "Business", "$business", constraintsDiamond, rhsDiamond);

        // https://docs.jboss.org/drools/release/5.2.0.Final/droolsjbpm-introduction-docs/html/ch02.html
/*        PackageDescr pkg = DescrFactory.newPackage()
                .name("dev.boghy933.drools.rules")
                    .newImport()
                        .target("dev.boghy933.droolsgenerator.dto.Business")
                    .end()
                    .newImport()
                        .target("dev.boghy933.droolsgenerator.dto.BusinessType")
                    .end()
                .newRule().name(rule.getName())
                    //.attribute("ruleflow-grou","bla")
                .lhs()
                    .and()
                        .pattern("Business").id( "$business", false )
                            .constraint("$business.getExpense() > 0")
                            .constraint("$business.getExpense() < 2000")
                            .constraint("$business.getBusinessType() = \"ciao\"")
                        .end()

                        // .not().pattern("Bar").constraint("a+b==c").end().end()
                    .end()
                .end()
                .rhs( "\t$business.setBusinessType(BusinessType.BRONZE); \n \t$business.setAppliedRule(\"1.0\");" )
                //.namedRhs("$business.setBusinessType(BusinessType.BRONZE)", "$business.setAppliedRule(1)")
                .end()
                .getDescr();*/


/*        DrlDumper dumper=new DrlDumper();
        String drl=dumper.dump(pkg);*/

        String drl = droolsFactory.dump();

        System.out.print(drl);

        // https://stackoverflow.com/questions/27522711/is-there-any-api-in-drools-to-create-the-drl-files-dynamically-by-just-passing-v
        try{
            // create new file
            File file = new File("src/main/resources/generated/test.drl");
            file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(drl);
            // close connection
            bw.close();
            System.out.println("File Created Successfully");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

package dev.boghy933.droolsgenerator.drools;

import dev.boghy933.droolsgenerator.entity.Action;
import dev.boghy933.droolsgenerator.entity.Condition;
import dev.boghy933.droolsgenerator.entity.Rule;
import org.drools.compiler.lang.DrlDumper;
import org.drools.compiler.lang.api.DescrFactory;
import org.drools.compiler.lang.descr.PackageDescr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

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
 */

public class GenerateRules {
    public void generateRules() {
        Rule rule = new Rule(1, "Bronze - business is low profile", null, null);

        // $business:Business
        Condition condition1 = new Condition(1, 1, "$business.getExpense() > 0 ");
        Condition condition2 = new Condition(2, 1, "$business.getExpense() < 2000");

        Action action1 = new Action(1,1, "$business.setBusinessType(BusinessType.BRONZE)");
        Action action2 = new Action(1,2, "$business.setAppliedRule(1)");

        // https://docs.jboss.org/drools/release/5.2.0.Final/droolsjbpm-introduction-docs/html/ch02.html
        PackageDescr pkg = DescrFactory.newPackage()
                .name("dev.boghy933.droolsgenerator")
                .newRule().name(rule.getName())
                    //.attribute("ruleflow-grou","bla")
                .lhs()
                    .and()
                        .pattern("Foo").id( "$foo", false ).constraint("bar==baz").constraint("x>y").end()
                        .not().pattern("Bar").constraint("a+b==c").end().end()
                    .end()
                .end()
                .rhs( "System.out.println();" ).end()
                .getDescr();

        DrlDumper dumper=new DrlDumper();
        String drl=dumper.dump(pkg);
        System.out.print(drl);

        // https://stackoverflow.com/questions/27522711/is-there-any-api-in-drools-to-create-the-drl-files-dynamically-by-just-passing-v
        try{
            // create new file
            File file = new File("src/main/resources/test.drl");
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

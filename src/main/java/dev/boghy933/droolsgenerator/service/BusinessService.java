package dev.boghy933.droolsgenerator.service;

import dev.boghy933.droolsgenerator.config.DroolsBeanFactory;
import dev.boghy933.droolsgenerator.dto.Business;
import org.kie.api.runtime.KieSession;

/**
 * Config resources structure https://stackoverflow.com/questions/56642087/is-there-any-simple-way-to-execute-all-the-drl-files-in-the-directory
 * Kbase : https://www.tabnine.com/web/assistant/code/rs/5c668fbd1095a50001cf1139#L36
 */
public class BusinessService {

    KieSession kieSession=new DroolsBeanFactory().getKieSession();

    public Business suggestType(Business business) {
        kieSession.insert(business);
        kieSession.fireAllRules();
        System.out.println(business.getBusinessType());
        return business;
    }
}

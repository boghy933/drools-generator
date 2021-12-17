package dev.boghy933.droolsgenerator;

import dev.boghy933.droolsgenerator.dto.Business;
import dev.boghy933.droolsgenerator.service.BusinessService;
import dev.boghy933.droolsgenerator.service.GenerateRulesService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DroolsGeneratorApplicationTests {

	private BusinessService businessService;

	// @Test // - You can't generate and run the rule in the same test so fast, it give you error
	void generateDroolsRule() {
		GenerateRulesService generateRulesService = new GenerateRulesService();
		generateRulesService.generateRules();
	}

	@Test
	void executeDroolsRule() {
		businessService = new BusinessService();
		Business business = new Business(Long.valueOf(1), "boghy933", 1000, null, null, null);
		business = businessService.suggestType(business);
		System.out.println(business.getBusinessType());
	}

}

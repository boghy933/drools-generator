package dev.boghy933.droolsgenerator;

import dev.boghy933.droolsgenerator.dto.Business;
import dev.boghy933.droolsgenerator.dto.BusinessType;
import dev.boghy933.droolsgenerator.service.BusinessService;
import dev.boghy933.droolsgenerator.service.GenerateRulesService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Order;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DroolsGeneratorApplicationTests {

	private BusinessService businessService = new BusinessService();

	@Test
	@Order(1)
	void generateDroolsRule() {
		GenerateRulesService generateRulesService = new GenerateRulesService();
		generateRulesService.generateRules();
	}

	@Test
	@Order(2)
	void testBronze() {

		Business business = new Business(Long.valueOf(1), "Bronze Company", 5000, null, null, null);
		business = businessService.suggestType(business);
		assertEquals(business.getBusinessType(), BusinessType.BRONZE);
		assertEquals(business.getAppliedRule(), "1.0-BRONZE");

		business = new Business(Long.valueOf(1), "Bronze Company", 10000, null, null, null);
		business = businessService.suggestType(business);
		assertEquals(business.getBusinessType(), BusinessType.BRONZE);
		assertEquals(business.getAppliedRule(), "1.0-BRONZE");
	}

	@Test
	@Order(2)
	void testSilver() {
		Business business = new Business(Long.valueOf(1), "Silver Company", 11000, null, null, null);
		business = businessService.suggestType(business);
		assertEquals(business.getBusinessType(), BusinessType.SILVER);
		assertEquals(business.getAppliedRule(), "2.0-SILVER");

		business = new Business(Long.valueOf(1), "Silver Company", 20000, null, null, null);
		business = businessService.suggestType(business);
		assertEquals(business.getBusinessType(), BusinessType.SILVER);
		assertEquals(business.getAppliedRule(), "2.0-SILVER");
	}

	@Test
	@Order(2)
	void testGold() {
		Business business = new Business(Long.valueOf(1), "Gold Company", 25000, null, null, null);
		business = businessService.suggestType(business);
		assertEquals(business.getBusinessType(), BusinessType.GOLD);
		assertEquals(business.getAppliedRule(), "3.0-GOLD");
	}

	@Test
	@Order(2)
	void testDiamond() {
		Business business = new Business(Long.valueOf(1), "Diamond Company", 50000, null, null, null);
		business = businessService.suggestType(business);
		assertEquals(business.getBusinessType(), BusinessType.DIAMOND);
		assertEquals(business.getAppliedRule(), "4.0-DIAMOND");
	}

}

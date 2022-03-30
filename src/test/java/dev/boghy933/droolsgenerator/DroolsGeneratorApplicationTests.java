package dev.boghy933.droolsgenerator;

import dev.boghy933.droolsgenerator.dto.Business;
import dev.boghy933.droolsgenerator.dto.BusinessType;
import dev.boghy933.droolsgenerator.service.BusinessService;
import dev.boghy933.droolsgenerator.service.GenerateRulesService;
import org.drools.core.util.DateUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Order;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		List<Integer> activeYears = new ArrayList<Integer>();
		activeYears.add(2019);
		activeYears.add(2020);
		activeYears.add(2021);

		// DateUtils.format("");

		Date birthDate = Date.from(LocalDate.of( 2004, 03, 30 ).atStartOfDay(ZoneId.of( "Europe/Rome" )).toInstant());
		Business business = new Business(Long.valueOf(1), "Bronze Company", 5000, birthDate, null, null, activeYears);
		business = businessService.suggestType(business);
		assertEquals(BusinessType.BRONZE, business.getBusinessType());
		assertEquals("1.0-BRONZE", business.getAppliedRule());

		activeYears = new ArrayList<Integer>();
		activeYears.add(2019);
		activeYears.add(2021);
		activeYears.add(2020);
		Date birthDate2 = Date.from(LocalDate.of( 1990, 3 , 25 ).atStartOfDay(ZoneId.of( "Europe/Rome" )).toInstant());
		business = new Business(Long.valueOf(1), "Bronze Company", 10000, birthDate2, null, null, activeYears);
		business = businessService.suggestType(business);
		assertEquals(BusinessType.BRONZE, business.getBusinessType());
		assertEquals("1.0-BRONZE", business.getAppliedRule());
	}

	@Test
	@Order(2)
	void testSilver() {
		Date birthDate = Date.from(LocalDate.of( 2020 , 2 , 11 ).atStartOfDay(ZoneId.of( "Europe/Rome" )).toInstant());
		Business business = new Business(Long.valueOf(1), "Silver Company", 11000, birthDate, null, null, null);
		business = businessService.suggestType(business);
		assertEquals(business.getBusinessType(), BusinessType.SILVER);
		assertEquals(business.getAppliedRule(), "2.0-SILVER");

		Date birthDate2 = Date.from(LocalDate.of( 2021 , 2 , 11 ).atStartOfDay(ZoneId.of( "Europe/Rome" )).toInstant());
		business = new Business(Long.valueOf(1), "Silver Company", 20000, birthDate2, null, null, null);
		business = businessService.suggestType(business);
		assertEquals(business.getBusinessType(), BusinessType.SILVER);
		assertEquals(business.getAppliedRule(), "2.0-SILVER");
	}

	@Test
	@Order(2)
	void testGold() {
		Business business = new Business(Long.valueOf(1), "Gold Company", 25000, null, null, null, null);
		business = businessService.suggestType(business);
		assertEquals(business.getBusinessType(), BusinessType.GOLD);
		assertEquals(business.getAppliedRule(), "3.0-GOLD");
	}

	@Test
	@Order(2)
	void testDiamond() {
		Business business = new Business(Long.valueOf(1), "Diamond Company", 50000, null, null, null, null);
		business = businessService.suggestType(business);
		assertEquals(business.getBusinessType(), BusinessType.DIAMOND);
		assertEquals(business.getAppliedRule(), "4.0-DIAMOND");
	}

}

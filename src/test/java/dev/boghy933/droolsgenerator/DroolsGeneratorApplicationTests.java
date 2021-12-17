package dev.boghy933.droolsgenerator;

import dev.boghy933.droolsgenerator.drools.GenerateRules;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DroolsGeneratorApplicationTests {

	@Test
	void generateDroolsRule() {
		GenerateRules generateRules = new GenerateRules();
		generateRules.generateRules();
	}

}

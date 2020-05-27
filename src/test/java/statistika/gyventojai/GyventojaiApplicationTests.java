package statistika.gyventojai;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GyventojaiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testNull() {
		
		assertNull ( null );
	}	
}

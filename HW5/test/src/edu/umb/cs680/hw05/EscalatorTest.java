package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw05.Escalator;

class EscalatorTest {

	@Test
	public void getInstanceReturnNonNullValue() {
		assertNotNull(Escalator.getInstance());
	}

	@Test
	public void getInstanceReturnIdenticalInstance() {
		Escalator es1 = Escalator.getInstance();
		Escalator es2 = Escalator.getInstance();
		assertSame(es1, es2);
	}

}

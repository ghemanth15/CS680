package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw10.Manhattan;

public class ManhattanTest {

	@Test
	public void disTestP1P2() {
		List<Double> l1 = Arrays.asList(2.0, 3.0, 5.0);
		List<Double> l2 = Arrays.asList(2.0, 5.0, 6.0);
		double expected = 3;
		double actual = new Manhattan().distance(l1, l2);
		assertEquals(expected, actual);
	}
}
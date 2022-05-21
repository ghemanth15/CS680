package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw10.Chebyshev;
import edu.umb.cs680.hw10.Distance;
import edu.umb.cs680.hw10.Euclidean;
import edu.umb.cs680.hw10.Manhattan;

public class DistanceTest {
	private static List<Double> l1, l2, l3, l4, l5;
	private static List<List<Double>> pointsList = new LinkedList<>();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		l1 = Arrays.asList(2.0, 3.0, 5.0);
		l2 = Arrays.asList(2.0, 5.0, 6.0);
		l3 = Arrays.asList(3.0, 4.0, 8.0);
		l4 = Arrays.asList(4.0, 2.0, 1.0);
		l5 = Arrays.asList(5.0, 5.0, 6.0);
		pointsList.add(l1);
		pointsList.add(l2);
		pointsList.add(l3);
		pointsList.add(l4);
		pointsList.add(l5);
	}

	@Test
	public void defaultGetWithP1P2() {
		double expected = Math.sqrt(5.0);
		double actual = Distance.get(l1, l2);
		assertEquals(expected, actual);
	}

	@Test
	public void getP1P2AndEuclidean() {
		double expected = Math.sqrt(5.0);
		double actual = Distance.get(l1, l2, new Euclidean());
		assertEquals(expected, actual);
	}

	@Test
	public void getP1P2AndManhattan() {
		double expected = 3.0;
		double actual = Distance.get(l1, l2, new Manhattan());
		assertEquals(expected, actual);
	}

	@Test
	public void getP1P2AndChebyshev() {
		double expected = 2.0;
		double actual = Distance.get(l1, l2, new Chebyshev());
		assertEquals(expected, actual);
	}

	@Test
	public void defaultMatrixWithPointsList() {
		Double[][] expected = { { 0.0, Math.sqrt(5.0), Math.sqrt(11.0), Math.sqrt(21.0), Math.sqrt(14.0) },
				{ Math.sqrt(5.0), 0.0, Math.sqrt(6.0), Math.sqrt(38.0), 3.0 },
				{ Math.sqrt(11.0), Math.sqrt(6.0), 0.0, Math.sqrt(54.0), 3.0 },
				{ Math.sqrt(21.0), Math.sqrt(38.0), Math.sqrt(54.0), 0.0, Math.sqrt(35.0) },
				{ Math.sqrt(14.0), 3.0, 3.0, Math.sqrt(35.0), 0.0 } };
		List<List<Double>> actual = Distance.matrix(pointsList);
		for (int i = 0; i < expected.length; i++) {
			Double[] temp = new Double[5];
			assertArrayEquals(expected[i], actual.get(i).toArray(temp));
		}
	}

	@Test
	public void matrixPointsListAndEuclidean() {
		Double[][] expected = { { 0.0, Math.sqrt(5.0), Math.sqrt(11.0), Math.sqrt(21.0), Math.sqrt(14.0) },
				{ Math.sqrt(5.0), 0.0, Math.sqrt(6.0), Math.sqrt(38.0), 3.0 },
				{ Math.sqrt(11.0), Math.sqrt(6.0), 0.0, Math.sqrt(54.0), 3.0 },
				{ Math.sqrt(21.0), Math.sqrt(38.0), Math.sqrt(54.0), 0.0, Math.sqrt(35.0) },
				{ Math.sqrt(14.0), 3.0, 3.0, Math.sqrt(35.0), 0.0 } };
		List<List<Double>> actual = Distance.matrix(pointsList, new Euclidean());
		for (int i = 0; i < expected.length; i++) {
			Double[] temp = new Double[5];
			assertArrayEquals(expected[i], actual.get(i).toArray(temp));
		}
	}
	
	@Test
	public void matrixPointsListAndManhattan() {
		Double[][] expected = { { 0.0, 3.0, 5.0, 7.0, 6.0 },
								{ 3.0, 0.0, 4.0, 10.0, 3.0 },
								{ 5.0, 4.0, 0.0, 10.0, 5.0 },
								{ 7.0, 10.0, 10.0, 0.0, 9.0 },
								{ 6.0, 3.0, 5.0, 9.0, 0.0 } };
		List<List<Double>> actual = Distance.matrix(pointsList, new Manhattan());
		for (int i = 0; i < expected.length; i++) {
			Double[] temp = new Double[5];
			assertArrayEquals(expected[i], actual.get(i).toArray(temp));
		}
	}
	
	@Test
	public void matrixPointsListAndChebyshev() {
		Double[][] expected = { { 0.0, 2.0, 3.0, 4.0, 3.0 },
								{ 2.0, 0.0, 2.0, 5.0, 3.0 },
								{ 3.0, 2.0, 0.0, 7.0, 2.0 },
								{ 4.0, 5.0, 7.0, 0.0, 5.0 },
								{ 3.0, 3.0, 2.0, 5.0, 0.0 } };
		List<List<Double>> actual = Distance.matrix(pointsList, new Chebyshev());
		for (int i = 0; i < expected.length; i++) {
			Double[] temp = new Double[5];
			assertArrayEquals(expected[i], actual.get(i).toArray(temp));
		}
	}

}

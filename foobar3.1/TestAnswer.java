import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TestAnswer {

	Map<Integer, Map<Integer, Node>> nodes;

	@Before
	public void setup() {
		nodes = new HashMap<Integer, Map<Integer, Node>>();
	}

	//	@Test
	//	public void test2by2Matrix() {
	//		Answer.setupNodes(new int[][]{new int[]{0, 1}, new int[]{0, 0}});
	//		
	//		nodes = Answer.getNodes();
	//		
	//		assertEquals(nodes.get(0).get(0).getValue(), 0);
	//		assertEquals(nodes.get(1).get(0).getValue(), 0);
	//		assertEquals(nodes.get(0).get(1).getValue(), 1);
	//		assertEquals(nodes.get(1).get(1).getValue(), 0);
	//		
	//		assertEquals(nodes.size(), 2);
	//		assertEquals(nodes.get(0).size(), 2);
	//		assertEquals(nodes.get(1).size(), 2);
	//	}
	//	
	//	@Test
	//	public void test3by3Matrix() {
	//		Answer.setupNodes(new int[][]{new int[]{0, 1, 1}, new int[]{0, 0, 1}, new int[]{1, 0, 0}});
	//		
	//		nodes = Answer.getNodes();
	//		
	//		assertEquals(nodes.get(0).get(0).getValue(), 0);
	//		assertEquals(nodes.get(0).get(1).getValue(), 1);
	//		assertEquals(nodes.get(0).get(2).getValue(), 1);
	//		
	//		assertEquals(nodes.get(1).get(0).getValue(), 0);
	//		assertEquals(nodes.get(1).get(1).getValue(), 0);
	//		assertEquals(nodes.get(1).get(2).getValue(), 1);
	//
	//		assertEquals(nodes.get(2).get(0).getValue(), 1);
	//		assertEquals(nodes.get(2).get(1).getValue(), 0);
	//		assertEquals(nodes.get(2).get(2).getValue(), 0);
	//		
	//		assertEquals(nodes.size(), 3);
	//		assertEquals(nodes.get(0).size(), 3);
	//		assertEquals(nodes.get(1).size(), 3);
	//		assertEquals(nodes.get(2).size(), 3);
	//	}

	@Test
	public void test2by2Solution() {
		int soln = Answer.answer(new int[][]{new int[]{0, 1}, new int[]{0, 0}});
		assertEquals(3, soln);

	}

	@Test
	public void test3by3Solution() {
		int soln = Answer.answer(new int[][]{new int[]{0, 1, 1}, new int[]{0, 0, 1}, new int[]{1, 0, 0}});
		assertEquals(5, soln);
	}

	@Test
	public void test6by6Solution() {
		int soln = Answer.answer(new int[][]{new int[] {0, 0, 0, 0, 0, 0}, new int[]{1, 1, 1, 1, 1, 0},
			new int[]{0, 0, 0, 0, 0, 0}, new int[]{0, 1, 1, 1, 1, 1}, new int[]{0, 1, 1, 1, 1, 1},
			new int[]{0, 0, 0, 0, 0, 0}
		});

		assertEquals(11, soln);
	}

	@Test
	public void test20by20Solution() {
		int soln = Answer.solve(new int[][]{
			{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
			{1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
			{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		});
		
		assertEquals(39, soln);
	}
}

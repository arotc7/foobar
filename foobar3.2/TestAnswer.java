package foobar5;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAnswer {

	@Test
	public void shouldBe3Example() {
		int solution = Answer.answer(new int[]{1, 2, 3, 4, 5, 6});
		assertEquals(3, solution);
	}
	
	@Test
	public void shouldBe1Example() {
		int solution = Answer.answer(new int[]{1, 1, 1});
		assertEquals(1, solution);
	}
	
	@Test
	public void shouldBe0Example() {
		int solution = Answer.answer(new int[]{2, 3, 9});
		assertEquals(0, solution);
	}
	
	@Test
	public void shouldBe4Example() {
		int solution = Answer.answer(new int[]{1, 2, 3, 4, 5, 6, 9});
		assertEquals(4, solution);
	}

	@Test
	public void shouldBe11Example() {
		int solution = Answer.answer(new int[]{1, 2, 3, 4, 5, 6, 9, 18});
		assertEquals(11, solution);
	}
	
	@Test
	public void duplicateShouldNotCreateProblems() {
		int solution = Answer.answer(new int[]{3, 9});
		assertEquals(0, solution);
		
		solution = Answer.answer(new int[]{2, 2, 4});
		assertEquals(1, solution);
		
		solution = Answer.answer(new int[]{1, 2, 2, 2, 2, 4});
		assertEquals(4, solution);
	}
}

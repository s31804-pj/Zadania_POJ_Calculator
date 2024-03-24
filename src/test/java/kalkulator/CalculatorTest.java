package kalkulator;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
	@Test
	public void testAddOne(){
		// Arrange
		// sut = System Under Test
		Calculator sut = new Calculator();
		// Act
		sut.add(1);
		// Assert
		assertEquals("0+1 = 1", 1, sut.getState());
	}

	@Test
	public void testMultOneByTwo(){
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.mult(2);
		assertEquals("1*2 = 2", 2, sut.getState());
	}

	@Test
	public void testAddZero() {
		Calculator sut = new Calculator();
		sut.add(0);
		assertEquals("0 + 0 = 0", 0, sut.getState());
	}

	@Test
	public void testAddNegativeNumber() {
		Calculator sut = new Calculator();
		sut.add(-5);
		assertEquals("0 + (-5) = -5", -5, sut.getState());
	}

	@Test
	public void testAddPositiveNumber() {
		Calculator sut = new Calculator();
		sut.setState(10);
		sut.add(7);
		assertEquals("10 + 7 = 17", 17, sut.getState());
	}

	@Test
	public void testMultByZero() {
		Calculator sut = new Calculator();
		sut.setState(3);
		sut.mult(0);
		assertEquals("3 * 0 = 0", 0, sut.getState());
	}

	@Test
	public void testMultByNegativeNumber() {
		Calculator sut = new Calculator();
		sut.setState(5);
		sut.mult(-2);
		assertEquals("5 * (-2) = -10", -10, sut.getState());
	}

	@Test
	public void testMultByPositiveNumber() {
		Calculator sut = new Calculator();
		sut.setState(4);
		sut.mult(3);
		assertEquals("4 * 3 = 12", 12, sut.getState());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddWithOverflow() {
		Calculator sut = new Calculator();
		sut.setState(Integer.MAX_VALUE);
		sut.add(1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMultWithOverflow() {
		Calculator sut = new Calculator();
		sut.setState(Integer.MAX_VALUE);
		sut.mult(2);
	}


	@Test
	public void testSubtractPositiveNumbers() {
		Calculator sut = new Calculator();
		sut.setState(10);
		sut.subtract(5);
		assertEquals("10 - 5 = 5", 5, sut.getState());
	}

	@Test
	public void testSubtractNegativeNumbers() {
		Calculator sut = new Calculator();
		sut.setState(5);
		sut.subtract(10);
		assertEquals("5 - 10 = -5", -5, sut.getState());
	}

	@Test
	public void testDivideByZero() {
		Calculator sut = new Calculator();
		sut.setState(10);
		try {
			sut.divide(0);
		} catch (IllegalArgumentException e) {
			assertEquals("Stan powinien zostać niezmieniony po dzieleniu przez 0", 10, sut.getState());
		}
	}

	@Test
	public void testDividePositiveNumbers() {
		Calculator sut = new Calculator();
		sut.setState(20);
		sut.divide(5);
		assertEquals("20 / 5 = 4", 4, sut.getState());
	}

	@Test
	public void testDivideNegativeNumbers() {
		Calculator sut = new Calculator();
		sut.setState(-20);
		sut.divide(5);
		assertEquals("-20 / 5 = -4", -4, sut.getState());
	}

	@Test
	public void testStoreAndRecallMemory() {
		Calculator sut = new Calculator();
		sut.setState(10);
		sut.storeInMemory(); // Zapisuje 10 w pamięci
		sut.setState(20);
		assertEquals("Zapisana wartość powinna zostać odczytana z pamięci", 10, sut.recallMemory());
	}


	@Test
	public void testAddToMemory() {
		Calculator sut = new Calculator();
		sut.addToMemory(5); // Dodaje 5 do pamięci
		assertEquals("0+5=5", 5, sut.recallMemory());
	}


	@Test
	public void testSubtractFromMemory() {
		Calculator sut = new Calculator();
		sut.addToMemory(10); // Dodaje 10 do pamięci
		sut.subtractFromMemory(3); // Odejmuje 3 od wartości w pamięci
		assertEquals("10-3=7", 7, sut.recallMemory());
	}


	@Test
	public void testMultiplyByMemory() {
		Calculator sut = new Calculator();
		sut.setState(5);
		sut.storeInMemory(); // Zapisujemy wartość 5 w pamięci
		sut.multiplyByMemory(3); // Mnożymy wartość w pamięci (5) przez 3
		assertEquals("5*3=15", 15, sut.getState());
	}

	@Test
	public void testDivideByMemory() {
		Calculator sut = new Calculator();
		sut.setState(20);
		sut.storeInMemory(); // Zapisujemy wartość 20 w pamięci
		sut.divideByMemory(5); // Dzielimy wartość w pamięci (20) przez 5
		assertEquals("20/5=4", 4, sut.getState());
	}
}









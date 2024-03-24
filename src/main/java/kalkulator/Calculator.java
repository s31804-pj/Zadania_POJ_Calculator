package kalkulator;

public class Calculator {
	private int state = 0;
	private int memory = 0;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void add(int value){
		if (value > 0 && state > Integer.MAX_VALUE - value) {
			throw new IllegalArgumentException("Przekroczono maksymalną wartość typu int");
		} else if (value < 0 && state < Integer.MIN_VALUE - value) {
			throw new IllegalArgumentException("Przekroczono minimalną wartość typu int");
		}
		state += value;
	}

	public void subtract(int value){
		if (value > 0 && state < Integer.MIN_VALUE + value) {
			throw new IllegalArgumentException("Przekroczono minimalną wartość typu int");
		} else if (value < 0 && state > Integer.MAX_VALUE + value) {
			throw new IllegalArgumentException("Przekroczono maksymalną wartość typu int");
		}
		state -= value;
	}

	public void mult(int value) {
		if (value > 0 && (state > Integer.MAX_VALUE / value || state < Integer.MIN_VALUE / value)) {
			throw new IllegalArgumentException("Przekroczono maksymalną wartość typu int");
		} else if (value < 0 && (state < Integer.MAX_VALUE / value || state > Integer.MIN_VALUE / value)) {
			throw new IllegalArgumentException("Przekroczono minimalną wartość typu int");
		}
		state *= value;
	}

	public void divide(int value){
		if (value == 0) {
			throw new IllegalArgumentException("Nie można dzielić przez zero");
		}
		if (value == -1 && state == Integer.MIN_VALUE) {
			throw new IllegalArgumentException("Przekroczono minimalną wartość typu int");
		}
		state /= value;
	}

	public void storeInMemory() {
		memory = state;
	}

	public int recallMemory() {
		return memory;
	}

	public void addToMemory(int value) {
		if (value > 0 && memory > Integer.MAX_VALUE - value) {
			throw new IllegalArgumentException("Przekroczono maksymalną wartość typu int");
		} else if (value < 0 && memory < Integer.MIN_VALUE - value) {
			throw new IllegalArgumentException("Przekroczono minimalną wartość typu int");
		}
		memory += value;
	}

	public void subtractFromMemory(int value) {
		if (value > 0 && memory < Integer.MIN_VALUE + value) {
			throw new IllegalArgumentException("Przekroczono minimalną wartość typu int");
		} else if (value < 0 && memory > Integer.MAX_VALUE + value) {
			throw new IllegalArgumentException("Przekroczono maksymalną wartość typu int");
		}
		memory -= value;
	}

	public void multiplyByMemory(int value) {
		if (value > 0 && memory != 0 && (memory > Integer.MAX_VALUE / value)) {
			throw new IllegalArgumentException("Przekroczono maksymalną wartość typu int");
		} else if (value < 0 && memory != 0 && (memory < Integer.MAX_VALUE / value)) {
			throw new IllegalArgumentException("Przekroczono minimalną wartość typu int");
		}
		state = memory * value;
	}

	public void divideByMemory(int value) {
		if (value == 0) {
			throw new IllegalArgumentException("Nie można dzielić przez zero");
		}
		if (value == -1 && memory == Integer.MIN_VALUE) {
			throw new IllegalArgumentException("Przekroczono minimalną wartość typu int");
		}
		state = memory / value;
	}


}

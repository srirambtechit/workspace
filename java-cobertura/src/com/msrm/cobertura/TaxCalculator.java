package com.msrm.cobertura;

public class TaxCalculator {

	private static final float CESS = 2.35f;

	public static float computeTaxAmoute(float salary) {
		if (salary < 250_000)
			return 0;

		float tax = 0;
		salary = salary - 250_000;

		if (0 < salary && salary <= 250_000)
			tax = salary * 5 / 100;
		if (250_000 < salary && salary <= 500_000)
			tax = salary * 10 / 100;
		else if (500_000 < salary && salary <= 1_000_000)
			tax = salary * 20 / 100;
		else if (salary > 1_000_000)
			tax = salary * 30 / 100;

		tax += CESS * tax / 100;
		return tax;
	}

	public static float computeTax(float salary) {
		if (salary <= 250_000)
			return 0;

		float tax = 0;
		salary -= 250_000;

		if (salary > 1_000_000)
			tax = salary * 30 / 100;
		else if (salary > 500_000)
			tax = salary * 20 / 100;
		else if (salary > 250_000)
			tax = salary * 10 / 100;
		else
			tax = salary * 5 / 100;

		tax += CESS * tax / 100;
		return tax;
	}

	public static void main(String[] args) {
		float salary = 750_000;
		System.out.println(computeTaxAmoute(salary));
		System.out.println(computeTax(salary));
	}

}

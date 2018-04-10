package com.philip.first;

public class Simple {
	private int rate;
	private String type;
	public int price;

	public Simple() {
		type = "mid-sized";
		rate = 45;
	}

    public String computeRentalCost(int numDays, String title) {
		price = numDays * rate;
		String retVal = "The cost of your " + type + " car is " + price + " " + title;
		
		return retVal;
	}
}

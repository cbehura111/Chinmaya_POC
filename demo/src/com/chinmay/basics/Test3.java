package com.chinmay.basics;

class Vegetable {

}

class Potato extends Vegetable {
	void prepairFries() {
		System.out.println("crispy fries ready");
	}
}

class Tomato extends Vegetable {
	void prepairSoup() {
		System.out.println("hot soup ready");
	}
}

class VegShop {
	Vegetable sell(String vegName) {
		if (vegName.equals("Potato"))
			return new Potato();
		if (vegName.equals("Tomato"))
			return new Tomato();
		System.out.println(vegName + "not available");
		return null;
	}
}

class Test3 {
	public static void main(String[] args) {
		VegShop shop = new VegShop();
		Vegetable v = shop.sell("Potato");
		((Potato) v).prepairFries();

	}
}
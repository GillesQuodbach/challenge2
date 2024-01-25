/**
 * Explications ici
 * 
 * @author El babili - 2023
 * 
 */

package fr.fms.cars;

public class Car {
	public String brand;				//marque : Renault
	public String type;					//type	: clio	
	public Boolean ct;					//contrôle technique à jour
	public String repair;				//réparation à prévoir : aucune / légère / moyenne / importante
	public double price;				//prix de vente 
	
	private static final double MIN_CAR_PRICE = 1000;
	
	public static void main(String[] args) {
		System.out.println("class Car : " + MIN_CAR_PRICE);
	}
	
	public Car(String b, String type, Boolean ct, String repair, double price) {
		brand = b;
		this.type = type;
		this.ct = ct;
		this.repair = repair;
		this.price = price;
	}

	@Override
	public String toString() {
		return brand + " * " + type + " * " + price + " * " + (ct?"ct ok":"ct nok") + " * " + repair;
	}

	public static double getMinCarPrice() {
		return MIN_CAR_PRICE;
	}	
}
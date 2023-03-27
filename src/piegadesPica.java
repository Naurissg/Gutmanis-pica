

public class piegadesPica extends Order{
	private String adress;
	

	public piegadesPica(String name, String phone, String adress, String size, String[] toppings, String sauce, String dzeriens, double price, boolean delivery) {
		super(name, phone, size, toppings, sauce, dzeriens, price, delivery);
		this.adress = adress;
		
}
	public String getAddress(){
		return adress;
	}
	 public String toString() {
	      String orderDetails = "Vārds: " + getName() + "\nTel:+371 " + getPhone() +  "\nPicas izmers: " + getSize() + "\nPiedevas: ";
	      for (String topping : getToppings()) {
	         orderDetails += topping + ", ";
	      }
	      orderDetails = orderDetails.substring(0, orderDetails.length() - 2); // Noņemt pēdējo komatu un atstarpi
	      orderDetails += "\nMērce: " + getSauce() + "\nDzēriens: " +getDzeriens()+  "\nCena: €" + getPrice()+"\nPiegades adrese: "+getAddress();
	         orderDetails += " (Ar piegādi +2.99€)"+"\n----------------------------------------";
	      return orderDetails;
}
}
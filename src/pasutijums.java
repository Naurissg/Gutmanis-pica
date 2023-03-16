
	class Order {
		   private String name;
		   private String phone;
		   private String address;
		   private String size;
		   private String[] toppings;
		   private String sauce;
		   private double price;
		   private boolean delivery;
		private String dzeriens;
		
	 public Order(String name, String phone, String address, String size, String[] toppings, String sauce, double price, boolean delivery) {
	      this.name = name;
	      this.phone = phone;
	      this.address = address;
	      this.size = size;
	      this.toppings = toppings;
	      this.sauce = sauce;
	      this.dzeriens = dzeriens;
	      this.price = price;
	      this.delivery = delivery;
	   }
	   
	   public String getName() {
	      return name;
	   }
	   
	   public String getPhone() {
	      return phone;
	   }
	   
	   public String getAddress() {
	      return address;
	   }
	   
	   public String getSize() {
	      return size;
	   }
	   
	   public String[] getToppings() {
	      return toppings;
	   }
	   
	   public String getSauce() {
	      return sauce;
	   }
	   
	   public String getDzeriens() {
		      return dzeriens;
	   }
	   public double getPrice() {
	      return price;
	   }
	   
	   public boolean isDelivery() {
	      return delivery;
	   }
	   public void setTalrunis(String telefonaNumurs) {
		    phone = telefonaNumurs;
		}
	   
	   public String toString() {
	      String orderDetails = "Vārds: " + name + "\nTel:+371 " + phone + "\nAdrese: " + address + "\nPicas izmers: " + size + "\nPiedevas: ";
	      for (String topping : toppings) {
	         orderDetails += topping + ", ";
	      }
	      orderDetails = orderDetails.substring(0, orderDetails.length() - 2); // Noņemt pēdējo komatu un atstarpi
	      orderDetails += "\nMērce: " + sauce + "\nDzēriens: " +dzeriens+  "\nCena: €" + price;
	      if (delivery) {
	         orderDetails += " (Ar piegādi +2.99€)"+"\n----------------------------------------";
	      } else {
	         orderDetails += " (Bez piegādes)"+"\n----------------------------------------";
	      }
	      return orderDetails;
	   }
	}

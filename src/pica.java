import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.Comparator;
public class pica {
	   public static void main(String[] args) {
	      //Izveido array lai saglabatu sutijumus
	      Order[] orders = new Order[10];
	      int orderCount = 0;
	      
	    	  String[] izvelnesVarianti = {"Izveidot jaunu pasutijumu", "Apskatīt izveidotas picas","Kārtot picas augošā/dilstošā secībā pēc cenas","Nodot picu klientam", "Iziet no programmas"};
	    	String izvelesVariantuNosaukumi;
	   
	   do{
		   izvelesVariantuNosaukumi = (String) JOptionPane.showInputDialog(null, "Izvēlieties darbību:", "Sveicināts čili pica",
		    	            JOptionPane.PLAIN_MESSAGE, null, izvelnesVarianti, izvelnesVarianti[0]);
		    	
		switch(izvelesVariantuNosaukumi){  
		case"Izveidot jaunu pasutijumu":       
	         // pajauta lietoajam kontakta informaciju
	         String name = JOptionPane.showInputDialog("Ievadiet klienta vardu:");
	         String phone;
	         do {
	         phone = JOptionPane.showInputDialog("Ievadiet telefona nummuru (8 cipari):");
	         } while (phone.length() != 8);
	    
	         String address = JOptionPane.showInputDialog("Ievadiet savu adresi:");
	         boolean delivery = JOptionPane.showConfirmDialog(null, "Vai vē"
	         		+ "laties saņemt piegādi?\nCena par piegādi ir (2.99€)", "Delivery", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
	         
	         // pajauta lietoajam ievadit picas izmeru
	         String[] sizes = {"Maza", "Videja", "Lielā"};
	         String size = (String) JOptionPane.showInputDialog(null, "Izvelieties picas izmēru:\nMaza 5.99 Eur\nVideja 7.99 Eur\nLielā 9.99 Eur", "Picas izmērs", JOptionPane.PLAIN_MESSAGE, null, sizes, sizes[0]);
	         
	         // pajauta lietotajam picu piedevas
	         String[] toppings = {"Peperoni", "Sēnes", "Sīpoli", "desa", "Bekons", "Extra siers"};
	         String selectedToppings = (String) JOptionPane.showInputDialog(null, "Izvēlieties picas piedevas:\nCena par jebkuru piedevu ir 0.99 Eur", "Picas piedevas", JOptionPane.PLAIN_MESSAGE, null, toppings, null);
	         String[] selectedToppingsArray = selectedToppings.split(",");
	         
	         // pajauta lietotajam ievadi picu merci
	         String[] sauces = {"Kečups", "BBQ", "Saldskābā", "Islandes", "Majonēze", "Ķiploku"};
	         String selectedSauce = (String) JOptionPane.showInputDialog(null, "Izvēlieties picas mērci:\nCena par jebkuru mērci ir 0.99 Eur", "Picas mērces", JOptionPane.PLAIN_MESSAGE, null, sauces, sauces[0]);
	         
	         //pajauta lietotajam ievadi dzerienu
	         String[] dzeriens = {"Cola", "Sprite", "Pepsi", "Apelsinu sula", "Tomatu sula", "Fanta"};
	         String izveletaisDzeriens = (String) JOptionPane.showInputDialog(null, "Izvēlieties papildus 0.5l dzērienu:\nCena par jebkuru Dzērienu ir 1 Eur", "Dzērienu izvēle", JOptionPane.PLAIN_MESSAGE, null, dzeriens, dzeriens[0]);
	         String[] izveletaisDzeriensArray = izveletaisDzeriens.split(",");
	         // apreķina pirkuma cenu pec lieluma, piedevam un dzēriena
	         double price = 0.0;
	         if (size.equals("Maza")) {
	            price += 5.99;
	         } else if (size.equals("Videja")) {
	            price += 7.99;
	         } else if (size.equals("Lielā")) {
	            price += 9.99;
	         }
	         price += selectedToppingsArray.length * 0.99;
	         price += izveletaisDzeriensArray.length * 1.99;
	         // Pievieno sutišanas izmaksas ja tiek izveleta piegade
	         if (delivery) {
	            price += 2.99;
	         }
	         
	         // Izveidot jaunu pasūtījuma objektu un pievienot to masīvā
	         orders[orderCount] = new Order(name, phone, address, size, selectedToppingsArray, selectedSauce, price, delivery);
	         orderCount++;
	    break;
		
		 case "Nodot picu klientam":
			   int deleteIndex = Integer.parseInt(JOptionPane.showInputDialog(null, "Ievadiet pasūtījuma indeksu (0-" + (orderCount-1) + "):"));
			// Pārvieto visus turpmākos pasūtījumus masīvā par vienu indeksu pa labi
			for (int i = deleteIndex; i < orderCount - 1; i++) {
			orders[i] = orders[i+1];
			}
			// Iestatata pirmo masīva elementu uz nulli
			orders[orderCount-1] = null;
			// Samazina pasūtījumu skaitu
			orderCount--;
			JOptionPane.showMessageDialog(null, "Pasūtījums ir veiksmīgi Nodots klientam!", "Dzēst pasūtījumu", JOptionPane.PLAIN_MESSAGE);
			break;
			
			//sakārto picas augoša seciba pec cenas
		   case "Kārtot picas augošā/dilstošā secībā pēc cenas":
			    // pajauta lietotājam, kārtot augoši vai dilstoši
			    String[] sortOptions = {"Augoši", "Dilstoši"};
			    String sortOrder = (String) JOptionPane.showInputDialog(null, "Kārtot picas augošā vai dilstošā secībā pēc cenas:", "Kārtot pēc cenas", JOptionPane.PLAIN_MESSAGE, null, sortOptions, sortOptions[0]);
			    
			    // izveido kopiju saraksta, lai nesabojātu oriģinālo sarakstu
			    Order[] sortedOrders = Arrays.copyOf(orders, orderCount);
			    
			    // izmanto Arrays.sort metodi, lai sakārtotu sarakstu pēc cenas
			    if (sortOrder.equals("Augoši")) {
			        Arrays.sort(sortedOrders, new Comparator<Order>() {
			            public int compare(Order o1, Order o2) {
			                return Double.compare(o1.getPrice(), o2.getPrice());
			            }
			        });
			    } else {
			        Arrays.sort(sortedOrders, new Comparator<Order>() {
			            public int compare(Order o1, Order o2) {
			                return Double.compare(o2.getPrice(), o1.getPrice());
			            }
			        });
			    }
			    
			    // izvada sakārtoto sarakstu
			    StringBuilder sb = new StringBuilder();
			    for (Order o : sortedOrders) {
			        sb.append(o.toString());
			        sb.append("\n\n");
			    }
			    JOptionPane.showMessageDialog(null, sb.toString(), "Sakārtotas picas", JOptionPane.PLAIN_MESSAGE);
			    break;
		}
	   }
import javax.swing.JOptionPane;
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
		}
	   
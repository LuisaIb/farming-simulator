package machines;

public class Tank{
	 
	int tankvolumen;
    int benzinstand;
    int verbrauch;
    int fields;

    public Tank(int benz, int fields)
    {  
        tankvolumen = 150;
        benzinstand = benz;

    }
    
    public int Tanken(int liter)
    {
        int differenz = tankvolumen - benzinstand;
        if(liter <= differenz)
        {
            benzinstand = benzinstand + liter;
            int zaehler = 0;
            while (zaehler < liter)
            {
                System.out.print("*");
                try 
                {
                    Thread.sleep(1000);
                } 
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                } 
                zaehler++;
            }
            System.out.println("");
            System.out.println("Sie haben " +liter +" Liter getankt.");
            System.out.println("Ihr Benzinstand beträgt nun " +benzinstand +" Liter.");
            System.out.println("");
        }
        if(liter > differenz)
        {
            benzinstand = benzinstand + differenz;
            int zaehler = 0;
            while (zaehler < differenz)
            {
                System.out.print("*");
                try 
                {
                    Thread.sleep(1000);
                } 
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                } 
                zaehler++;
            }
            System.out.println("");
            System.out.println("Brechen Sie den Tankvorgang ab!");
            System.out.println("Sie haben " +differenz +" Liter getankt.");
            System.out.println("Ihr Tank ist voll.");
            System.out.println("");
        }
    }
    
    public int consumption(int fields, int liter) {
    	for(int i=0; i<=150 && i>=0; i--) {
    		
    }
    
    public void move(int fields)
    {
        int verb;
        benzinstand = benzinstand - verb;
        if((benzinstand <= 10)&&(benzinstand > 0))
        {
            System.out.println("Sie haben noch maximal 10 Liter Benzin.");
            System.out.println("Tanken Sie bitte ihr Fahrzeug auf!");
            System.out.println("");
        }
        if(benzinstand == 0)
        {
            System.out.println("Ihr Tank ist leer.");
        }
    }
}
}


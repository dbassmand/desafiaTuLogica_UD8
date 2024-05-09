package progUD8.RetoUD8;

public class App 
{
    public static void main( String[] args )
    {
        DatabaseManager miBBDD = new DatabaseManager();
                             	
    	MenuOpcion miMenu = new MenuOpcion(miBBDD);    	    	
    	
    	miMenu.muestraMenu();
    	
    }
}

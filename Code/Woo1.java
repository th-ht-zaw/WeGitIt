import cs1.Keyboard;

//Driver
public class Woo {

    //instance vars
    private static final String[] _tealist = new String[10]; //may not be final if user adds tea, list of teas
    private static String[] _choices = {"white","green","black","oolong",
					"herbal","digestion",
					"relaxation","nausea","sleep",
					"awake","skin","immune",
					"heart","circulation",
					"metabolism"};

    private String[] _teachoices; //

    //Default constructor
    public Woo() {
	_teachoices = new String[10];
    }
    
    //Methods
    public void Narrow (String sF) {
	//implementation	
    }

    public void populate() {
	//implementation
    }

    public String toString(){
	return "";
	//prints out Array TeaChoices
    }
    /*
      public void playIter() {
      while ( true ) {
      System.out.println("Pick a symptom:");
      for(choice : _choices)
      System.out.println(choice);
      }
      }
    
      public void play() {
      playIter();
      }
    */

    //Search (binary)
    public static String[] searchTeas(Tea teas, String sF) {
	String[] a = {"You","are","mistaked"};
	int lo = 0;
	int med = 0;
	int hi = teas._sizeY - 1;
	while ( lo <= hi ) {
	    med = (lo + hi) / 2;	    
	    int x = (teas.get(med,0)).compareTo(sF);
	    if (x == 0)
		return teas.get(med);
	    else if (x > 0)
		hi = med - 1;
	    else
		lo = med + 1;
	}
	return a;
    }

    public static boolean hasA(String str, String[] strArr) {
	for (int i = 0 ; i < strArr.length ; i++ ) {
	    if (str.equals(strArr[i])) {
		return true;
	    }
	}
	return false;
    }
    /*

    public static void trimsF(String[] teas, Tea example) {
	String[] newChoices = new String[15];
	for (int i = 0 ; i < teas.length ; i++ ) {
	    for (int j = 0 ; j < _choices.length ; j++ ) {
		if ( hasA(teas[i] , example.locate(_choices[j] ) ) ) {
		    if ( ! (hasA (_choices[j] , newChoices ) ) ) {
			newChoices[i] = _choices[j];
		    }
		}
	    }
	}
	for (int z = 0 ; z < newChoices.length ; z++ ) {
	    if ( newChoices[z] == null ) {
		newChoices[z] = "a";
	    }
	}
	_choices = newChoices;
    } 
    */
    
    //main
    public static void main (String[] args) {
	Tea table = new Tea();
	table.populate();
	table.sort();

	//while (true) {
	String choice;
	
	System.out.println("Pick a symptom:");
	for( int i = 0; i < _choices.length; i++ )
	    System.out.println(_choices[i]);
	choice = Keyboard.readString();
	System.out.println(choice);
	String[] row = searchTeas(table, choice);
	for( int i = 1; i < Tea.size(row); i++ )
	    System.out.print(row[i] + ", ");
	System.out.println("\n");
	System.out.println(hasA("white" , _choices ));
	System.out.println(hasA("silver_needle" , row) ); 
	/*
	trimsF(row, table);
       	for( int i = 0; i < _choices.length; i++ )
	    System.out.println(_choices[i]);
	//}
	*/
    }

}//end

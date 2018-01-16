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

    private static String[] _teachoices = {"assam", "chamomile" , "darjeeling" , "keemun" , "sencha" , "silver_needle" ,
					   "matcha" , "ginger" , "ginseng" , "peppermint" , "bai_mudan" ,
					   "water_sprite" , "high_mountain" , "puerh" };

    private static boolean isPlaying = true; 

    //Default constructor
    /*
      public Woo() {
      _teachoices = new String[10];
      }
    */ //Doubt we need this. 
    
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
	for (int i = 0 ; i < Tea.size(strArr) ; i++ ) {
	    if (str.equals(strArr[i])) {
		return true;
	    }
	}
	return false;
    }

    public static void trims(String[] teas, Tea Table) {
	String[] newChoices = new String[15];
	for (int i = 0; i < Tea.size(teas); i++)
	    for(int j = 0; j < Tea.size(_choices); j++)
		if (hasA(teas[i], Table.locate(_choices[j])))
		    if ( ! (hasA (_choices[j] , newChoices ) ) )
			add(newChoices, _choices[j]);
	_choices = newChoices;	
    }

    public static void trimTea(String[] teas) {
	String[] newChoices = new String[15];
	for (int i = 0 ; i < Tea.size(_teachoices) ; i++ ) {
	    if ( hasA( _teachoices[i] , teas ) ) {
		add(newChoices , _teachoices[i]);
	    }
	}
	_teachoices = newChoices;
    } 

    private static void expand(String[] arr)
    {
	String[] temp = new String[ arr.length * 2 ];

	for( int i = 0; i < arr.length; i++ )
	    temp[i] = arr[i];

	arr = temp;
    }

    
    public static void add(String[] arr, String str )
    {
	//first expand if necessary
	if ( Tea.size(arr) >= arr.length )
	    expand(arr);

        arr[Tea.size(arr)] = str;
    }
    
    
    //main
    public static void main (String[] args) {
	Tea table = new Tea();
	table.populate();
	table.sort();

	while (isPlaying) {
	    final String ANSI_CLS = "\u001b[2J";
	    final String ANSI_HOME = "\u001b[H";
	    System.out.print(ANSI_CLS + ANSI_HOME);
	    System.out.flush();
	    String choice;

	    System.out.println("Current Tea Choices: ");
	    for( int i = 0; i < Tea.size(_teachoices) ; i++ )
		System.out.print(_teachoices[i] + ", ");

	    System.out.println("\n");
	    
	    System.out.println("Pick a trait: ");
	    for( int i = 0; i < Tea.size(_choices); i++ )
		System.out.print(_choices[i] + ", ");

	    System.out.println("\n");
	    
	    choice = Keyboard.readString();
	    System.out.println("\nYour choice: " + choice);
	    
	    String[] row = searchTeas(table, choice);
	
	    trims(row, table);
	    trimTea(row);

	    System.out.println("\nCurrent Tea Choices: ");
	    for (int i = 0; i < Tea.size(_teachoices) ; i++ )
		System.out.print(_teachoices[i] + ", ");

	    System.out.println("\n");
	    System.out.println("\nDo you want to keep playing?");
	    System.out.println("\nType 0 for yes or type 1 for no" + "\n");

	    int selection;
	    selection = Keyboard.readInt();
	    if (selection == 1) {
		isPlaying = false;
	    }

	    if (selection > 1 || selection < 0) {
		System.out.println("Invalid input. Exiting by default.");
		isPlaying = false;
	    }

	    System.out.println("\n");
	}
	for (String tea : _teachoices) {
	    Database.printinformation(tea);
	    System.out.println();
	}
    }

}//end

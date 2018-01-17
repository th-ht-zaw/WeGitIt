import cs1.Keyboard;

//Driver
public class Woo {

    //instance vars
    private static final String[] _tealist = new String[10];
    //may not be final if user adds tea, list of teas
    private static String[] _choices = {"white","green","black","oolong","herbal",
					"digestion","relaxation","nausea","sleep",
					"awake","skin","immune","heart","circulation",
					"metabolism"};

    private static String[] _teachoices = {"assam", "chamomile", "darjeeling", "keemun", "sencha",
					   "silver_needle", "matcha", "ginger", "ginseng", "peppermint",
					   "bai_mudan", "water_sprite", "high_mountain", "puerh" };

    private static String[] selections = new String[15];

    private static boolean isPlaying = true;
    
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

    //hasA: returns true if the array has that string
    //      otherwise it returns false
    public static boolean hasA(String str, String[] strArr) {
	for (int i = 0 ; i < Tea.size(strArr) ; i++ ) {
	    if (str.equals(strArr[i])) {
		return true;
	    }
	}
	return false;
    }

    //trims
    public static void trims(String[] teas, Tea Table) {
	String[] newChoices = new String[15];
	for (int i = 0; i < Tea.size(teas); i++)
	    for(int j = 0; j < Tea.size(_choices); j++)
		if (hasA(teas[i], Table.locate(_choices[j])))
		    if ( ! (hasA (_choices[j] , newChoices ) ) )
			add(newChoices, _choices[j]);
	_choices = newChoices;	
    }

    //trimTea
    public static void trimTea(String[] teas) {
	String[] newChoices = new String[15];
	for (int i = 0 ; i < Tea.size(_teachoices) ; i++ ) {
	    if ( hasA( _teachoices[i] , teas ) ) {
		add(newChoices , _teachoices[i]);
	    }
	}
	_teachoices = newChoices;
    } 

    //expand
    private static void expand(String[] arr)
    {
	String[] temp = new String[ arr.length * 2 ];

	for( int i = 0; i < arr.length; i++ )
	    temp[i] = arr[i];

	arr = temp;
    }


    //add
    public static void add(String[] arr, String str )
    {
	//first expand if necessary
	if ( Tea.size(arr) >= arr.length )
	    expand(arr);

        arr[Tea.size(arr)] = str;
    }
    
    
    //main
    public static void main (String[] args) {

	//populates the 2D array
	Tea table = new Tea();
	table.populate();
	table.sort();
	
	while (isPlaying) {
	    
	    //clears the terminal
	    final String ANSI_CLS = "\u001b[2J";
	    final String ANSI_HOME = "\u001b[H";
	    System.out.print(ANSI_CLS + ANSI_HOME);
	    System.out.flush();
	    
	    
	    String choice;

	    System.out.println("CURRENT TEA CHOICES: ");
	    for( int i = 0; i < Tea.size(_teachoices); i++ )
		System.out.print(_teachoices[i] + "  ");

	    System.out.println("\n");

	    //Prints out a list of what traits the user can choose from
	    System.out.println("YOUR SELECTIONS: ");
	    for( int i = 0; i < Tea.size(selections); i++ )
		System.out.print(selections[i] + "  ");

	    System.out.println("\n");

	    //Prompts the user to select a trait
	    System.out.println("PICK A TEA FAMILY OR A SYMPTOM (type your selection at the cursor): ");
	    System.out.println("*******************************************************");
	    System.out.print("TEA FAMILIES: ");
	    for( int i = 0; i < 5; i++ )
		System.out.print(_choices[i] + "  ");
	    System.out.print("\nSYMPTOMS: ");
	    for( int i = 5; i < Tea.size(_choices); i++ )
		System.out.print(_choices[i] + "  ");

	    System.out.println("\n");
	    
	    choice = Keyboard.readString().toLowerCase();

	    //in the case of an invalid input
	    if (! (hasA(choice, _choices) ) ) {
		System.out.println("Invalid input. Try again.");
		continue;
	    }

	    //adds what the user picked to an array of what the user has picked
	    add(selections, choice);
	    System.out.println("\nYOUR CHOICE: " + choice);


	    String[] row = searchTeas(table, choice);
	    
	    trims(row, table);
	    trimTea(row);

	    //prints out what teas fit the users criteria so far
	    System.out.println("\nCURRENT TEA CHOICES: ");
	    for (int i = 0; i < Tea.size(_teachoices) ; i++ )
		System.out.print(_teachoices[i] + "  ");

	    //asks the user whether or not to continue
	    System.out.println("");
	    System.out.println("\nDo you want to select more traits?");
	    System.out.println("\nType 0 for yes or type 1 for no" + "\n");
	    

	    int selection;
	       
	    outer: while (true) {
		selection = Keyboard.readInt();
		if (selection == 1) {
		    isPlaying = false;
		    break outer;
		}
	        
		else if (selection > 1 || selection < 0) {
		    System.out.println("Invalid input. Type 0 for yes or type 1 for no.");
		    continue outer;
		}
		
		else
		    break outer;
		
	    }

	    System.out.println("\n");
	}
	//print out information
	final String ANSI_CLS = "\u001b[2J";
	final String ANSI_HOME = "\u001b[H";
	System.out.print(ANSI_CLS + ANSI_HOME);
	System.out.flush();
	for (int i = 0; i < Tea.size(_teachoices); i++) {
	    Database.printinformation(_teachoices[i]);
	    System.out.println();
	}
    }
}//end

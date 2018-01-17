/*
- Driver class
- Contains: 
  - searchTeas
  - hasA
  - trims
  - trimTea
  - expand
  - add
  - printInfo()
  - playSelection()
  - playStats()
  - play()
 */

import cs1.Keyboard;

//Driver
public class Woo {

    //INSTANCE VARS
    private static final String[] _tealist = new String[10];
    //may not be final if user adds tea, list of teas

    //_choicesF - final symptom/flavor choices
    private static final String[] _choicesF = {"white","green","black","oolong","herbal",
					"indigestion","stress","nausea","insomnia",
					"exhaustion","bad_skin","immunodeficiency","cardiac_disease","poor_circulation",
					"slow_metabolism"};


    //_teaChoicesF - final tea choices
    private static final String[] _teachoicesF = {"assam", "chamomile", "darjeeling", "keemun", "sencha",
					   "silver_needle", "matcha", "ginger", "ginseng", "peppermint",
					   "bai_mudan", "water_sprite", "high_mountain", "puerh" };

    //_choices - symptom/flavor choices
    private static String[] _choices = {"white","green","black","oolong","herbal",
					"indigestion","stress","nausea","insomnia",
					"exhaustion","bad_skin","immunodeficiency","cardiac_disease","poor_circulation",
					"slow_metabolism"};

    //_teachoices - tea choices
    private static String[] _teachoices = {"assam", "chamomile", "darjeeling", "keemun", "sencha",
					   "silver_needle", "matcha", "ginger", "ginseng", "peppermint",
					   "bai_mudan", "water_sprite", "high_mountain", "puerh" };

    private static String[] selections; //what the user has already entered

    private static boolean isPlaying = true; //is tea search activity chosem?

    private static boolean wantsInfo = true; //does the user want tea info printed out?

    private static boolean stats = true; //is health stats activity chosen?

    private static boolean game = true; //is user still in game?


    //METHODS
    //Binary search through the String[] of teas
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

    //trims: trims _choices based on user input
    public static void trims(String[] teas, Tea Table) {
	String[] newChoices = new String[15];
	for (int i = 0; i < Tea.size(teas); i++)
	    for(int j = 0; j < Tea.size(_choices); j++)
		if (hasA(teas[i], Table.locate(_choices[j])))
		    if ( ! (hasA (_choices[j] , newChoices ) ) )
			add(newChoices, _choices[j]);
	_choices = newChoices;	
    }

    //trimTea: trims _teaChoices based on what symptom/flavor user inputs
    public static void trimTea(String[] teas) {
	String[] newChoices = new String[15];
	for (int i = 0 ; i < Tea.size(_teachoices) ; i++ ) {
	    if ( hasA( _teachoices[i] , teas ) ) {
		add(newChoices , _teachoices[i]);
	    }
	}
	_teachoices = newChoices;
    } 

    //expand - doubles length of a String array
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

    //Tea info printer
    public static void printInfo() {
	if (wantsInfo) {
	    //clears the terminal
	    final String ANSI_CLS = "\u001b[2J";
	    final String ANSI_HOME = "\u001b[H";
	    System.out.print(ANSI_CLS + ANSI_HOME);
	    System.out.flush();
	    for (int i = 0; i < Tea.size(_teachoices); i++) {
		Database.printinformation(_teachoices[i]);
		System.out.println("\n");
	    }
	}
    }

    //Flavor and Symptom Selection Loop
    public static void playSelection() {
	//populates the 2D array
	Tea table = new Tea();
	table.populate();
	table.sort();

	selections = new String[15];
	
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
	    System.out.println("**********************************************************************");
	    for( int i = 0; i < Tea.size(_choices); i++ )
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
	}

	if (! stats) {
	    //asks the user whether or not to continue
	    System.out.println("");
	    System.out.println("\nDo you want to see information about your teas?");
	    System.out.println("\nType 0 for yes or type 1 for no" + "\n");
	
	    int yesNo;
	       
	    outer: while (true) {
		yesNo = Keyboard.readInt();
		if (yesNo == 1) {
		    wantsInfo = false;
		    break outer;
		}
	        
		else if (yesNo > 1 || yesNo < 0) {
		    System.out.println("Invalid input. Type 0 for yes or type 1 for no.");
		    continue outer;
		}
		
		else
		    break outer;
		
	    }
	    System.out.println("\n");
	    printInfo();
        }
    }


    //Health Stats Activity
    public static void playStats() {

	if (stats) {

	    //clears the terminal
	    final String ANSI_CLS = "\u001b[2J";
	    final String ANSI_HOME = "\u001b[H";
	    System.out.print(ANSI_CLS + ANSI_HOME);
	    System.out.flush();
	    
	    System.out.println("ENTER YOUR STATS:\n");

	    System.out.println("SEX (type male or female):");
	    String sex;
	    outer: while (true) {
		String[] sexes = {"male","female"};
		sex = Keyboard.readString().toLowerCase();
		if (! (hasA(sex, sexes) ) ) {
		    System.out.println("Invalid input. Type male or female.");
		    continue;
		}
		else
		    break outer;
	    }

	    int age;
	    outer: while (true) {
		System.out.println("AGE:");
		age = Keyboard.readInt();
		if (! (age > 0 && age < 150) ) {
		    System.out.println("Invalid input. Type appropriate age.");
		    continue;
		}
		else
		    break outer;
	    }

	    int weight;
	    outer: while (true) {
		System.out.println("WEIGHT (to nearest pound):");
		weight = Keyboard.readInt();
		if (! (weight > 0 && weight < 2000) ) {
		    System.out.println("Invalid input. Type appropriate weight.");
		    continue;
		}
		else
		    break outer;
	    }

	    int height;
	    outer: while (true) {
		System.out.println("HEIGHT (to nearest inch):");
		height = Keyboard.readInt();
		if (! (height > 0 && height < 150) ) {
		    System.out.println("Invalid input. Type appropriate height.");
		    continue;
		}
		else
		    break outer;
	    }

	    int exercise;
	    outer: while (true) {
		System.out.println("ACTIVITY LEVEL (enter corresponding number:");
		System.out.print("1: Little or no exercise\n2: Light Exercise/sports 1-3 days/week\n3: Medium Exercise/sports 3-5 days/week\n4: Hard Exercise/sports 6-7 days/week\n5: Intense exercise/sports, physical job or twice/day training\n");
		exercise = Keyboard.readInt();
		if (! (exercise == 1 || exercise == 2 || exercise == 3 || exercise
		       == 4 || exercise == 5) ) {
		    System.out.println("Invalid input. Type a number from 1-5.");
		    continue;
		}
		else
		    break outer;
	    }

	    int pounds;
	    outer: while (true) {
		System.out.println("POUNDS YOU'D LIKE TO LOSE:");
		pounds = Keyboard.readInt();
		if (! (pounds >= 0 && pounds < weight) ) {
		    System.out.println("Invalid input. Type an appropriate goal.");
		    continue;
		}
		else
		    break outer;
	    }

	    int bmi = Calculator.BMI( weight, height );
	    int bmr = Calculator.BMR( sex, age, weight, height );
	    
	    System.out.print("BMI: ");
	    System.out.println(bmi);
	    System.out.print("BMI RANGE: ");
	    System.out.println( Calculator.BMIRange( bmi ) );
	    System.out.print("BMR: ");
	    System.out.println(bmr);
	    System.out.print("DAILY CALORIE INTAKE: ");
	    System.out.println( Calculator.calIntake( bmr, exercise ) );
	    System.out.print("HOW MANY DAYS OF TEA-DRINKING TO LOSE " + pounds + " POUNDS (at 2.5 cups of tea per day): ");
	    System.out.println( Calculator.days( pounds ) );
	}
    }

    //play
    public static void play() {
	
	//clears the terminal
	final String ANSI_CLS = "\u001b[2J";
	final String ANSI_HOME = "\u001b[H";
	System.out.print(ANSI_CLS + ANSI_HOME);
	System.out.flush();
	
	System.out.println("Would you like to get your health stats/lose weight or relieve your ailments? \nType 0 to get health stats and/or develop a tea weight-loss plan. \nType 1 to relieve your ailments with tea.");

        int selection;
	       
	outer: while (true) {
	    selection = Keyboard.readInt();
	    if (selection == 1) {
		stats = false;
		break outer;
	    }
	        
	    else if (selection > 1 || selection < 0) {
		System.out.println("Invalid input. Type 0 for yes or type 1 for no.");
		continue outer;
	    }
		
	    else
		isPlaying = false;
	    break outer;
		
	}
	playStats();
	playSelection();
    }
    
    //main
    public static void main (String[] args) {
	outer: while (game) {
	    _teachoices = _teachoicesF;
	    _choices = _choicesF;
	    isPlaying = true;
	    stats = true;
	    play();
	    System.out.println("PLAY AGAIN? If yes, type 0. If no, type 1.");
	    int toPlay;
	    inner: while (true) {
		toPlay = Keyboard.readInt();
		if (! (toPlay == 0 || toPlay == 1) ) {
		    System.out.println("Invalid input. Type 0 or 1.");
		    continue;
		}
		else if (toPlay == 0)
		    break inner;
		else
		    break outer;
	    }
	    
	}
    }
}//end

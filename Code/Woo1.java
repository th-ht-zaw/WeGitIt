import cs1.Keyboard;

//Driver
public class Woo1 {

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
    public Woo1() {
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
    public static String[] searchTeas(Tea1 teas, String sF) {
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
	for (int i = 0 ; i < Tea1.size(strArr) ; i++ ) {
	    if (str.equals(strArr[i])) {
		return true;
	    }
	}
	return false;
    }

    public static void trims(String[] teas, Tea1 Table) {
	String[] newChoices = new String[15];
	for (int i = 0; i < Tea1.size(teas); i++)
	    for(int j = 0; j < Tea1.size(_choices); j++)
		if (hasA(teas[i], Table.locate(_choices[j])))
		    if ( ! (hasA (_choices[j] , newChoices ) ) )
			add(newChoices, _choices[j]);
	_choices = newChoices;	
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
	if ( Tea1.size(arr) >= arr.length )
	    expand(arr);

        arr[Tea1.size(arr)] = str;
    }
    
    
    //main
    public static void main (String[] args) {
	Tea1 table = new Tea1();
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
	
	trims(row, table);
       	for( int i = 0; i < Tea1.size(_choices); i++ )
	    System.out.println(_choices[i]);
	//}
	
    }

}//end

public class Tea {

    //Instance Variables
    public String[][] _data; //will hardcode symFlav
    protected int _sizeY;
    
    //Default Constructor
    public Tea() {
	_data = new String[10][10];
	_sizeY = 0;
    }

    //toString()
    public String toString() {
	String str = "";
	for( int i = 0; i < _sizeY; i++ ) {
	    for( int x = 0; x < size(_data[i]); x++ )
		str += _data[i][x] + ", ";
	    str += "\n";
	}
	return str;
    }
    
    //Methods
    //populate (combines all helper methods
    public void populate() {
	String[] traits = { "white", "green", "black", "oolong", "herbal" ,
			    "indigestion", "stress", "nausea", "insomnia",
			    "exhaustion" , "bad_skin" , "immunodeficiency" ,"cardiac_disease" ,
			    "poor_circulation", "slow_metabolism" };
	for (int i = 0; i < traits.length ; i++ ) {
	    String arr[] = {traits[i]};
	    addArr(arr);
	}

	//Adding assam
	add("black", "exhaustion" , "bad_skin" , "cardiac_disease", "slow_metabolism",  "assam");
	add("exhaustion", "poor_circulation" , "indigestion" , "assam");
	
	//Adding chamomile
	add("herbal", "stress", "indigestion" , "insomnia", "nausea", "chamomile");

	//Adding darjeeling
	add("black" , "indigestion" , "exhaustion" , "cardiac_disease" , "slow_metabolism" , "darjeeling" );

	//Adding keemun
	add("black" , "indigestion" , "exhaustion" , "cardiac_disease" , "slow_metabolism" , "keemun" );

	//Adding sencha
	add("green" , "stress" , "immunodeficiency" , "sencha" );
	add( "slow_metabolism" , "sencha" ); 

	//Adding silver needle
	add("white" , "indigestion", "exhaustion" , "silver_needle" );
	add("immunodeficiency" , "cardiac_disease" , "slow_metabolism" , "silver_needle" );

	//Adding matcha
	add("green" , "bad_skin" , "stress" , "matcha");
	add("immunodeficiency" , "matcha");

	//Adding ginger
	add("herbal" , "nausea" , "immunodeficiency" , "cardiac_disease" , "poor_circulation" , "ginger" );
	add("slow_metabolism" , "ginger" );

	//Adding ginseng
	add("herbal" , "indigestion" , "stress" , "bad_skin" , "slow_metabolism" , "ginseng");

	//Adding peppermint
	add("herbal" , "insomnia" , "indigestion" , "stress" , "nausea" , "peppermint" );
	add("immunodeficiency" , "peppermint");
	add("slow_metabolism", "peppermint");

	//Adding bai mudan
	add("white", "immunodeficiency" , "cardiac_disease" , "bai_mudan");

	//Adding water sprite
	add("oolong" , "stress" , "exhaustion" , "immunodeficiency" , "cardiac_disease" , "water_sprite" );

	//Adding high mountain
	add("oolong" , "stress" , "immunodeficiency" , "high_mountain");
	add("cardiac_disease" , "high_mountain");

	//Adding puerh
	add("indigestion" , "exhaustion" , "cardiac_disease" , "puerh" ); 
    }
    
    //size(): returns the size if the array
    public static int size(String[] arr){
	int ct = 0;
	for(int i = 0; i < arr.length; i++) {
	    if (arr[i] == null)
		return ct;
	    ct += 1;
	}
	return ct;
    }
    
    //addArrL: adds a row into the 2D array
    public void addArr(String[] newArr){
	if (_data.length <= _sizeY)
	    expandY();

	_data[_sizeY] = newArr;
	_sizeY += 1;
    }

    //add tea to row
    public void add(String symFlav, String tea){
	int index = 0;
	for( int i = 0; i < _data.length; i++ )
	    if (_data[i][0].equals(symFlav)) {
		index = i;
		break;
	    }
	if ( _data[index].length <= size(_data[index]) )
	    expandX(index);
	_data[index][size(_data[index])] = tea;
    }

    
    //Overloaded Add version 1
    public void add(String symFlav1, String symFlav2,
		    String symFlav3, String tea){
	add(symFlav1, tea);
	add(symFlav2, tea);
	add(symFlav3, tea);
    }

    //Overloaded Add version 2
    public void add(String symFlav1, String symFlav2,
		    String symFlav3, String symFlav4,
		    String symFlav5, String tea) {
	add(symFlav1, tea);
	add(symFlav2, tea);
	add(symFlav3, tea);
	add(symFlav4, tea);
	add(symFlav5, tea); 
 
    }
    
    //ExpandX
    private void expandX(int row){
	String[] temp = new String[ _data[row].length * 2 ];

	for( int i = 0; i < _data[row].length; i++ )
	    temp[i] = _data[row][i];

	_data[row] = temp;
    }

    //ExpandY
    private void expandY(){
	String[][] temp = new String[ _data.length * 2 ][ _data[0].length ];

	for( int i = 0; i < _data.length; i++ ) {
	    if ( size(_data[i]) > _data[0].length )
		expandX(i);
	    for( int x = 0; x < _data[i].length; x++ )
		temp[i][x] = _data[i][x];	
	}
	_data = temp;
    }
    
    //get: returns the array at the designated row
    public String[] get( int row ) {
	return _data[row];
    }

    //Overloaded get
    public String get( int row, int col ) {
	return _data[row][col];
    }
    
    //set
    public String[] set( int index, String[] newVal ) {
	String[] temp = _data[index];
	_data[index] = newVal;
	return temp;
    }
    
    //sort: sorts based on alphabetical order
    public void sort() {
	for( int i = 1; i < _sizeY; i++ ) {
	    for( int x = i; x > 0; x-- ) {
		if ( _data[x][0].compareTo( _data[x-1][0] ) < 0 ) {
		    String[] temp = _data[x];
		    _data[x] = _data[x-1];
		    _data[x-1] = temp;
		}
		else 
		    break; 
	    }
	}
    }

    //locate (basically get but with Strings)
    public String[] locate(String symFlav) {
	for (int i = 0 ; i < _sizeY ; i++ ) {
	    if (symFlav.equals(_data[i][0])) {
		return _data[i];
	    }
	}
	System.out.println("Error: Trait does not exist");
	return _data[1]; //Just for the code to work
    }
    
    //main for testing
    public static void main (String[] args) {
	Tea teas = new Tea();
	teas.populate();
	teas.sort();
	System.out.println(teas);

	for (int i = 0 ; i < size(teas.locate("indigestion")) ; i++ ) {
	    System.out.println(teas.locate("indigestion")[i]);
	}

    }
}

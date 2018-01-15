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
			    "digestion", "relaxation", "nausea", "sleep",
			    "awake" , "skin" , "immune" ,"heart" ,
			    "circulation", "metabolism" };
	for (int i = 0; i < traits.length ; i++ ) {
	    String arr[] = {traits[i]};
	    addArr(arr);
	}

	//Adding assam
	add("black", "awake" , "skin" , "heart", "metabolism",  "assam");
	add("awake", "circulation" , "digestion" , "assam");
	
	//Adding chamomile
	add("herbal", "relaxation", "digestion" , "sleep", "nausea", "chamomile");

	//Adding darjeeling
	add("black" , "digestion" , "awake" , "heart" , "metabolism" , "darjeeling" );

	//Adding keemun
	add("black" , "digestion" , "awake" , "heart" , "metabolism" , "keemun" );

	//Adding sencha
	add("green" , "relaxation" , "immune" , "sencha" );
	add( "metabolism" , "sencha" ); 

	//Adding silver needle
	add("white" , "digestion", "awake" , "silver_needle" );
	add("immune" , "heart" , "metabolism" , "silver_needle" );

	//Adding matcha
	add("green" , "skin" , "relaxation" , "matcha");
	add("immune" , "matcha");

	//Adding ginger
	add("herbal" , "nausea" , "immune" , "heart" , "circulation" , "ginger" );
	add("metabolism" , "ginger" );

	//Adding ginseng
	add("herbal" , "digestion" , "relaxation" , "skin" , "metabolism" , "ginseng");

	//Adding peppermint
	add("herbal" , "sleep" , "digestion" , "relaxation" , "nausea" , "peppermint" );
	add("immune" , "peppermint");
	add("metabolism", "peppermint");

	//Adding bai mudan
	add("white", "immune" , "heart" , "bai_mudan");

	//Adding water sprite
	add("oolong" , "relaxation" , "awake" , "immune" , "heart" , "water_sprite" );

	//Adding high mountain
	add("oolong" , "relaxation" , "immune" , "high_mountain");
	add("heart" , "high_mountain");

	//Adding puerh
	add("digestion" , "awake" , "heart" , "puerh" ); 
    }
    
    //size()
    public static int size(String[] arr){
	int ct = 0;
	for(int i = 0; i < arr.length; i++) {
	    if (arr[i] == null)
		return ct;
	    ct += 1;
	}
	return ct;
    }
    
    //addArr
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

    
    //Overloaded Add
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
    
    //Expand
    private void expandX(int row){
	String[] temp = new String[ _data[row].length * 2 ];

	for( int i = 0; i < _data[row].length; i++ )
	    temp[i] = _data[row][i];

	_data[row] = temp;
    }
    
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
    
    //get
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
    
    //sort
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
	for (int i = 0 ; i < _data.length ; i++ ) {
	    if (symFlav.equals(_data[i][0])) {
		return _data[i];
	    }
	}
	System.out.println("Error: Trait does not exist");
	return _data[1]; //Just for the code to work
    }
    
    //main
    public static void main (String[] args) {
	Tea teas = new Tea();
	teas.populate();
	teas.sort();
	System.out.println(teas);
    }

}

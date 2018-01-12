public class Tea {

    //Instance Variables
    public String[][] _data; //will hardcode symFlav
    private int _sizeX;
    private int _sizeY;
    
    //Default Constructor
    public Tea() {
	_data = new String[10][10];
        _sizeX = 0;
	_sizeY = 0;
    }

    
    //Methods
    //size()
    public int size(String[] array){

    }
    
    //addArr
    public void addArr(int index, String[] newArr){
	if ( index < 0 || index >= sizeY() )
	    throw new IndexOutOfBoundsException("add index out of bounds");

	//first expand if necessary
	if ( _sizeY >= _data.length )
	    expand();
	
    }

    /* REFERENCE
       public void add( int index, Object newVal )
       {
       if ( index < 0 || index >= size() )
       throw new IndexOutOfBoundsException("add index out of bounds");

       //first expand if necessary
       if ( _size >= _data.length )
       expand();

       for( int i = _size; i > index; i-- ) {
       _data[i] = _data[i-1]; //each slot gets value of left neighbor
       }

       _data[index] = newVal;
       _size++;
       }*/

    
    public void add(String symFlav, String tea){
	//first expand if necessary
	if ( _size >= _data[0].length )
	    expand();

	for( int i = _size;
	     i > index;
	     i-- ) {
	    _data[i] = _data[i-1]; //each slot gets value of left neighbor
	}

	_data[index] = newVal;
	_size++;
    }

    
    //Overloaded Add
    public void add(String symFlav1, String symFlav2,
		    String symFlav3, String tea){
	
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

	for( int i = 0; i < _data[0].length; i++ )
	    temp[i] = _data[i];

	_data = temp;
    }

    //main
    public static void main (String[] args) {
	
        System.out.println("Compiles and runs!");
    }

}

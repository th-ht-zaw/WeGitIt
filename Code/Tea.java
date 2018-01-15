public class Tea {

    //Instance Variables
    public String[][] _data; //will hardcode symFlav
    private int _sizeY;
    
    //Default Constructor
    public Tea() {
	_data = new String[10][10];
	_sizeY = 0;
    }
    
    //Methods
    //size()
    public int size(String[] arr){
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
	
    
	//main
	public static void main (String[] args) {
	
	    System.out.println("a".compareTo("b"));
	    System.out.println("b".compareTo("a"));
	    System.out.println("a".compareTo("aa"));
	}

    }

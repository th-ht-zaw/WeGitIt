public class Tea {

    //Instance Variables
    public String[][]_data; //will hardcode symptoms
    private int _size;

    
    //Default Constructor
    public Tea() {
	//_data = ??
	_size = 0;
    }

    
    //Methods
    //Add
    public void add(String symFlav, String tea){
	
    }

    
    //Overloaded Add
    public void add(String symFlav1, String symFlav2,
		    String symFlav3, String tea){
    }
    
    
    //Expand
    private void expand(){
	String[][] temp = new String[ _data.length ][ _data[0].length * 2 ];

	for( int i = 0; i < _data[0].length; i++ )
	    temp[i] = _data[i];

	_data = temp;
    }
    
}

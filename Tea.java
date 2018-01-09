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
    
    //Remove
    public void remove(String symFlav, String tea){
	
    }
    
    //Expand
    private void expand(){
	String[][] temp = new String[ _data.length ][ _data[0].length * 2 ];

	for( int i = 0; i < _data[0].length; i++ )
	    temp[i] = _data[i];

	_data = temp;
    }
    
}

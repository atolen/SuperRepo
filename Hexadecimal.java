/* Team Mellon Collie -- Shamaul Dilmohamed, Anna Tolen
APCS1 pd10
HW44 -- This or That or Fourteen Other Things 
2015-12-08 */

public class Hexadecimal {

    private int _decNum;
    private String _hexNum;
    private final static String HEXDIGITS = "0123456789ABCDEF";

    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _hexNum to "0"
      =====================================*/
    public Hexadecimal() { 
	_decNum = 0;
	_hexNum = "0";
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _hexNum to equiv string of bits
      =====================================*/
    public Hexadecimal( int n ) {
	_decNum = n;
	_hexNum = decToHex( n );
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative hexadecimal number
      post: sets _hexNum to input, _decNum to decimal equiv
      =====================================*/
    public Hexadecimal( String s ) {
	_decNum = hexToDec( s );
	_hexNum = s;
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	return _hexNum;
    }


    /*=====================================
      String decToHex(int) -- converts base-10 input to hexadecimal
      pre:  n >= 0
      post: returns String of bits
      eg  decToHex(0) -> "0"
      decToHex(1) -> "1"
      decToHex(2) -> "2"
      decToHex(3) -> "3"
      decToHex(14) -> "E"
      =====================================*/
    public static String decToHex( int n ) {
	String retStr = "";
	while( n != 0 ) {
	    retStr = HEXDIGITS.substring( ( n%16 ),( n%16 ) + 1 ) + retStr;
	    n /= 16;
	}
	return retStr;
	
    }


    /*=====================================
      String decToHexR(int) -- converts base-10 input to hexadecimal, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToHexR(0) -> "0"
      decToHexR(1) -> "1"
      decToHexR(2) -> "2"
      decToHexR(3) -> "3"
      decToHexR(14) -> "E"
      =====================================*/
    public static String decToHexR( int n ) { 
	String retStr = "";
	if( n > 15 ) 
	    retStr = decToHexR(n / 16) + HEXDIGITS.substring(( n%16 ), ( n%16 ) + 1 ) ;
	else
	    retStr = HEXDIGITS.substring( ( n%16 ),( n%16 ) + 1 );
	return retStr;
    }


    /*=====================================
      String hexToDec(String) -- converts base-10 input to hexadecimal
      pre:  s represents non-negative hexadecimal number
      post: returns String of bits
      eg  
      hexToDec("0") -> 0
      hexToDec("1") -> 1
      hexToDec("10") -> 16
      hexToDec("11") -> 17
      hexToDec("E") -> 14
      =====================================*/
    public static int hexToDec( String s ) {
	int retInt = 0;
	int power = s.length() - 1;
	for( int i = 0; i < s.length(); i++ ) {
	    retInt += HEXDIGITS.indexOf( s.substring( i,i+1 )) * Math.pow( 16,power );
	    power--;
	}
		
	return retInt;
    }

    /*=====================================
      String hexToDecR(String) -- converts base-10 input to hexadecimal, recursively
      pre:  s represents non-negative hexadecimal number
      post: returns String of bits
      eg  
      hexToDecR("0") -> 0
      hexToDecR("1") -> 1
      hexToDecR("10") -> 16
      hexToDecR("11") -> 17
      hexToDecR("E") -> 14
      =====================================*/
    public static int hexToDecR( String s ) { 
	int retInt = 0;
	if( s.length() > 1 ) {
	    retInt = (HEXDIGITS.indexOf( s.substring(0,1) ) * (int)Math.pow( 16,s.length()-1 )) + hexToDecR( s.substring(1) );
	    return retInt;
	}
	return HEXDIGITS.indexOf( s );
    }
    
    
    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Hexadecimal
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal hexadecimal values
      =============================================*/
    public boolean equals( Object other ) {
	if ( !( other instanceof Hexadecimal ) )
	    throw new ClassCastException( "equals() input not a Hexadecimal" );
	else
	    return( this == other || this.compareTo(other) == 0 );
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Hexadecimal objects is greater
      pre:  other is instance of class Hexadecimal
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
	if( !( other instanceof Hexadecimal ) )
	    throw new ClassCastException( "compareTo() input not a Hexadecimal" );
	else {
	    if( this._decNum == ((Hexadecimal)other)._decNum )
		return 0;
	    else if( this._decNum > ((Hexadecimal)other)._decNum )
		return 1;
	}
	return -1;
    }


    //main method for testing
    public static void main( String[] args ) {
	
	System.out.println();
	System.out.println( "Testing ..." );

	Hexadecimal h1 = new Hexadecimal(5);
	Hexadecimal h2 = new Hexadecimal(5);
	Hexadecimal h3 = h1;
	Hexadecimal h4 = new Hexadecimal(17);

	System.out.println( h1 );
	System.out.println( h2 );
	System.out.println( h3 );       
	System.out.println( h4 );       

	System.out.println( "\n==..." );
	System.out.println( h1 == h2 ); //should be false
	System.out.println( h1 == h3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( h1.equals(h2) ); //should be true
	System.out.println( h1.equals(h3) ); //should be true
	System.out.println( h3.equals(h1) ); //should be true
	System.out.println( h4.equals(h2) ); //should be false
	System.out.println( h1.equals(h4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( h1.compareTo(h2) ); //should be 0
	System.out.println( h1.compareTo(h3) ); //should be 0
	System.out.println( h1.compareTo(h4) ); //should be neg
	System.out.println( h4.compareTo(h1) ); //should be pos

	System.out.println( "\nconverters..." );
	System.out.println( decToHex( 14 ) ); //should be E
	System.out.println( decToHex( 16 ) ); //should be 10
	System.out.println( decToHex( 42 ) ); //should be 2A
	
       	System.out.println( decToHexR( 14 ) ); //should be E
	System.out.println( decToHexR( 16 ) ); //should be 10
	System.out.println( decToHexR( 42 ) ); //should be 2A
	
	System.out.println();
	
	System.out.println( hexToDec( "E" ) ); //should be 14
	System.out.println( hexToDec( "10" ) ); //should be 16
	System.out.println( hexToDec( "2A" ) ); //should be 42
	
	System.out.println( hexToDecR( "E" ) ); //should be 14
	System.out.println( hexToDecR( "10" ) ); //should be 16
	System.out.println( hexToDecR( "2A" ) ); //should be 42

	System.out.println("\nexception throwing...");
	String a = "test";
	System.out.println( h1.equals(a) );
	/*=========================================			
	  =========================================*/
    }//end main()

} //end class

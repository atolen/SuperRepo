/* Team Grace Annatomy -- Grace Stempel, Anna Tolen
APCS1 pd10
HW41 -- In America, the Driver Sits on the Left
2015-12-03 */

public class Rational implements Comparable {
    
    // instvars
    private int n;
    private int d;

    // constructors
    public Rational() {
	setN( 0 );
	setD( 1 );
    }

    public Rational( int n, int d ) {
	this();
	if( d != 0 ) {
	    setN( n );
	    setD( d );
	}
    }
    
    // mutators
    public void setN( int newN ) {
	n = newN;
    }

    public void setD( int newD ) {
	d = newD;
    }

    // other methods
    public String toString() {
	String retStr = n + "/" + d;
	return retStr;
    }

    public double floatValue() {
	double retDub = (double)n / d;
	return retDub;
    }
    
    public void multiply( Rational r ) {
	int n = this.n * r.n;
	int d = this.d * r.d;
	this.setN( n );
	this.setD( d );
    }
	
    public void divide( Rational r ) {
       	int n = this.n * r.d;
	int d = this.d * r.n;
	this.setN( n );
	this.setD( d );
    }

    public void add( Rational r ) {
	this.setN( (this.n * r.d) + (r.n * this.d) );
	this.setD( this.d * r.d );	
    }

    public void subtract( Rational r ) {
	this.setN( (this.n * r.d) - (r.n * this.d) );
	this.setD( this.d * r.d );
    }

    // employs Euclid's algorithm iteratively
    public int gcd() {
	int a = n;
	int b = d;
	int c = (a % b);
	while( c != 0 ) {
	    a = b;
	    b = c;
	    c = (a % b);
	} 
	return b;
    } 

    public static int gcd( int n, int d ) {
	Rational r = new Rational(n,d);
	return r.gcd();
    }
    public void reduce() {
	int gcd = gcd( n,d );
	setN( n / gcd );
	setD( d / gcd );
    }

    public int compareTo( Object r ) {
	Rational t = (Rational)r;
	this.reduce();
	t.reduce();

	if( this.n * t.d > t.n * this.d )
	    return 1;
	else if( this.n * t.d == t.n * this.d )
	    return 0;
	else
	    return -1;
    }

    public boolean equals( Object r ) {
	try {
	    return( this.compareTo( r ) == 0 );
	}
	catch( ClassCastException e ) {
	    return false;
	}
    }

    public static void main( String[] args ) {
	Rational r = new Rational(2,3); //Stores the rational number 2/3
	Rational s = new Rational(1,2); //Stores the rational number 1/2
	Rational t = new Rational(4,18); //Stores the rational number 4/18

	Rational v = new Rational(4,8);
	Object a = 42;
	Object b = "hi";
       	r.add(s);  //Adds r to s, changes r to 7/6.  s remains 1/2
	t.reduce(); //Changes t to 2/9
	
	System.out.println( r + "\tshould be 7/6" );
       	System.out.println( s + "\tshould be 1/2" );
       	System.out.println( t + "\tshould be 2/9" );

       	System.out.println( r.compareTo(s) + "\tshould be 1" );	
       	System.out.println( s.compareTo(r) + "\tshould be -1" );
       	System.out.println( s.compareTo(s) + "\t should be 0");
	System.out.println( s.compareTo(v) + "\t should be 0");
	
	System.out.println( s.equals(a) + "\tshould be false");
       	System.out.println( s.equals(b) + "\tshould be false");
	System.out.println( s.equals(r) + "\tshould be false");
	System.out.println( s.equals(s) + "\tshould be true");
	System.out.println( s.equals(v) + "\tshould be true"); 
    }
    
} // close class Rational

	    

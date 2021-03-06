package longType;

public class LongToString {
	
	 private char value[];
	 
	public LongToString(char[] value, boolean share) {
	        // assert share : "unshared not supported";
	        this.value = value;
	    }
	
	 final static char [] DigitOnes = {
		        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		        } ;
	 
	 final static char [] DigitTens = {
		        '0', '0', '0', '0', '0', '0', '0', '0', '0', '0',
		        '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
		        '2', '2', '2', '2', '2', '2', '2', '2', '2', '2',
		        '3', '3', '3', '3', '3', '3', '3', '3', '3', '3',
		        '4', '4', '4', '4', '4', '4', '4', '4', '4', '4',
		        '5', '5', '5', '5', '5', '5', '5', '5', '5', '5',
		        '6', '6', '6', '6', '6', '6', '6', '6', '6', '6',
		        '7', '7', '7', '7', '7', '7', '7', '7', '7', '7',
		        '8', '8', '8', '8', '8', '8', '8', '8', '8', '8',
		        '9', '9', '9', '9', '9', '9', '9', '9', '9', '9',
		        } ;

	 final static char[] digits = {
		        '0' , '1' , '2' , '3' , '4' , '5' ,
		        '6' , '7' , '8' , '9' , 'a' , 'b' ,
		        'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
		        'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
		        'o' , 'p' , 'q' , 'r' , 's' , 't' ,
		        'u' , 'v' , 'w' , 'x' , 'y' , 'z'
		    };
	 
	public static void main(String[] args) {
		Long a = 234L;
		System.out.println(a>>=1);
		System.out.println(toString(234L));
	}
	
	 public static String toString(long i) {
	        if (i == Long.MIN_VALUE)
	            return "-9223372036854775808";
	        int size = (i < 0) ? stringSize(-i) + 1 : stringSize(i);
	        char[] buf = new char[size];
	        getChars(i, size, buf);
	        LongToString a = new LongToString(buf, true);
	        return new String(a.value);
	    }
	
	 public static String toString(long i, int radix) {
	        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX)
	            radix = 10;
	        if (radix == 10)
	            return toString(i);
	        char[] buf = new char[65];
	        int charPos = 64;
	        boolean negative = (i < 0);

	        if (!negative) {
	            i = -i;
	        }

	        while (i <= -radix) {
	            buf[charPos--] = digits[(int)(-(i % radix))];
	            i = i / radix;
	        }
	        buf[charPos] = digits[(int)(-i)];

	        if (negative) {
	            buf[--charPos] = '-';
	        }

	        return new String(buf, charPos, (65 - charPos));
	    }

	
	static void getChars(long i, int index, char[] buf) {
        long q;
        int r;
        int charPos = index;
        char sign = 0;

        if (i < 0) {
            sign = '-';
            i = -i;
        }

        // Get 2 digits/iteration using longs until quotient fits into an int
        while (i > Integer.MAX_VALUE) {
            q = i / 100;
            // really: r = i - (q * 100);
            r = (int)(i - ((q << 6) + (q << 5) + (q << 2)));
            i = q;
            buf[--charPos] = DigitOnes[r];
            buf[--charPos] = DigitTens[r];
        }

        // Get 2 digits/iteration using ints
        int q2;
        int i2 = (int)i;
        while (i2 >= 65536) {
            q2 = i2 / 100;
            // really: r = i2 - (q * 100);
            r = i2 - ((q2 << 6) + (q2 << 5) + (q2 << 2));
            i2 = q2;
            buf[--charPos] = DigitOnes[r];
            buf[--charPos] = DigitTens[r];
        }

        // Fall thru to fast mode for smaller numbers
        // assert(i2 <= 65536, i2);
        for (;;) {
            q2 = (i2 * 52429) >>> (16+3);
            r = i2 - ((q2 << 3) + (q2 << 1));  // r = i2-(q2*10) ...
            buf[--charPos] = digits[r];
            i2 = q2;
            if (i2 == 0) break;
        }
        if (sign != 0) {
            buf[--charPos] = sign;
        }
    }

    // Requires positive x
    static int stringSize(long x) {
        long p = 10;
        for (int i=1; i<19; i++) {
            if (x < p)
                return i;
            p = 10*p;
        }
        return 19;
    }
}

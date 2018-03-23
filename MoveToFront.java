public class MoveToFront {
	// apply move-to-front encoding, reading from standard input and writing to standard output
	public static void encode()
	{

        char[] zm = new char[256];
        for (char i = 0; i < 256; i++)
        	zm[i] = i;

        char c, i, tmp_1, tmp_2;
        while (!BinaryStdIn.isEmpty()) {
            c = BinaryStdIn.readChar();
            tmp_2 = zm[0];
            for (i = 0; c != zm[i]; i++) {
            	tmp_1 = zm[i];
                zm[i] = tmp_2;
                tmp_2 = tmp_1;
            }  
            zm[i] = tmp_2;
            zm[0] = c;
            BinaryStdOut.write(i);
        }        
        BinaryStdOut.close();
	}
	// apply move-to-front decoding, reading from standard input and writing to standard output
	public static void decode()
	{
        char[] zm = new char[256];
        for (char i = 0; i < 256; i++)
        	zm[i] = i;
        
        char a, b;
        while (!BinaryStdIn.isEmpty()) {            
            a = BinaryStdIn.readChar();
            for (b = zm[a]; a > 0; a--) 
            	zm[a] = zm[a-1];
            zm[a] = b;
            BinaryStdOut.write(b);
        }         
        BinaryStdOut.close();
	}

	// if args[0] is '-', apply move-to-front encoding
	// if args[0] is '+', apply move-to-front decoding
	public static void main(String[] args)
	{
        if (args[0].equals("-")) 
        	encode();
        else if (args[0].equals("+"))
        	decode();
        else throw new IllegalArgumentException("Illegal command line argument"); 
	}
}
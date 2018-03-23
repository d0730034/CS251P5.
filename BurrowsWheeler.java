
public class BurrowsWheeler {

    public static void encode()
    {
        String s = BinaryStdIn.readString();
        int len = s.length();
        ChangeArray ca = new ChangeArray(s);
        for (int i = 0; i < len; i++) 
            if (ca.index(i) == 0) {
                BinaryStdOut.write(i);
                break;
            }
        for (int i = 0; i < len; i++) 
            BinaryStdOut.write(s.charAt((ca.index(i) + len - 1) % len));
        BinaryStdOut.close();
    }
    // apply Burrows-Wheeler decoding, reading from standard input and writing to standard output
    public static void decode()
    {
        int bi = BinaryStdIn.readInt();
        String bs = BinaryStdIn.readString(); 
        int len = bs.length();     
        
        int[] a = new int[len];
        int[] b = new int[257];
        for (int i = 0; i < len; i++)
            b[bs.charAt(i) + 1]++;
        
        for (int i = 0; i < 256; i++)
            b[i + 1] += b[i];
        
        for (int i = 0; i < len; i++) 
            a[b[bs.charAt(i)]++] = i;
        
        for (int i = a[bi], c = 0; c < len; i = a[i], c++) 
            BinaryStdOut.write(bs.charAt(i));              
        BinaryStdOut.close();
    }
    // if args[0] is '-', apply Burrows-Wheeler encoding
    // if args[0] is '+', apply Burrows-Wheeler decoding
    public static void main(String[] args)
    {
        if	(args[0].equals("-")) 
        	encode();
        else if (args[0].equals("+")) 
        	decode();
        else 
        	throw new IllegalArgumentException("Illegal command line argument");      
    }
}
public class ChangeArray {
    private int MAT = 15;   
    private int[] index;  
    private int LEN;         
    
    public ChangeArray(String s) {
        LEN = s.length();
        index = new int[LEN];
        for (int i = 0; i < LEN; i++)
            index[i] = i;
        quicksort(s, 0, LEN-1, 0);       
    }
    public int length() {
        return LEN;
    }

    public int index(int i) {
        return index[i];
    }
    
    private void quicksort(String s, int a, int b, int c) { 
        
        if (b <= a + MAT) {
        	insert(s, a, b, c);
            return;
        }

        int min = a;
        int max = b;
        int v = s.charAt((index[a] + c) % LEN);
        int i = a + 1;
        while (i <= max) {
            int t = s.charAt((index[i] + c) % LEN); 
            if (t < v)
            	swap(min++, i++);
            else if (t > v)
            	swap(i, max--);
            else
            	i++;
        }

        quicksort(s, a, min-1, c);
        quicksort(s, min, max, c+1);
        quicksort(s, max+1, b, c);
    }
    
    private void swap(int i, int j) {
        int temp = index[i];
        index[i] = index[j];
        index[j] = temp;
    }
    
    private boolean compare(String s, int i, int j, int d) {
        int i_p = index[i];
        int j_p = index[j];
        for (int p = d; p < LEN; p++) {
            int j_v = s.charAt((j_p + p) % LEN);  
            int i_v = s.charAt((i_p + p) % LEN); 
            if (i_v > j_v) 
            	return false;
            if (i_v < j_v)
            	return true;
        }
        return false;
    }

    private void insert(String s, int a, int b, int d) {
        for (int i = a; i <= b; i++) 
            for (int j = i; j > a && compare(s, j, j-1, d); j--) 
            	swap(j, j-1);
    }


    public static void main(String[] args) {
    }    
}
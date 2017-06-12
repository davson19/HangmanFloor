package HangmanFloor;

/**
 * Created by micpi on 5/22/2017.
 */
public class Tester {
    public static void main(String[] args)  throws Exception{
    	boolean[][] arr = ArrayFromXML.getArray(new DataReader());
    	while (true) {
	    	for (int i = 0; i < arr.length; i++) {
	    		for (int j = 0; j < arr[i].length; j++) {
	    			if (arr[i][j]) {
	    				System.out.println(i + ", " +  j);
	    			}
	    		}
	    	}
	    	arr = ArrayFromXML.getArray(new DataReader());
	    	System.out.println();
	    	System.out.println();
	    	Thread.sleep(5000);
    	}
    }
}

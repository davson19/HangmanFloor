/**
 * Created by micpi on 5/22/2017.
 */
public class Tester {
    public static void main(String[] args) {
        boolean[][] b = new boolean[0][];
        try {
            b = ArrayFromXML.getArray(new DataReader());
        } catch (Exception e) {
        }
        for (boolean[] bools : b) {
            for (boolean bool: bools) {
                System.out.println(bool);
            }
        }
    }
}

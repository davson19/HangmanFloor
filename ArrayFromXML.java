package HangmanFloor;

/**
 * Created by micpi on 5/23/2017.
 */
public class ArrayFromXML {
    public static final int BOARD_SIZE = 24;
    public static boolean[][] getArray (DataReader reader) {
        String[][] sArr = getStringArray(reader);
        boolean[][] bArr = new boolean[BOARD_SIZE][sArr[0].length];
        for (int i = 0; i < bArr.length; i++) {
            for (int j = 0; j < bArr[i].length; j++) {
                if (sArr[i][j].equals("*")) {
                    bArr[i][j] = true;
                }
            }
        }
        return bArr;
    }

    private static String[][] getStringArray (DataReader reader) {
        String[][] rowArr = new String[BOARD_SIZE][];
        try {
            String row;
            while (reader.hasNextRow()) {
                row = reader.getNextRow();
                String[] arr = row.split(",");
                rowArr[reader.getRow()-1] = arr;
            }
        } catch (Exception e) {}

        return rowArr;
    }
}

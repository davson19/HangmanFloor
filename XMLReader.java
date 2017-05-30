import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by micpi on 5/22/2017.
 */
public class XMLReader {
    public void ReadXMLFile () throws Exception {
        URL oracle = new URL("http://activefloor.bca.bergen.org:8080");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine = in.readLine();
        String[] strs = inputLine.split(">");

        for (int i = 0; i < strs.length; i++) {

            strs[i] += ">";
        }
        in.close();
        PrintWriter writer = new PrintWriter("floor.xml", "UTF-8");
        for (int i = 0; i < strs.length; i++) {
            writer.write(strs[i] + "\n");
        }
        writer.close();
    }
}

package sugoi.android.amazfun.Common;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by awasthi's on 9/20/2017.
 */

public class HTTPDataHandler {
    static String stream = null;

    public HTTPDataHandler() {

    }

    public String getHTTPData(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            if(urlConnection.getResponseCode()== HttpURLConnection.HTTP_OK)
            {
                InputStream in= new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader r= new BufferedReader(new InputStreamReader(in));
                StringBuilder ab= new StringBuilder();
                String line;
                while((line=r.readLine())!= null)
                    ab.append(line);
                stream=ab.toString();
                urlConnection.disconnect();

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream;
    }
}

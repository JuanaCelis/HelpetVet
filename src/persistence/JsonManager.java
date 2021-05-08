package persistence;

import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class JsonManager {

    public JsonManager(){

    }

    public static void readMedicine() throws IOException, DeserializationException {

        String webService = "https://www.datos.gov.co/api/views/w877-w4d7/rows.json?accessType=DOWNLOAD";

        BufferedReader br = new BufferedReader(new InputStreamReader(getInputStream(false,webService)));

        System.out.println("output is -----------");

        JsonObject jsonObject;

        jsonObject = (JsonObject) Jsoner.deserialize(br);
        JsonArray jsonArrayDatas = (JsonArray) jsonObject.get("data");

        for (int i = 0; i < jsonArrayDatas.size(); i++) {
            System.out.println(jsonArrayDatas.get(i));
            System.out.println("---------");
        }

    }



    public static InputStream getInputStream(boolean isProxy, String filePath){

        HttpURLConnection httpURLConnection;
        URL url = null;
        InputStream inputStream = null;
        try {
            url = new URL(filePath);
            if (!isProxy){
                System.out.println("Sin proxy");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                inputStream = httpURLConnection.getInputStream();
            }else{
                System.out.println("Con proxy");
                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("0.0.0.0", 8080));
                httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
                inputStream = httpURLConnection.getInputStream();
            }
        } catch (ConnectException connectException) {
            isProxy = true;
            return getInputStream(isProxy,filePath);
        } catch (UnknownHostException e) {
            isProxy = true;
            return getInputStream(isProxy, filePath);
        }catch (MalformedURLException e1){
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    public static void main(String[] args) {
        try {
            readMedicine();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DeserializationException e) {
            e.printStackTrace();
        }
    }
}

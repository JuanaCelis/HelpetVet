package persistence;

import model.*;
import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;

public class JsonManager {

    private  JsonArray jsonArrayObject;

    public JsonManager(){
    }

    public ArrayList<Medicine> getMedicineList() throws IOException, DeserializationException {

        ArrayList<Medicine>medicinesList = new ArrayList<>();

        String webService = "https://www.datos.gov.co/api/views/w877-w4d7/rows.json?accessType=DOWNLOAD";

        BufferedReader br = new BufferedReader(new InputStreamReader(getInputStream(false,webService)));
        System.out.println("output is -----------");

        JsonObject jsonObject;

        jsonObject = (JsonObject) Jsoner.deserialize(br);
        JsonArray jsonMed = (JsonArray) jsonObject.get("data");

        for (Object arrayData : jsonMed) {
            jsonArrayObject = (JsonArray) arrayData;

            //System.out.println(jsonArrayObject.get(10));
            //String temp [] = jsonArrayDatas.get(i).toString().split(", (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

            medicinesList.add(new Medicine(jsonArrayObject.get(8).toString(),
                    jsonArrayObject.get(9).toString(),
                    jsonArrayObject.get(10).toString(),
                    jsonArrayObject.get(11).toString()));

            for (int i = 0; i < medicinesList.size(); i++) {
                //System.out.println(medicinesList.get(i).toString() + "\n");
            }
        }
        //System.out.println(medicinesList.size() + "\n");
        return medicinesList;
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

}

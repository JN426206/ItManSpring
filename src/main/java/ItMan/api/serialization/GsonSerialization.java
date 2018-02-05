package ItMan.api.serialization;

import ItMan.api.entities.Adres;
import ItMan.api.entities.Firma;
import com.fatboyindustrial.gsonjodatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GsonSerialization {

    final static Logger logger = Logger.getLogger(GsonSerialization.class);

    public static void generateFirstJson(){
        Adres adres = new Adres("Długa", "60-150", "15", "Poznań");

        Firma firma = new Firma("nazwa jakas", "12312312321", "029192",adres);

        List<Firma> firmy = new ArrayList<Firma>();
        firmy.add(firma);

        //Gson gsonPrettyS = new GsonBuilder().setPrettyPrinting().create();
        Gson gsonPrettyS = Converters.registerDateMidnight(Converters.registerLocalTime(Converters.registerDateTime(new GsonBuilder().setPrettyPrinting()))).create();
        String prettySerializedAlbumS = gsonPrettyS.toJson(firmy);
        FileOutputStream outputStream;

        try {
            outputStream = new FileOutputStream("firstOutput.json");
            outputStream.write(prettySerializedAlbumS.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Gson gson = new Gson();
//        String serializedAlbum = gson.toJson(users);
//        logger.info("Print album json:");
//        System.out.println(serializedAlbum);

        //Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
        Gson gsonPretty = Converters.registerDateMidnight(Converters.registerLocalTime(Converters.registerDateTime(new GsonBuilder().setPrettyPrinting()))).create();
        String prettySerializedAlbum = gsonPretty.toJson(firmy);
        logger.info("Pretty-print album json:");
        System.out.println(prettySerializedAlbum);

//        Users albumRed = gson.fromJson(serializedAlbum,Users.class);
//        System.out.println(albumRed.getName() + " " + albumRed.getLogin());
    }

    public static void saveJSON(List<Firma>  firmy){
        //Gson gsonPrettyS = new GsonBuilder().setPrettyPrinting().create();
        Gson gsonPrettyS = Converters.registerDateMidnight(Converters.registerLocalTime(Converters.registerDateTime(new GsonBuilder().setPrettyPrinting()))).create();
        String prettySerializedAlbumS = gsonPrettyS.toJson(firmy);
        FileOutputStream outputStream;

        try {
            outputStream = new FileOutputStream("Output.json");
            outputStream.write(prettySerializedAlbumS.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadJSON(String fileName){


        try {
            FileInputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }

            String json = sb.toString();
            Gson gson = Converters.registerDateMidnight(Converters.registerLocalTime(Converters.registerDateTime(new GsonBuilder()))).create();
            //Gson gson = new Gson();
            List<Firma> firmy = gson.fromJson(json, new TypeToken<ArrayList<Firma>>(){}.getType());
            //new Manager().saveToDatabaseAllDate(firmy);
            System.out.println(firmy.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String [ ] args) {

        generateFirstJson();
        //saveJSON(new Manager().readFromBaseAllDate());
        //loadJSON("output.json");
        //loadJSON("firstOutput.json");
    }
}

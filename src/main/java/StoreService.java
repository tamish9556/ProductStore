import com.google.gson.JsonObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class StoreService {
    String PATH = "https://www.demoblaze.com/prod.html?idp_=3";

    public static String getId(String path) {
        if(path.endsWith("3")){
            return "3";
        }
        return null;
    }

    static String ID = getId("https://www.demoblaze.com/prod.html?idp_=3");
    public static List<StoreModel> htmlToJson(String path) {
        String data = "";
        try {
            File file = new File(path);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                data.concat(myReader.nextLine().concat("\n"));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        List<StoreModel> productModels = new ArrayList<>();
        Document doc = Jsoup.parse(data);
        JsonObject jsonParentObject = new JsonObject();
        int cnt = 1;
        for (Element table : doc.select("table")) {
            for (Element row : table.select("tr")) {
                JsonObject jsonObject = new JsonObject();
                Elements tds = row.select("td");
                if(tds != null){
                    String title = tds.get(0).text();
                    String price = tds.get(1).text();
                    jsonObject.addProperty("Title", title);
                    jsonObject.addProperty("Price", price);
                    jsonObject.addProperty("Cnt", cnt);
                    productModels.add(new StoreModel(ID, title, Double.valueOf(price), cnt));
                }
                jsonParentObject.add("Product", jsonObject);
                cnt++;
            }
        }
        try {
            FileWriter file = new FileWriter("/C:/Users/Tami/Downloads/result.json");
            file.write(jsonParentObject.toString());
            file.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productModels;
    }
}

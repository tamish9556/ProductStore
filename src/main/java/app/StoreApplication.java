package app;

import com.StoreModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SpringBootApplication
public class StoreApplication {
    public static String getId(String path) {
        if(path.endsWith("3")){
            return "3";
        }
        return null;
    }

    static String ID = getId("https://www.demoblaze.com/prod.html?idp_=3");
    public static StoreModel htmlToJson(String path) {
        String data = "";
        try {
            File file = new File(path);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                data += myReader.nextLine()+"/n";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred - FileNotFoundException");
        }
        Document doc = Jsoup.parse(data);
        int cnt = 0;
        Element title = doc.body().select("h2").first();
        Element price = doc.body().select("h3").first();
        try{
            while(doc.body().select("h2").get(cnt) != null){
                cnt++;
            }
        }
        catch (Exception e){}
        double priceDouble;
        try{
            priceDouble = Double.valueOf(price.text().substring(1, price.text().indexOf(" ")));
        }
        catch (NumberFormatException e){
            priceDouble = 0;
            e.printStackTrace();
        }
        StoreModel productModel  = new StoreModel(ID, title.text(), priceDouble,cnt);
        return productModel;
    }
    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
        System.out.println(htmlToJson("../ProductStore/moreInfo/main.html"));
    }
}
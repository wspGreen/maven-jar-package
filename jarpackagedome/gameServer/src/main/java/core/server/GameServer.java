package core.server;

import cenum.PrizeType;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class GameServer {
    public static void main(String[] args) {
        System.out.println("mainmainmain");
        PrizeType a = PrizeType.Gold;

        JsonObject jo = util.commonutil.show(1);

        System.out.println("end end  " + jo.toString());

//        File file = new File("D:\\Project\\mykingdom\\server\\mk-game\\gameServer\\bin\\conf\\first.properties");
//        try {
//            InputStream in = new FileInputStream("./bin/conf/first.properties");
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        CommProperties.load("./bin/conf/first.properties");
        CommProperties.printPropertis();



    }
}
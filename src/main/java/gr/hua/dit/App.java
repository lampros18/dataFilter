package gr.hua.dit;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FileHandler fh1 = new FileHandler();
        DatabaseManager databaseManager = new DatabaseManager();
        System.out.println("Parsing data file...");
        ArrayList<Record> records1 = fh1.readXLSXFile("src\\main\\java\\gr\\hua\\dit\\data2019_1.xlsx", 1);
        fh1.close();
        //----------------------------
        FileHandler fh2 = new FileHandler();
        System.out.println("Parsing data file...");
        ArrayList<Record> records2 = fh2.readXLSXFile("src\\main\\java\\gr\\hua\\dit\\data2019_2.xlsx", 1);
        fh2.close();
        //----------------------------
        FileHandler fh3 = new FileHandler();
        System.out.println("Parsing data file...");
        ArrayList<Record> records3 = fh3.readXLSXFile("src\\main\\java\\gr\\hua\\dit\\data2019_3.xlsx", 1);
        fh3.close();
        //----------------------------
        ArrayList<Record> records = new ArrayList<>();
        for(Record record : records1){
            records.add(record);
        }
        for(Record record : records2){
            records.add(record);
        }
        for(Record record : records3){
            records.add(record);
        }
        //----------------------------
        
        System.out.println("TOTAL READ: " + records.size());
        System.out.println("Connecting to mysql db");
        databaseManager.connect();
        System.out.println("Inserting data...");
        databaseManager.insertData(records);
        databaseManager.close();
        System.out.println("DONE!");
    }
}

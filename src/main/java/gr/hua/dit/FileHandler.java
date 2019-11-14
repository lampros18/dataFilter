package gr.hua.dit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileHandler {
    
    private File excelFile;
    private FileInputStream fis;
    private ArrayList<Record> records;
    // we create an XSSF Workbook object for our XLSX Excel File
    private XSSFWorkbook workbook;

    public ArrayList<Record> readXLSXFile(String fileName, int worksheetNumber){
        ArrayList<String> record = new ArrayList<>();
        records = new ArrayList<>();
        try{
            excelFile = new File(fileName);
            fis = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(fis);
            // we get first sheet
            XSSFSheet sheet = workbook.getSheetAt(worksheetNumber);
        
            // we iterate on rows
            Iterator<Row> rowIt = sheet.iterator();
            rowIt.next();
 
            while(rowIt.hasNext()) {
              Row row = rowIt.next();
            
              // iterate on cells for the current row
              Iterator<Cell> cellIterator = row.cellIterator();
        
              while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                record.add(cell.toString());
              }
            //   int year  = (int) Math.round(Double.parseDouble(record.get(0)));
              int year = 2019;
            //   String months = record.get(1);
              String months = "";
              String country = record.get(0);;
              String region = record.get(1);;
              String city = record.get(2);;
              String postalCode = record.get(3);;
              int registrationCount = (int) Math.round(Double.parseDouble(record.get(4)));

              records.add(new Record(year, months, country, region, city, postalCode, registrationCount));

              record.clear();
            }
        } catch (NullPointerException | FileNotFoundException exception) {
            System.out.println(exception.getMessage());
            return records;
        } catch (IOException e){
            System.out.println(e.getMessage());
            return records;
        }
        
        return records;
    }

    public int close(){
        try{
            workbook.close();
            fis.close();
        } catch( Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        return 0;
    }

}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Sales_data_analysis{
    public static void main(String[] args) {
        
        HashMap<String, Integer> map=new HashMap<>();

        String fileName="DATASHEET.txt";
        File myfile=new File(fileName);

        // read the File.
        try(Scanner read=new Scanner(myfile)){
            read.nextLine();

            while(read.hasNextLine()){
                String Line=read.nextLine();
                String[] part=Line.split("\\s+");
                String product=part[8];
                int price=Integer.parseInt(part[9]);

                 if(map.containsKey(product)){
                    map.put(product, map.get(product)+price);
                }else{
                    map.put(product,price);
                }
            }

            System.out.println("\n\tSum Of Same Products\n");
            for(Map.Entry<String,Integer> e:map.entrySet()){
                System.out.println("\tThe Sum of   "+e.getKey()+" = "+e.getValue());
            }


        }catch(FileNotFoundException e){
            System.out.println("couldn't able to read the file !!!");
        }
    }
}
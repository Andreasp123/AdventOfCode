import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day3 {
    private HashMap<Integer, Integer> ids = new HashMap<>();
    private HashMap<Integer, ArrayList<Integer>> claims = new HashMap<>();
    private int overlap = 0;


    //inte klar än
    public void readInput() throws FileNotFoundException {
        File file = new File("C:\\Users\\Andreas\\AdventOfCode\\input.txt");
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            int counter = 0;
            int countSpaces = 0;
            String fromLeft = "";
            String fromTop = "";
            boolean comma = false;
            boolean colon = false;
            boolean x = false;
            String inchesWide = "";
            String inchesTall = "";
            for(int i = 0; i < line.length(); i++){
                if(line.charAt(i) == ' '){
                    countSpaces++;

                }
                if(line.charAt(i) == ','){
                    comma = true;


                } if(line.charAt(i) == 'x'){
                    x = true;

                } else {

                    if(line.charAt(i) == ':'){
                        colon = true;
                    }
                    if(countSpaces == 2 && !comma && line.charAt(i) != ' '){
                        fromLeft += line.charAt(i);

                    }
                    if(comma && !colon && line.charAt(i) != ','){
                        fromTop += line.charAt(i);
                    }
                    if(countSpaces == 3 && !x && line.charAt(i) != ' '){
                        inchesWide += line.charAt(i);
                    }
                    if(x){
                        inchesTall += line.charAt(i);
                    }
                }

            }

             addToMap(fromLeft, fromTop, inchesWide, inchesTall);




        }
    }

    public void addToMap(String left, String top, String wide, String tall){
        int fromLeft = Integer.parseInt(left); //10
        int fromTop = Integer.parseInt(top); //15
        int inchesWide = Integer.parseInt(wide); //5
        int inchesTall = Integer.parseInt(tall); //8
        System.out.println("left + wide" + (left + wide));

        for(int i = fromTop; i <= inchesTall + fromTop; i++){
            System.out.println("går in i loop");
            if(claims.get(i) == null){
                ArrayList<Integer> list = new ArrayList<>();
                claims.put(fromTop, list);
                overlap++;
                System.out.println(overlap);

            }

                ArrayList<Integer> list = claims.get(fromTop);

                    for(int j = fromLeft; j <= inchesWide + fromLeft; j++){
                        list.add(j);
                }
                claims.put(i, list);
        }

        for(int key : ids.keySet()){
            System.out.println(key);
        }
    }

    public void count(){
        for(int inty : claims.keySet()){
            ArrayList<Integer> list = claims.get(inty);
            System.out.println(list.size());

            for(int i = 0; i < list.size(); i++){
                int counter = 0;
                int number = list.get(i);
                for(int num : list){
                    if(num == number){
                        counter++;
                    }
                }
                if(counter <= 2){
                    overlap++;
                }
            }

        }
        System.out.println(overlap);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Day3 d3 = new Day3();
        d3.readInput();
        d3.count();
    }

}

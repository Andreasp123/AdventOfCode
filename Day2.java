import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day2 {
    ArrayList<String> input = new ArrayList<>();
    int twice = 0;
    int thrice = 0;


    public void readInput() throws FileNotFoundException {
        File file = new File("C:\\Users\\Andreas\\AdventOfCode\\input.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            HashMap<String, Integer> list = new HashMap<>();
            input.add(line);
            for(int i = 0; i < line.length(); i++){
                String character = "";
                character += line.charAt(i);
                if(list.get(character) == null){
                    list.put(character, 1);
                } else{
                    list.put(character, list.get(character) +1);
                }
            }
            boolean foundTwice = false;
            boolean foundThrice = false;
            for(String str : list.keySet()){

                if(list.get(str) == 2){
                    if(!foundTwice){
                        twice++;
                        foundTwice = true;
                    }
                }
                if(list.get(str) == 3){
                    if(!foundThrice){
                        thrice++;
                        foundThrice = true;
                    }
                }
            }
        }
        System.out.println("twice:" + twice);
        System.out.println("thrice: " + thrice);
        System.out.println(twice * thrice);
    }

    public void partTwo(){
        for(String str : input){

        }
    }

        public static void main (String[]args) throws FileNotFoundException {
        Day2 d2 = new Day2();
        d2.readInput();

        }
    }

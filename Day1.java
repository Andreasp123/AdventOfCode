import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {

    ArrayList<Integer> input = new ArrayList<>();
    ArrayList<Integer> lista = new ArrayList<>();



    public void readInput() throws FileNotFoundException {
        File file = new File("C:\\Users\\Andreas\\AdventOfCode\\input.txt");
        Scanner scan = new Scanner(file);
        int answer = 0;
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String numberAsString = "";
            for(int i = 1; i < line.length(); i++){
                numberAsString += line.charAt(i);
            }
            int number = Integer.parseInt(numberAsString);
            input.add(number);

            if(line.contains("+")){
                answer += number;
                for(int num : lista){
                    if(num == answer){
                        System.out.println("hittade" + num);
                    }
                }


                lista.add(answer);
            }
            if(line.contains("-")){
                answer -= number;
                for(int num : lista){
                    if(num == answer){
                        System.out.println("hittade" + num);
                    }
                }
                lista.add(answer);
            }
        }
        System.out.println(answer);

    }

    public void printLista(){
        System.out.println("i printlista");


    }

    public void test(){
        int answer = 0;

    }

    public static void main(String[] args) throws FileNotFoundException {
        Day1 d1 = new Day1();
        d1.readInput();

       d1.printLista();
    }
}

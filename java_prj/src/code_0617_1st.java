import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class code_0617_1st {
    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream fis = new FileInputStream("C:\\Users\\user\\Desktop\\WorkSpace\\java_prj\\res\\data.csv");
        Scanner scan = new Scanner(fis);
        String first_line = scan.nextLine();
        String[] first = first_line.split(",");
        System.out.printf("%8s %8s %8s %8s\n", first[0], first[1], first[2], first[3]);

        // hasNextLine() : 다음 라인이 있는지 t/f
        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            String[] score = str.split(",");
            //  System.out.printf("score : %s\n", Arrays.toString(score));
            
            String name = score[0];
            int kor = Integer.parseInt(score[1]);
            int eng = Integer.parseInt(score[2]);
            int math = Integer.parseInt(score[3]);
             
            System.out.printf("name : %4s, kor : %4d, eng : %4d, math : %4d\n", name, kor, eng, math);
        }
        scan.close();
    }

}

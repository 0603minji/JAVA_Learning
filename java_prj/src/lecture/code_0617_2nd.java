package lecture;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class code_0617_2nd {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("┌──────────────────────────┐");
        System.out.println("│        성적 출력         │");
        System.out.println("└──────────────────────────┘");

        int no = 0;
        int kor;
        int eng;
        int math;
        int total;
        double avg;

        FileInputStream fis = new FileInputStream("C:\\Users\\user\\Desktop\\WorkSpace\\java_prj\\res\\data.csv");
        Scanner scan = new Scanner(fis);

        String first_line = scan.nextLine();
        String[] first = first_line.split(",");
        System.out.printf("%1s %10s %10s %10s %10s %10s %10s\n", "#", first[0], first[1], first[2], first[3], "총점",
                "평균");
        System.out.println("---------------------------------------------------------------------------------");

        // hasNextLine() : 다음 라인이 있는지 t/f
        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            String[] score = str.split(",");
            // System.out.printf("score : %s\n", Arrays.toString(score));

            no++;
            String name = score[0];

            if (!isNumeric(score[1]))
                kor = 0;
            else {
                kor = Integer.parseInt(score[1]);
                if (kor < 0 || kor > 100)
                    kor = 0;
            }

            if (!isNumeric(score[2]))
                eng = 0;
            else {
                eng = Integer.parseInt(score[2]);
                if (eng < 0 || eng > 100)
                    eng = 0;
            }

            if (!isNumeric(score[3]))
                math = 0;
            else {
                math = Integer.parseInt(score[3]);
                if (math < 0 || math > 100)
                    math = 0;
            }

            total = kor + eng + math;
            avg = total / 3.0;

            System.out.printf("%d. name : %4s, kor : %4d, eng : %4d, math : %4d, total : %4d, avg : %4.2f\n", no,
                    name, kor, eng, math, total, avg);
        }
        scan.close();
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

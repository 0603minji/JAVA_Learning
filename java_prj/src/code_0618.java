import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class code_0618 {
  public static void main(String[] args) throws IOException {
    //  메인 메뉴
    {
      System.out.println("┌──────────────────────────┐");
      System.out.println("│        성적 관리         │");
      System.out.println("└──────────────────────────┘");
      System.out.println();
      System.out.println("1.  목록보기");
      System.out.println("2.  성적추가");
      System.out.println("3.  성적로드");
      System.out.println("4.  성적저장");
      System.out.println("5.  종료");
      System.out.println("-------------------------------------");
      System.out.print("Slecect a menu >>   ");

      Scanner scan = new Scanner(System.in);
      int menu = Integer.parseInt(scan.nextLine());
      System.out.printf("menu value : %d\n", menu);

      System.out.println();
      System.out.println();
      System.out.println();
    }

    //  성적 출력
    {
      int no = 0;
      int kor;
      int eng;
      int math;
      int total;
      double avg;

      System.out.println("┌──────────────────────────┐");
      System.out.println("│        성적 출력         │");
      System.out.println("└──────────────────────────┘");

      FileInputStream fis = new FileInputStream("C:\\Users\\user\\Desktop\\WorkSpace\\java_prj\\res\\data.csv");
      Scanner scan = new Scanner(fis);

      // 컬럼명 버리기
      String first_line = scan.nextLine();

      String[] first = first_line.split(",");
      System.out.printf("%1s %10s   %10s %10s %10s   %10s   %10s   %10s\n", "#", first[0], first[1], first[2], first[3],
          "총점",
          "평균", "학점");
      System.out.println(
          "-------------------------------------------------------------------------------------------------------------");

      // hasNextLine() : 다음 라인이 있는지 t/f
      while (scan.hasNextLine()) {
        String str = scan.nextLine();
        String[] score = str.split(",");
        String grade;

        no++;

        // name 값
        String name = score[0];

        // else : 정상적 일반적 경우(문제가 되지 않는 경우의 처리)
        // if : 비정상적 특수적 경우(문제가 되는 경우의 처리)

        // kor 값 유효성 검사
        if (!(isNumeric(score[1]))) // score 문자열 값이 숫자로 변환 불가능 (특수경우)
          kor = 0;
        else // score 문자열 값이 숫자로 변환가능 (일반 경우)
          kor = Integer.parseInt(score[1]);

        if (!(0 <= kor && kor <= 100))
          kor = 0;

        // eng 값 유효성 검사
        if (!(isNumeric(score[2])))
          eng = 0;
        else
          eng = Integer.parseInt(score[2]);

        if (!(0 <= eng && eng <= 100))
          eng = 0;

        // math 값 유효성 검사
        if (!(isNumeric(score[3])))
          math = 0;
        else
          math = Integer.parseInt(score[3]);

        if (!(0 <= math && math <= 100))
          math = 0;

        // total, avg 연산
        total = kor + eng + math;
        avg = total / 3.0;

        // grade 연산
        
        if (avg>=90) grade = "A";
        else if (avg>=80) grade = "B";
        else if (avg>=70) grade = "C";
        else if (avg>=60) grade = "D";
        else grade = "F";
         
/* 
        grade = "F";
        if (avg >= 60)
          grade = "D";
        if (avg >= 70)
          grade = "C";
        if (avg >= 80)
          grade = "B";
        if (avg >= 90)
          grade = "A";
*/
        // 결과 출력
        System.out.printf(
            "%d. | name : %4s | kor : %4d | eng : %4d | math : %4d | total : %4d | avg : %4.2f | grade : %2s\n",
            no, name, kor, eng, math, total, avg, grade);
      } // while문 종료

      scan.close();
      fis.close();
    }

  } // main함수 종료

  // isNumeric 함수 정의
  public static boolean isNumeric(String str) {
    try {
      Double.parseDouble(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
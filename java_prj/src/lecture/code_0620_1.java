package lecture;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class code_0620_1 {
  public static void main(String[] args) throws IOException {
    int menu;
    Scanner scan;

    while (true) {
      // 메인 메뉴 =======================================================
      {
        clear();
        System.out.println("┌────────────────────────────┐");
        System.out.println("│      성적 관리 시스템      │");
        System.out.println("└────────────────────────────┘");
        System.out.println();
        System.out.println("[1]. 목록보기");
        System.out.println("[2]. 성적추가");
        System.out.println("[3]. 성적로드");
        System.out.println("[4]. 성적저장");
        System.out.println("[5]. 종료");
        System.out.println();
        System.out.println("====================================================================================");
        System.out.print("메뉴 번호 입력 >>>   ");
        scan = new Scanner(System.in);
        menu = scan.nextInt();
      }

      // 메뉴 이동
      switch (menu) {
        case 1: { // 목록 보기 ===============================
          System.out.println("목록 보기");
        } break;

        case 2: { // 성적 추가 ===============================
          clear();

          String name;
          int kor;
          int math;
          int eng;

          scan = new Scanner(System.in);

          System.out.println("┌────────────────────────────┐");
          System.out.println("│          성적 추가         │");
          System.out.println("└────────────────────────────┘");
          System.out.println();

          System.out.print("Input a name  : ");
          name = scan.nextLine();

          System.out.print("Input a kor score  : ");
          kor = scan.nextInt();

          System.out.print("Input a math score  : ");
          math = scan.nextInt();

          System.out.print("Input a eng score  : ");
          eng = scan.nextInt();

        
          FileOutputStream fos = new FileOutputStream("res/data.csv", true);
          PrintStream ps = new PrintStream(fos);
          ps.printf("%s,%d,%d,%d\n", name, kor, math, eng);

          System.out.println("====================================================================================");
          System.out.print("Press any key to continue >>  ");
          scan.nextLine();

          ps.close();
          fos.close();
        } break;

        case 3: { // 성적 로드 ===============================
          int no = 0;
          int kor;
          int eng;
          int math;
          int total;
          double avg;

          System.out.println("┌──────────────────────────┐");
          System.out.println("│        성적 로드         │");
          System.out.println("└──────────────────────────┘");

          FileInputStream fis = new FileInputStream("res/data.csv");
          scan = new Scanner(fis);

          // 컬럼명 버리기
          String first_line = scan.nextLine();

          //  첫째줄 출력
          String[] first = first_line.split(",");
          System.out.printf("%1s %10s   %10s %10s %10s   %10s   %10s   %10s\n",
           "#", first[0], first[1], first[2], first[3], "총점", "평균", "학점");
          System.out.println(
              "====================================================================================");

          //  데이터 출력
          // hasNextLine() : 다음 라인이 있는지 t/f
          while (scan.hasNextLine()) {
            String str = scan.nextLine();
            String[] arr = str.split(",");
            String grade;

            no++;

            // name 값
            String name = arr[0];

            // else : 정상적 일반적 경우(문제가 되지 않는 경우의 처리)
            // if : 비정상적 특수적 경우(문제가 되는 경우의 처리)

            // kor 값 유효성 검사
            if (!(isNumeric(arr[1]))) // score 문자열 값이 숫자로 변환 불가능 (특수경우)
              kor = 0;
            else // score 문자열 값이 숫자로 변환가능 (일반 경우)
              kor = Integer.parseInt(arr[1]);

            if (!(0 <= kor && kor <= 100))
              kor = 0;

            // eng 값 유효성 검사
            if (!(isNumeric(arr[2])))
              eng = 0;
            else
              eng = Integer.parseInt(arr[2]);

            if (!(0 <= eng && eng <= 100))
              eng = 0;

            // math 값 유효성 검사
            if (!(isNumeric(arr[3])))
              math = 0;
            else
              math = Integer.parseInt(arr[3]);

            if (!(0 <= math && math <= 100))
              math = 0;

            // total, avg 연산
            total = kor + eng + math;
            avg = total / 3.0;

            // grade 연산
            if (avg >= 90)
              grade = "A";
            else if (avg >= 80)
              grade = "B";
            else if (avg >= 70)
              grade = "C";
            else if (avg >= 60)
              grade = "D";
            else
              grade = "F";

            // 결과 출력
            System.out.printf(
                "%d. | name :%8s | kor : %4d | eng : %4d | math : %4d | total : %4d | avg : %4.2f | grade : %2s\n",
                no, name, kor, eng, math, total, avg, grade);
          } // while문 종료
          scan.close();
          fis.close();

          System.out.println("====================================================================================");
          System.out.print("Press any key to continue >>  ");
          scan = new Scanner(System.in);
          scan.nextLine();
        } break;

        case 4: { // 성적 저장 ===============================
          System.out.println("성적 저장");
          
          System.out.println("====================================================================================");
          System.out.print("Press any key to continue >>  ");
          scan = new Scanner(System.in);
          scan.nextLine();
        } break;
        
        case 5: { // 종료 ===================================
          System.out.println("종료");

          System.out.println("====================================================================================");
          System.out.print("Press any key to exit system  >>  ");
          scan = new Scanner(System.in);
          scan.nextLine();
          break;
        }
      } //  switch문 종료
      if(menu==5) break;
    } // while(true) 종료

  } // main함수 종료

  // isNumeric() 함수 정의 ===============================================
  public static boolean isNumeric(String str) {
    try {
      Double.parseDouble(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  // clear() 함수 정의 ===================================================
  public static void clear() {
    try {
      String operatingSystem = System.getProperty("os.name");
      if (operatingSystem.contains("Windows")) {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
        Process startProcess = pb.inheritIO().start();
        startProcess.waitFor();
      } else {
        ProcessBuilder pb = new ProcessBuilder("clear");
        Process startProcess = pb.inheritIO().start();
        startProcess.waitFor();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}

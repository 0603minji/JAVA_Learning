package exam;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws IOException {
    // 문제 1 : 다음 블록이 무한 반복하는 조건을 추가하시오.
    while (true)     
    {
      // 메뉴 입력
      int menu = -1;
      {
        // 문제 1 : 다음 화면 코드를 이용해서 메뉴를 출력하는 코드를 작성하시오.
        System.out.print("""
            ┌───────────────────────────────┐
            │          음료관리 메뉴        │
            └───────────────────────────────┘
              1. 음료목록
              2. 음료추가
              3. 종료
            ----------------------------------
              번호 입력 >>     """);

        // 문제 2 : 콘솔 입력을 위한 Scanner 객체 scan을 생성하는 코드를 작성하시오.
        Scanner scan = new Scanner(System.in);

        // 문제 3 : scan을 이용해서 번호를 입력 받아 menu 변수에 대입하시오.
        menu = Integer.parseInt(scan.nextLine());
      }

      // 문제 4 : 다음 지역블록이 menu가 1인 경우만 실행되도록 조건을 추가하시오.
      if (menu == 1) {
        // 문제 5 : res/menus.csv 파일을 읽기 위한 FileInputStream 객체 fis와 Scanner 객체 scan을
        // 생성하시오.
        FileInputStream fis = new FileInputStream("res/menus.csv");
        Scanner scan = new Scanner(fis);

        // 문제 6 : res/menus.csv 파일에서 첫 번째 줄 내용(“메뉴명,가격,종류”)을 읽어서 버리는 코드를 작성하시오.
        scan.nextLine();

        // 문제 7 : 다음 화면 코드를 이용해서 컬럼이름을 출력하시오.
        System.out.println("""
            ┌─────────────────┬────────┬───────────────┐
            │      음료명     │  가격  │      종류     │""");

        // 문제 8 : scan 이 읽을 수 있는 다음 줄이 있으면 반복하는 “조건문”을 추가하시오.
        while (scan.hasNextLine()) {
          // 문제 9 : scan으로 다음 줄을 읽어서 참조시키시오.
          String line = scan.nextLine();

          // 문제 10 : 콤마(“,”)를 기준으로 line 문자열을 나눈 문자열 배열을 대입하시오.
          String[] tokens = line.split(",");

          // 문제 11 : tokens에 배열에 담은 값을 각각의 변수에 대입하시오.
          String name = tokens[0];
          int price = Integer.parseInt(tokens[1]);
          int type = Integer.parseInt(tokens[2]);
          String type_str = (type==1) ? "에스프레소" : "피지오";
          

          // 문제 12 : 다음 모양으로 위 변수의 값들을 출력하시오.
          System.out.println("├─────────────────┼────────┼───────────────┤");
          System.out.printf("│%-12s│%-8d│%-12s│\n", name, price, type_str);
        }

        // 문제 13 : 다음 화면 코드를 이용해서 표를 닫는 코드를 출력하시오.
        System.out.println("└─────────────────┴────────┴───────────────┘");

        // 문제 14 : fis와 scan 객체를 닫는 코드를 작성하시오.
        scan.close();
        fis.close();
      }

      // 문제 15 : 다음 지역블록이 menu가 2인 경우만 실행되도록 조건을 추가하시오.
      else if (menu == 2)
        System.out.println("음료추가 메뉴 선택");

      // 문제 16 : 다음 지역블록이 menu가 3인 경우만 실행되도록 조건을 추가하시오.
      else if (menu == 3) {
        System.out.println("Bye~");
        return;
      }

    } // 무한반복 블록 끝부분

  }
}

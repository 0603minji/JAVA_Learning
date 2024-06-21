package exam;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class exam_0620 {
  public static void main(String[] args) throws IOException {

    // 문제 1번 ===========================================================
    // 40의 위치 얻기
    int indexOf40 = -1;
    {
      // 코드 작성
      FileInputStream fis = new FileInputStream("res/nums.data");
      Scanner scan = new Scanner(fis);
      while (scan.hasNextLine()) {
        // 코드 작성
        indexOf40++;
        int value = Integer.parseInt(scan.nextLine());
        if (value == 40)
          break;
      }
      scan.close();
      fis.close();
    }
    {
      // indexOf40 값 출력 : 출력 결과는 “index is 3” 처럼 출력할 것.
      System.out.printf("index is %d\n", indexOf40);
    }

    System.out.println("================================");

    // 문제 2번 ======================================================
    // 짝수만 출력
    {
      FileInputStream fis = new FileInputStream("res/nums.data");
      Scanner scan = new Scanner(fis);

      while (scan.hasNextLine()) {
        // 코드 작성
        int num = scan.nextInt();
        // 코드 작성
        if (num % 2 == 0)
          System.out.printf("num is %d\n", num);
      }
      scan.close();
      fis.close();
    }

    System.out.println("================================");

    // 문제 3번 =====================================================
    // 앞에서 5개만 출력
    {
      FileInputStream fis = new FileInputStream("res/nums.data");
      Scanner scan = new Scanner(fis);

      for (int i = 0; i < 5; i++) {
        int num = scan.nextInt();
        System.out.printf("num is %d\n", num);
      }
      scan.close();
      fis.close();
    }

    System.out.println("================================");

    // 문제 4번 ======================================================
    // 앞 문제에서 얻은 indexOf40 값을 이용해서 res/nums.data에서 첫 번째 40 이후의 값들만 출력하는 코드를 완성하시오.
    // 40이후의 값들 출력(40 포함)
    {

      FileInputStream fis = new FileInputStream("res/nums.data");
      Scanner scan = new Scanner(fis);
      // 코드 작성
      for (int i = 0; i < indexOf40; i++) {
        scan.nextLine();
      }

      while (scan.hasNextLine()) {
        int num = scan.nextInt();
        System.out.printf("num is %d\n", num);
      }

      scan.close();
      fis.close();
    }

    System.out.println("================================");

    // 문제 5번 =======================================================
    // nums.data의 데이터는 3개씩 합한 결과를 3개까지만 출력하시오.출력 결과는 다음과 같다.
    {
      FileInputStream fis = new FileInputStream("res/nums.data");
      Scanner scan = new Scanner(fis);

      int sum = 0;

      for (int j = 0; j < 3; j++) {
        for (int i = 0; i < 3; i++) {
          sum = sum + scan.nextInt();
        }
        System.out.printf("%d번째 sum is %d\n", j + 1, sum);
        sum = 0;
      }
      scan.close();
      fis.close();
    }
  }
}

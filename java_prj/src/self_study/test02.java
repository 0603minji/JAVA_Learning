package self_study;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class test02 {
  public static void main(String[] args) throws IOException {

    FileInputStream fis = new FileInputStream(
        "C:\\Users\\user\\Desktop\\WorkSpace\\java_prj\\res\\data.txt");
    Scanner scan = new Scanner(fis);

    int b = fis.read(); // 1byte 단위로 읽어와서 b에 저장
    // fis.read()는 문자 '3'을 읽어서 (아스키 코드값으로 받아들임) int 형으로 출력
    // 51 출력 ('3'의 아스키코드값)

    String w = scan.next(); // 공백 전 까지 읽어와서 w에 저장
    // scan.next()는 문자 '3''4''0'까지 읽어서 (아스키 코드값으로 받아들임) String으로 출력
    // 340 출력 ('3''4''0'의 각 아스키 코드값으로 가지고 있다가 문자로 다시 출력)

    String l = scan.nextLine(); // 한줄 전체 읽어와서 l에 저장
    // scan.nextLine()은 문자 '3''4''0'' ''5''0'' ''4'로 읽어서
    // (아스키코드값으로 받아들임) String으로 출력
    // 340 50 4 출력

    System.out.println(b);
    System.out.println(w);
    System.out.println(l);

    scan.close();
    fis.close();

  }
}
package exam;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class exam_0619 {
  public static void main(String[] args) throws IOException {
    // res/data1.txt 데이터 파일에 값을 저장하기 위한 코드를 작성하려고 한다.

    // 값을 바이너리로 저장하기
    {
      int x = 10;
      int y = 20;

      // 1. 위의 두 변수의 값을 바이너리로 저장하는 코드를 작성하시오.

      FileOutputStream fout = new FileOutputStream("res/data1.txt");
      fout.write(x);
      fout.write(y);
    }

    // 값을 Text로 저장하기
    {
      int x = 10;//127
      int y = 20;//256

      // 3. 위의 두 변수의 값을 text로 저장하는 코드를 작성하시오. 두 값 사이에는 어떠한 구분자도 포함하지 않는다.
      FileOutputStream fout = new FileOutputStream("res/data2.txt");
      PrintStream out = new PrintStream(fout);

      out.print(x);
      out.print(y);

    }

    {
      int x = 127;
      int y = 256;
      //System.out.printf("%d", y);
      // 3. 위의 두 변수의 값을 text로 저장하는 코드를 작성하시오. 두 값 사이에는 어떠한 구분자도 포함하지 않는다.
      FileOutputStream fout = new FileOutputStream("res/data3.txt");
      //PrintStream out = new PrintStream(fout);

      fout.write(x);
      fout.write(y);


      //out.print(y);

    }


  }
}

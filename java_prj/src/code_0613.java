
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class code_0613 {
    public static void main(String[] args) throws IOException {
        //  cos 이름의 ConsoleOutputStream 객체 생성
        //  ConsoleOutputStream cos = new ConsoleOutputStream();
        //  out이름으로 cos를 넘겨받는 PrintStream 객체
        //  PrintStream out = new PrintStream(System.out);
        //  System.out.println("Hello");
        int kor1;
        int kor2;
        int kor3;
        int total;
        double avg;
        
        kor1 = 30;
        kor2 = 40;
        kor3 = 100;

        total = kor1 + kor2 + kor3;
        avg = total/3.0;

        System.out.println(" ┌──────────────────┐");
        System.out.println(" │     성적 출력    │ ");
        System.out.println(" └──────────────────┘");
        System.out.printf("kor1  : %5d\n", kor1);
        System.out.printf("kor2  : %5d\n", kor2);
        System.out.printf("kor3  : %5d\n", kor3);
        System.out.printf("total : %5d\n", total);
        System.out.printf("avg   : %5.2f\n", avg);

        //  fos 이름의 FileoutputStream 객체 생성
        //  아무런 경로 표시없이 데이터파일 명시 = class가 있는 경로가 디폴트값 (= class path = bin 파일 경로)
        //  윈도우는 경로 구분자로 역슬래시 사용하므로 역슬래시 2개 표시 필요
        //  자바는 경로 구분자로 /(슬래시) 사용
        FileOutputStream fos = new FileOutputStream("res/data.txt");

        //  fout 이름의 PrintStream 객체 생성
        PrintStream fout = new PrintStream(fos);
        fout.printf("%d %d %d", kor1, kor2, kor3);
        fout.close();
        fos.close();


        //  출력 위한 버퍼 생성 (Platform Buffer)
        FileOutputStream fileout = new FileOutputStream("res/test.txt");
        PrintStream out = new PrintStream(fileout);

        //  write함수
        //  입력 받은 것을 바이너리 값으로 버퍼에 저장후 콘솔이 문자로 인식 출력
        fileout.write(65);      //  65의 바이너리 값을 버퍼로

        //  print함수
        //  입력 받은 것을 문자 코드값으로 버퍼에 저장후 콘솔이 문자로 인식 출력
        out.print(65);      //  '6''5'각 문자에 해당하는 코드값을 버퍼로

        fileout.write('7');
        out.print('7');

        //  한꺼번에 모아서 OS버퍼로 전달
        //  1개씩 데이터를 전달하지않고 일괄처리
        fileout.flush();
        
        //  버퍼 삭제 (OS Buffer도 함께 삭제됨)
        fileout.close(); 




    } 
}
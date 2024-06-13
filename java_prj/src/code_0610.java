public class code_0610 {
    public static void main(String[] args) throws Exception {

        // byte : 1byte (8bit)
        // short : 2byte (16bit)
        // int : 4byte (32bit)
        // long : 8byte (64bit)
        long x = 1234567890;
        int z = (int) x;

        // float : 4byte (32bit)
        // double : 8byte (64bit)
        float a = x;

        //  1
        System.out.printf("1. %d\n", z);
        //  2
        System.out.printf("2. %f\n", a); // 컴파일 오류는 없지만 오류값 출력

        int b = (int) (3.0f / 3.0d);
        double c = 10.0 / 3;
        //  3
        System.out.print("3. ");
        System.out.println(b);
        //  4
        System.out.print("4. ");
        System.out.println(c);

        boolean res;
        int i = 7;
        res = (i == 0) || (i == 2);
        //  5
        System.out.print("5. ");
        System.out.println(res);

        int age = 32;
        res = (20 <= age) && (age < 30);
        //  6
        System.out.print("6. ");
        System.out.println(res);

        int num = 12;
        //  7
        System.out.print("7. ");
        System.out.println((float) num / 7.0);

    }
}

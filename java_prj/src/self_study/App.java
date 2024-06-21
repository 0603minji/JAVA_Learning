package self_study;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        // Test Score ... Intro
        {
            clear();
            System.out.println("┌───────────────────────────────┐");
            System.out.println("│  Test Score Management System │");
            System.out.println("└───────────────────────────────┘");
            System.out.println();
            System.out.println();
            System.out.println();
        }
        {
            System.out.println("─────────────────────────────────────────────────────");
            System.out.print("Press any Key to Continue >>   ");

            Scanner scan = new Scanner(System.in);
            scan.nextLine();
        }

        while (true) {
            // main menu
            // =====================================================================
            int menu;
            {
                clear();
                System.out.println("┌───────────────────────────────┐");
                System.out.println("│           Main menu           │");
                System.out.println("└───────────────────────────────┘");
                System.out.println();
                System.out.println("1.  Test Score List");
                System.out.println("2.  Test Score Input");
                System.out.println("3.  Exit");
                System.out.println();
                System.out.println();
            }
            {
                System.out.println("─────────────────────────────────────────────────────");
                System.out.print("Select a menu to Continue >>   ");

                Scanner scan = new Scanner(System.in);
                menu = Integer.parseInt(scan.nextLine());
            }

            switch (menu) {
                default: {
                    {
                        System.out.println("┌───────────────────────────────┐");
                        System.out.println("│             Error             │");
                        System.out.println("└───────────────────────────────┘");
                        System.out.println("The menu value's range should be 1~3");
                    }
                    {
                        System.out.println("─────────────────────────────────────────────────────");
                        System.out.print("Press any Key to Continue >>   ");

                        Scanner scan = new Scanner(System.in);
                        scan.nextLine();
                    }
                }   break;


                
                // Test Score List
                // =================================================================
                case 1: {
                    {
                        clear();
                        System.out.println("┌───────────────────────────────┐");
                        System.out.println("│        Test Score List        │");
                        System.out.println("└───────────────────────────────┘");

                        System.out.printf("%-2s %-6s %-4s %-4s %-4s %-6s %-6s\n",
                                "NO", "NAME", "  KOR", "ENG", "MATH", "TOTAL", "AVG");
                        System.out.println("─────────────────────────────────────────────────────");

                        FileInputStream fis = new FileInputStream(
                                "C:\\Users\\user\\Desktop\\WorkSpace\\java_prj\\res\\data.csv");
                        Scanner scan = new Scanner(fis);
                        scan.nextLine();

                        int no = 0;
                        while (scan.hasNextLine()) {
                            String line = scan.nextLine();

                            String[] tokens = line.split(",");// ["10","90","50"];

                            String name = tokens[0];
                            int kor = Integer.parseInt(tokens[1]);
                            int eng = Integer.parseInt(tokens[2]);
                            int math = Integer.parseInt(tokens[3]);
                            int total = kor + eng + math;
                            double avg = total / 3.0;

                            System.out.printf("%-2d %-6s %-4d %-4d %-4d %-6d %-6.2f\n",
                                    no + 1, name, kor, eng, math, total, avg);
                            no++;
                        } // while문 종료

                        scan.close();
                        fis.close();
                    }
                    {
                        System.out.println("─────────────────────────────────────────────────────");
                        System.out.print("Press any Key to Continue >>   ");

                        Scanner scan = new Scanner(System.in);
                        scan.nextLine();
                    }
                }
                    break;

                // Test Score Input ==========================================================
                case 2: {
                    {
                        clear();
                        System.out.println("┌───────────────────────────────┐");
                        System.out.println("│        Test Score Input       │");
                        System.out.println("└───────────────────────────────┘");

                        Scanner scan = new Scanner(System.in);

                        String name;
                        int kor;
                        int eng;
                        int math;

                        System.out.print("Name : ");
                        name = scan.nextLine();

                        do {
                            System.out.print("Kor : ");
                            kor = Integer.parseInt(scan.nextLine());
                            if (kor < 0 || kor > 100)
                                System.out.println("성적 유효범위는 0~100 입니다.");
                        } while (kor < 0 || kor > 100);

                        do {
                            System.out.print("Eng : ");
                            eng = Integer.parseInt(scan.nextLine());
                            if (eng < 0 || eng > 100)
                                System.out.println("성적 유효범위는 0~100 입니다.");
                        } while (eng < 0 || eng > 100);

                        do {
                            System.out.print("Math : ");
                            math = Integer.parseInt(scan.nextLine());
                            if (math < 0 || math > 100)
                                System.out.println("성적 유효범위는 0~100 입니다.");
                        } while (math < 0 || math > 100);

                        FileOutputStream fos = new FileOutputStream(
                                "C:\\Users\\user\\Desktop\\WorkSpace\\java_prj\\res\\data.csv", true);
                        PrintStream out = new PrintStream(fos);

                        out.printf("\n%s,%d,%d,%d", name, kor, eng, math);

                        out.close();
                        fos.close();

                    }
                    {
                        System.out.println("─────────────────────────────────────────────────────");
                        System.out.print("Press any Key to Continue >>   ");

                        Scanner scan = new Scanner(System.in);
                        scan.nextLine();
                    }
                }
                    break;

                case 3: {
                    // Exit ===========================================================
                    {
                        clear();
                        System.out.println("┌───────────────────────────────┐");
                        System.out.println("│             Exit              │");
                        System.out.println("└───────────────────────────────┘");
                        System.out.println();
                        System.out.println();
                    }
                    {
                        System.out.println("─────────────────────────────────────────────────────");
                        System.out.print("Press any Key to Exit >>   ");

                        Scanner scan = new Scanner(System.in);
                        scan.nextLine();
                        break;
                    }
                }
            } // switch문 종료
            if (menu == 3) {
                System.out.println("============ System is being closed... ============");
                break;
            }
        } // while(true) 종료

    } // main 함수 종료

    // clear함수
    // ======================================================================
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

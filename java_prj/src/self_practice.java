
public class self_practice {
  public static void main(String[] args) {
    
    for (int y = 0; y > -10; y--) {
      for (int x = 0; x < 10; x++) {
        if(x-9<=y || y<=-x) System.out.print("*");       
      }
      System.out.println();  
    }
  }
}


  
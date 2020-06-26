package AmazonTest;//import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import OA.AmazonOA2.Amazon1;
import java.util.Arrays;

class Amazon1Test {

//  @Test
  public static void main(String[] args) {
    int[] movie1 = new int[] {90, 85, 75, 60, 120, 150, 125};
    int duration1 = 250;

    int[] movie2 = new int[] {90, 60, 160, 120, 130, 90};
    int duration2 = 210;

    int[] movie3 = new int[] {60, 40, 90, 120, 80, 160};
    int duration3 = 210;

    Amazon1 constructor = new Amazon1();

//    assertArrayEquals(constructor.chooseMovie(movie1, duration1), new int[] {90, 125});
    System.out.println(Arrays.toString(constructor.chooseMovie(movie1, duration1)));

//    assertArrayEquals(constructor.chooseMovie(movie2, duration2), new int[] {60, 120});
    System.out.println(Arrays.toString(constructor.chooseMovie(movie2, duration2)));

//    assertArrayEquals(constructor.chooseMovie(movie3, duration3), new int[] {60, 120});
    System.out.println(Arrays.toString(constructor.chooseMovie(movie3, duration3)));
  }
}

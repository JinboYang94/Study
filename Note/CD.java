import java.io.IOException;
import java.math.*;
import java.io.PrintWriter;
import java.util.*;

/*
  @purpose: practise
  @author: Jinbo Y
*/

public class CD{
    
    public static void main(String[] args) throws IOException, IOException { // declare exception manually
        // start write in txt
        PrintWriter out = new PrintWriter("my.txt", "UTF-8");
        out.println("Hi!");
        out.println("I'm god.");
        out.close(); // close printwriter

        // set a string
    	String greeting = "Hello"; 

    	int n = greeting.length(); // get length of String greeeting = n

    	String s = greeting.substring(0,3); // get a substring of 3 characters
    	
        int c = greeting.codePointCount(0,greeting.length()); // get the real length of the string -- the num of code units
    	
        char d = greeting.charAt(3); // get the corresponding character in the String
    	
        //get the 1st code point in the String
        int index = greeting.offsetByCodePoints(0,1);
    	int cp = greeting.codePointAt(index);
    	
        // attach two code unit into one String
        StringBuilder b = new StringBuilder();
    	b.append(2);
    	b.append("love");
    	String complete = b.toString();

        // big integer, it has more accuracy
        BigInteger bi = BigInteger.valueOf(10);
        bi = (BigInteger.valueOf(100).add(BigInteger.valueOf(100))).divide(BigInteger.valueOf(10)); // (100+100)/10
    	

        // array 
        // int [] iArray = new int[10]
        boolean [] bArray = new boolean[10];
        String [] stArray = new String[10];
        int [] iArray = {2,1,3,5,4,6,7,8,9,10};
        Arrays.sort(iArray);  // sort int array using quicksort algorithm
        int [] copyArray = Arrays.copyOf(iArray, iArray.length-1); // copy to a new array and can change the length
        int [] copyArray2 = Arrays.copyOfRange(iArray, iArray [0], iArray [2]); // a more accurate way, and only for value arrays
        int [][] doubleArray = new int [2][3];

        // print all the elements in the array
        // for (boolean element : bArray) System.out.println(element);     
        
        /* 
          a more simple way to output elements in an array
          System.out.println(Arrays.toString(bArray)); // one-dimensional array
          System.out.println(Arrays.deepToString(doubleArray)); // two-dimensional array
        */

        // pow, sqrt
        double power = Math.pow(2.0, 3.0);
        double squareRoot = Math.sqrt(16.0);
        System.out.println(power+squareRoot);

        // output
        System.out.println(Arrays.deepToString(doubleArray));  
    	
        // output system time and date
        System.out.printf("%tc\n", new Date());  // /n for next line, printf is similar in C++

        // invoke a private method 
        Student H1 = new Student();
        // H1.name =  "Scott";
        // H1.age = 24;
        // H1.career = "Student";
        H1.setName("Scott");
        H1.setAge(24);
        H1.setCareer("Student");

        System.out.println(H1.getName()+" is a "+H1.getCareer()+" at age "+H1.getAge());

        // H1.tell();

        Supervisor S1 = new Supervisor();
        S1.setNum(2);
        S1.setCareer("Prof");
        S1.setName("Chralice");

        System.out.println(S1.getNum()+" "+S1.getCareer()+" called "+S1.getName()+" are coming here.");

    }
}

class Student{    
// Why here the class is not declared public: if public, then Student must be saved as Student.java. 
// So in one class, only one public class.
    private String name;
    private int age;
    private String career;
    
    // constructor
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setCareer(String career){
        this.career = career;
    }
    // 

    // accessor
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getCareer(){
        return career;
    }
    //

    // public void tell(){
        // System.out.print(name+career+age);    // this for the public fields, not private
    // }
}

class Supervisor extends Student{ // Subclass Supervisor
    private int Num;
    
    public void setNum(int Num){
        this.Num = Num;
    }

    public int getNum(){
        return Num;
    }
}
package Practice.TreePractice;

public class StringPractice {
    
    public static void main(String[] args) {
        String s1 = "Pranav";
        System.out.println("S1 : "+s1.hashCode());
        String s2 = new String("Pranav");
        System.out.println("S2 create as object : "+s2.hashCode());
        String s3 = new String("Pranav");
        System.out.println("S3 create as object : "+s3.hashCode());
        String s4 = "Pranav";

        System.out.println("\n\nS1 declared as literal and s2 declared as new String object");
        System.out.println("\ns1 s2 using 2equal operator : "+s1==s2);          //false bcz it check address and adress is diff for both bcz s1 stored in string pool and s2 stored in heap
        System.out.println("\ns1 s4 using 2equal operator : "+s1==s4);             //True bcz strings reffering to string at same location
        System.out.println("\nS1.equals(s2) result : "+s1.equals(s2));          //True bcz .equals()  method checks value of the strings and s1 , s2 stored value pranav
        System.out.println("\nS2 == S3 result : "+s2==s3);                      //False bcz both are diff objects created vy using new keywordd
        System.out.println("\nS2.equals(S3) result : "+s2.equals(s3));          //true bcz content is same

    }
}



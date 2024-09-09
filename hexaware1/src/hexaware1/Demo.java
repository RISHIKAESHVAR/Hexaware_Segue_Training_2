package hexaware1;

public class Demo {
    public static void main(String[] args) {

        Student s1 = new Student(101, "asha", 300);
        Student s2 = new Student(101, "latha", 300);

        if (s1.equals(s2)) {
            System.out.println("same");
        } else {
            System.out.println("not same");
        }
    }
}

package segue_training_2;

public class person {
	int age;
	String name;
	
	public person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void Person() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
	
}

class Student extends person {
    String sub;
    int rollno; 

    public Student(int age, String name, String sub, int rollno) {
        super(age, name); 
        this.sub = sub;
        this.rollno = rollno;
    }

    public void student() {
        Person();
        System.out.println("Subject: " + sub);
        System.out.println("Roll Number: " + rollno);
    }
}

package hexaware1;

class Student {
    int roll_no;
    String name;
    int fee;

    Student(int roll, String name, int fee) {
        this.roll_no = roll_no;
        this.name = name;
        this.fee = fee;
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) {
            return true;
        }

        if (a == null || getClass() != a.getClass()) {
            return false;
        }

        Student student = (Student) a;

        return roll_no == student.roll_no && fee == student.fee && name.equals(student.name);
    }

}

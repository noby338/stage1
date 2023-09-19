package pra;

/**
 * @author Noby
 * @since 2023/3/8
 */
public class Demo {
    public static void main(String[] args) {
        Student student = new Student(1,"noby",true);
        student.show();
        System.out.println("Student.charactor=" + Student.charactor);
        System.out.println("student = " + student);
        Student studentGirl = new Girl(2,"lady",false,160.0, 55.3,3);
        System.out.println("Girl.charactor=" + Girl.charactor);
        System.out.println("studentGirl = " + studentGirl);
        studentGirl.show();

        System.out.println("studentGirl.getId() = " + studentGirl.getId());
    }
}

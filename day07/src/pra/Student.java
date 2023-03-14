package pra;

/**
 * @author Noby
 * @since 2023/3/8
 */
class Student {
    private Integer id;
    private String name;
    private Boolean isMale;
    public static final String charactor = "学生";

    public Student() {
    }

    public Student(Integer id,String name,Boolean isMale){
        this.id = id;
        this.name = name;
        this.isMale = isMale;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getMale() {
        return isMale;
    }

    public void setMale(Boolean male) {
        isMale = male;
    }


    public void show(){
        System.out.printf("id=%d,name=%s,isMale=%b\n",this.id,this.name,this.isMale);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isMale=" + isMale +
                '}';
    }
}

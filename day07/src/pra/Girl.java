package pra;

/**
 * @author Noby
 * @since 2023/3/8
 */
public class Girl extends Student{
    private Integer id;
    private Double height;
    private Double weight;
    public static final String charactor = "女孩";

    public Girl() {
    }

    public Girl(Integer id, String name, Boolean isMale, Double height, Double weight,Integer id2) {
        super(id, name, isMale);
        this.id = id2;
        this.height = height;
        this.weight = weight;
    }


    public void show() {
        System.out.printf("id=%d,name=%s,height=%f,weight=%f",super.getId(),super.getName(),height,weight);
    }

    @Override
    public String toString() {
        return "Girl{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }
}

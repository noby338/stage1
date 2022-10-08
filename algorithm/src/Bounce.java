public class Bounce {
    public static void main(String[] args) {
        double distance = 0;

        double height = 100;


        int times = 10;

        for (int n = 1; n < (times + 1); n++) {

            distance = distance + height * 2;

            height = height / 2;

            if (n == times) {

                System.out.println("第" + n + "次反弹高度为：" + height);

                System.out.println("第" + n + "次落地共经过为：" + (distance - 100));

            }

        }
    }

}

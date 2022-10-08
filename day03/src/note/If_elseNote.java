package note;

public class If_elseNote {
    public static void main(String[] args) {
        //region 并列条件语句
        int i = 2;
        if (i == 0) {
            System.out.println("i == 0");
        } else if (i == 1) {
            System.out.println("i == 1");
        } else if (i == 2) {
            System.out.println("i == 2");
        } else {
            System.out.println("others");
        }
        //endregion

        //region 嵌套条件语句
        int year = 2021;
        if (year % 4 == 0) {
            if (year % 100 !=0) {
                System.out.println("闰年");
            }else {
                System.out.println("平年");
            }
        }else if (year % 400 == 0) {
            System.out.println("闰年");
        }else {
            System.out.println("平年");
        }
        //endregion

        //region 多条件判断
        int year1 = 2021;
        if ((year1 %4 ==0 && year1 % 100 !=0) || year1 % 400 == 0) {
            System.out.println("闰年");
        }else {
            System.out.println("平年");
        }
        //endregion
    }
}

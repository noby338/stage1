package task;

import java.util.Scanner;

public class Task11 {
    /*
    11.分析以下需求,并用代码实现
	1.键盘录入一个源字符串由字符串变量scrStr接收
	2.键盘录入一个要删除的字符串由字符串变量delStr接收
	3.要求
		删除该字scrStr符串中的所有delStr字符串（最终的字符串中不能包含delStr），要求打印删除后的结果以及删除了几个delStr字符串
	4.代码运行打印格式:
		请输入源字符串:java woaijava,i like jajavava i enjoy java
		请输入要删除的字符串:java
		控制台输出结果:源字符串中总共包含:5 个 java 删除java后的字符串为: woai,i like  i enjoy
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入源字符串");
        String scrStr = scanner.nextLine();
        System.out.println("请输入要删除的字符串");
        String delStr = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder(scrStr);
        int times = 0;
        int index;
        while ((index = stringBuilder.indexOf(delStr)) != -1) {
            stringBuilder.delete(index, delStr.length() + index);
            times++;
        }
        System.out.println("结果为：" + stringBuilder.toString());
        System.out.println("原字符串中包含删除字符串数量：" + times);
    }
}

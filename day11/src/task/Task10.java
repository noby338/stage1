package task;


import java.util.Arrays;
import java.util.Scanner;

public class Task10 {
    /*
    10.需求说明：实现用户注册、登陆功能；
	1.	程序中使用一个长度为3的对象数组，存储用户的登录名和密码：
		例如如下格式：
				登录名    密码      生日           爱好
				zhangsan  1111	  1998-03-15	旅游，唱歌
				lisi	  2222	  2002-05-20	吃饭，睡觉，打豆豆
				wangwu	  3333	  2001-07-28	看书，看电影，旅游
		注册时，要判断数组是否已满，是：则禁止注册。
	2.	循环为用户列出菜单：
		1.注册     2.登陆     3.退出
	3.	用户选择1，调用：registe()方法，执行注册流程；
		用户选择2，调用：login()方法，执行登陆流程；
		用户选择3，结束程序；
	4.	编写方法：registe()，执行注册流程：
			要求用户输入以下信息(信息无需校验)：
				用户名：
				登录密码：
				出生日期：
				爱好：（多个爱好中间用逗号(中英文都可以)隔开）
	5.	编写方法：login()，执行登陆流程：
		请用户输入登录名、登陆密码；
		使用登录名和密码进行验证；
			通过：打印：这个用户的所有信息；
			未通过：打印：用户名或密码错误！
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] users = new User[3];

        while (true) {
            System.out.println("1.注册");
            System.out.println("2.登录");
            System.out.println("3.退出");
            System.out.println("4.显示");
            int option = scanner.nextInt();
            if (option == 1) {
                registe(users);
            } else if (option == 2) {
                login(users);
            } else if (option == 4) {
                for (User user : users) {
                    System.out.println(user);
                }
            } else {
                break;
            }
        }
    }




    private static void login(User[] users) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String userName = scanner.nextLine();
        System.out.print("请输入密码：");
        String password = scanner.nextLine();
        boolean exist = false;
        boolean passwordRight = false;
        for (User user : users) {
            if (user == null) {
                break;
            }
            if (user.getName().equals(userName)) {
                exist = true;
                if (user.getPassword().equals(password)) {
                    passwordRight = true;
                    System.out.println("登陆成功！");
                }
            }
        }
        if (!exist) {
            System.out.println("用户不存在");
        }
        if (exist && !passwordRight) {
            System.out.println("密码错误");
        }
    }

    private static void registe(User[] users) {
        if (users[2] != null) {
            System.out.println("注册人数已满");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        System.out.print("用户名：");
        String name = scanner.nextLine();
        for (User u : users) {
            if (u != null) {
                while (u.getName().equals(name)) {
                    System.out.println("用户名已存在，请重新输入");
                    System.out.print("用户名：");
                    name = scanner.nextLine();
                }
            }
        }
        user.setName(name);
        System.out.print("登录密码：");
        user.setPassword(scanner.nextLine());
        System.out.print("出生日期：");
        user.setBirthday(scanner.nextLine());
        System.out.print("爱好(多个爱好中间用逗号(中英文都可以)隔开)：");
        String hobyStr = scanner.nextLine();
        char[] chars = hobyStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] == ',' || chars[i] == '，')) {
                chars[i] = '&';
            }
        }
        hobyStr = new String(chars);
        String[] hobys = hobyStr.split("&");
        user.setHoby(hobys);
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                break;
            }
        }
    }
}

class User {
    private String name;
    private String password;
    private String birthday;
    private String[] hoby;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", birthday='" + birthday + '\'' +
                ", hoby=" + Arrays.toString(hoby) +
                '}';
    }

    public User(String name, String password, String birthday, String[] hoby) {
        this.name = name;
        this.password = password;
        this.birthday = birthday;
        this.hoby = hoby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String[] getHoby() {
        return hoby;
    }

    public void setHoby(String[] hoby) {
        this.hoby = hoby;
    }
}

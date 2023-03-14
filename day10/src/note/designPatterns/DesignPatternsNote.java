package note.designPatterns;

/**
 * 软件的单例设计模式
 */
public class DesignPatternsNote {
    public static void main(String[] args) {
        //region 饱汉设计模式
        Full3 fullInstance = Full3.getInstance();
        Full3 fullInstance1 = Full3.getInstance();
        System.out.println(fullInstance == fullInstance1);//true
        //endregion

        //region 饿汉式设计模式
        Hungry hungryInstance = Hungry.getInstance();
        Hungry hungryInstance1 = Hungry.getInstance();
        System.out.println(hungryInstance == hungryInstance1);//true
        //endregion
    }
}

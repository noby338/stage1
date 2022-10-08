package note.designPatterns;

public class DesignPatternsNote {//软件设计模式
    public static void main(String[] args) {
        //region 饱汉设计模式
        Full fullInstance = Full.getInstance();
        Full fullInstance1 = Full.getInstance();
        System.out.println(fullInstance == fullInstance1);//true
        //endregion

        //region 饿汉式设计模式
        Hungry hungryInstance = Hungry.getInstance();
        Hungry hungryInstance1 = Hungry.getInstance();
        System.out.println(hungryInstance == hungryInstance1);//true
        //endregion
    }
}

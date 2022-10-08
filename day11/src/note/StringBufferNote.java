package note;

public class StringBufferNote {
    public static void main(String[] args) {
        //region 构造函数
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer1 = new StringBuffer(new String("stringBuffer"));
        StringBuffer stringBuffer2 = new StringBuffer(4);
        //endregion

        //region 成员方法
        stringBuffer.append("append");
        System.out.println("stringBuffer.length() = " + stringBuffer.length());
        System.out.println("stringBuffer.capacity() = " + stringBuffer.capacity());
        stringBuffer.delete(1,4);//4表示索引
        stringBuffer.insert(1,"insert");
        System.out.println("stringBuffer = " + stringBuffer);
        //endregion
    }
}

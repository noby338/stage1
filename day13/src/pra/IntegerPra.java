package pra;

public class IntegerPra {
    public static void main(String[] args) {
        Integer inte = 10;
        String string = inte.toString();
        int i = inte.intValue();

        int i1 = Integer.parseInt("20");
        Integer integer = Integer.valueOf("20");
        Integer integer1 = Integer.valueOf(20);
        String string1 = Integer.toString(20);

        System.out.println(Integer.MAX_VALUE);
        int minValue = Integer.MIN_VALUE;
        System.out.println("Integer.toBinaryString(128) = " + Integer.toBinaryString(127));
        System.out.println("Integer.toHexString(127) = " + Integer.toHexString(127));
        System.out.println("Integer.toOctalString(127) = " + Integer.toOctalString(127));

        System.out.println("Character.toUpperCase('a') = " + Character.toUpperCase('a'));

    }
}

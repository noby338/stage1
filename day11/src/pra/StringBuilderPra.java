package pra;

public class StringBuilderPra {
    public static void main(String[] args) {
        String str =  "Hello";
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append("World").append("Javaa");
        System.out.println("stringBuilder.reverse().toString() = " + stringBuilder.reverse().toString());
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == 'a') {
                stringBuilder.deleteCharAt(i--);
            }
        }
        System.out.println("stringBuilder.length() = " + stringBuilder.length());
        System.out.println("stringBuilder.capacity() = " + stringBuilder.capacity());
        System.out.println("stringBuilder = " + stringBuilder);


    }
}

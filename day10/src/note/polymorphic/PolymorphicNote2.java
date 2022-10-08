package note.polymorphic;

public class PolymorphicNote2 {
    public static void main(String[] args) {
        Person noby = new Person();
        noby.name = "noby";
        System.out.println("noby.work(new Mp3()) = " + noby.work(new Mp3()));
        System.out.println("noby.work(new Mp4()) = " + noby.work(new Mp4()));
    }
}
class Person {
    String name;
    String work(File file) {
        return file.open();
    }
}

interface File {
    String open();
}

class Mp3 implements File {
    @Override
    public String open() {
        return "opened mp3";
    }
}

class Mp4 implements File {
    @Override
    public String open() {
        return "opened mp4";
    }
}
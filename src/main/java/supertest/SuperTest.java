package supertest;

public class SuperTest {
    public static void main(String[] args) {
        Son son1 = new Son("hello");
        Father son2 = new Son("hello");
        System.out.println(son1.getName());
        System.out.println(son2.getName());
    }

}

class Father {
    private String name;

    public Father(){}
    public Father(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Son extends Father{
    private String name;
    public Son(String name){
        super(name);
        this.name=super.getName()+name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

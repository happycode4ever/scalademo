package enumtest;

public enum MyEnum {
    RED(1,"",""),GREEN(2,"","");


    private int id;
    private String name;
    private String info;

    MyEnum(int id, String name, String info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }

    public static void main(String[] args) {
        MyEnum[] values = MyEnum.values();
    }
}

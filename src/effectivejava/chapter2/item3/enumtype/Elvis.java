package effectivejava.chapter2.item3.enumtype;

public enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    //이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다.
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}

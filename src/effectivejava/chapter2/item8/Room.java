package effectivejava.chapter2.item8;

import java.lang.ref.Cleaner;

//cleaner 를 안정망으로 활용하는 AutoCloseable 클래스
public class Room implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();

    //청소가 필요한 자원. Room 을 참조하면 안되기 때문에 정적 맴버 클래스로 선언한다.
    private static class State implements Runnable {
        int numJunkPiles;

        public State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        @Override
        public void run() { //방청소 완료
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }

    //방의 상태. cleanable 과 공유한다.
    private final State state;

    // cleanable 객체. 수거 대상이 되면 방을 청소한다.
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() {
        cleanable.clean();
    }
}

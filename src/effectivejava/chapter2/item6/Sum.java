package effectivejava.chapter2.item6;

public class Sum {
    private static long sum() {
        Long sum = 0L; //문제가 되는 부분
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }
}

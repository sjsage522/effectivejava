package effectivejava.chapter2.item9.tryfinally;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {

    //try-finally -> 더 이상 자원을 회수하는 최선의 방책이 아니다.
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close(); //명시적으로 자원을 닫아줘야 한다.
        }
    }
}

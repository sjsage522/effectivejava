package effectivejava.chapter2.item9.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {

    //try-with-resources -> 자원을 회수하는 최선책
    static String firstLineOfFile(String path) throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }
}

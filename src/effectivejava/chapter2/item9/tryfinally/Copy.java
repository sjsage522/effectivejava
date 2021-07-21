package effectivejava.chapter2.item9.tryfinally;

import java.io.*;

public class Copy {
    private static final int BUFFER_SIZE = 8 * 1024;

    //자원이 둘 이상이면 try-finally 방식은 너무 지저분하다.
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0)
                    out.write(buf, 0, n);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }
}

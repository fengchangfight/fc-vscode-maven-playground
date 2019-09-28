import org.apache.commons.lang3.RandomUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Singleton {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private Singleton() throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        List<String> li = Arrays.asList("/tmp/chuang2.txt","/tmp/chuang.txt");
        String fn = li.get(RandomUtils.nextInt(0, li.size()));
        System.out.println("File name:"+fn);
        Stream<String> stream = Files.lines( Paths.get(fn), StandardCharsets.UTF_8);

        stream.forEach(s -> contentBuilder.append(s).append("\n"));

        this.content = contentBuilder.toString();
    }

    private static class SingletonHolder {
        public static Singleton instance;

        static {
            try {
                instance = new Singleton();
            } catch (IOException e) {
               throw new RuntimeException("what");
            }
        }
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}

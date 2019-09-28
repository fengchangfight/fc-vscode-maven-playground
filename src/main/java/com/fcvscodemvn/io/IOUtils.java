import java.io.File;

public class IOUtils {
    private static void createDirectory(String path){
        File directory = new File(path);
        if(!directory.exists()){
            directory.mkdir();
        }
    }
    public static void main(String[] args){
        String path = "/tmp/whatthehell";
        createDirectory(path);
        System.out.println("Directory created");
    }
}

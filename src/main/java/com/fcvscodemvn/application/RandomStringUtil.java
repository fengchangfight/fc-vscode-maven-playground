import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringUtil {

    private static String randStringOfLength(int len){
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(len, useLetters, useNumbers);
        return generatedString;
    }
    public static void main(String[] args){
        System.out.println(randStringOfLength(10));
    }
}

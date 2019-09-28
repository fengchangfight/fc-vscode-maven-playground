import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


class UserVo implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6846034858002233878L;

    private String userId;

    private String userName;

    private int age;

    private Date born;

    public UserVo() {
    }

    public UserVo(String userId, String userName, int age, Date born) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.born = born;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @return the born
     */
    public Date getBorn() {
        return born;
    }

    /**
     * @param pUserId the userId to set
     */
    public void setUserId(String pUserId) {
        userId = pUserId;
    }

    /**
     * @param pUserName the userName to set
     */
    public void setUserName(String pUserName) {
        userName = pUserName;
    }

    /**
     * @param pAge the age to set
     */
    public void setAge(int pAge) {
        age = pAge;
    }

    /**
     * @param pBorn the born to set
     */
    public void setBorn(Date pBorn) {
        born = pBorn;
    }

    @Override
    public String toString() {
        return "userId=[ " + userId + " ] userName=[ " + userName + " ] age=[ "
                + age + " ] born=[ " + born + "] .";
    }

}


public class ObjectFileConvert {

    /**
     * 文件转化为Object
     * @param fileName
     * @return byte[]
     */
    public static Object file2Object(String fileName) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(fileName));
            ois = new ObjectInputStream(fis);
            Object object = ois.readObject();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 把Object输出到文件
     * @param obj
     * @param outputFile
     */
    public static void object2File(Object obj, String outputFile) {
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(outputFile));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /**
     * @param args
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        String fileName = "/tmp/object.obj";
        List<String> list = new ArrayList<String>();
        list.add("michael");
        list.add("大大");

        ObjectFileConvert.object2File(list, fileName);
        System.out.println("success write List<String> to file.");

        List<String> tmpList = (List<String>) ObjectFileConvert
                .file2Object(fileName);
        for (String tmp : tmpList) {
            System.out.println(tmp);
        }

        System.out.println("--------------------------------");

        fileName = "/tmp/uservo.obj";
        UserVo vo = new UserVo("michael", "大大", 18, new Date());

        ObjectFileConvert.object2File(vo, fileName);
        System.out.println("success write bean:UserVo to file.");

        UserVo tmpvo = (UserVo) ObjectFileConvert.file2Object(fileName);
        System.out.println("read bean:UserVo from file get info : " + tmpvo);

    }

}
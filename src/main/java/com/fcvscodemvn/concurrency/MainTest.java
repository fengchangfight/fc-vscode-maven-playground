import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


class People{
    private String name;
    private int age;

    public People(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return this.name.equals(((People)obj).name) && this.age== ((People)obj).age;
    }
}

public class MainTest {

    public static void main(String[] args) {

        People p1 = new People("Jack", 12);
        People p2 = new People("Jack", 12);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p1.equals(p2));
//
//        HashMap<People, Integer> hashMap = new HashMap<People, Integer>();
//        hashMap.put(p1, 1);
//
//        System.out.println(hashMap.get(new People("Jack", 12)));
    }
}
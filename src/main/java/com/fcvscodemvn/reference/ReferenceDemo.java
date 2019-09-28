import java.lang.ref.*;
import java.util.ArrayList;
import java.util.List;

class Employee{
    Integer id;
    String name;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
class LargeObjectFinalizer extends PhantomReference<Object> {

    public LargeObjectFinalizer(
            Object referent, ReferenceQueue<? super Object> q) {
        super(referent, q);
    }

    public void finalizeResources() {
        // free resources
        System.out.println("clearing ...");
    }
}
public class ReferenceDemo {
    public static void main(String[] args) {
//        strongReference();
//        weakReference();
//        softReference();
        phantomReference();

    }

    private static void strongReference(){
        Employee emp = new Employee(1441, "KK");
        emp = null;  //Eligible for gc
    }

    private static void softReference(){
        Employee emp = new Employee(1441, "KK");
        SoftReference<Employee> softReference = new SoftReference<Employee>(emp);

        System.out.println(softReference.get());
        emp = null;
        System.gc();
        System.out.println(softReference.get());
    }

    private static void weakReference(){
        Employee emp = new Employee(1441, "KK");
        WeakReference<Employee> weakReference = new WeakReference<Employee>(emp);

        System.out.println(weakReference.get());
        emp = null;
        System.gc();
        System.out.println(weakReference.get());
    }

    private static void phantomReference(){
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        List<LargeObjectFinalizer> references = new ArrayList<>();
        List<Object> largeObjects = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            Object largeObject = new Object();
            largeObjects.add(largeObject);
            references.add(new LargeObjectFinalizer(largeObject, referenceQueue));
        }

        largeObjects = null;
        System.gc();

        Reference<?> referenceFromQueue;
        for (PhantomReference<Object> reference : references) {
            System.out.println(reference.isEnqueued());
        }

        while ((referenceFromQueue = referenceQueue.poll()) != null) {
            ((LargeObjectFinalizer)referenceFromQueue).finalizeResources();
            referenceFromQueue.clear();
        }
    }
}

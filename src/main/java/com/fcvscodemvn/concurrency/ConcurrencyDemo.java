import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class ConcurrencyDemo {
    public static void main(String[] args){
        try {
            List<Future> results = new ArrayList<>();
            results.add(ForkJoinPool.commonPool().submit(() -> {
                try{
                    List ab = null;
                    ab.size();
                }catch (RuntimeException e){
                    System.out.println("hell no");
                    throw e;
                }
            }));
        }catch (RuntimeException e){
            System.out.println("what the hell");
        }

//
//        for(Future f: results){
//            try {
//                f.get();
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
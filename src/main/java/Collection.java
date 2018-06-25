import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

public class Collection {
    public static void main(String[] args) {
         Map<Integer, String> hashMap = new HashMap<Integer, String>();

         for (int i=0; i<20; i++ ){
             hashMap.put(i, "test "+i);
         }
        System.out.println("size: " + hashMap.size());
        for (int i=0; i<20; i++ ){
            System.out.println(hashMap.get(i));
        }


    }
}

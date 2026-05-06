package basics;

import java.util.ArrayList;
import java.util.List;

public class DemoPPS1 {
	public static void main(String[] args) { 

        List<Integer> list = new ArrayList<>();

        for(Integer i : list) {
            list.add(10); // exception
        }

        System.out.println(list);
    }
}

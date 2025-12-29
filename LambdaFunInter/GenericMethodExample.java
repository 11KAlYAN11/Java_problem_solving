import java.util.List;

package LambdaFunInter;

public class GenericMethodExample {

    // Generic method to find the maximum element in a list
    public static <T extends Comparable<T>> T findMax(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List must not be null or empty");
        }

        T max = list.get(0); // Assume the first element is the max initially

        for (T element : list) {
            if (element.compareTo(max) > 0) {
                max = element; // Update max if current element is greater
            }
        }

        return max;
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(3, 5, 1, 9, 7);
        System.out.println("Max integer: " + findMax(intList));

        List<String> strList = List.of("apple", "banana", "grape", "orange", "watermelon");
        System.out.println("Max string: " + findMax(strList));
    }
}

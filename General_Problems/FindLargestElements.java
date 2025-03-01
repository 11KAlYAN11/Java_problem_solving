public class FindLargestElements {
    public static void findLargest(int[] arr) {
        if (arr.length < 3) {
            System.out.println("Array must have at least 3 elements.");
            return;
        }
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        for(int ele: arr) {
            if(ele > first) {
                third = second;
                second = first;
                first = ele;
            }
            else if(ele > second && ele != first) {
                third = second;
                second = ele;
            }
            else if( ele > third && ele != second && ele != first) third = ele;
        }
        System.out.println("1st Largest: " + first);
        System.out.println("2nd Largest: " + (second == Integer.MIN_VALUE ? "No second largest" : second));
        System.out.println("3rd Largest: " + (third == Integer.MIN_VALUE ? "No third largest" : third));
        
        System.err.println("hello this is a how bascailly erros thrown in java");
        System.err.println(
            "This is how we throw error with System.err");

        // Taking a input from the console    
        String x = System.console().readLine();
        System.out.println("You entered string " + x);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 4, 45, 99, 99, 99, 6};
        findLargest(arr);
    }
}

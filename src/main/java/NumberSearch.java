import java.util.stream.IntStream;

public class NumberSearch {
    public static int countLessThan(int[] nums, int x){
        int result      = 0;
        int finalVal    = 0;

        //Check if given value is exist in the array.
        boolean hasValue = IntStream.of(nums).anyMatch(n -> n == x);

        // if the value is not found in the array then,
        // use binary search algorithm to force to find the closest value of x in the array.
        if(!hasValue){

            int start = 0, mid = 0;
            int end = nums.length - 1;

            // Keep dividing array till further division is not possible
            while (end - start != 1) {

                // Calculate middle index
                mid = (start + end) / 2;


                // Check if the target value in array is smaller in the middle
                // get half of  the array
                if (x < nums[mid]){
                    end = mid;
                }

                // Check if the target value is larger in middle
                // get half of  the array
                if (x > nums[mid]){
                    start = mid;
                }
            }
            // After that, only two numbers in array in which the target value is closer then
            // compare using Math.abs to get the most closest value and replace the target value
            finalVal = Math.abs(x - nums[start]) <= Math.abs(x - nums[end]) ? nums[start] : nums[end];
        }

        //To get number of array elements use loop to count.
        for (int number : nums) {
            if (number == finalVal) {
                if(!hasValue && result > 0){
                    //add 1 for those closest value and for those closest value
                    // that not start in the beginning since it will only count
                    // those array element before it match.
                    result++;
                }

                //Once the target value was met then break the loop and get the counter.
                break;
            }
            result++;
        }

        return result;
    }

    public  static void main(String[] args){
        System.out.println(countLessThan(new int[]{1,2,3,4,8},6));
        System.out.println(countLessThan(new int[]{4,4,4,6,6,6,8,8,8},8));
        System.out.println(countLessThan(new int[]{2,3,4},9));
        System.out.println(countLessThan(new int[]{2,3,4},1));
    }
}

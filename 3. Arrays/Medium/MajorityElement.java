
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int majEle = -1, count = 0;

        for(int num : nums) {
            if(count == 0) majEle = num;
            if(num == majEle) count++;
            else count--;
        }

        count = 0;

        for(int num : nums) {
            if(num == majEle) count++;
        }
        if(count > nums.length / 2) return majEle;
        else return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
    }
}

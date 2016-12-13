import java.util.Arrays;

/**
 * Created by hp on 2016/12/12.
 */
public class RotedArray {

    public static void main(String args[]){
        RotedArray r = new RotedArray();
        int [] nums = {1, 2, 3, 4, 5};
        int k = 2;
        r.rotate(nums, k);
        System.out.print(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k){
        if ((nums == null) || (nums.length == 0)) return;
        if(nums.length == 1 || k == 0 || k == nums.length) return;

        int len = nums.length;
        k %= len;
        int idx = 0;
        int tmp = nums[idx];
        int tmp2 = 0;
        for(int i = 0,j = 0; i < len; i++){
            idx = (idx + k) % len;
            tmp2 = nums[idx];
            nums[idx] = tmp;
            tmp = tmp2;
            if(idx == j){
                idx = ++j;
                tmp = nums[idx];
            }

        }

    }
}

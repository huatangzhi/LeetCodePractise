import java.util.Arrays;
import java.util.Map;

/**
 * Created by hp on 2016/12/13.
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] num, int target) {
        int closest = 0;
        if(num == null || num.length == 0) return closest;
        Arrays.sort(num);
        for(int i= 0; i < num.length && i < 3; i++){
            closest += num[i];
        }
        if(num.length < 3) return closest;
        for(int i = 0; i < num.length - 2; i++){
            int j = i + 1;
            int k = num.length - 1;
            while (j < k){
                int sum = num[i] + num[j] + num[k];
                if(Math.abs(target - sum) < Math.abs(target - closest)){
                   closest = sum;
                    if( closest == target) return closest;
                }
                if (sum > target){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return closest;
    }
}

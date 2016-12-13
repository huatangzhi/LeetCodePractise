import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hp on 2016/12/12.
 */
public class ThreeSum {
    public static void main(String args[]){
        ThreeSum t = new ThreeSum();
        int [] s = {-1, 0, 1, 2, -1, -4};

        t.printResult(t.threeSum(s));
    }

    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(num);

        for(int i = 0; i < num.length - 2; i++){
            if(i >0 && num[i]  == num[i-1]) continue;
            if (num[i] > 0) break;

            int j = i + 1;
            int k = num.length - 1;
            while( j < k){
                if(j > i + 1 && num[j] == num[j-1]) {
                    j++;
                    continue;
                }

                if(num[i] + num[j] > 0)  {
                    break;
                }

                if(num[i] + num[j] + num[k] < 0){
                    j++;
                }else if(num[i] + num[j] + num[k] >0 ){
                    k--;
                }
                else {
                    List<Integer> triplets = new ArrayList<Integer>();
                    triplets.add(num[i]);
                    triplets.add(num[j]);
                    triplets.add(num[k]);
                    res.add(triplets);
                    j++;
                    k--;
                }
            }

        }
        return res;
    }

    private void printResult(List<List<Integer>> result){
        for (List<Integer>  l : result){
            System.out.print("{");
            for(Integer i:l){
                System.out.print(" " + i);
            }
            System.out.println("}");
        }
    }
}

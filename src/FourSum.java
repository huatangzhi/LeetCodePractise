import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hp on 2016/12/13.
 */
public class FourSum {
    public static void main(String[] args){
        FourSum f = new FourSum();
        int [] s = {-1, 0, 1, 2, -1, -4};

        f.printResult(f.fourSum(s, 2));


    }

    public List<List<Integer>> fourSum(int[] num, int target){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if((num == null) || num.length < 4) return res;
        Arrays.sort(num);

        for(int i=0; i < num.length; i++){
            if(i > 0 && num[i] == num[i-1]) continue;
            for(int j=i+1; j < num.length-2; j++){
                if(j > i+1 && num[j] == num[j-1]) continue;
                int newTar = target - num[i] - num[j];
                int l = j + 1;
                int r = num.length - 1;
                while (l < r){
                    if(l>j+1 && num[l] == num[l-1]) {
                        l++;
                        continue;
                    }
                    if(r < num.length-1 && num[r] == num[r+1]){
                        r--;
                        continue;
                    }
                    int sum = num[l] +num[r];
                    if (sum < newTar){
                        l++;
                    }
                    else if(sum > newTar){
                        r--;
                    }
                    else{
                        res.add(new ArrayList<Integer>(Arrays.asList(num[i], num[j], num[l], num[r])));
                        l++;
                        r--;
                    }
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

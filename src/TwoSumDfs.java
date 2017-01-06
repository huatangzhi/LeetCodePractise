import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2017/1/6.
 */
public class TwoSumDfs {

    public static void main(String[] args){
        TwoSumDfs twoSumDfs = new TwoSumDfs();
        TreeNode root = new TreeNode(5);
        TreeNode node1_1 = new TreeNode(4);
        TreeNode node1_2 = new TreeNode(8);
        root.left = node1_1;root.right=node1_2;
        TreeNode node2_1 = new TreeNode(11); TreeNode node2_2 = new TreeNode(13); TreeNode node2_3 = new TreeNode(4);
        node1_1.left = node2_1; node1_2.left = node2_2; node1_2.right = node2_3;
        TreeNode node3_1 = new TreeNode(7); TreeNode node3_2 = new TreeNode(2); TreeNode node3_3 = new TreeNode(5); TreeNode node3_4 = new TreeNode(1);
        node2_1.left = node3_1;node2_1.right = node3_2; node2_3.left = node3_3; node2_3.right = node3_4;

        List<List<Integer>> res = twoSumDfs.pathSum(root, 22);

        System.out.println(res.toString());
    }



    public List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        pathSum(root, sum, new ArrayList<Integer>(), res);
        return res;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res){
        if (root == null){
            return;
        }
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0){
            path.add(root.val);
            res.add(new ArrayList<Integer>(path));
            path.remove(path.size() - 1);
            return;
        }

        path.add(root.val);
        pathSum(root.left, sum, path, res);
        pathSum(root.right, sum, path, res);
        path.remove(path.size() - 1);
    }
}

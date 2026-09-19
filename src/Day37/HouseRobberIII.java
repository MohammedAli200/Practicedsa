package Day37;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class HouseRobberIII {
    public static int rob(TreeNode root) {
        int[] result = robSub(root);
        return Math.max(result[0], result[1]);
    }

    private static int[] robSub(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);

        // Index 0: Not robbing current node
        int notRobbed = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // Index 1: Robbing current node
        int robbed = root.val + left[0] + right[0];

        return new int[]{notRobbed, robbed};
    }

    public static void main(String[] args) {
        // Construct tree: [3, 2, 3, null, 3, null, 1]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        System.out.println("Maximum stolen value from tree: " + rob(root));
    }
}
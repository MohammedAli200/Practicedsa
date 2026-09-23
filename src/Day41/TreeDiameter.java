package Day41;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class TreeDiameter {
    private static int maxDiameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        calculateHeight(root);
        return maxDiameter;
    }

    private static int calculateHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Update maximum diameter encountered so far
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return height of current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        // Construct tree: [1, 2, 3, 4, 5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Diameter of Tree: " + diameterOfBinaryTree(root));
    }
}
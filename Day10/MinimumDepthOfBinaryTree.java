package Day10;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if (l == 0)
            return 1 + r;
        if (r == 0)
            return 1 + l;
        return 1 + Math.min(l, r);
    }
}
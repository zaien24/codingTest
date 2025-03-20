class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class InverBinaryTree {
    public static TreeNode inverTree(TreeNode root) {
        if (root == null) return null;

        // 왼쪽과 오른쪽 자식 노드 교환
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 재귀적으로 왼쪽과 오른쪽 서브트리를 반전
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    // 트리 출력 (BFS 방식)
    public static void printTree(TreeNode root) {
        if (root == null) return;

        Queue<TreeeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    public static void main(String[] args) {
        // 트리 생성
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        printTree(root);

        root = inverTree(root);

        Syso
        
    }
}


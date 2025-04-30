class Solution {
    private int maxDiameter = 0; // 최대 지름 저장용

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = depth(node.left);   // 왼쪽 서브트리 깊이
        int rightDepth = depth(node.right); // 오른쪽 서브트리 깊이

        // 현재 노드를 지나는 경로 길이 = 왼쪽 깊이 + 오른쪽 깊이
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        // 현재 노드의 깊이 = 1(자기자신) + 더 깊은 쪽
        return 1 + Math.max(leftDepth, rightDepth);
    }
}

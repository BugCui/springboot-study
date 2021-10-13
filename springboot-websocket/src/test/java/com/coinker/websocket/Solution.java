package com.coinker.websocket;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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


class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode = new TreeNode(1, treeNode2, treeNode3);
        solution.inorderTraversal(treeNode);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> valueList = new ArrayList<>();
        middleFor(valueList, root);
        System.out.println(Arrays.toString(valueList.toArray()));
        return valueList;
    }

    public void middleFor(List<Integer> valueList, TreeNode root) {
        if (root == null) return;
        middleFor(valueList, root.left);
        valueList.add(root.val);
        middleFor(valueList, root.right);
    }
}
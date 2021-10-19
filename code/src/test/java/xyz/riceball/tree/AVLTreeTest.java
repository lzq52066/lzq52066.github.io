package xyz.riceball.tree;

import org.junit.Test;

/**
 * 二叉平衡树
 *
 * @author xiaovcloud
 * @since 2021/10/14 20:52
 */
public class AVLTreeTest {

	@Test
	public void test() {
		AVLTree<Integer> tree = new AVLTree<>();
		TreeNode<Integer> treeNode1 = new TreeNode<>(10);
		TreeNode<Integer> treeNode2 = new TreeNode<>(6);
		TreeNode<Integer> treeNode3 = new TreeNode<>(15);
		TreeNode<Integer> treeNode4 = new TreeNode<>(5);
		TreeNode<Integer> treeNode5 = new TreeNode<>(8);
//		TreeNode<Integer> treeNode6 = new TreeNode<>(7);
//		TreeNode<Integer> treeNode7 = new TreeNode<>(9);

		tree.add(treeNode1);
		System.out.println(tree.preOrder());
		tree.add(treeNode2);
		System.out.println(tree.preOrder());
		tree.add(treeNode4);
		tree.add(treeNode3);
		System.out.println(tree.preOrder());
		tree.add(treeNode5);
		System.out.println(tree.preOrder());
//		tree.add(treeNode6);
//		System.out.println(tree.inOrder());
//		tree.add(treeNode7);
//		System.out.println(tree.inOrder());

		tree.delete(5);
		System.out.println(tree.preOrder());
	}
}

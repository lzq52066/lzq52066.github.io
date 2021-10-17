package xyz.riceball.tree;

import xyz.riceball.list.List;

/**
 * 二叉查找树测试
 *
 * @author xiaovcloud
 * @since 2021/10/14 19:52
 */
public class BinaryTreeTest {

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();

		TreeNode<Integer> treeNode1 = new TreeNode<>(10);
		TreeNode<Integer> treeNode2 = new TreeNode<>(6);
		TreeNode<Integer> treeNode3 = new TreeNode<>(15);
		TreeNode<Integer> treeNode4 = new TreeNode<>(5);
		TreeNode<Integer> treeNode5 = new TreeNode<>(8);
		TreeNode<Integer> treeNode6 = new TreeNode<>(7);
		TreeNode<Integer> treeNode7 = new TreeNode<>(9);
		TreeNode<Integer> treeNode8 = new TreeNode<>(13);
		TreeNode<Integer> treeNode9 = new TreeNode<>(11);
		TreeNode<Integer> treeNode10 = new TreeNode<>(18);
		TreeNode<Integer> treeNode11 = new TreeNode<>(16);
		TreeNode<Integer> treeNode12 = new TreeNode<>(19);

		//测试添加操作
		tree.add(treeNode1);
		tree.add(treeNode2);
		tree.add(treeNode3);
		tree.add(treeNode4);
		tree.add(treeNode5);
		tree.add(treeNode6);
		tree.add(treeNode7);
		tree.add(treeNode8);
		tree.add(treeNode9);
		tree.add(treeNode10);
		tree.add(treeNode11);
		tree.add(treeNode12);

		System.out.println("中序遍历:");
		List<TreeNode<Integer>> treeNodes = tree.inOrder();
		for (TreeNode<Integer> treeNode : treeNodes) {
			System.out.println(treeNode);
		}

		//验证获取中序后继节点
//		System.out.println("中序后继节点:");
//		TreeNode<Integer> inOrderSuccessorTreeNode = tree.getInOrderSuccessorTreeNode(treeNode2, false);
//		System.out.println(inOrderSuccessorTreeNode);

		//验证删除节点
		tree.delete(10);
		//删除不存在的值
		boolean delete = tree.delete(20);
		System.out.println(delete);  //false
		tree.delete(2);
		tree.delete(7);
		tree.delete(15);
		tree.delete(18);
		tree.delete(19);
		tree.delete(5);
		tree.delete(8);
		System.out.println("中序遍历:");
		treeNodes = tree.inOrder();
		for (TreeNode<Integer> treeNode : treeNodes) {
			System.out.println(treeNode);
		}

		//验证根节点,删除根节点10后,根节点应该为11
		TreeNode<Integer> root = tree.getRoot();
		System.out.println("根节点:" + root);
	}
}

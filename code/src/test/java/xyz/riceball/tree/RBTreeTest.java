package xyz.riceball.tree;

import org.junit.Test;

/**
 * @author xiaovcloud
 * @since 2021/10/20 20:11
 */
public class RBTreeTest {

	@Test
	public void test() {
		RBTreeNode<Integer> node1 = new RBTreeNode<Integer>(10);
		RBTreeNode<Integer> node2 = new RBTreeNode<Integer>(5);
		RBTreeNode<Integer> node3 = new RBTreeNode<Integer>(15);
		RBTreeNode<Integer> node4 = new RBTreeNode<Integer>(6);
		RBTreeNode<Integer> node5 = new RBTreeNode<Integer>(7);
		RBTreeNode<Integer> node6 = new RBTreeNode<Integer>(8);
		RBTreeNode<Integer> node7 = new RBTreeNode<Integer>(14);
		RBTreeNode<Integer> node8 = new RBTreeNode<Integer>(16);
		RBTreeNode<Integer> node9 = new RBTreeNode<Integer>(2);
		RBTreeNode<Integer> node10 = new RBTreeNode<Integer>(9);
		RBTreeNode<Integer> node11 = new RBTreeNode<Integer>(12);
		RBTreeNode<Integer> node12 = new RBTreeNode<Integer>(11);

		RBTree<Integer> tree = new RBTree<>();
		tree.add(node1);
		tree.add(node2);
		tree.add(node3);
		tree.add(node4);
		tree.add(node5);
		tree.add(node6);
		tree.add(node7);
		tree.add(node8);
		tree.add(node9);
		tree.add(node10);
		tree.add(node11);
		tree.add(node12);

		tree.preOrder().forEach(System.out::println);
	}

}

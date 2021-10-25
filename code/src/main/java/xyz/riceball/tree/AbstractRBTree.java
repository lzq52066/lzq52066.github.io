package xyz.riceball.tree;

import xyz.riceball.list.ArrayList;
import xyz.riceball.list.List;

/**
 * 红黑树抽象
 *
 * @author xiaovcloud
 * @since 2021/10/20 13:00
 */
public abstract class AbstractRBTree<T extends Comparable<T>> implements IRBTree<T> {
	protected RBTreeNode<T> root;

	/**
	 * 前序遍历
	 *
	 * @return List<RBTreeNode < T>>
	 */
	public List<RBTreeNode<T>> preOrder() {
		List<RBTreeNode<T>> treeNodes = new ArrayList<>();
		preOrder(treeNodes, root);
		return treeNodes;
	}

	/**
	 * 前序遍历
	 *
	 * @param treeNodes 记录的集合
	 * @param root      根节电
	 */
	private void preOrder(List<RBTreeNode<T>> treeNodes, RBTreeNode<T> root) {
		if (root == null) {
			return;
		}
		treeNodes.add(root);
		preOrder(treeNodes, root.getLeft());
		preOrder(treeNodes, root.getRight());
	}

	/**
	 * 中序遍历
	 *
	 * @return List<RBTreeNode < T>>
	 */
	public List<RBTreeNode<T>> inOrder() {
		List<RBTreeNode<T>> treeNodes = new ArrayList<>();
		inOrder(treeNodes, root);
		return treeNodes;
	}

	/**
	 * 中序遍历
	 *
	 * @param treeNodes 记录的集合
	 * @param root      根节电
	 */
	private void inOrder(List<RBTreeNode<T>> treeNodes, RBTreeNode<T> root) {
		if (root == null) {
			return;
		}
		inOrder(treeNodes, root.getLeft());
		treeNodes.add(root);
		inOrder(treeNodes, root.getRight());
	}


	/**
	 * 后序遍历
	 *
	 * @return List<RBTreeNode < T>>
	 */

	public List<RBTreeNode<T>> postOrder() {
		List<RBTreeNode<T>> treeNodes = new ArrayList<>();
		postOrder(treeNodes, root);
		return treeNodes;
	}

	/**
	 * 后序遍历
	 *
	 * @param treeNodes 记录的集合
	 * @param root      根节电
	 */
	private void postOrder(List<RBTreeNode<T>> treeNodes, RBTreeNode<T> root) {
		if (root == null) {
			return;
		}
		postOrder(treeNodes, root.getLeft());
		postOrder(treeNodes, root.getRight());
		treeNodes.add(root);
	}


}

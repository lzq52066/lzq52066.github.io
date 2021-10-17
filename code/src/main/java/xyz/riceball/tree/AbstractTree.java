package xyz.riceball.tree;

import lombok.Data;
import xyz.riceball.list.ArrayList;
import xyz.riceball.list.List;

/**
 * 树的默认实现
 *
 * @author xiaovcloud
 * @since 2021/10/14 19:52
 */
@Data
public abstract class AbstractTree<T extends Comparable<T>> implements Tree<T> {

	protected TreeNode<T> root;

	/**
	 * 前序遍历
	 *
	 * @return List<TreeNode < T>>
	 */
	public List<TreeNode<T>> preOrder() {
		List<TreeNode<T>> treeNodes = new ArrayList<>();
		preOrder(treeNodes, root);
		return treeNodes;
	}

	/**
	 * 前序遍历
	 *
	 * @param treeNodes 记录的集合
	 * @param root      根节电
	 */
	private void preOrder(List<TreeNode<T>> treeNodes, TreeNode<T> root) {
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
	 * @return List<TreeNode < T>>
	 */
	public List<TreeNode<T>> inOrder() {
		List<TreeNode<T>> treeNodes = new ArrayList<>();
		inOrder(treeNodes, root);
		return treeNodes;
	}

	/**
	 * 中序遍历
	 *
	 * @param treeNodes 记录的集合
	 * @param root      根节电
	 */
	private void inOrder(List<TreeNode<T>> treeNodes, TreeNode<T> root) {
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
	 * @return List<TreeNode < T>>
	 */

	public List<TreeNode<T>> postOrder() {
		List<TreeNode<T>> treeNodes = new ArrayList<>();
		postOrder(treeNodes, root);
		return treeNodes;
	}

	/**
	 * 后序遍历
	 *
	 * @param treeNodes 记录的集合
	 * @param root      根节电
	 */
	private void postOrder(List<TreeNode<T>> treeNodes, TreeNode<T> root) {
		if (root == null) {
			return;
		}
		postOrder(treeNodes, root.getLeft());
		postOrder(treeNodes, root.getRight());
		treeNodes.add(root);
	}

}

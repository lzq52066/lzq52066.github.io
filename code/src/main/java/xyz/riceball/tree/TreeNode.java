package xyz.riceball.tree;

import lombok.Data;

/**
 * Node节点
 *
 * @author xiaovcloud
 * @since 2021/10/14 19:52
 */
@Data
public class TreeNode<T extends Comparable<T>> {
	private T value;
	private TreeNode<T> left;
	private TreeNode<T> right;

	public TreeNode(T value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node{" +
				"value=" + value +
				", left=" + (left == null ? "null" : left.value) +
				", right=" + (right == null ? "null" : right.value) +
				'}';
	}
}

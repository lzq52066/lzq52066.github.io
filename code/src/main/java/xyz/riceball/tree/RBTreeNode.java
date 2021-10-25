package xyz.riceball.tree;

import lombok.Data;

/**
 * 红黑树节点
 *
 * @author xiaovcloud
 * @since 2021/10/20 8:24
 */
@Data
public class RBTreeNode<T extends Comparable<T>> {

	/**
	 * 左子树
	 */
	private RBTreeNode<T> left;
	/**
	 * 右子树
	 */
	private RBTreeNode<T> right;
	/**
	 * 颜色,默认为红色
	 */
	private boolean color;
	/**
	 * 值
	 */
	private T value;
	/**
	 * 父节点
	 */
	private RBTreeNode<T> parent;

	public static final Boolean RED = false;
	public static final Boolean BLACK = true;

	public RBTreeNode(T value) {
		this.value = value;
		this.color = RED;
	}

	public RBTreeNode(boolean color, T value) {
		this.color = color;
		this.value = value;
	}

	@Override
	public String toString() {
		return "RBTreeNode{" +
				"value=" + value +
				", color=" + (color ? "black" : "red") +
				", left=" + (left == null ? "null" : left.value) +
				", right=" + (right == null ? "null" : right.value) +
				'}';
	}
}

package xyz.riceball.tree;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * 二叉查找树
 *
 * @author xiaovcloud
 * @since 2021/10/14 19:52
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
public class BinaryTree<T extends Comparable<T>> extends AbstractTree<T> {

	/**
	 * 添加一个节点
	 *
	 * @param treeNode 节点
	 * @return boolean
	 */
	@Override
	public boolean add(TreeNode<T> treeNode) {
		if (this.root == null) {
			//root不存在
			this.root = treeNode;
			return true;
		}

		TreeNode<T> current = this.root;
		for (; ; ) {
			if (current.getValue().compareTo(treeNode.getValue()) >= 0) {
				//如果current的值大于传入的值
				if (current.getLeft() != null) {
					current = current.getLeft();
				} else {
					current.setLeft(treeNode);
					break;
				}
			} else {
				if (current.getRight() != null) {
					current = current.getRight();
				} else {
					current.setRight(treeNode);
					break;
				}
			}
		}
		return true;
	}

	/**
	 * 删除一个节点
	 *
	 * @param value 值
	 * @return boolean
	 */
	@Override
	public boolean delete(T value) {
		TreeNode<T> parent = null;
		TreeNode<T> current = this.root;
		for (; ; ) {
			if (current.getValue().compareTo(value) == 0) {
				delete(parent, current);
				return true;
			} else if (current.getValue().compareTo(value) > 0) {
				//如果传入的值小于current的值
				if (current.getLeft() != null) {
					parent = current;
					current = current.getLeft();
				} else {
					return false;
				}
			} else if (current.getValue().compareTo(value) < 0) {
				//如果传入的值大于current的值
				if (current.getRight() != null) {
					parent = current;
					current = current.getRight();
				} else {
					return false;
				}
			}
		}
	}

	/**
	 * 删除节点
	 *
	 * @param parent  待删除的父节点
	 * @param current 待删除的节点
	 */
	private void delete(TreeNode<T> parent, TreeNode<T> current) {
		//将中序后继节点的父节点左节点设置为null,增加参数setParentNull
		TreeNode<T> successorNode = this.getInOrderSuccessorTreeNode(current, true);

		if (parent != null) {
			//判断是左子节点还是右子节点
			if (parent.getRight() != null && parent.getRight().getValue().equals(current.getValue())) {
				parent.setRight(successorNode);
			} else {
				parent.setLeft(successorNode);
			}
		} else {
			//父节点为空,就是删除的根节点,把中序后继节点赋值给根节点
			this.root = successorNode;
		}

		if (successorNode != null) {
			successorNode.setLeft(current.getLeft());
			successorNode.setRight(current.getRight());
		}
	}

	/**
	 * 获取节点的中序后继节点
	 *
	 * @param node          节点
	 * @param setParentNull 是否设置中序后继节点位置为空
	 * @return 返回中序后继节点
	 */
	private TreeNode<T> getInOrderSuccessorTreeNode(TreeNode<T> node, boolean setParentNull) {
		if (node == null || node.getRight() == null) {
			return null;
		}
		TreeNode<T> parent = node;
		node = node.getRight();
		int count = 0;
		while (node.getLeft() != null) {
			parent = node;
			node = node.getLeft();
			count++;
		}
		if (count == 0 && setParentNull) {
			parent.setRight(null);
		} else if (count > 0 && setParentNull) {
			parent.setLeft(null);
		}
		return node;
	}


}

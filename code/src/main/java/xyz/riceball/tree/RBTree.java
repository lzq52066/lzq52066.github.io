package xyz.riceball.tree;

/**
 * 红黑树业务实现
 *
 * @author xiaovcloud
 * @since 2021/10/20 8:22
 */
public class RBTree<T extends Comparable<T>> extends AbstractRBTree<T> {
	/**
	 * 获取父节点
	 *
	 * @param treeNode 当前节点
	 * @return 父节点
	 */
	private RBTreeNode<T> getParent(RBTreeNode<T> treeNode) {
		if (treeNode == null) {
			return null;
		}
		return treeNode.getParent();
	}

	/**
	 * 获取祖父节点
	 *
	 * @param treeNode 当前节点
	 * @return 祖父节点
	 */
	private RBTreeNode<T> getGrandParent(RBTreeNode<T> treeNode) {
		if (treeNode == null || treeNode.getParent() == null) {
			return null;
		}
		return treeNode.getParent().getParent();
	}

	@Override
	public boolean add(RBTreeNode<T> treeNode) {
		if (this.root == null) {
			//root不存在
			this.root = treeNode;
			this.root.setColor(RBTreeNode.BLACK);
			return true;
		}

		RBTreeNode<T> current = this.root;
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
		//插入完成,设置父节点
		treeNode.setParent(current);

		//处理红黑树的结构
		fixTreeUp(treeNode);
		return true;
	}

	/**
	 * 修正红黑树
	 *
	 * @param treeNode 当前节点
	 */
	private void fixTreeUp(RBTreeNode<T> treeNode) {

		RBTreeNode<T> parent = getParent(treeNode);
		//父节点不存在
		if (parent == null) {
			//只有root节点
			this.root.setColor(RBTreeNode.BLACK);
			return;
		}

		//如果父节点存在，并且父节点是红色的，红色父节点，祖父节点不可能为空
		if (parent.isColor() == RBTreeNode.RED) {
			RBTreeNode<T> grandParent = getGrandParent(treeNode);
			RBTreeNode<T> uncle = parent.equals(grandParent.getRight())
					? grandParent.getLeft() : grandParent.getRight();

			//如果叔叔节点存在,且是红色
			if (uncle != null && uncle.isColor() == RBTreeNode.RED) {
				//将父亲和叔叔节点变成黑色，将祖父节点(祖父节点之前一定是黑色的)变成红色，并将祖父节点设为当前节点接着判断
				parent.setColor(RBTreeNode.BLACK);
				uncle.setColor(RBTreeNode.BLACK);
				grandParent.setColor(RBTreeNode.RED);
				fixTreeUp(grandParent);
				return;
			}
			//叔叔节点不存在或者为黑色
			if (parent.equals(grandParent.getLeft()) && treeNode.equals(parent.getLeft())) {
				//如果父节点是祖父节点的左孩子,且插入节点是父节点的左孩子 LL
				//交换祖父节点和父亲节点的颜色，再以祖父节点为支点进行右旋转
				parent.setColor(RBTreeNode.BLACK);
				grandParent.setColor(RBTreeNode.RED);
				rightRotate(grandParent);
			} else if (parent.equals(grandParent.getLeft()) && treeNode.equals(parent.getRight())) {
				//如果父节点是祖父节点的左孩子,且插入节点是父节点的右孩子 LR
				//以父节点左旋得到LL,再指定父节点为当前节点,进行下一轮
				leftRotate(parent);
				fixTreeUp(parent);
				return;
			} else if (parent.equals(grandParent.getRight()) && treeNode.equals(parent.getRight())) {
				//如果父节点是祖父节点的右孩子,且插入节点是父节点的右孩子 RR
				//交换祖父节点和父亲节点的颜色，再以祖父节点为支点进行左旋转
				parent.setColor(RBTreeNode.BLACK);
				grandParent.setColor(RBTreeNode.RED);
				leftRotate(grandParent);
			} else if (parent.equals(grandParent.getRight()) && treeNode.equals(parent.getLeft())) {
				//如果父节点是祖父节点的右孩子,且插入节点是父节点的右孩子 RL
				//以父节点右旋得到RR,再指定父节点为当前节点,进行下一轮
				rightRotate(parent);
				fixTreeUp(parent);
				return;
			}
		}
		//将根节点设置为黑色
		this.root.setColor(RBTreeNode.BLACK);
	}

	@Override
	public boolean delete(T value) {
		RBTreeNode<T> current = this.root;
		for (; ; ) {
			if (current.getValue().equals(value)) {

				break;
			}
		}
		return true;
	}

	/**
	 * 左旋转
	 *
	 * @param node 当前节点
	 */
	private void leftRotate(RBTreeNode<T> node) {
		RBTreeNode<T> right = node.getRight();
		node.setRight(right.getLeft());
		if (right.getLeft() != null) {
			right.getLeft().setParent(node);
		}
		right.setParent(node.getParent());
		if (node.getParent() == null) {
			this.root = right;
		} else if (node == node.getParent().getLeft()) {
			node.getParent().setLeft(right);
		} else {
			node.getParent().setRight(right);
		}
		right.setLeft(node);
		node.setParent(right);

	}

	/**
	 * 右旋转
	 *
	 * @param node 当前节点
	 */
	private void rightRotate(RBTreeNode<T> node) {
		RBTreeNode<T> left = node.getLeft();
		node.setLeft(left.getRight());
		if (left.getRight() != null) {
			left.getRight().setParent(node);
		}
		left.setParent(node.getParent());
		if (node.getParent() == null) {
			this.root = left;
		} else if (node == node.getParent().getLeft()) {
			node.getParent().setLeft(left);
		} else {
			node.getParent().setRight(left);
		}
		left.setRight(node);
		node.setParent(left);
	}

}

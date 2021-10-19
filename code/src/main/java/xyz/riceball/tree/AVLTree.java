package xyz.riceball.tree;


/**
 * 二叉平衡树
 *
 * @author xiaovcloud
 * @since 2021/10/14 19:52
 */
public class AVLTree<T extends Comparable<T>> extends BinaryTree<T> {

	/**
	 * 节点为node的树的高度
	 *
	 * @param node 节点
	 * @return int
	 */
	public int height(TreeNode<T> node) {
		return Math.max(node == null ? 0 : height(node.getLeft())
				, node == null ? 0 : height(node.getRight())) + 1;
	}

	/**
	 * 左子节树的高度
	 *
	 * @param node 节点
	 * @return int
	 */
	public int lHeight(TreeNode<T> node) {
		if (node == null) {
			return 0;
		}
		return height(node.getLeft());
	}

	/**
	 * 右子节树的高度
	 *
	 * @param node 节点
	 * @return int
	 */
	public int rHeight(TreeNode<T> node) {
		if (node == null) {
			return 0;
		}
		return height(node.getRight());
	}

	/**
	 * 平衡树添加节点
	 * 双旋转目的 : 先解决一遍树的高度
	 *
	 * @param treeNode 节点
	 * @return boolean
	 */
	@Override
	public boolean add(TreeNode<T> treeNode) {
		super.add(treeNode);
		return rotate();
	}

	/**
	 * 平衡树添加节点
	 * 双旋转目的 : 先解决一遍树的高度
	 *
	 * @param value 需要删除的值
	 * @return boolean
	 */
	@Override
	public boolean delete(T value) {
		boolean delete = super.delete(value);
		if (delete) {
			return rotate();
		}
		return false;
	}

	/**
	 * 旋转
	 */
	private boolean rotate() {
		//右子节点 - 左子节点 > 1 左旋
		if (rHeight(this.root) - lHeight(this.root) > 1) {
			//如果 右子树的 左子树高度 大于 右子树高度 ,先对右子树进行右旋
			if (this.root.getRight() != null &&
					lHeight(this.root.getRight()) > rHeight(this.root.getRight())) {
				rightRotate(this.root.getRight());
			}
			leftRotate(this.root);
		}
		//左子节点 - 右子节点 > 1 右旋
		else if (lHeight(this.root) - rHeight(this.root) > 1) {
			//如果 左子树的 右子树高度 大于 左子树高度 ,先对左子树进行左旋
			if (this.root.getLeft() != null &&
					rHeight(this.root.getLeft()) > lHeight(this.root.getLeft())) {
				leftRotate(this.root.getLeft());
			}
			rightRotate(this.root);
		}
		return true;
	}

	/**
	 * 左旋转
	 *
	 * @param node 当前节点
	 */
	private void leftRotate(TreeNode<T> node) {
		//添加后, 右子节点 - 左子节点 > 1 左旋
		//1. 创建一个新节点，值等于当前根节点
		TreeNode<T> newNode = new TreeNode<T>(node.getValue());
		//2. 把新节点的左子树设置为当前节点的左子树
		newNode.setLeft(node.getLeft());
		//3. 把新节点的右子树设置为当前节点右子树的左子树
		newNode.setRight(node.getRight().getLeft());
		//4. 把当前节点的值替换为右子节点的值
		node.setValue(node.getRight().getValue());
		//5. 把当前节点的右子树设置为右子树的右子树
		node.setRight(node.getRight().getRight());
		//6. 把当前节点的左子树设置为新的节点
		node.setLeft(newNode);
	}

	/**
	 * 右旋转
	 *
	 * @param node 当前节点
	 */
	private void rightRotate(TreeNode<T> node) {
		//添加后, 右子节点 - 左子节点 > 1 左旋
		//1. 创建一个新节点，值等于当前根节点
		TreeNode<T> newNode = new TreeNode<T>(node.getValue());
		//2. 把新节点的右子树设置为当前节点的右子树
		newNode.setRight(node.getRight());
		//3. 把新节点的左子树设置为当前节点左子树的右子树
		newNode.setLeft(node.getLeft().getRight());
		//4. 把当前节点的值替换为左子节点的值
		node.setValue(node.getLeft().getValue());
		//5. 把当前节点的左子树设置为左子树的左子树
		node.setLeft(node.getLeft().getLeft());
		//6. 把当前节点的右子树设置为新的节点
		node.setRight(newNode);
	}

}

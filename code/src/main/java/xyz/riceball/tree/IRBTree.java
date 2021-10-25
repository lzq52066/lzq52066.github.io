package xyz.riceball.tree;

/**
 * 红黑树接口
 *
 * @author xiaovcloud
 * @since 2021/10/20 13:03
 */
public interface IRBTree<T extends Comparable<T>> {

	/**
	 * 添加一个节点
	 *
	 * @param treeNode 节点
	 * @return boolean
	 */
	boolean add(RBTreeNode<T> treeNode);

	/**
	 * 删除值为value的节点
	 *
	 * @param value 值
	 * @return 返回旧的节点
	 */
	boolean delete(T value);

}

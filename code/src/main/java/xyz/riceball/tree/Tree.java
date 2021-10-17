package xyz.riceball.tree;

/**
 * Tree的接口
 *
 * @author xiaovcloud
 * @since 2021/10/14 19:52
 */
public interface Tree<T extends Comparable<T>> {

	/**
	 * 添加一个节点
	 *
	 * @param treeNode 节点
	 * @return boolean
	 */
	boolean add(TreeNode<T> treeNode);

	/**
	 * 删除值为value的节点
	 *
	 * @param value 值
	 * @return 返回旧的节点
	 */
	boolean delete(T value);

}

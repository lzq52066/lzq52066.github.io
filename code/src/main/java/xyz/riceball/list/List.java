package xyz.riceball.list;

import java.util.Iterator;

/**
 * List的接口
 *
 * @author xiaovcloud
 * @since 2021/10/14 19:52
 */
public interface List<E> extends Iterable<E> {
	/**
	 * List的大小
	 *
	 * @return int
	 */
	int size();

	/**
	 * 实现迭代器
	 *
	 * @return Iterator
	 */
	@Override
	Iterator<E> iterator();

	/**
	 * 是否为空
	 *
	 * @return boolean
	 */
	boolean isEmpty();

	/**
	 * 是否包含指定的值
	 *
	 * @param value 指定的value
	 * @return boolean
	 */
	boolean contains(Object value);

	/**
	 * 添加一个值
	 *
	 * @param value 值
	 * @return boolean
	 */
	boolean add(E value);

	/**
	 * 移除一个值
	 *
	 * @param index 移除的索引
	 * @return E
	 */
	E remove(int index);

	/**
	 * 移除一个数据
	 *
	 * @param o 需要移除的数据
	 * @return boolean
	 */
	boolean remove(Object o);

	/**
	 * 获取指定位置的值
	 *
	 * @param index 指定索引
	 * @return E
	 */
	E get(int index);

}

package xyz.riceball.list;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Collection接口
 *
 * @author xiaovcloud
 * @since 2021/10/17 8:29
 */
public interface Collection<E> extends Iterable<E> {
	/**
	 * 集合的容量
	 *
	 * @return int
	 */
	int size();

	/**
	 * 集合是否为空
	 *
	 * @return boolean
	 */
	boolean isEmpty();

	/**
	 * 集合是否包含指定元素
	 *
	 * @param o 指定元素
	 * @return boolean
	 */
	boolean contains(Object o);

	/**
	 * 返回一个迭代器
	 *
	 * @return Iterator
	 */
	@Override
	Iterator<E> iterator();

	/**
	 * 新增一个元素
	 *
	 * @param e 需要添加的元素
	 * @return boolean
	 */
	boolean add(E e);

	/**
	 * 移除一个指定元素
	 *
	 * @param o 指定的值
	 * @return boolean
	 */
	boolean remove(Object o);

	/**
	 * 通过条件移除一个元素
	 *
	 * @param filter 条件
	 * @return boolean
	 */
	default boolean removeIf(Predicate<? super E> filter) {
		Objects.requireNonNull(filter);
		boolean removed = false;
		final Iterator<E> each = iterator();
		while (each.hasNext()) {
			if (filter.test(each.next())) {
				each.remove();
				removed = true;
			}
		}
		return removed;
	}

	/**
	 * 清除集合
	 */
	void clear();
}

package xyz.riceball.list;

import java.util.Iterator;

/**
 * 抽象List
 *
 * @author xiaovcloud
 * @since 2021/10/15 8:29
 */
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {

	protected AbstractList() {
	}

	/**
	 * 集合的大小
	 *
	 * @return int size
	 */
	@Override
	public abstract int size();

	@Override
	public boolean add(E e) {
		add(size(), e);
		return true;
	}

	public void add(int index, E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public abstract E get(int index);

	/**
	 * 抽象的迭代器方法
	 *
	 * @return Iterator
	 */
	@Override
	public abstract Iterator<E> iterator();

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

//	/**
//	 * 返回第一个数据索引的位置
//	 * 没有数据时返回-1
//	 *
//	 * @param value 数据
//	 * @return 索引
//	 */
//	public int indexOf(Object value) {
//		ListIterator<E> it = listIterator();
//		if (o==null) {
//			while (it.hasNext())
//				if (it.next()==null)
//					return it.previousIndex();
//		} else {
//			while (it.hasNext())
//				if (o.equals(it.next()))
//					return it.previousIndex();
//		}
//		return -1;
//	}
//
//	public ListIterator<E> listIterator() {
//		return listIterator(0);
//	}
//
//	public ListIterator<E> listIterator(final int index) {
//
//		return new java.util.AbstractList.ListItr(index);
//	}


//	/**
//	 * 移除一个数据
//	 *
//	 * @param o 需要移除的数据
//	 * @return boolean
//	 */
//	@Override
//	public boolean remove(Object o) {
//		Iterator<E> it = iterator();
//		if (o == null) {
//			while (it.hasNext()) {
//				if (it.next() == null) {
//					it.remove();
//					return true;
//				}
//			}
//		} else {
//			while (it.hasNext()) {
//				if (o.equals(it.next())) {
//					it.remove();
//					return true;
//				}
//			}
//		}
//		return false;
//	}


}

package xyz.riceball.list;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ArrayList 集合
 *
 * @author xiaovcloud
 * @since 2021/10/15 8:29
 */
@Slf4j
public class ArrayList<E> extends AbstractList<E> implements List<E>, Serializable {

	private static final long serialVersionUID = 8683452581122892189L;
	/**
	 * 默认初始化的空数据
	 */
	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
	/**
	 * 默认的容量
	 */
	private static final int DEFAULT_CAPACITY = 10;
	/**
	 * 作为list的底层数据
	 */
	transient Object[] elementData;
	/**
	 * List的容量
	 */
	private int size;

	public ArrayList() {
		this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
	}

	public ArrayList(int size) {
		if (size > 0) {
			this.elementData = new Object[size];
		} else if (size == 0) {
			this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
		} else {
			throw new IllegalArgumentException("Illegal Capacity: " + size);
		}
	}

	/**
	 * 获取集合的容量
	 *
	 * @return int
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * 添加数据
	 *
	 * @param value 值
	 * @return boolean
	 */
	@Override
	public boolean add(E value) {
		add(value, elementData, size);
		return true;
	}

	/**
	 * 添加数据
	 *
	 * @param e           添加的数据
	 * @param elementData 添加的数组
	 * @param size        数据的大小
	 */
	public void add(E e, Object[] elementData, int size) {
		if (size == elementData.length) {
			elementData = grow();
		}
		elementData[size] = e;
		this.size = size + 1;
	}

	/**
	 * 扩容
	 *
	 * @return Object[]
	 */
	private Object[] grow() {
		//防止最开始初始化一直为0的情况
		return grow(size + 1);
	}

	/**
	 * 扩容
	 *
	 * @param minCapacity 最小的容量
	 * @return Object[]
	 */
	private Object[] grow(int minCapacity) {
		int length = size << 1;
		if (length <= minCapacity) {
			//扩容之后,还是比之前的小
			length = DEFAULT_CAPACITY;
		}
		return elementData = Arrays.copyOf(elementData, length);
	}

	/**
	 * 移除指定索引的数据
	 *
	 * @param index 移除的索引
	 * @return 移除的值
	 */
	@Override
	public E remove(int index) {
		@SuppressWarnings("unchecked")
		E oldValue = (E) elementData[index];
		Object[] elementData = this.elementData;
		fastRemove(elementData, index);
		return oldValue;
	}

	/**
	 * 移除指定的数据
	 *
	 * @param o 需要移除的数据
	 * @return boolean
	 */
	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		if (index < 0) {
			return false;
		}
		Object[] elementData = this.elementData;
		fastRemove(elementData, index);
		return true;
	}

	/**
	 * 返回第一个数据索引的位置
	 * 没有数据时返回-1
	 *
	 * @param value 数据
	 * @return 索引
	 */
	public int indexOf(Object value) {
		Object[] elementData = this.elementData;
		int size = this.size;
		int i = 0;
		if (value == null) {
			for (; i < size; i++) {
				if (elementData[i] == null) {
					return i;
				}
			}
		} else {
			for (; i < size; i++) {
				if (value.equals(elementData[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * 快速移除数据
	 *
	 * @param es 移除的数组
	 * @param i  移除的元素
	 */
	private void fastRemove(Object[] es, int i) {
		final int newSize;
		if ((newSize = size - 1) > i) {
			System.arraycopy(es, i + 1, es, i, newSize - i);
		}
		es[size = newSize] = null;
	}

	/**
	 * 通过索引获取数据
	 *
	 * @param index 指定索引
	 * @return E
	 */
	@Override
	public E get(int index) {
		return elementData(index);
	}

	/**
	 * 获取数据
	 *
	 * @param index 索引
	 * @return E
	 */
	@SuppressWarnings("unchecked")
	E elementData(int index) {
		return (E) elementData[index];
	}

	/**
	 * 是否包含数据
	 *
	 * @param value 指定的value
	 * @return
	 */
	@Override
	public boolean contains(Object value) {
		return indexOf(value) >= 0;
	}

	/**
	 * 返回自己实现的迭代器
	 *
	 * @return Iterator
	 */
	@Override
	public Iterator<E> iterator() {
		return new Itr();
	}


	private class Itr implements Iterator<E> {
		int cursor;
		int lastRet = -1;

		Itr() {
		}

		@Override
		public boolean hasNext() {
			return cursor != size;
		}

		@Override
		@SuppressWarnings("unchecked")
		public E next() {
			int i = cursor;
			if (i >= size) {
				throw new NoSuchElementException();
			}
			Object[] elementData = ArrayList.this.elementData;
			if (i >= elementData.length) {
				throw new ConcurrentModificationException();
			}
			cursor = i + 1;
			return (E) elementData[lastRet = i];
		}

		@Override
		public void remove() {
			if (lastRet < 0) {
				throw new IllegalStateException();
			}
			try {
				ArrayList.this.remove(lastRet);
				cursor = lastRet;
				lastRet = -1;
			} catch (IndexOutOfBoundsException ex) {
				throw new ConcurrentModificationException();
			}
		}
	}
}

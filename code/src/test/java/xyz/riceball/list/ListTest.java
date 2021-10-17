package xyz.riceball.list;

import org.junit.Test;

import java.util.Iterator;

/**
 * list测试
 *
 * @author xiaovcloud
 * @since 2021/10/17 19:52
 */
public class ListTest {

	@Test
	public void testArrayList() {
		List<String> arrayList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			arrayList.add(i + "");
		}
		System.out.println(arrayList);
		for (int i = 0; i < 6; i++) {
			arrayList.remove(i + "");
		}
		System.out.println(arrayList);

	}

	@Test
	public void testIterator() {
		List<String> arrayList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			arrayList.add(i + "");
		}

		Iterator<String> it = arrayList.iterator();
		while (it.hasNext()) {
			String next = it.next();
			if (next.equals("9")) {
				it.remove();
			}
			System.out.print(next + " ");
		}
		System.out.println();
		System.out.println(arrayList);

//		for (String s : arrayList) {
//			System.out.print(s+" ");
//			if (s.equals("9")){
//				arrayList.remove(s);
//			}
//		}

		System.out.println(arrayList);
	}
}

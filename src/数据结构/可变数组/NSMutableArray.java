/**
 * NSMutableArray.java
 * Created by SaiDiCaprio on 2020/6/1.
 * Copyright © 2020 SaiDiCaprio. All rights reserved.
 */

package 数据结构.可变数组;

import 实体类.Person;

@SuppressWarnings("unchecked")
public class NSMutableArray<E> {
    /** 元素的数量 */
    private int size;
    /** 所有的元素 */
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    public NSMutableArray(int capaticy) {
        capaticy = Math.max(capaticy, DEFAULT_CAPACITY);
        elements = (E[]) new Object[capaticy];
    }

    public NSMutableArray() {
        this(DEFAULT_CAPACITY);
    }

    /** 清除所有元素 */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /** 元素的数量 */
    public int size() {
        return size;
    }

    /**  是否为空 */
    public boolean isEmpty() {
        return size == 0;
    }

    /** 是否包含某个元素 */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /** 添加元素到尾部 */
    public void add(E element) {
        add(size, element);
    }

    /** 获取index位置的元素 */
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 设置index位置的元素
     * @return 原来的元素ֵ
     */
    public E set(int index, E element) {
        rangeCheck(index);

        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /** 在index位置插入一个元素 */
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    /** * 删除index位置的元素  */
    public E remove(int index) {
        rangeCheck(index);

        E old = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        return old;
    }

    /** 查看元素的索引 */
    public int indexOf(E element) {
        // 查看第一个空元素的位置
        if (element == null) {  // 1
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i; // n
            }
        }
        return ELEMENT_NOT_FOUND;
    }

//	public int indexOf2(E element) {
//		for (int i = 0; i < size; i++) {
//			if (valEquals(element, elements[i])) return i; // 2n
//		}
//		return ELEMENT_NOT_FOUND;
//	}
//
//	private boolean valEquals(Object v1, Object v2) {
//		return v1 == null ? v2 == null : v1.equals(v2);
//	}

    /**
     * 保证要有capacity的容量
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;

        System.out.println(oldCapacity + "扩容为" + newCapacity);
    }

    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    @Override
    public String toString() {
        // size=3, [99, 88, 77]
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(elements[i]);

//			if (i != size - 1) {
//				string.append(", ");
//			}
        }
        string.append("]");
        return string.toString();
    }

    private static void NSLog(Object x) {
        System.out.println(x);
    }

    public static void TestMutableArray() {
        NSMutableArray<Person> array = new NSMutableArray<Person>();
    }
}

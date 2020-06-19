/**
 * AbstractList.java
 * Created by SaiDiCaprio on 2020/6/10.
 * Copyright © 2020 SaiDiCaprio. All rights reserved.
 */

package 数据结构.链表;

public abstract class AbstractList<E> implements List<E> {
    /** 元素的数量 */
    protected int size;

    /**  元素的数量 */
    public int size() {
        return size;
    }

    /** 是否为空 */
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

    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }
}


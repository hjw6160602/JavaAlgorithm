/**
 * List.java
 * Created by SaiDiCaprio on 2020/6/10.
 * Copyright © 2020 SaiDiCaprio. All rights reserved.
 */

package 数据结构.链表;

public interface List<E> {
    static final int ELEMENT_NOT_FOUND = -1;
    /** 清除所有元素 */
    void clear();

    /** 元素的数量 */
    int size();

    /** 是否为空 */
    boolean isEmpty();

    /** 是否包含某个元素 */
    boolean contains(E element);

    /** 添加元素到尾部 */
    void add(E element);

    /** 获取index位置的元素 */
    E get(int index);

    /** 设置index位置的元素 */
    E set(int index, E element);

    /** 在index位置插入一个元素 */
    void add(int index, E element);

    /** 删除index位置的元素 */
    E remove(int index);

    /** 查看元素的索引 */
    int indexOf(E element);
}


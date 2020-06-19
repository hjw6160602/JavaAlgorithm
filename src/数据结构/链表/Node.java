/**
 * LinkList.Node.java
 * Created by SaiDiCaprio on 2020/6/10.
 * Copyright © 2020 SaiDiCaprio. All rights reserved.
 */

package 数据结构.链表;

public class Node<E> {
    E element;
    Node<E> prev;
    Node<E> next;
    // 构造函数
    public Node(Node<E> prev, E element, Node<E> next) {
        this.prev = prev;
        this.element = element;
        this.next = next;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (prev != null) {
            sb.append(prev.element);
        } else {
            sb.append("null");
        }

        sb.append("->").append(element).append("->");

        if (next != null) {
            sb.append(next.element);
        } else {
            sb.append("null");
        }

        return sb.toString();
    }
}
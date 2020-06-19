/**
 * BinarySearchTree.java
 * Created by SaiDiCaprio on 2020/6/18.
 * Copyright © 2020 SaiDiCaprio. All rights reserved.
 */

package 数据结构.二叉树;


public class BinarySearchTree<E extends Comparable> {
    private int size;
    private Node<E> root;

    public void add(E element) {
        elementNotNullCheck(element);
        if( root == null) {
            root = new Node<E>(element, null);
            size++;
            return;
        }
        // 需要记录父节点和位置来保证插入的位置
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {// 如果相等 直接返回
                return;
            }
        }
        // 看看插入到父节点的哪个位置
        Node<E> newNOde = new Node<E>(element, parent);
        if (cmp > 0) {
            parent.right = newNOde;
        } else {
            parent.left = newNOde;
        }
        size++;
    }

    /**
     *
     * @param e1 待比较的元素1
     * @param e2 待比较的元素2
     * @return boolean
     *
     */
    private int compare(E e1, E e2) {
        return e1.compareTo(e2);
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {

        }
    }

}

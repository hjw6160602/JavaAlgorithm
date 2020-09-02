/**
 * BinarySearchTree.java
 * Created by SaiDiCaprio on 2020/6/18.
 * Copyright © 2020 SaiDiCaprio. All rights reserved.
 */

package 数据结构.二叉树.二叉搜索树;

import 数据结构.二叉树.Node;
import 数据结构.二叉树.Printer.BinaryTreeInfo;
import java.util.Comparator;
import java.lang.Comparable;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E> implements BinaryTreeInfo {
    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    // 比较器可能为空
    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }
    // 增
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

    // 查 前序遍历
    public void preOrder(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        preOrderTraversal(root, visitor);
    }

    // 中 前序遍历
    public void inOrder(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        inOrderTraversal(root, visitor);
    }

    // 后 前序遍历
    public void postOrder(Visitor<E> visitor){
        if (visitor == null) {
            return;
        }
        postOrderTraversal(root, visitor);
    }

    public static void TestBinarySearchTree() {

    }

    // 前序遍历
    private void preOrderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) {
            return;
        }
        visitor.stop = visitor.visit(node.element);
        preOrderTraversal(node.left, visitor);
        preOrderTraversal(node.right, visitor);
    }

    // 中序遍历
    private void inOrderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null) {
            return;
        }
        visitor.visit(node.element);
        inOrderTraversal(node.left, visitor);
        inOrderTraversal(node.right, visitor);

    }

    // 后序遍历
    private void postOrderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null) {
            return;
        }
        visitor.visit(node.element);
        postOrderTraversal(node.left, visitor);
        postOrderTraversal(node.right, visitor);
    }

    // 层级遍历
    private void levelOrderTraversal(Visitor<E> visitor) {
        if (root == null || visitor == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
//            System.out.println(node.element);
            visitor.visit(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    // 访问器
    public abstract static class Visitor<E> {
        boolean stop;

        boolean visit(E element) {
            return true;
        }
    }

    /**
     * @param e1 待比较的元素1
     * @param e2 待比较的元素2
     * @return boolean
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return this.comparator.compare(e1, e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>)node;
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = myNode.parent.element.toString();
        }
        return myNode.element + "_p(" + parentString + ")";
    }
}

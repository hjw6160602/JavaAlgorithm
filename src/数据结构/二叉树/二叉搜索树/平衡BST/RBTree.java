//package 数据结构.二叉树.二叉搜索树.平衡BST;
//
//import 数据结构.二叉树.Node;
//import 数据结构.二叉树.二叉搜索树.BinarySearchTree;
//
//import java.util.Comparator;
//
//public class RBTree<E> extends BinarySearchTree<E> {
//    private static final boolean RED = false;
//    private static final boolean BLACK = true;
//
//    public RBTree() {
//        this(null);
//    }
//
//    public RBTree(Comparator<E> comparator) {
//        super(comparator);
//        Node<E> node;
//        Node<E> parent = color(node.parent, RED);
//    }
//
//
//    protected void afterAdd(Node<E> node) {
//        Node<E> parent = node.parent;
//        // 添加的是根节点
//        if (parent == null) {
//           black(node);
//           return;
//        }
//        // 如果父节点是黑色，直接返回
//        if (isBlack(parent)) {
//            return;
//        }
//
//        // uncle节点
//        Node<E> uncle = parent.sibling();
//        // 祖父节点
//        Node<E> grand = parent.parent;
//        if (isRed(uncle)) {
//            black(uncle);
//            black(parent);
//            afterAdd(red(grand));
//            return;
//        }
//
//        // 叔父节点不是红色
//        if (parent.isLeftChild()) {
//            red(grand);
//            if (node.isLeftChild()) {
//                black(parent);
//            }
//        }
//
//    }
//
//    private Node<E> color(Node<E> node, boolean color) {
//        if (node == null) return node;
//        ((RBNode<E>)node).color = color;
//        return node;
//    }
//
//    private Node<E> red(Node<E> node) {
//        return color(node, RED);
//    }
//
//    private Node<E> black(Node<E> node) {
//        return color(node, BLACK);
//    }
//
//    private boolean isBlack(Node<E> node) {
//        return colorOf(node) == BLACK;
//    }
//
//    private boolean isRed(Node<E> node) {
//        return colorOf(node) == RED;
//    }
//
//    private boolean colorOf(Node<E> node) {
//        return node == null ? BLACK :((RBNode<E>)node).color;
//    }
//
//    private static  class RBNode<E> extends Node {
//        // 默认给红色 能够尽快让红黑树的性质 得到满足
//        boolean color = RED;
//        public  RBNode(E element, Node<E> parent) {
//            super(element, parent);
//        }
//
//        @Override
//        public String toString() {
//            return "RBNode{}";
//        }
//    }
//
//}

/**
 * ListGraph.java
 * Created by SaiDiCaprio on 2020/9/2.
 * Copyright © 2020 SaiDiCaprio. All rights reserved.
 */

package 数据结构.图;

import java.util.*;

public class ListGraph<V, E> implements Graph<V, E> {
    // 放着所有的顶点
    private Map<V, Vertex<V, E>> vertices = new HashMap<>();
    // 放着所有的边
    private Set<Edge<V, E>> edges = new HashSet<>();

    @Override
    public int edgeSize() {
        return edges.size();
    }

    @Override
    public int verticesSize() {
        return vertices.size();
    }

    @Override
    public void addVertex(V v) {
        if (vertices.containsKey(v)) return;
        vertices.put(v, new Vertex<>(v));
    }

    @Override
    // 添加一条有权重的边
    public void addEdge(V from, V to) {
        // 判断 from/to 的顶点是否存在
        addEdge(from, to, null);
    }

    @Override
    // 添加一条有权重的边
    public void addEdge(V from, V to, E weight) {
        Vertex<V, E>fromVertex = vertices.get(from);

        if (fromVertex == null) {
            fromVertex = new Vertex<>(from);
            vertices.put(from, fromVertex);
        }

        Vertex<V, E>toVertex = vertices.get(to);
        if (toVertex == null) {
            toVertex = new Vertex<>(to);
            vertices.put(to, toVertex);
        }

        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        edge.weight = weight;
        /**
        // 使用哈希表存储减少查询时间复杂度为O(1)
        if (fromVertex.outEdges.contains(edge)) {
            // 已经存在一条边 替换权重
            fromVertex.outEdges.remove(edge);
            toVertex.inEdges.remove(edge);

            fromVertex.outEdges.add(edge);
            toVertex.inEdges.add(edge);
        } else {
            // 没有这条存在的边
            fromVertex.outEdges.add(edge);
            toVertex.inEdges.add(edge);
        }*/
        //
        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }
        fromVertex.outEdges.add(edge);
        toVertex.inEdges.add(edge);
        edges.add(edge);
    }

    // 删除一个顶点
    @Override
    public void removeVertex(V v) {
        // 如果对应的key是存在的 java会把删除掉的key的value返回
        Vertex<V, E>vertex = vertices.remove(v);
        if (vertex == null) return;
        /**
        vertex.outEdges.forEach((Edge<V, E> edge) -> {
            // 一边遍历一边删除 有问题
            removeEdge(edge.from.value, edge.to.value);
        });

        vertex.inEdges.forEach((Edge<V, E> edge) -> {
            // 一边遍历一边删除 有问题
            removeEdge(edge.from.value, edge.to.value);
        }); */

        // 迭代器
        for (Iterator<Edge<V, E>> iterator = vertex.outEdges.iterator(); iterator.hasNext();) {
            Edge<V, E> edge = iterator.next();
            // 找到到达顶点的 所有进入边集合 并删除对应的边
            edge.to.inEdges.remove(edge);
            // 将当前遍历到的元素edge从集合vertex.outEdges中删除
            iterator.remove();
            edges.remove(edge);
        }

        for (Iterator<Edge<V, E>> iterator = vertex.inEdges.iterator(); iterator.hasNext();) {
            Edge<V, E> edge = iterator.next();
            // 找到到达顶点的 所有进入边集合 并删除对应的边
            edge.from.outEdges.remove(edge);
            // 将当前遍历到的元素edge从集合vertex.inEdges中删除
            iterator.remove();
            edges.remove(edge);
        }

    }

    // 删除一条边
    @Override
    public void removeEdge(Object from, Object to) {

        Vertex<V, E> fromVertex = vertices.get(from);
        if (fromVertex == null) return;

        Vertex<V, E> toVertex = vertices.get(to);
        if (toVertex == null) return;

        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        // 先尝试去删一下 如果成功就证明确实存在这条边
        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }
    }

    // 顶点
    private static class Vertex<V, E> {
        V value;
        // 以顶点为终点的边
        Set<Edge<V, E>> inEdges = new HashSet<>();
        // 以顶点为起点的边
        Set <Edge<V, E>> outEdges = new HashSet<>();

        public Vertex(V v) {
            this.value = v;
        }

        @Override
        public boolean equals(Object o) {
           return Objects.equals(value, ((Vertex<V, E>)o).value);
        }

        @Override
        public int hashCode() {
            return value == null ? 0 : value.hashCode();
        }

        @Override
        public String toString() {
//            String valueString = (value == null) ? "nil" : value.toString();
//            return "Vertex{" +
//                    "value=" + valueString +
//                    ", inEdges=" + inEdges +
//                    ", outEdges=" + outEdges +
//                    '}';
            return value == null ? "nil" :value.toString();
        }
    }

    // 边
    private  static class  Edge<V, E> {
        Vertex<V, E> from;
        Vertex<V, E> to;
        E weight;

        // 构造方法
        public Edge(Vertex<V, E> from, Vertex<V, E> to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            Edge<V, E> edge = (Edge<V, E>)o;
            // 起点与终点相同就认为这条边是相同的
            return Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
        }

        @Override
        public int hashCode() {
            return from.hashCode() * 31 + to.hashCode();
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }

    // 打印方法
    public void print() {
        vertices.forEach((V v, Vertex<V, E> vertex) -> {
            System.out.println("\n顶点：" + v);
            if (vertex.outEdges.size() > 0) {
                System.out.println("出去的边" + vertex.outEdges);
            }

            if (vertex.inEdges.size() > 0) {
                System.out.println("进来的边" + vertex.inEdges);
            }
        });

        System.out.println("\n========【图中的所有边】========");
        edges.forEach((Edge<V, E> edge) -> {
            System.out.println(edge);
        });
    }
}

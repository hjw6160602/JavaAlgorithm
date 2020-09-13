/**
 * Graph.java
 * Created by SaiDiCaprio on 2020/9/2.
 * Copyright © 2020 SaiDiCaprio. All rights reserved.
 */

package 数据结构.图;

import java.util.Set;
import 数据结构.链表.List;

public interface Graph<V, E> {
    // 边的条数
    int edgeSize();
    // 顶点个数
    int verticesSize();

    // 添加顶点
    void  addVertex(V v);

    // 添加无权重的边
    void  addEdge(V from, V to);
    // 添加有权重边
    void  addEdge(V from, V to, E weight);

    // 删除顶点
    void removeVertex(V v);
    // 删除边
    void removeEdge(V from, V to);

    // 广度优先搜索
    void bfs(V begin);
    // 深度优先搜索
    void dfs(V begin);

    // 最小生成树
    Set<EdgeInfo<V, E>> mst();

    // 拓扑排序
//    List<V> topologicalSort();

    interface VerTexVisitor<V> {
        boolean visit(V v);
    }

    class EdgeInfo<V, E> {
        // 起点
        private V from;
        // 终点
        private V to;
        // 权值
        private E weight;

        public EdgeInfo(V from, V to, E weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public V getFrom() {
            return from;
        }

        public V getTo() {
            return to;
        }

        public E getWeight() {
            return weight;
        }

        public void setFrom(V from) {
            this.from = from;
        }

        public void setTo(V to) {
            this.to = to;
        }

        public void setWeight(E weight) {
            this.weight = weight;
        }
    }
}

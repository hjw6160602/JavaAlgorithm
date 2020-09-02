/**
 * Graph.java
 * Created by SaiDiCaprio on 2020/9/2.
 * Copyright © 2020 SaiDiCaprio. All rights reserved.
 */

package 数据结构.图;

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


}

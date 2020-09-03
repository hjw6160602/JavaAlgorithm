/**
 * TestListGraph.java
 * Created by SaiDiCaprio on 2020/9/2.
 * Copyright © 2020 SaiDiCaprio. All rights reserved.
 */

package 数据结构.图;

public class TestListGraph {

    // 测试用例
    public static void testDirectionListGraph() {
        ListGraph<String, Integer> graph = new ListGraph<>();
        graph.addEdge("v1", "v0", 9);
        graph.addEdge("v1", "v2", 3);
        graph.addEdge("v2", "v0", 2);
        graph.addEdge("v2", "v3", 5);
        graph.addEdge("v3", "v4", 1);
        graph.addEdge("v0", "v4", 6);

//        graph.removeEdge("v0", "v4");
//        graph.removeVertex("v0");

        graph.bfs("v1");
//        graph.print();
    }

    public static void testNoDirectionListGraph() {
        ListGraph<String, Integer> graph = new ListGraph<>();
        graph.addEdge("v0", "v2");
        graph.addEdge("v2", "v0");

        graph.addEdge("v0", "v3");
        graph.addEdge("v3", "v0");

        graph.addEdge("v1", "v2");
        graph.addEdge("v2", "v1");

        graph.addEdge("v2", "v3");
        graph.addEdge("v3", "v2");

        graph.bfs("v1");
//        graph.print();
    }

}

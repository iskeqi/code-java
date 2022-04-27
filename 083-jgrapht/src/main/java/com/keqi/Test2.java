package com.keqi;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import java.util.Set;
import java.util.StringJoiner;

public class Test2 {

    public static void main(String[] args) {
        f();

        // 如果自己实现这个图呢？
        // 节点使用 HashSet 存储
        // 边使用长度为4的数组存储 int[] edge = new int[4]; 第一个参数为起点的 key，第二个为终点的key，第三个是权重，第四个是是否占用

        // 如何自定义实现 Dijkstra 算法

    }

    public static void f() {
        // 构造地图对象
        SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph =
                new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        // 添加顶点
        for (int i = 0; i < 8; i++) {
            graph.addVertex("v" + i);
        }

        // 添加边并指定权重
        graph.setEdgeWeight(graph.addEdge("v0", "v1"), 2);
        graph.setEdgeWeight(graph.addEdge("v0", "v2"), 1);
        graph.setEdgeWeight(graph.addEdge("v0", "v3"), 8);

        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 6);
        graph.setEdgeWeight(graph.addEdge("v1", "v4"), 1);

        graph.setEdgeWeight(graph.addEdge("v2", "v6"), 9);

        graph.setEdgeWeight(graph.addEdge("v3", "v4"), 5);
        graph.setEdgeWeight(graph.addEdge("v3", "v5"), 1);
        graph.setEdgeWeight(graph.addEdge("v3", "v6"), 2);
        graph.setEdgeWeight(graph.addEdge("v3", "v0"), 8);

        graph.setEdgeWeight(graph.addEdge("v4", "v5"), 3);
        graph.setEdgeWeight(graph.addEdge("v4", "v6"), 9);

        graph.setEdgeWeight(graph.addEdge("v5", "v6"), 4);
        graph.setEdgeWeight(graph.addEdge("v5", "v7"), 6);
        graph.setEdgeWeight(graph.addEdge("v5", "v3"), 1);

        graph.setEdgeWeight(graph.addEdge("v6", "v7"), 6);

        DefaultWeightedEdge v7_v5 = graph.addEdge("v7", "v5");

        graph.setEdgeWeight(v7_v5, 6);

        Set<DefaultWeightedEdge> edges = graph.edgeSet();
        for (DefaultWeightedEdge edge : edges) {
            System.out.println(edge);
        }

        // 获取图对应的 DijkstraShortestPath 对象
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        // 获取指定顶点到其他路径的最短路径
        ShortestPathAlgorithm.SingleSourcePaths<String, DefaultWeightedEdge> sourcePaths = dijkstraShortestPath.getPaths("v7");
        GraphPath<String, DefaultWeightedEdge> graphPath = sourcePaths.getPath("v0");
        if (graphPath != null) {
            // 打印出最短路径的顶点列表
            StringJoiner path = new StringJoiner(" -> ");
            for (String vertex : graphPath.getVertexList()) {
                path.add(vertex);
            }
            System.out.println(path);
            System.out.println(graphPath.getLength());
            System.out.println(graphPath.getWeight());
        } else {
            System.out.println("不存在指定路径");
        }
    }
}

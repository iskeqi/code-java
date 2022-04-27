package com.keqi;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.Graphs;
import org.jgrapht.alg.cycle.CycleDetector;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph = createGraph();
        printShortestPath(graph);
    }

    /**
     * 创建一个有向带权图
     */
    public static SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> createGraph() {

        String[] str = {"v0", "v1", "v2", "v3", "v4", "v5", "v6", "v7"};
        int[] startPoint = {0, 0, 0, 1, 1, 3, 3, 3, 3, 2, 4, 5, 5, 4, 6};
        int[] endPoint =   {1, 3, 2, 4, 3, 4, 5, 6, 2, 6, 5, 6, 7, 7, 7};
        double[] weights = {2, 8, 1, 1, 6, 5, 1, 2, 7, 9, 3, 4, 6, 9, 3};

        SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> directedGraph =
                new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        //添加顶点
        for (String s : str) {
            directedGraph.addVertex(s);
        }

        // 起点
        DefaultWeightedEdge[] edgeSources = new DefaultWeightedEdge[startPoint.length];
        // 终点
        DefaultWeightedEdge[] edgeTargets = new DefaultWeightedEdge[startPoint.length];

        for (int i = 0; i < endPoint.length; i++) {
            edgeSources[i] = directedGraph.addEdge(str[startPoint[i]], str[endPoint[i]]);
            edgeTargets[i] = directedGraph.addEdge(str[endPoint[i]], str[startPoint[i]]);
            directedGraph.setEdgeWeight(edgeSources[i], weights[i]);
            directedGraph.setEdgeWeight(edgeTargets[i], weights[i]);
        }
        return directedGraph;
    }

    /**
     * 根据得到的带权有向图，Dijkstra计算最短路径，并保存他们的路径权值之和到数组Dij中
     */
    public static void printShortestPath(SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph) {

        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraAlg = new DijkstraShortestPath<>(graph);

        // 获取从u0到u7的最短路径
        System.out.println("Shortest path from v0 to v7:");
        ShortestPathAlgorithm.SingleSourcePaths<String, DefaultWeightedEdge> sourcePaths = dijkstraAlg.getPaths("v0");
        GraphPath<String, DefaultWeightedEdge> u0ToU7ShortestPath = sourcePaths.getPath("v7");


        //打印路径
        List<String> pathsList = u0ToU7ShortestPath.getVertexList();

        StringBuilder sb = new StringBuilder();
        boolean firstElement = true;
        for (String s : pathsList) {
            if (firstElement) {
                sb.append(s);
                firstElement = false;
            } else {
                sb.append("->").append(s);
            }
        }
        System.out.println(sb);

        System.out.println("Shortest path weight:" + u0ToU7ShortestPath.getWeight());
        System.out.println(u0ToU7ShortestPath.getStartVertex());
        System.out.println(u0ToU7ShortestPath.getEndVertex());
        System.out.println(u0ToU7ShortestPath.getLength());
    }
}

package com.graph;

import com.graph.algorithms.BFS;
import com.graph.algorithms.DFS;
import com.graph.algorithms.GraphRatio;
import com.graph.analyze.AnalyzeGraph;
import com.graph.file.FileService;
import com.graph.matrix.AdjacencyMatrix;
import com.graph.matrix.IncidenceMatrix;
import com.graph.matrix.MatrixService;
import java.io.IOException;
import java.nio.file.Path;

import com.graph.algorithms.ColoringGraph;
import com.graph.matrix.WeightedMatrix;

/**
 * Вивід матриць інцидентності та суміжності. За вимогою користувача програма
 * повинна виводити матриці інцидентності та суміжності (окремі функції) на екран
 * та у текстовий файл, який вказує користувач.
 * @author Arsen Savshak
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) throws IOException {
        FileService file = new FileService();
        MatrixService mService = new MatrixService();
        FileService aServise = new FileService();

        int[][] FileMatrix = aServise.getGraphFromFile(Path.of("graph_01_1.txt"));
        IncidenceMatrix iMatrix = new IncidenceMatrix(FileMatrix);
        System.out.println("Матриця інцедентності");
        mService.printMatrix(iMatrix.getMatrix());
        FileMatrix = aServise.getGraphFromFile(Path.of("graph_01_1.txt"));
        AdjacencyMatrix aMatrix = new AdjacencyMatrix(FileMatrix);
        System.out.println("Матриця суміжності");
        mService.printMatrix(aMatrix.getMatrix());

        System.out.println("=====================================================");
        System.out.println("=====================================================");
        System.out.println("=====================================================");

        AnalyzeGraph analyzeGraph = new AnalyzeGraph();
        int[][] inDegrees = analyzeGraph.FindInDegrees(aMatrix);
        int[][] outDegrees = analyzeGraph.FindOutDegrees(aMatrix);
        int isH = analyzeGraph.isHomogeneous(inDegrees, outDegrees);
        int[] hTops = analyzeGraph.getHangingTops(inDegrees, outDegrees);
        int[] iTops = analyzeGraph.getIsolatedTops(inDegrees, outDegrees);
        mService.printTopsResult(inDegrees, "Вхідні вершини");
        mService.printTopsResult(outDegrees, "Вихідні вершини");
        System.out.println("Граф однорідний: " + isH);
        mService.printTopsResult(hTops, "Висячі вершини");
        mService.printTopsResult(iTops, "Ізольовані вершини");

        System.out.println("=====================================================");
        System.out.println("=====================================================");
        System.out.println("=====================================================");

        DFS dfs = new DFS();
        dfs.matrixSearch(aMatrix, 1);
        dfs.printResult();

        System.out.println("==================================");
        System.out.println("==================================");
        System.out.println("==================================");

        BFS bfs = new BFS();
        bfs.matrixSearch(aMatrix, 1);
        bfs.printResult();

        System.out.println("========================================");
        System.out.println("========================================");
        System.out.println("========================================");

        int[][] fileWMatrix = aServise.getWeightedGraphFromFile(Path.of("weighted_graph_01.txt"));
        WeightedMatrix wMatrix = new WeightedMatrix(fileWMatrix);
        mService.printMatrix(wMatrix.getMatrix());

    }
}

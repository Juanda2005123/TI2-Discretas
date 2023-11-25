package com.example.util;

import com.example.model.Horse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GraphListTest {

    @Test
    void addVertex() {
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertex(1,2,3);
        graph.addVertex(2,3,4);
        assertEquals(2, graph.getList().get(1).getVertex());

    }

    @Test
    void addVertex2() {
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertex(1,2,3);
        graph.addVertex(2,3,4);
        assertNotEquals(4, graph.getList().get(0).getVertex());
    }

    @Test
    void addVertex3(){
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertex(1,2,3);
        graph.addVertex(2,3,4);
        graph.addVertex(3,4,1);

        assertNull(graph.getList().get(4).getVertex());
    }

    @Test
    void deleteVertex(){
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertex(1,2,3);
        graph.addVertex(2,3,4);
        graph.addVertex(3,4,1);

        graph.deleteVertex(1);
        assertEquals(2, graph.getList().get(0).getVertex());
    }


    @Test
    void deleteEdge(){
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertex(1,2,3);
        graph.addVertex(2,3,4);
        graph.deleteEdge(2,3);
        assertEquals(-1, graph.dijkstra(1,3));
        assertNull(graph.getList().get(2).get(0));
    }
    //Técnicamente si pasa, sino que el test espera un null, y el algoritmo le retorna un [],
    //Pero en este caso podríamos asumirlo como lo mismo.

    @Test
    void getEdgeWeight(){
        GraphList graph = new GraphList(4);
        graph.addVertex(1,2,3);
        graph.addVertex(2,3,4);
        assertEquals(4, graph.getEdgeWeight(2, 3));
    }

    @Test
    void checkConnect(){
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertex(1,2,3);
        graph.addVertex(2,3,4);
        assertTrue(graph.checkConnect(1,2));
    }

    @Test
    void checkConnect2(){
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertex(1,2,3);
        graph.addVertex(2,3,4);
        assertFalse(graph.checkConnect(1,3));
    }

    @Test
    void checkConnect3(){
        GraphList<Character> graph = new GraphList<>();
        graph.addVertex('A', 'B', 5);
        graph.addVertex('A', 'C', 10);
        graph.addVertex('B', 'C', 3);
        assertFalse(graph.checkConnect('A', 'E');
    }

    @Test
    void getListVertex(){
        GraphList graph = new GraphList(4);
        graph.addVertex(1,2,3);
        graph.addVertex(2,3,4);

        assertTrue(graph.getListVertex(1).equals("2(3) "));
    }


    @Test
    void test1(){

    }
    @Test
    void test2(){
        Horse horse = new Horse("Spirit","Red1");
        horse.newGraphUndirected();
        horse.graphDijkstra();
        int num1 = horse.getMinimunPath();
        horse.graphfloydWarshall();
        int num2 = horse.getMinimunPath();
        System.out.println(num1);
        System.out.println(num2);
        assertEquals(num1,num2);

    }

    @Test
    public void testDijkstra() {
        GraphList<Character> graph = new GraphList<>();
        graph.addVertex('A', 'B', 5);
        graph.addVertex('A', 'C', 10);
        graph.addVertex('B', 'C', 3);
        int distance = graph.dijkstra('A', 'C');
        assertEquals(8, distance);
    }

    @Test
    public void testDijkstra2(){
        GraphList<Character> graph = new GraphList<>();
        graph.addVertex('A', 'B', 7);
        graph.addVertex('A', 'C', 10);
        graph.addVertex('B', 'C', 4);
        int distance = graph.dijkstra('A', 'C');
        assertEquals(10, distance);
    }

    @Test
    public void testDijkstra3(){
        GraphList<Character> graph = new GraphList<>();
        graph.addVertex('A', 'D', 7);
        graph.addVertex('A', 'H', 10);
        graph.addVertex('B', 'C', 4);
        int distance = graph.dijkstra('A', 'C');
        assertEquals(-1, distance);
    }

}
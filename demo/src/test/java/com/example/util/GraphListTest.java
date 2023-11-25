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

        assertNotEquals(3, graph.getList().get(1).getVertex());
    }

    @Test
    void fillMatrix(){
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertex(1,2,3);
        graph.addVertex(2,3,4);
        graph.addVertex(3,4,1);
        graph.fillMatrix();
        assertEquals(Integer.MAX_VALUE, graph.getMatrix()[1][3]);
    }

    @Test
    void fillMatrix2(){
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertex(1,2,3);
        graph.addVertex(2,3,4);
        graph.addVertex(3,4,1);
        graph.fillMatrix();
        assertEquals(0, graph.getMatrix()[1][1]);
    }

    @Test
    void fillMatrix3(){
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertex(1,2,3);
        graph.addVertex(2,3,4);
        graph.addVertex(3,4,1);
        graph.fillMatrix();
        assertEquals(1, graph.getMatrix()[4][3]);
    }

    @Test
    void addVertexDirigido(){
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertexDirigido(1,2,3);
        graph.addVertexDirigido(2,3,4);
        graph.addVertexDirigido(3,4,5);
        graph.addVertexDirigido(4,5,6);
        graph.addVertexDirigido(5,6,7);

        assertEquals(-1,graph.dijkstra(6,1));

    }

    @Test
    void addVertexDirigido2(){
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertexDirigido(1,2,3);
        graph.addVertexDirigido(2,3,4);
        graph.addVertexDirigido(3,4,5);
        graph.addVertexDirigido(4,5,6);
        graph.addVertexDirigido(5,6,7);
        assertFalse(graph.checkConnect(2,1));
    }



    @Test
    void addVertexDirigido3(){
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertexDirigido(1,2,3);
        graph.addVertexDirigido(2,3,4);
        graph.addVertexDirigido(3,4,5);
        graph.addVertexDirigido(4,5,6);
        graph.addVertexDirigido(5,6,7);
        assertTrue(graph.checkConnect(1,2));
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
    void deleteVertex2(){
        GraphList<String> graph = new GraphList<>();
        graph.addVertex("MaloH", "Agua", 11);
        graph.addVertex("Agua", "No puede ser", 12);
        graph.addVertex("Locura", "Descontrol", 2);
        graph.addVertex("No puede ser", "Locura", 13);
        graph.addVertex("Locura", "MaloH", 10);
        graph.addVertex("Agua", "Descontrol", 15);
        graph.deleteVertex("MaloH");
        assertFalse(graph.checkConnect("MaloH", "Agua"));
    }


    @Test
    void deleteVertex3() {
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertex(1, 2, 3);
        graph.addVertex(2, 3, 4);
        graph.deleteVertex(2);
        assertEquals(-1, graph.dijkstra(1, 3));
    }

    @Test
    void deleteEdge(){
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertex(1, 2, 3);
        graph.addVertex(2, 3, 4);
        graph.addVertex(3,4,5);
        graph.deleteEdge(2, 3);
        assertEquals(1,graph.getList().get(0).getVertex());
    }

    @Test
    void deleteEdge2(){
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertex(1, 2, 3);
        graph.addVertex(2, 3, 4);
        graph.addVertex(3,4,5);
        graph.deleteEdge(2,3);
        assertFalse(graph.checkConnect(2,3));
    }

    @Test
    void deleteEdge3(){
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertex(1, 2, 3);
        graph.addVertex(2, 3, 4);
        graph.addVertex(3,4,5);
        graph.deleteEdge(3, 4);
        graph.deleteEdge(4,3);
        assertFalse(graph.checkConnect(3,4));

    }


    @Test
    void getEdgeWeight(){
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertex(1,2,3);
        graph.addVertex(2,3,4);
        assertEquals(4, graph.getEdgeWeight(2, 3));
    }

    @Test
    void getEdgeWeight2(){
        GraphList<Character> graph = new GraphList<>();
        graph.addVertex('A', 'B', 5);
        graph.addVertex('A', 'C', 10);
        graph.addVertex('B', 'C', 3);
        assertEquals(3, graph.getEdgeWeight('B','C'));
    }

    @Test
    void getEdgeWeight3(){
        GraphList<String> graph = new GraphList<>();
        graph.addVertex("MaloH", "Agua", 12);
        graph.addVertex("Agua", "No puede ser", 12);
        graph.addVertex("Locura", "Descontrol", 12);
        graph.addVertex("No puede ser", "Locura", 12);
        graph.addVertex("Locura", "MaloH", 10);
        graph.addVertex("Agua", "Descontrol", 12);
        assertNotEquals(12, graph.getEdgeWeight("Locura","MaloH"));
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
        assertFalse(graph.checkConnect('A', 'E'));
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

    @Test
    public void floydWarshall(){
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertex(1, 2, 7);
        graph.addVertex(3, 4, 10);
        graph.addVertex(6, 5, 4);
        graph.fillMatrix();
        graph.floydWarshall();
        assertEquals(Integer.MAX_VALUE, graph.getMatrix()[0][4]);
    }

    @Test
    public void floydWarshall2(){
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertex(1, 2, 7);
        graph.addVertex(2,3,5);
        graph.addVertex(3, 4, 10);
        graph.addVertex(6, 5, 4);
        graph.fillMatrix();
        graph.floydWarshall();
        
        assertEquals(22, graph.getMatrix()[4][0]);
    }

    @Test
    public void floydWarshall3(){
        GraphList<Integer> graph = new GraphList<>();
        graph.addVertex(1, 2, 7);
        graph.addVertex(2,3,5);
        graph.addVertex(3, 4, 10);
        graph.addVertex(6, 5, 4);
        graph.fillMatrix();
        graph.floydWarshall();
        assertEquals(0,graph.getMatrix()[2][2]);
    }

}
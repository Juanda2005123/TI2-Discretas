package com.example.util;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphList {
    private int amountV;
    private List<List<Integer>> list;
    private Integer[][] matrix;
    private Random ran;

    public int getAmountV() {
        return amountV;
    }

    public List<List<Integer>> getList() {
        return list;
    }

    public GraphList(int amountV) {
        ran = new Random();
        this.amountV = amountV;
        list = new ArrayList<>(amountV+1);
        for (int i = 1; i < amountV+1; i++) {
            list.add(new ArrayList<>(2));
        }
        matrix = new Integer[amountV][amountV];
    }

    public void fillMatrix(){

        for (int i = 1; i < list.size(); i++){
            for (int j = 0; j < list.get(i).size(); j+=2){
                matrix[i-1][list.get(i).get(j)-1] = list.get(i).get(j+1);
            }
        }

        for(int i = 0; i < matrix.length; i++){
            matrix[i][i] = 0;
            for (int j = 0; j < matrix.length; j++){

                if(matrix[i][j] == null){
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    public void floydWarshall() {
        for (int k = 0; k < amountV; k++) {
            for (int i = 0; i < amountV; i++) {
                for (int j = 0; j < amountV; j++) {
                    if (matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }
    }

    public void addEdge(int edge1, int edge2, int weight) {
        list.get(edge1).add(0,edge2);
        list.get(edge1).add(1,weight);
        list.get(edge2).add(0, edge1);
        list.get(edge2).add(1, weight);

    }
    public void addEdgeDirigido(int edge1, int edge2, int weight){
        list.get(edge1).add(0,edge2);
        list.get(edge1).add(1,weight);
    }

    public String printMatrix(){
        String ans = "";
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if (matrix[i][j] == Integer.MAX_VALUE){
                    ans += " | I | ";
                }else{
                    ans += " | " + matrix[i][j] + " | ";
                }

            }
            ans += "\n";
        }
        return ans;
    }

    public void printGraph() {
        for (int i = 1;  i < amountV; i++) {
            System.out.print("Vertex " + i + ": ");

            for (int j = 0; j < list.get(i).size(); j += 2) {

                int adjacent = list.get(i).get(j);
                int weight = list.get(i).get(j + 1);
                System.out.print(adjacent + "(" + weight + ") ");
            }
            System.out.println();
        }
    }
    public void deleteVertex(int vertex){
        for(int i = 1; i < amountV; i++){
            if(i == vertex){

                list.remove(vertex);

                list.add(vertex, new ArrayList<>());

            }else{

                for(int j = 0; j < (list.get(i)).size(); j+=2){

                    if(list.get(i).get(j) == vertex){
                        list.get(i).remove(j+1);
                        list.get(i).remove(j);

                    }
                }
            }

        }
    }

    public void deleteEdge(int edge1, int edge2){
        for (int i = 0; i < list.get(edge1).size(); i+=2){

            if(list.get(edge1).get(i) == edge2){

                list.get(edge1).remove(i+1);
                list.get(edge1).remove(i);

            }

        }

        for (int i = 0; i < list.get(edge2).size(); i+=2){

            if(list.get(edge2).get(i) == edge1){

                list.get(edge2).remove(i+1);
                list.get(edge2).remove(i);

            }

        }


    }

    public int getEdgeWeight(int edge1, int edge2){
        int ans = -1;
        for(int i = 0; i < list.get(edge1).size(); i+=2){
            if(list.get(edge1).get(i) == edge2){
                ans = list.get(edge1).get(i+1);
            }
        }
        return ans;
    }

    public boolean checkConnect(int edge1, int edge2){
        boolean ans = false;

        for(int i = 0; i < list.get(edge1).size(); i+=2){
            if(list.get(edge1).get(i) == edge2){
                ans = true;
            }
        }

        return ans;
    }

    public String getListVertex(int edge){
        String ans = "";

        for (int i = 0; i < list.get(edge).size(); i+=2){
            int adjacent = list.get(edge).get(i);
            int weight = list.get(edge).get(i + 1);
            ans = (adjacent + "(" + weight + ") ");
        }

        return ans;
    }

    public int dijkstra(int start, int destination) {

        int[] distances = new int[amountV + 1];
        for (int i = 1; i <= amountV; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[start] = 0;

        ArrayList<Tupla> nextToVisit = new ArrayList<>();
        Tupla tupla = new Tupla(start, 0);
        nextToVisit.add(tupla);
        ArrayList<Integer> possibleRoads = new ArrayList<>();

        for (int i = 0; i < nextToVisit.size(); i++) {

            int actual = nextToVisit.get(i).getFirst();
            int acumDistance = nextToVisit.get(i).getSecond();

            if (actual == destination) {
                //return acumDistance;
                possibleRoads.add(acumDistance);
            }

            for (int j = 0; j < list.get(actual).size(); j += 2) {
                int neighbor = list.get(actual).get(j);
                int weight = list.get(actual).get(j + 1);
                int newDistance = acumDistance + weight;

                if (newDistance < distances[neighbor]) {
                    distances[neighbor] = newDistance;
                    nextToVisit.add(new Tupla(neighbor, newDistance));
                }
            }

        }
        if(possibleRoads.isEmpty()){
            return -1;
        }else{
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < possibleRoads.size(); i++){
                if(possibleRoads.get(i) < min){
                    min = possibleRoads.get(i);
                }
            }
            return min;

        }


    }

    public static void main(String[] args) {
        int amountV = 51; // Número de vértices
        GraphList graph = new GraphList(amountV);

        //Horizontal

        //Fila uno
        graph.addEdge(1, 2, graph.ran.nextInt(1,6));
        graph.addEdge(2, 3, graph.ran.nextInt(1,6));
        graph.addEdge(3, 4, graph.ran.nextInt(1,6));
        graph.addEdge(4, 5, graph.ran.nextInt(1,6));
        graph.addEdge(5, 6, graph.ran.nextInt(1,6));
        graph.addEdge(6, 7, graph.ran.nextInt(1,6));
        graph.addEdge(7, 8, graph.ran.nextInt(1,6));
        graph.addEdge(8, 9, graph.ran.nextInt(1,6));
        graph.addEdge(9, 10, graph.ran.nextInt(1,6));
        //Fila dos
        graph.addEdge(11, 12, graph.ran.nextInt(1,6));
        graph.addEdge(12, 13, graph.ran.nextInt(1,6));
        graph.addEdge(13, 14, graph.ran.nextInt(1,6));
        graph.addEdge(14, 15, graph.ran.nextInt(1,6));
        graph.addEdge(15, 16, graph.ran.nextInt(1,6));
        graph.addEdge(16, 17, graph.ran.nextInt(1,6));
        graph.addEdge(17, 18, graph.ran.nextInt(1,6));
        graph.addEdge(18, 19, graph.ran.nextInt(1,6));
        graph.addEdge(19, 20, graph.ran.nextInt(1,6));
        //Fila tres
        graph.addEdge(21, 22, graph.ran.nextInt(1,6));
        graph.addEdge(22, 23, graph.ran.nextInt(1,6));
        graph.addEdge(23, 24, graph.ran.nextInt(1,6));
        graph.addEdge(24, 25, graph.ran.nextInt(1,6));
        graph.addEdge(25, 26, graph.ran.nextInt(1,6));
        graph.addEdge(26, 27, graph.ran.nextInt(1,6));
        graph.addEdge(27, 28, graph.ran.nextInt(1,6));
        graph.addEdge(28, 29, graph.ran.nextInt(1,6));
        graph.addEdge(29, 30, graph.ran.nextInt(1,6));
        //Fila cuatro
        graph.addEdge(31, 32, graph.ran.nextInt(1,6));
        graph.addEdge(32, 33, graph.ran.nextInt(1,6));
        graph.addEdge(33, 34, graph.ran.nextInt(1,6));
        graph.addEdge(34, 35, graph.ran.nextInt(1,6));
        graph.addEdge(35, 36, graph.ran.nextInt(1,6));
        graph.addEdge(36, 37, graph.ran.nextInt(1,6));
        graph.addEdge(37, 38, graph.ran.nextInt(1,6));
        graph.addEdge(38, 39, graph.ran.nextInt(1,6));
        graph.addEdge(39, 40, graph.ran.nextInt(1,6));
        //Fila cinco
        graph.addEdge(41, 42, graph.ran.nextInt(1,6));
        graph.addEdge(42, 43, graph.ran.nextInt(1,6));
        graph.addEdge(43, 44, graph.ran.nextInt(1,6));
        graph.addEdge(44, 45, graph.ran.nextInt(1,6));
        graph.addEdge(45, 46, graph.ran.nextInt(1,6));
        graph.addEdge(46, 47, graph.ran.nextInt(1,6));
        graph.addEdge(47, 48, graph.ran.nextInt(1,6));
        graph.addEdge(48, 49, graph.ran.nextInt(1,6));
        graph.addEdge(49, 50, graph.ran.nextInt(1,6));

        //Vertical
        //Columna uno
        graph.addEdge(1, 11, graph.ran.nextInt(1,6));
        graph.addEdge(2, 12, graph.ran.nextInt(1,6));
        graph.addEdge(3, 13, graph.ran.nextInt(1,6));
        graph.addEdge(4, 14, graph.ran.nextInt(1,6));
        graph.addEdge(5, 15, graph.ran.nextInt(1,6));
        graph.addEdge(6, 16, graph.ran.nextInt(1,6));
        graph.addEdge(7, 17, graph.ran.nextInt(1,6));
        graph.addEdge(8, 18, graph.ran.nextInt(1,6));
        graph.addEdge(9, 19, graph.ran.nextInt(1,6));
        graph.addEdge(10, 20, graph.ran.nextInt(1,6));
        //Columna dos
        graph.addEdge(21, 11, graph.ran.nextInt(1,6));
        graph.addEdge(22, 12, graph.ran.nextInt(1,6));
        graph.addEdge(23, 13, graph.ran.nextInt(1,6));
        graph.addEdge(24, 14, graph.ran.nextInt(1,6));
        graph.addEdge(25, 15, graph.ran.nextInt(1,6));
        graph.addEdge(26, 16, graph.ran.nextInt(1,6));
        graph.addEdge(27, 17, graph.ran.nextInt(1,6));
        graph.addEdge(28, 18, graph.ran.nextInt(1,6));
        graph.addEdge(29, 19, graph.ran.nextInt(1,6));
        graph.addEdge(30, 20, graph.ran.nextInt(1,6));
        //Columna tres
        graph.addEdge(21, 31, graph.ran.nextInt(1,6));
        graph.addEdge(22, 32, graph.ran.nextInt(1,6));
        graph.addEdge(23, 33, graph.ran.nextInt(1,6));
        graph.addEdge(24, 34, graph.ran.nextInt(1,6));
        graph.addEdge(25, 35, graph.ran.nextInt(1,6));
        graph.addEdge(26, 36, graph.ran.nextInt(1,6));
        graph.addEdge(27, 37, graph.ran.nextInt(1,6));
        graph.addEdge(28, 38, graph.ran.nextInt(1,6));
        graph.addEdge(29, 39, graph.ran.nextInt(1,6));
        graph.addEdge(30, 40, graph.ran.nextInt(1,6));
        //Columna cuatro
        graph.addEdge(41, 31, graph.ran.nextInt(1,6));
        graph.addEdge(42, 32, graph.ran.nextInt(1,6));
        graph.addEdge(43, 33, graph.ran.nextInt(1,6));
        graph.addEdge(44, 34, graph.ran.nextInt(1,6));
        graph.addEdge(45, 35, graph.ran.nextInt(1,6));
        graph.addEdge(46, 36, graph.ran.nextInt(1,6));
        graph.addEdge(47, 37, graph.ran.nextInt(1,6));
        graph.addEdge(48, 38, graph.ran.nextInt(1,6));
        graph.addEdge(49, 39, graph.ran.nextInt(1,6));
        graph.addEdge(50, 40, graph.ran.nextInt(1,6));
        //graph.printGraph();
        //graph.getListVertex(1);

        System.out.println(graph.dijkstra(1, 12));

        graph.fillMatrix();
        //System.out.println(graph.printMatrix());
        graph.floydWarshall();
        System.out.println(graph.matrix[0][11]);
    }
}


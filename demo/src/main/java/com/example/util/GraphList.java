package com.example.util;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphList {
    private int amountV;
    private List<List<Integer>> list;
    private Integer[][] matrix;
    private Random ran;

    public Integer[][] getMatrix() {
        return matrix;
    }

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
    public void startNewRandomWeightGraphDirected(){
        //First
        addEdgeDirigido(1,2,ran.nextInt(1,8));
        addEdgeDirigido(1,3,ran.nextInt(1,8));
        addEdgeDirigido(1,4,ran.nextInt(1,8));
        for(int i = 0 ; i < 15 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                for(int k = 0 ; k < 3 ; k++){
                    addEdgeDirigido(2+(i*3)+j,5+(i*3)+k,ran.nextInt(1,8));
                }
            }
        }
        //Last
        addEdgeDirigido(47,50,ran.nextInt(1,8));
        addEdgeDirigido(48,50,ran.nextInt(1,8));
        addEdgeDirigido(49,50,ran.nextInt(1,8));
    }
    public void startNewRandomWeightGraphUndirected(){
        //First
        addEdge(1,2,ran.nextInt(1,8));
        addEdge(1,3,ran.nextInt(1,8));
        addEdge(1,4,ran.nextInt(1,8));
        for(int i = 0 ; i < 15 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                for(int k = 0 ; k < 3 ; k++){
                    addEdge(2+(i*3)+j,5+(i*3)+k,ran.nextInt(1,8));
                }
            }
        }
        //Last
        addEdge(47,50,ran.nextInt(1,8));
        addEdge(48,50,ran.nextInt(1,8));
        addEdge(49,50,ran.nextInt(1,8));
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

        //graph.printGraph();
        //graph.getListVertex(1);

        System.out.println(graph.dijkstra(1, 2));

        graph.fillMatrix();
        //System.out.println(graph.printMatrix());
        graph.floydWarshall();
        System.out.println(graph.matrix[0][1]);
    }
}


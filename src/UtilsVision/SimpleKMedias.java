/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilsVision;

import java.util.BitSet;
import java.util.Random;

/**
 *
 * @author LABORATORIO #3
 */
public class SimpleKMedias {

    private int maxnumIterations = 200;
    private int numClusters = 3;

    private double[][] data;
    private double[][] centroids = null;

    public SimpleKMedias() {

    }

    public void build(double[][] data) {
        this.data = data;
        int numpatterns = data.length;
        int numatts = data[0].length;
        int[] belong = new int[numpatterns];
//        int[] pastbelong = new int[numpatterns];
        int temp = 0;
        boolean stop = false;
        setCentroids(inicializar());
        int iteracion = 0;

        while (!stop) {

            // asignar pertenencia 
            boolean distintos = false;
            for (int i = 0; i < numpatterns; i++) {
                temp = getClusterBelong(data[i]);
                distintos |= (belong[i] != temp);
                belong[i] = temp;
            }
            stop = (iteracion != 0 && !distintos) || (iteracion++ == maxnumIterations);
            if (stop) {
                break;
            }
            // calcular medias 
            int[] cantidades = new int[numpatterns];
            double[][] medias = new double[numClusters][numatts];
            for (int i = 0; i < numpatterns; i++) {
                for (int j = 0; j < numatts; j++) {
                    medias[belong[i]][j] += data[i][j];
                }
                cantidades[belong[i]]++;
            }
            for (int i = 0; i < numClusters; i++) {
                if(cantidades[i]!=0)
                for (int j = 0; j < numatts; j++) {
                    medias[i][j] /= cantidades[i];
                }
            }
            // mover centroides

            for (int i = 0; i < numatts; i++) {
                getCentroids()[i] = medias[i];
            }

            System.out.println("Iteración: "+iteracion);
        }

    }

    public int getClusterBelong(double[] pattern) {
        int index = -1;
        double mindistance = Double.MAX_VALUE, temp = 0;
        int pos = 0;
        for (double[] p : centroids) {
            temp = distance(pattern, p);
            if (temp < mindistance) {
                mindistance = temp;
                index = pos;
            }
            pos++;
        }

        return index;
    }

    public double[][] getClusters(double[] pattern) {
        return getCentroids();
    }

    /**
     * @return the maxnumIterations
     */
    public int getMaxnumIterations() {
        return maxnumIterations;
    }

    /**
     * @param maxnumIterations the maxnumIterations to set
     */
    public void setMaxnumIterations(int maxnumIterations) {
        this.maxnumIterations = maxnumIterations;
    }

    /**
     * @return the numClusters
     */
    public int getNumClusters() {
        return numClusters;
    }

    /**
     * @param numClusters the numClusters to set
     */
    public void setNumClusters(int numClusters) {
        this.numClusters = numClusters;
    }

    public static void main(String[] args) {
        SimpleKMedias kmean = new SimpleKMedias();
        int numclusters = 2;
        kmean.setNumClusters(numclusters);
        double[][] data = new double[][]{
            new double[]{1, 1},
            new double[]{2, 1},
            new double[]{4, 3},
            new double[]{5, 4}
        };
        kmean.setCentroids(new double[][]{
            new double[]{1, 1},
            new double[]{2, 1}
        });
        kmean.setMaxnumIterations(200);
        kmean.build(data);
        int numpatterns = data.length;

        for (int i = 0; i < numpatterns; i++) {
            double[] pattern = data[i];
            System.out.println(kmean.getClusterBelong(pattern));
        }

        double[][] centroide = kmean.centroids;

        System.out.println("Centroides");

        for (int i = 0; i < numclusters; i++) {
            for (int j = 0; j < centroide[i].length; j++) {
                System.out.print(centroide[i][j] + " ");
            }
            System.out.println();
        }

    }

    private double distance(double[] pattern, double[] p) {
        double distance = 0;
        for (int i = 0; i < p.length; i++) {
            distance += Math.pow(p[i] - pattern[i], 2);
        }
        return distance;

    }

    @SuppressWarnings("empty-statement")
    private double[][] inicializar() {

        if (getCentroids() != null) {
            return getCentroids();
        }

        double[][] acentroids = new double[numClusters][data[0].length];
        BitSet bs = new BitSet(data.length);
        int pos = 0;
        Random rnd = new Random();
        int indice;
        while (pos < numClusters) {
            while (bs.get(indice = rnd.nextInt(data.length))){
            int g=9;
            };
            for (int i = 0; i < data[indice].length; i++) {
                acentroids[pos][i] = data[indice][i];
            }
            bs.set(indice);
            pos++;
        }

        System.out.println("Tremino inicializar");
        return acentroids;
    }

    /**
     * @return the centroids
     */
    public double[][] getCentroids() {
        return centroids;
    }

    /**
     * @param centroids the centroids to set
     */
    public void setCentroids(double[][] centroids) {
        this.centroids = centroids;
    }
}

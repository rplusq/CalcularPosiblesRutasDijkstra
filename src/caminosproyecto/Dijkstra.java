/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caminosproyecto;

/**
 *
 * @author flamingo
 */
public class Dijkstra {

    private int[][] matrizDistancias;
    private String[] rutas = new String[10];
    private int numRutas = 0;

    public Dijkstra() {
        // Inicio matriz de 5*5
        this.matrizDistancias = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.matrizDistancias[i][j] = -1;
            }
        }

        this.matrizDistancias[0][1] = 1;
        this.matrizDistancias[0][2] = 3;
        this.matrizDistancias[1][3] = 5;
        this.matrizDistancias[2][1] = 4;
        this.matrizDistancias[2][3] = 1;
        this.matrizDistancias[3][4] = 3;

        // Imprimir matriz
        this.mostrarMatriz();

        // Buscar todas las rutas y guardarlas en this.rutas del nodo 0 al 4
        this.calcularRutasDeNodos(0, 4, "0, ");

        int index = 0;

        while (this.rutas[index] != null) {
            String indexS = String.valueOf(index + 1);
            System.out.println("Ruta " + indexS + ": " + this.rutas[index]);
            index++;
        }
    }

    public void mostrarMatriz() {
        String display = "";

        for (int i = 0; i < 5; i++) {
            display = "[ ";
            for (int j = 0; j < 5; j++) {
                if (j == 4) {
                    display += this.matrizDistancias[i][j];
                } else {
                    display += this.matrizDistancias[i][j] + " , ";
                }
            }
            display += " ]";
            System.out.println(display);
        }
    }

    public void calcularRutasDeNodos(int nodoInicial, int nodoFinal, String ruta) {
        for (int j = 0; j < 5; j++) {
            if (this.matrizDistancias[nodoInicial][j] != -1) {
                if (j != nodoFinal) {
                    String rutaAux = ruta + j + " ,";
                    this.calcularRutasDeNodos(j, nodoFinal, rutaAux);
                } else {
                    System.out.println("Final en " + nodoInicial + " " + j);
                    ruta += " " + j;
                    this.rutas[this.numRutas] = ruta;
                    this.numRutas++;
                    return;
                }
            }
        }

    }

}

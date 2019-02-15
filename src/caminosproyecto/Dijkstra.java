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
        
        // La relleno con -1 para indicar que no tiene conexiones en ese punto
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.matrizDistancias[i][j] = -1;
            }
        }
        
        // Lleno la matriz con las direcciones de cada grafo (y diferentes pesos)
        this.matrizDistancias[0][1] = 1;
        this.matrizDistancias[0][2] = 3;
        this.matrizDistancias[1][3] = 5;
        this.matrizDistancias[2][1] = 4;
        this.matrizDistancias[2][3] = 1;
        this.matrizDistancias[3][4] = 3;

        // Imprimir matriz
        this.mostrarMatriz();

        // Buscar todas las rutas y guardarlas en this.rutas del nodo 0 al 4. Se envia un String con el nodo inicial
        this.calcularRutasDeNodos(0, 4, "0, ");
        
        
        // Imprimimos todas las rutas del array rutas que no sean null
        int index = 0;
        while (this.rutas[index] != null) {
            String indexS = String.valueOf(index + 1);
            System.out.println("Ruta " + indexS + ": " + this.rutas[index]);
            index++;
        }
    }

    public void mostrarMatriz() {
        String display = "";
        // Formateo de la matriz
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
        // Se recorre la fila del nodoInicial
        for (int j = 0; j < 5; j++) {
            // Revisa si hay alguna direccion para ese grafo.
            if (this.matrizDistancias[nodoInicial][j] != -1) {
                // Si consigue una direccion, pero no es para el nodo final, le envia la ruta actual
                // y vuelve a llamar al metodo para que busque en la fila del nodo al que se dirige.
                if (j != nodoFinal) {
                    String rutaAux = ruta + j + " ,";
                    this.calcularRutasDeNodos(j, nodoFinal, rutaAux);
                } else {
                // Si consiguio el nodo final, se acaba la recursividad. Anota la ruta en el array de rutas y sale del metodo.
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

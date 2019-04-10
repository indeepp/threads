/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author ricardocosta
 */
public class Threads {

  
        

        String nome;
        int delay;
        int pecasProduzidas = 0;
        static int TOTAL_PECAS = 10;

        public Threads(String nome, int delay) {
            this.nome = nome;
            this.delay = delay;
        }

        public void trabalhar() {
            System.out.println(nome + " - Comecei.");
            while (pecasProduzidas < TOTAL_PECAS) {
                try {
                    Thread.sleep(delay);
                    System.out.println(nome + ": " + ++pecasProduzidas);
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
            System.out.println(nome + " - Terminei.");
        }

        /**
         * main em que não existe concorrência.
         */
        public static void main(String[] args) {
            Threads manuel = new Threads("Manuel", 300);
            manuel.trabalhar();
            Threads pedro = new Threads("\tPedro", 500);
            pedro.trabalhar();
            System.out.println("Main terminado.");
        } 

    }
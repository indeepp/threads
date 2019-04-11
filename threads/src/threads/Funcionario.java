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
public class Funcionario extends Thread{

    String nome;
    int delay;
    int pecasProduzidas = 0;
    static int TOTAL_PECAS = 10;

    public Funcionario(String nome, int delay) {
        this.nome = nome;
        this.delay = delay;
    }

    public void run() {
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
        Funcionario manuel = new Funcionario("Manuel", 300);
        manuel.start();
        Funcionario pedro = new Funcionario("\tPedro", 300);
        //pedro.run();
        pedro.start();
        System.out.println("Main terminado.");
    }
}

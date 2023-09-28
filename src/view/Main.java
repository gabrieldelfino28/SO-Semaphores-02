package view;

import controller.CaminhadaController;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Semaphore semaphore = new Semaphore(1);
        for (int pessoa = 0; pessoa < 4; pessoa++) {
            Thread caminhada = new CaminhadaController(pessoa, semaphore);
            caminhada.start();
        }
    }
}

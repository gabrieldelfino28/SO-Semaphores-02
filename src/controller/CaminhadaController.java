package controller;

import java.util.concurrent.Semaphore;

public class CaminhadaController extends Thread {
    int pessoaID;
    Semaphore semaphore;

    public CaminhadaController(int pessoaID, Semaphore semaphore) {
        this.pessoaID = pessoaID;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            Caminhada();
            //Seção crítica
            semaphore.acquire();
            Porta();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void Caminhada() {
        int corredor = 200; //meters
        int andou = 0;
        do {
            int andar = (int) ((Math.random() * 2) + 4);
            andou += andar;
            System.out.println("A pessoa do corredor#" + pessoaID + " andou " + andou + " metros");
        } while (andou < corredor);
        System.out.println("A pessoa do corredor #" + pessoaID + " chegou na porta!");
    }

    private void Porta() {
        System.out.println("A pessoa #" + pessoaID + " Abriu a porta");
        int tempo = (int) ((Math.random() * 1000) + 1000);
        try {
            sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A pessoa #" + pessoaID + " Atravessou a porta");
    }
}

package com.stok.takipstok;

public class LoggerThread extends Thread {
    private final String logMessage;

    public LoggerThread(String logMessage) {
        this.logMessage = logMessage;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500); // Gecikme simülasyonu
            Thread.sleep(500); 
            System.out.println("[LOG] " + logMessage);
        } catch (InterruptedException e) {
            System.err.println("Logger kesintiye uğradı.");
        }
    }
}

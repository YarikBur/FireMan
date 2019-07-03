package ru.sgs.fireman.utlis;

public class Random {
    private static java.util.Random random = new java.util.Random();

    public static int randomInteger(int min, int max){
        return (random.nextInt((max - min) + 1) + min);
    }
}

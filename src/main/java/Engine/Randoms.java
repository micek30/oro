package Engine;

import java.util.Random;

public class Randoms {
    public Integer randInt(int min, int max){
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }

    public Double randDouble(int min, int max){
        Random random = new Random();
        double roundOff = Math.round(min + (max - min) * random.nextDouble() * 100.0) / 100.0;
        return roundOff;
    }

    public Boolean randBoolean(float a){
        return Math.random() < a;
    }
}

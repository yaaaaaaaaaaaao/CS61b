package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;
import java.util.ArrayDeque;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHero {
    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        double CONCERTS[] = new double[37];
        GuitarString strings[] = new GuitarString[37];

        for (int i = 0; i < 37; i++) {
            CONCERTS[i] = 440 * Math.pow(2, (i - 24) / 12.0);
            strings[i] = new GuitarString(CONCERTS[i]);
        }

        while(true){
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int n = keyboard.indexOf(key);
                if (n == -1) continue;
                strings[n].pluck();
            }

            /* compute the superposition of samples */
            double sample = 0;
            for (int i = 0; i < 37; i += 1) {
                sample = strings[i].sample() + sample;
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (int i = 0; i < 37; i += 1) {
                strings[i].tic();
            }





        }





    }
}



public class GuitarHero {

    // Each character i of keyboardString corresponds to a frequency of  Hz,
    // so that the character 'q' is 110 Hz, 'i' is 220 Hz, 'v' is 440 Hz, and
    // the space character is 880 Hz.
    public static void main(String[] args) {
        double CONCERT_A = 440.0;
        String keyboardString = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] guitar = new GuitarString[keyboardString.length()];

        for (int i = 0; i < guitar.length; i++) {
            double frequency = CONCERT_A * Math.pow(2, (i - 24) / 12.0);
            guitar[i] = new GuitarString(frequency);
        }

        // the main input loop
        Keyboard keyboard = new Keyboard();
        while (true) {

            // check if the user has played a key; if so, process it
            if (keyboard.hasNextKeyPlayed()) {

                // the key the user played
                char key = keyboard.nextKeyPlayed();

                // pluck the corresponding string
                int index = keyboardString.indexOf(key);
                if (index != -1) guitar[index].pluck();
            }

            // compute the superposition of the samples
            double sample = 0.0;
            for (GuitarString x : guitar) {
                sample += x.sample();
            }

            // play the sample on standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for (GuitarString x : guitar) {
                x.tic();
            }
        }

    }
}

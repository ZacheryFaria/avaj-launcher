package zfaria.avajlauncher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public final class Logger {

    public PrintWriter out;

    private Logger() {
        try {
            out = new PrintWriter(new File("simulation.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Error creating simulation.txt file...");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static final Logger logger = new Logger();

    public static Logger getInstance() {
        return logger;
    }

    public void finish() {
        out.flush();
        out.close();
    }
}

package main;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;

public final class Logger {
        private static File csvFile = null;
        private static Logger instance = null;
        private static String filePath = null;

        private Logger(){
            Logger.csvFile = new File(Logger.filePath);
        }

        public static void setFilePath(String path){
            Logger.filePath = path;
        }

        public static Logger getInstance(){
            if (instance == null){
                instance = new Logger();
            }
            return instance;
        }
        
        public static void log(String event){
            Date timestamp = new Date();
            try (PrintWriter pw = new PrintWriter(Logger.csvFile)) {
                pw.println(event + ", " + timestamp.toString());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
}

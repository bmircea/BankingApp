package main;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import classes.LoggableEvent;

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
        
        public static void dumpLog(ArrayList<LoggableEvent> events){
            try (FileWriter writer = new FileWriter(Logger.filePath, true)) {
                for (LoggableEvent e : events){
                    writer.write(e.getEventName() + ", " + e.getTimestamp().toString());
                    writer.write('\n');
                }
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        public static void log(String event){
            LoggableEvent e = new LoggableEvent(event);
            Service.addEvent(e);
        }
}

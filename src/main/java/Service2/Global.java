package Service2;

import Service1.TimeTable;
import Service3.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Global {
    public static ArrayList<TimeTable> List1 = new ArrayList<>();
    public static ArrayList<WaitingQueue> List2 = new ArrayList<>();
//    public static Queue<WaitingQueue> shipQueue=new LinkedList<>();
    public static Queue<WaitingQueue> shipQueue = new ConcurrentLinkedQueue<>();
}


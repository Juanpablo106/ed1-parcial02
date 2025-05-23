package ed.lab;

import java.util.HashMap;
import java.util.Map;

public class E02Logger {

    private final Map<String, Integer> lastTimestamp;

    public E02Logger() {
        this.lastTimestamp = new HashMap<>();
    }
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (lastTimestamp.containsKey(message)) {
            int lastTime = lastTimestamp.get(message);
            if (timestamp - lastTime < 10) {
                return false;
            }
        }
        lastTimestamp.put(message, timestamp);
        return true;
    }
}
package ed.lab;

import java.util.*;

public class E01MeetingRooms {

    public int minMeetingRooms(List<MeetingInterval> meetingIntervals) {
        if (meetingIntervals == null || meetingIntervals.isEmpty()) {
            return 0;
        }

        meetingIntervals.sort(Comparator.comparingInt(MeetingInterval::startTime));

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        for (MeetingInterval interval : meetingIntervals) {

            if (!endTimes.isEmpty() && endTimes.peek() <= interval.startTime()) {
                endTimes.poll(); // Libera la sala
            }

            endTimes.offer(interval.endTime());
        }

        return endTimes.size();
    }
}

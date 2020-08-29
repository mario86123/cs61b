import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solver for the Flight problem (#9) from CS 61B Spring 2018 Midterm 2.
 * Assumes valid input, i.e. all Flight start times are >= end times.
 * If a flight starts at the same time as a flight's end time, they are
 * considered to be in the air at the same time.
 */
public class FlightSolver {
    /* FIX ME */
    ArrayList<Flight> f;
    public FlightSolver(ArrayList<Flight> flights) {
        this.f = flights;
    }

    public int solve() {
        /* FIX ME */
        PriorityQueue<Flight> flightPQ = new PriorityQueue<>((i, j) -> i.endTime - j.endTime);
        int maxTotalPassengers = 0, currentTotalPassengers;

        flightPQ.addAll(f);

        while (flightPQ.size() != 0) {
            Flight minEndTimeFlight = flightPQ.poll();
            currentTotalPassengers = minEndTimeFlight.passengers;
            for (Flight tmp:flightPQ) {
                if (tmp.startTime < minEndTimeFlight.endTime) {
                    currentTotalPassengers += tmp.passengers;
                }
            }
            if (currentTotalPassengers > maxTotalPassengers) {
                maxTotalPassengers = currentTotalPassengers;
            }
        }
        return maxTotalPassengers;
    }
}

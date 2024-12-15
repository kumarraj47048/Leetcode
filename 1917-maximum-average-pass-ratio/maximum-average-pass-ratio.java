class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;

        // PriorityQueue to maximize improvement in pass ratio
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.improvement(), a.improvement()));

        // Populate the queue with initial pairs
        for (int[] cls : classes) {
            pq.add(new Pair(cls[0], cls[1]));
        }

        // Distribute extra students
        while (extraStudents-- > 0) {
            Pair temp = pq.poll();
            temp.addStudent();
            pq.add(temp); // Reinsert with updated values
        }

        // Calculate the total average pass ratio
        double sum = 0;
        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            sum += temp.passRatio();
        }

        return sum / n;
    }
}

// Custom Pair class with improvement calculation
class Pair {
    int curr;  // Current passing students
    int total; // Total students

    Pair(int curr, int total) {
        this.curr = curr;
        this.total = total;
    }

    // Calculate the current pass ratio
    double passRatio() {
        return (double) curr / total;
    }

    // Calculate the improvement in pass ratio if one more student is added
    double improvement() {
        return (double) (curr + 1) / (total + 1) - passRatio();
    }

    // Add a student to this class
    void addStudent() {
        curr++;
        total++;
    }
}

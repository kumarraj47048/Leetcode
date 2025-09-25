class Router {

    private record Packet(int source, int destination, int timestamp) {}

    private static class Pair {

        List<Integer> timestamps;
        int head;

        Pair() {
            this.timestamps = new ArrayList<>();
            this.head = 0;
        }
    }

    private final int memoryLimit;
    private final Queue<Packet> packetQ = new ArrayDeque<>();
    private final Set<Packet> packetSet = new HashSet<>();
    private final Map<Integer, Pair> destToTimestamps = new HashMap<>();

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source, destination, timestamp);
        if (!packetSet.add(packet)) return false;
        if (packetQ.size() == memoryLimit) forwardPacket();
        packetQ.add(packet);
        destToTimestamps
            .computeIfAbsent(destination, k -> new Pair())
            .timestamps.add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if (packetQ.isEmpty()) return new int[] {};
        Packet packet = packetQ.poll();
        packetSet.remove(packet);
        Pair p = destToTimestamps.get(packet.destination);
        p.head++;
        return new int[] {
            packet.source,
            packet.destination,
            packet.timestamp,
        };
    }

    public int getCount(int destination, int startTime, int endTime) {
        Pair p = destToTimestamps.get(destination);
        if (p == null) return 0;
        int left = lowerBound(p.timestamps, startTime, p.head);
        int right = lowerBound(p.timestamps, endTime + 1, p.head);
        return right - left;
    }

    private int lowerBound(List<Integer> nums, int target, int left) {
        int right = nums.size();
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
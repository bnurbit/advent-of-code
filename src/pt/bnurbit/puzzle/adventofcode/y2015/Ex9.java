package pt.bnurbit.puzzle.adventofcode.y2015;

import pt.bnurbit.puzzle.adventofcode.utils.Utils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ex9 {

    public static void main(String[] args) {
        String[] data = Utils.getTestDataAsRows("2015/ex9");
        part1(data);
        part2(data);
    }

    /**
     * Counting shortest distance.
     * Start and end at any two (different) locations but must visit each location exactly once
     */
    private static void part1(String[] strings) {

        List<Route> routes = getRoutes(strings);
        Set<String> locations = routes.stream().map(Route::getOrigin).collect(Collectors.toSet());
        Map<String, List<Route>> routesPerLocation = new HashMap<>();

        for(var l : locations){

        }
        System.out.println("Total: " );
    }

    /**
     * Counting storage space.
     * Encode each code representation as a new string and find the number of characters of the new encoded representation, including the surrounding double quotes.
     */
    private static void part2(String[] strings) {

        System.out.println("Total: " );
    }

    private static List<Route> getRoutes(String[] strings){

        Pattern pattern = Pattern.compile("(\\w+) to (\\w+) = (\\d+)");
        List<Route> routes = new ArrayList<>();

        for(var s : strings){
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()){
                routes.add(new Route(matcher.group(1), matcher.group(2), Integer.parseInt(matcher.group(3))));
            }
        }

        return routes;
    }

    private static class Route {
        private String origin;
        private String destination;
        private int distance;

        public Route(String origin, String destination, int distance) {
            this.origin = origin;
            this.destination = destination;
            this.distance = distance;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }
}

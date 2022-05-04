import helper.Helper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BreakpointFinder {

  int minDistance;
  int maxDistance;
  private String firstPath;
  private String secondPath;

  /**
   * Function that finds the breakpoint for given 2 paths as well as checks the interval
   * @return Coordinates of the breakpoint that corresponds to the interval
   */
  public String getBreakPointCoordinates() {
    // Coordinates & sums for paths
    Map<String, Integer> firstPathCoordinates = getAllCoordinatesWithCurrSumOfPath(firstPath);
    Map<String, Integer> secondPathCoordinates = getAllCoordinatesWithCurrSumOfPath(secondPath);
    // Shared coordinates (as keys)
    Set<String> sameKeys = Helper.findSameKeysInMaps(firstPathCoordinates, secondPathCoordinates);
    // returning the first valid breakpoint coordinates
    return sameKeys
            .stream()
            .filter(key ->
                    Helper.isInInterval(minDistance, maxDistance, firstPathCoordinates.get(key)) && Helper.isInInterval(minDistance, maxDistance, secondPathCoordinates.get(key)))
            .findFirst()
            .orElse("No valid breakpoint");
  }

  /**
   * Function that generates map of coordinates and path sum for them
   * @param path Path as string
   * @return Hashmap of all path's coordinates as well as their curr path sum
   */
  private Map<String, Integer> getAllCoordinatesWithCurrSumOfPath(String path) {
    Map<String, Integer> coordinateWithCurrPathSum = new HashMap<>();
    // starting point with 0 sum
    coordinateWithCurrPathSum.put("0,0", 0);
    int x = 0, y = 0;
    int currPathSum = 0;
    // Split path string into steps(50W) (represented as List<String>)
    List<String> steps = Helper.splitStringByAnotherString(path, ",");

    for (String step : steps) {
      char stepDirection = step.charAt(step.length() - 1); // direction
      int numberOfStepsInDirection = Integer.parseInt(step.substring(0, step.length() - 1));

      // filling up the entire path
      int stepsDoneInDirection = 0;
      while(stepsDoneInDirection < numberOfStepsInDirection) {
        // possible directions: N,W,E,S
        switch (stepDirection) {
          case 'N' -> y++;
          case 'S' -> y--;
          case 'E' -> x++;
          case 'W' -> x--;
          default -> throw new IllegalStateException("Invalid direction");
        }
        currPathSum++;
        coordinateWithCurrPathSum.put(String.format("[%d,%d]", x,y), currPathSum);
        stepsDoneInDirection++;
      }
    }
    return coordinateWithCurrPathSum;
  }
}

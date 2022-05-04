import helper.Importer;

import java.io.IOException;

public class App {
  public static void main(String[] args) throws IOException {
    Importer importer = new Importer("src/main/resources/data.txt");
    BreakpointFinder breakpointFinder =
        new BreakpointFinder(
            importer.getNumericInterval()[0], // min interval
            importer.getNumericInterval()[1], // max interval
            importer.getSplitUpText()[1], // path1
            importer.getSplitUpText()[2]); // path2
    System.out.println(breakpointFinder.getBreakPointCoordinates());
  }
}

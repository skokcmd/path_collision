import java.io.IOException;

public class App {
  public static void main(String[] args) throws IOException {
    BreakpointFinder breakpointFinder = new BreakpointFinder(5, 10, "3E,4N,4W,2S", "2W,3N,3E,3N");
    System.out.println(breakpointFinder.getBreakPointCoordinates());
  }
}

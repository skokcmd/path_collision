package helper;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Data
@AllArgsConstructor
public class Importer {
  // Path for reading
  private String path;

  /**
   * Function that returns data in the file as a string
   *
   * @return String from the file
   * @throws IOException
   */
  private String getTextAsString() throws IOException {
    return Files.readString(Path.of(path));
  }

  /**
   * Function that splits up read string - Interval, path1, path2
   *
   * @return String[] from the read string
   * @throws IOException
   */
  public String[] getSplitUpText() throws IOException {
    return getTextAsString().split("\n");
  }

  /**
   * Function that splits up the interval by "-"
   *
   * @return String[] of interval values {min, max}
   * @throws IOException
   */
  private String[] getStringInterval() throws IOException {
    return getSplitUpText()[0].split("-");
  }

  /**
   * Function that converts String[] of interval values to int[] {min, max}
   *
   * @return int[] of interval values {min, max}
   * @throws IOException
   */
  public int[] getNumericInterval() throws IOException {
    return new int[] {
      Integer.parseInt(getStringInterval()[0]), Integer.parseInt(getStringInterval()[1])
    };
  }
}

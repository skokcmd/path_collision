package helper;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Helper {
  /**
   * Function to split up a string by a splitter
   *
   * @param s String which will be split up
   * @param splitter String which will split up the given String
   * @return List of Strings from original String
   */
  public static List<String> splitStringByAnotherString(String s, String splitter) {
    return Pattern.compile(splitter).splitAsStream(s).collect(Collectors.toList());
  }

  /**
   * Generic function that returns shared keys in 2 hashmaps
   *
   * @param mapA first map
   * @param mapB second map
   * @param <S> Key type
   * @param <T> Value type
   * @return Keys which are shared in both maps
   */
  public static <S, T> Set<S> findSameKeysInMaps(Map<S, T> mapA, Map<S, T> mapB) {
    Set<S> s = new HashSet<>(mapA.keySet());
    s.retainAll(mapB.keySet());
    return s;
  }

  /**
   * Checks whether a number is in the interval
   *
   * @param min minimal value of the interval
   * @param max maximal value of the interval
   * @param num number to be checked
   * @return boolean representing whether a num is in the interval
   */
  public static boolean isInInterval(int min, int max, int num) {
    return (num >= min && num <= max);
  }
}

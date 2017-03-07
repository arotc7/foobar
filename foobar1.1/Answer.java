import java.util.TreeMap;
import java.util.Map;

public class Answer {   
  public static int[] answer(int[] data, int n) { 
    Map<Integer, Integer> occurrences = new TreeMap<>();
    for(int i = 0; i < data.length; i++) {
      if(!occurrences.containsKey(data[i])) {
        occurrences.put(data[i], 1);
      } else {
        occurrences.put(data[i], occurrences.get(data[i]) + 1);
      }
    }

    int count = 0;

    for(Integer key : occurrences.keySet()) {
      if(occurrences.get(key) <= n) {
        occurrences.put(key, 0);
      } else {
        count++;
      }
    }

    int[] retVal = new int[count];

    int i = 0;
    for(Integer key : occurrences.keySet()) {
      retVal[i] = occurrences.get(key);
      i++;
    }

    return retVal;
  } 
}

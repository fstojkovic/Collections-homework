import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Bigram {

	public static void main(String[] args) {

		String string = "abbcceeeeeeabcc";
		Map<String, Integer> mapa = new HashMap<>();

		for (int i = 0; i < string.length() - 1; i++) {
			String bigram = string.substring(i, i + 2);

			if (mapa.containsKey(bigram)) {
				mapa.put(bigram, mapa.get(bigram) + 1);
			} else {
				mapa.put(bigram, 1);
			}
		}

		@SuppressWarnings("rawtypes")
		Iterator iterator = mapa.entrySet().iterator();
		while (iterator.hasNext()) {
			@SuppressWarnings("unchecked")
			Map.Entry<String, Integer> entry = (Entry<String, Integer>) iterator.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}

}

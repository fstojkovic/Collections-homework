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

		String pocetak = "ja";

		for (int i = 0; i < 3; i++) {
			int maxFi = 0;
			String bigramMaxFi = "";

			for (Map.Entry<String, Integer> ent : mapa.entrySet()) {
				if (ent.getKey().startsWith(pocetak.substring(pocetak.length() - 1)) && (maxFi < ent.getValue())) {
					maxFi = ent.getValue();
					bigramMaxFi = ent.getKey();
				}
			}
			if (maxFi > 0) {
				pocetak = pocetak + bigramMaxFi.charAt(1);
			}
		}
		System.out.println(pocetak);
	}

}

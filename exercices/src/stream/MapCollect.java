package stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapCollect {

	public static void main(String[] args) {
		Map<String, Unit> map = new HashMap<>();
		map(map);
	}
	
	private static void map(Map<String, Unit> map) {
		List<Unit> testList = Unit.getTestList();
		testList.stream().forEach(e -> {map.put(e.getSku(), e);});
		List<Unit> newList = map.entrySet().stream().map(e -> {
			Unit u = e.getValue();
			u.setQnty(u.getQnty() * 3);
			return u;
		}).collect(Collectors.toList());
		System.out.println(newList.size());
		newList.forEach(e-> {System.out.println(e.getQnty());});
	}
}

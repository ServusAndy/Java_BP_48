import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Shop implements IShop{
	private HashMap<String, Item> itemsMap;
	private TreeSet<Item> itemsByPrice;
	private HashMap<Item, Integer> itemCountMap;
	private HashMap<String,HashSet<Item>> itemCatMap;
	public Shop() {
		itemsMap = new HashMap<>();
		itemsByPrice = new TreeSet<>((o1, o2) -> {
				int res = Double.compare(o1.getPrice(), o2.getPrice());
				if(res == 0) {
					res = o1.getId().compareTo(o2.getId());
				}
				return res;
			});
		itemCountMap = new HashMap<>();
		itemCatMap = new HashMap<>();
	}
	@Override
	public boolean add(Item i) {
		if(i == null || i.getId() == null || i.getCategory() == null) {
			return false;
		}
		Item tmp = itemsMap.get(i.getId());
		if(tmp != null) {
			int count = itemCountMap.remove(i);
			itemCountMap.put(i, ++count);
		}else {
			itemsMap.put(i.getId(), i);
			itemCountMap.put(i, 1);
			itemsByPrice.add(i);
			HashSet<Item> items = itemCatMap.get(i.getCategory());
			if(items!=null) {
				items.add(i);
			}else {
				items = new HashSet<>();
				items.add(i);
				itemCatMap.put(i.getCategory(), items);
			}
		}
		return true;
	}

	@Override
	public Iterable<Item> getItemsByCategory(String category) {
		Set<Item> res = itemCatMap.get(category);
		if(res == null) {
			res = new HashSet<>();
		}
		return res;
	}

	@Override
	public Iterable<Item> getItemsByPrice() {
		return itemsByPrice;
	}

	@Override
	public int getItemCount(String id) {
		Integer res = itemCountMap.get(new Item(id,"","",0));
		if(res == null) {
			return 0;
		}
		return res;
	}

	@Override
	public Item buy(String itemId) {
		Item res = itemsMap.get(itemId);
		if(res != null){
			int count = itemCountMap.remove(res);
			count--;
			if(count > 0) {
				itemCountMap.put(res, count);
			}else{
				itemsMap.remove(itemId);
				itemsByPrice.remove(res);
				itemCatMap.get(res.getCategory()).remove(res);
				
			}
		}
		return res;
	}

	@Override
	public Iterable<Item> buy(String itemId, int count) {
		int currCount = count;
		Item res = itemsMap.get(itemId);
		if(res != null) {
			int mapCount = itemCountMap.remove(res);
			currCount = mapCount - currCount;
			if(currCount <= 0) {
				itemsMap.remove(itemId);
				itemsByPrice.remove(res);
				itemCatMap.get(res.getCategory()).remove(res);
			}else {
				itemCountMap.put(res, currCount);
			}
		}
		ArrayList<Item> list = new ArrayList<>();
		if(currCount >= 0 && res != null) {
			currCount = count;
		}else if(res != null) {
			currCount = count + currCount;
		}else {
			currCount = 0;
		}
		for(int i = 0; i < currCount; i++) {
			list.add(new Item(res.getId(), res.getTitle(),res.getCategory(), res.getPrice()));
		}
		return list;
	}

	@Override
	public void returnItem(Item item) {
		add(item);
	}

	@Override
	public void returnItem(Item item, int count) {
		for(int i = 0; i < count; i++) {
			add(item);
		}
		
	}

}

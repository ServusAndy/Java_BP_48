
public interface IShop {
	boolean add(Item i);
	Iterable<Item> getItemsByCategory(String category);
	Iterable<Item> getItemsByPrice();
	int getItemCount(String id);
	Item buy(String itemId);
	Iterable<Item> buy(String itemId, int count);
	void returnItem(Item item);
	void returnItem(Item item, int count);
}

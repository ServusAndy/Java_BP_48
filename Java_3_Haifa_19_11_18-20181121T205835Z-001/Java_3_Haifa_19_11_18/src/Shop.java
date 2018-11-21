import java.util.Iterator;

public class Shop implements Iterable<Shop.Item>{
	private Item[] arr;
	private int count = 0;
	private int tax = 17;
	public Shop() {
		arr = new Item[10];
	}
	
	public void add(String name, int id,double price) {
		Item i = new Item(name,id,price);
		if(count < arr.length) {
			arr[count++] = i;
		}
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator();
	}
	
	public /*static*/ class Item{
		private String name;
		private int id;
		private double price;
		
		private Item(String name, int id, double price) {
			this.name = name;
			this.id = id;
			this.price = price + (price/100)*tax;
		}
		
		public String toString() {
			return id + " " + name + " " + price;
		}
	}
	
	private class MyIterator implements Iterator<Item>{
		int curr = 0;
		@Override
		public boolean hasNext() {
			return curr < count;
		}

		@Override
		public Item next() {
			
			return arr[curr++];
		}
		
	}

	
}






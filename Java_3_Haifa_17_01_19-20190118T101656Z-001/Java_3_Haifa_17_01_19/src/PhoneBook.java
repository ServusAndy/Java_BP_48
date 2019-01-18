import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class PhoneBook {
	private List<Contact> list;
	
	public PhoneBook() {
		list = new ArrayList<>();
	}
	
	public boolean add(Contact c) {
		Objects.requireNonNull(c);
		if(!list.contains(c)) {
			list.add(c);
			return true;
		}
		return false;
	}
	
	public int size() {
		return list.size();
	}
	
	public Iterable<Contact> findByName(String name){
		Objects.requireNonNull(name);
		List<Contact> res = new ArrayList<>();
		for(Contact c : list) {
			if(name.equals(c.getName())) {
				res.add(c);
			}
		}
		return res;
	}
	
	public Iterable<Contact> findByAge(int age){
		List<Contact> res = new ArrayList<>();
		for(Contact c : list) {
			if(age == c.getAge()) {
				res.add(c);
			}
		}
		return res;
	}
	
	public Iterable<Contact> findByPhoneStartWith(String str){
		Objects.requireNonNull(str);
		List<Contact> res = new ArrayList<>();
		for(Contact c : list) {
			if(c.getPhone().startsWith(str)) {
				res.add(c);
			}
		}
		return res;
	}
	
	public Iterable<Contact> findOlderThen(int age){
		List<Contact> res = new ArrayList<>();
		for(Contact c : list) {
			if(c.getAge() >= age) {
				res.add(c);
			}
		}
		return res;
	}
	
	public Iterable<Contact> find(Predicate<Contact> filter){
		List<Contact> res = new ArrayList<>();
		for(Contact c : list) {
			if(filter.test(c)) {
				res.add(c);
			}
		}
		return res;
	}
	
	public <T> void find(Predicate<Contact> filter, 
			Function<Contact, ? extends T> mapper,
			Collection<? super T> collector) {
		for(Contact c : list) {
			if(filter.test(c)) {
				T t = mapper.apply(c);
				collector.add(t);
			}
		}
	}
}

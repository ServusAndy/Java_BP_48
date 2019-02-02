

import java.math.BigDecimal;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.IntStream;

public class ShopHomeWork {
    private static Shop shop = generate();

    public static void main(String[] args) {
//        displayShop();
        System.out.println("------totalSalesByProduct------");
        System.out.println(totalSalesByProduct("Milk"));
        System.out.println("------totalSalesByBranch------");
        System.out.println(totalSalesByBranch("Tel Aviv"));
        System.out.println("------ most popular ------");
        displayMostPupularProduct();
        System.out.println("------ display branches statistic ------");
        displayBranchesSalesStatistic();
        System.out.println("------ display product statistic ------");
        displayBranchesProductsStatistic();
        
//        randomize();
    }
    
    static void randomize() {
    	IntStream.range(1, 1000)
    	.boxed()
    	.sorted((a,b) -> Math.random() > 0.5 ? 1 : -1)
    	.forEach(System.out::println);
    }


    static double totalSalesByProduct(String productName) {
    		return shop.branches.stream()
    				.flatMap(v -> v.sales.stream())
    				.filter(v -> productName.equals(v.productName))
    				.map(Sale::getPrice)
    				.reduce(0.0, (a,b) -> a+b);
//        return 0;
    }

    static double totalSalesByBranch(String branchName) {
    		return shop.branches.stream()
    				.filter(v -> branchName.equals(v.branchName))
    				.flatMap(v -> v.sales.stream())
    				.map(Sale::getPrice)
    				.reduce(0.0, (a, b) -> a+b);
//        return 0;
    }

    static void displayMostPupularProduct() {
    		Set<String> products = new HashSet<>();
    		for(Branch b : shop.branches) {
    			for(Sale s : b.sales) {
    				products.add(s.productName);
    			}
    		}
    		String name = "";
    		long count = 0;
    		for(String pName : products) {
    			long c = shop.branches.stream()
    					.flatMap(v -> v.sales.stream())
    					.filter(v -> pName.equals(v.productName))
    					.count();
    			if(c > count) {
    				count = c;
    				name = pName;
    			}
    		}
    		double total = totalSalesByProduct(name);
    		System.out.println(name + " - " + count + " total = " + total);
        //Распечатать имя и общую стоимость самого продоваемого продукта
        //!!!Не использовать collect и коллекторы!!!!
    }

    static void displayBranchesSalesStatistic() {
    		Set<String> branches = new HashSet<>();
    		for(Branch b : shop.branches) {
    			branches.add(b.branchName);
    		}
    		
    		Map<Double,String> bag = 
    				new TreeMap<>((left,right) -> Double.compare(right,left));
    		for(String name : branches) {
    			double total = totalSalesByBranch(name);
    			bag.merge(total, name, (name1,name2) -> name1+","+name2);
    		}
    		Set<Entry<Double,String>> entries = bag.entrySet();
    		for(Entry<Double,String> entry : entries) {
    			String[] arr = entry.getValue().split(",");
    			for(String n : arr) {
    				System.out.println(n + " - " + entry.getKey());
    			}
    		}
        //Распичать имя и общую стоимость продаж каждого филиалов
        //Формат вывода BranchName - totalPrice
        //Распечатать в порядке убывания по totalSales
        //!!!Не использовать collect и коллекторы!!!!
    }

    static void displayBranchesProductsStatistic() { 
    	 Set<String> branches = new HashSet<>();
         for (Branch b : shop.branches) {
             branches.add(b.branchName);
         }

         Map<Long, String> bag = new TreeMap<>();
         for (String name : branches) {
             long count = shop.branches.stream()
                     .filter(branch -> branch.branchName.equals(name))
                     .flatMap(branch -> branch.sales.stream())
                     .count();
             bag.merge(count, name, (name1, name2) -> name1 + "," + name2);
         }
         Set<Map.Entry<Long, String>> entries = bag.entrySet();
         for (Map.Entry<Long, String> entry : entries) {
             String[] arr = entry.getValue().split(",");
             for (String productName : arr) {
                 System.out.println(productName + " - " + entry.getKey());
             }
         }
        //Распечатать имя и количество проданных товаров каждого филиала
        //Формат вывода BranchName - salesCount
        //Распечатать в порядке возростания по salesCount
        //!!!Не использовать collect и коллекторы!!!!
    }

    static void displayShop() {
        System.out.println("------ " + shop.name + " --------");
        shop.branches.stream()
                .peek(branch -> System.out.println("*** " + branch.branchName + " ***"))
                .flatMap(v -> v.sales.stream())
                .forEach(sale -> System.out.println("\t" + sale.productName + " - " + sale.price));

    }

    static Shop generate() {
        String[] products = {"Milk", "Meat", "Bread", "Cigarettes", "Juice", "Potato"};
        String[] branches = {"Tel Aviv", "Haifa", "Rehovot", "Ashdod"};
        double[] prices = {15.5, 16.3, 23.7, 28.90, 7.20, 3.20};
        Random rnd = new Random();
        Shop shop = new Shop("SuperShop");
        shop.branches = new ArrayList<>();
        for (String branch : branches) {
            Branch b = new Branch(branch);
            List<Sale> sales = new ArrayList<>();
            for (int i = 0; i < rnd.nextInt(100) + 1; i++) {
                int indx = rnd.nextInt(products.length);
                sales.add(new Sale(products[indx], prices[indx]));
            }
            b.sales = sales;
            shop.branches.add(b);
        }
        return shop;
    }

    static class Shop {
        String name;
        List<Branch> branches;

        public Shop(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public List<Branch> getBranches() {
            return branches;
        }
    }

    static class Branch {
        String branchName;
        List<Sale> sales;

        public Branch(String branchName) {
            this.branchName = branchName;
        }

        public String getBranchName() {
            return branchName;
        }

        public List<Sale> getSales() {
            return sales;
        }
    }

    static class Sale {
        String productName;
        double price;

        public Sale(String productName, double price) {
            this.productName = productName;
            this.price = price;
        }

        String getProductName() {
            return productName;
        }

        double getPrice() {
            return price;
        }
    }
}

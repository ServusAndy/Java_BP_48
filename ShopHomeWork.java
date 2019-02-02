package com.sheygam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShopHomeWork {
    static Shop shop = generate();
    public static void main(String[] args) {
//        displayShop();
    }



    static double totalSalesByProduct(String productName){

        return 0;
    }

    static double totalSalesByBranch(String branchName){

        return 0;
    }

    static void displayMostPupularProduct(){
        //Распечатать имя и общую стоимость самого продоваемого продукта
        //!!!Не использовать collect и коллекторы!!!!
    }

    static void displayBranchesSalesStatistic(){
        //Распичать имя и общую стоимость продаж каждого филиалов
        //Формат вывода BranchName - totalPrice
        //Распечатать в порядке убывания по totalSales
        //!!!Не использовать collect и коллекторы!!!!
    }

    static void displayBranchesProductsStatistic(){
        //Распечатать имя и количество проданных товаров каждого филиала
        //Формат вывода BranchName - salesCount
        //Распечатать в порядке возростания по salesCount
        //!!!Не использовать collect и коллекторы!!!!
    }

    static void displayShop(){
        System.out.println("------ " + shop.name + " --------");
        shop.branches.stream()
                .peek(branch -> System.out.println("*** " + branch.branchName + " ***"))
                .flatMap(v -> v.sales.stream())
                .forEach(sale -> System.out.println("\t" + sale.productName + " - " + sale.price));

    }

    static Shop generate(){
        String[] products = {"Milk","Meat","Bread","Cigarettes","Juice","Potato"};
        String[] branches = {"Tel Aviv","Haifa","Rehovot","Ashdod"};
        double[] prices = {15.5,16.3,23.7,28.90,7.20,3.20};
        Random rnd = new Random();
        Shop shop = new Shop("SuperShop");
        shop.branches = new ArrayList<>();
        for(String branch : branches){
            Branch b = new Branch(branch);
            List<Sale> sales = new ArrayList<>();
            for(int i = 0; i < rnd.nextInt(100) + 1;i++){
                int indx = rnd.nextInt(products.length);
                sales.add(new Sale(products[indx],prices[indx]));
            }
            b.sales = sales;
            shop.branches.add(b);
        }
        return shop;
    }

    static class Shop{
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
    static class Branch{
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

    static class Sale{
        String productName;
        double price;

        public Sale(String productName, double price) {
            this.productName = productName;
            this.price = price;
        }

        String getProductName(){
            return productName;
        }
        double getPrice(){
            return price;
        }
    }
}

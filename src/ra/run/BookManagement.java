package ra.run;

import ra.config.Config;
import ra.config.InputMethods;
import ra.model.Catalog;
import ra.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookManagement {
    static List<Catalog> catalogs = new ArrayList<>();
    static List<Product> products = new ArrayList<>();
    public static void main(String[] args) {
        while (true) {
            System.out.println("**************************BASIC-MENU**************************\n" +
                    "1. Quản lý danh mục [5 điểm]\n" +
                    "2. Quản lý sản phẩm [5 điểm]\n" +
                    "3. Thoát [5 điểm]");
            System.out.println("Nhập vào lựa chọn của bạn");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    menuCatalog();
                    break;
                case 2:
                    menuProduct();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Phải nhâp số từ 1 đến 3");
            }
        }
    }

    public static void menuCatalog(){
        byte choice = 0;
        while (choice != 5) {
            System.out.println("********************CATALOG-MANAGEMENT********************\n" +
                    "1. Nhập số danh mục thêm mới và nhập thông tin cho từng danh mục [5 điểm]\n" +
                    "2. Hiển thị thông tin tất cả các danh mục [5 điểm]\n" +
                    "3. Sửa tên danh mục theo mã danh mục [5 điểm]\n" +
                    "4. Xóa danh muc theo mã danh mục (lưu ý ko xóa khi có sản phẩm) [5 điểm]\n" +
                    "5. Quay lại");
            System.out.println("Nhập vào lựa chọn của bạn");
            choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    createCatalog();
                    break;
                case 2:
                    if(catalogs.isEmpty()){
                        System.err.println("Chưa có danh muc");
                    } else {
                        System.out.println(catalogs);
                    }
                    break;
                case 3:
                    editCatalog();
                    break;
                case 4:
                    removeCatalog();
                    break;
                case 5:
                    break;
                default:
                    System.err.println("Phải nhâp số từ 1 đến 5");
            }
        }
    }
    public static void menuProduct(){
        byte choice = 0;
        while (choice != 7) {
            System.out.println("********************PRODUCT-MANAGEMENT********************\n" +
                    "1. Nhập số sản sản phẩm và nhập thông tin sản phẩm [5 điểm]\n" +
                    "2. Hiển thị thông tin các sản phẩm [5 điểm]\n" +
                    "3. Sắp xếp sản phẩm theo giá giảm dần [5 điểm]\n" +
                    "4. Xóa sản phẩm theo mã [5 điểm]\n" +
                    "5. Tìm kiếm sách theo tên sách [10 điểm]\n" +
                    "6. Thay đổi thông tin của sách theo mã sách [10 điểm]\n" +
                    "7. Quay lại");
            System.out.println("Nhập vào  lựa chọn của bạn");
            choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    createProduct();
                    break;
                case 2:
                    if(products.isEmpty()){
                        System.err.println("Chưa có sản pham");
                    } else {
                        System.out.println(products);
                    }
                    break;
                case 3:
                    Collections.sort(products);
                    break;
                case 4:
                    removeProduct();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.err.println("Phải nhâp số từ 1 đến 7");
                    break;
            }
        }
    }

    public static void createCatalog() {
        // nhập vào số lượng danh muc cần thêm mới
        System.out.println("Nhập số lượng danh mục cần thêm mới");
        int n = InputMethods.getInteger();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin danh mục thứ " + (i + 1));
            Catalog catalog = new Catalog();
            System.out.println("Nhập id danh mục:");
            catalog.setCatalogId(InputMethods.getInteger());
            System.out.println("Nhập tên danh mục:");
            catalog.setCatalogName(InputMethods.getString());
            catalogs.add(catalog);
        }
    }

    public static void editCatalog(){
        System.out.println("Nhập mã danh mục: ");
        List<Integer> numbers = new ArrayList<>();
        for (Catalog catalog : catalogs) {
            numbers.add(catalog.getCatalogId());
        }
        int input = InputMethods.getInteger();
        for (Catalog catalog : catalogs) {
            if(catalog.getCatalogId() == input) {
                System.out.println("Nhập ten danh mục muốn thay đổi: ");
                String newName = InputMethods.getString();
                catalog.setCatalogName(newName);
                System.out.println("Sửa thành công");
                break;
            }
        }
    }

    public static void removeCatalog(){
        System.out.println("Nhập mã danh mục: ");
        List<Integer> numbers = new ArrayList<>();
        for (Catalog catalog : catalogs) {
            numbers.add(catalog.getCatalogId());
        }
        int input = InputMethods.getInteger();
        for (Catalog catalog : catalogs) {
            if(catalog.getCatalogId() == input) {
                catalogs.remove(catalog);
                System.out.println("Xoa thanh cong");
                break;
            }
        }
    }

    public static void createProduct() {
        // nhập vào số lượng sản phẩm cần thêm mới
        System.out.println("Nhập số lượng sản phẩm cần thêm mới");
        int n = InputMethods.getInteger();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sản phâm thứ " + (i + 1));
            Product product = new Product();
            System.out.println("Nhập id sản phẩm:");
            product.setProductId(InputMethods.getString());
            System.out.println("Nhập tên sản phẩm:");
            product.setProductName(InputMethods.getString());
            System.out.println("Nhập giá sản phẩm:");
            product.setProductPrice(InputMethods.getDouble());
            System.out.println("Nhập mô tả sản phẩm:");
            product.setDescription(InputMethods.getString());
            System.out.println("Nhập stock sản phẩm:");
            product.setStock(InputMethods.getInteger());

            while (true){
                boolean flag = false;
                System.out.println("Nhap catalog sản phẩm");
                int id = InputMethods.getInteger();
                for (Catalog au: catalogs) {
                    if(au.getCatalogId()==id){
                        product.setCatalog(au);
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    break;
                }
                System.err.println("Id not found");
            }
            System.out.println("Nhập trạng thái sản phẩm:");
            product.setStatus(InputMethods.getBoolean());
            products.add(product);
        }
    }

    public static void removeProduct(){
        System.out.println("Nhập mã sản phẩm: ");
        List<String> strings = new ArrayList<>();
        for (Product product : products) {
            strings.add(product.getProductId());
        }
        String input = InputMethods.getString();
        for (Product product : products) {
            if(product.getProductId().equals(input)) {
                products.remove(product);
                System.out.println("Xoa thanh cong");
                break;
            }
        }
    }
}

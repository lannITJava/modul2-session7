package ra.entity;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;

    public Book() {
    }

    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, float interest, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.interest = interest;
        this.year = year;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public float getInterest() {
        return interest;
    }

    public int getYear() {
        return year;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public void inputData(@org.jetbrains.annotations.NotNull Scanner scanner, Book[] arrBook, int index){
        System.out.println("Nhập vào mã sách");
        boolean checkBookId = true;
        do {
            this.bookId = scanner.nextLine();
            if (index!=0){
                boolean isExit = false;
                for (int i = 0; i < index; i++) {
                    if (arrBook[i].bookId.equals(this.bookId)){
                        isExit= true;
                        break;
                    }
                }
                if (!isExit){
                    break;
                }else {
                    System.err.println("Mã sách đã tồn tại, vui lòng nhập lại");
                }
            }else{
                break;
            }
        }while (checkBookId);
        System.out.println("Nhập vào tên sách");
        boolean checkBookName = true;
        String bookNameRegex = "^[B][a-zA-Z0-9]{3}$";
        do {
            this.bookName = scanner.nextLine();
            if (index!=0){
                boolean isExit = false;
                for (int i = 0; i < index; i++) {
                    if (!Pattern.matches(bookNameRegex,this.bookName) || arrBook[i].bookName.equals(this.bookName)){
                        isExit= true;
                        break;
                    }
                }
                if (!isExit){
                    break;
                }else {
                    System.err.println("Tên sách không được trùng lặp, gồm 4 ký tự, bắt đầu là ký tự B");
                }
            }else{
                if (!Pattern.matches(bookNameRegex,this.bookName)){
                    System.err.println("Tên sách không được trùng lặp, gồm 4 ký tự, bắt đầu là ký tự B");
                }else {
                    break;
                }
            }
        }while (checkBookName);
        System.out.println("Nhập vào giá nhập của sách ");
        do{
            this.importPrice= Float.parseFloat(scanner.nextLine());
                if (this.importPrice<=0){
                    System.err.println("Giá nhập của sách phải lớn hơn 0");
                }else {
                    break;
                }

        }while (true);
        System.out.println("Nhập vào giá xuất của sách ");
        do{
            this.exportPrice= Float.parseFloat(scanner.nextLine());
                if (this.exportPrice<(this.importPrice*30/100)+this.importPrice){
                    System.err.println("Giá xuất của sách phải lớn hơn ít nhất 30% so với giá nhập");
                }else{
                    break;
                }
        }while (true);
        System.out.println("Nhập vào tên tác giả");
        do {
            this.author= scanner.nextLine();
                if (this.author.length()<6||this.author.length()>50){
                    System.err.println("Tên tác giả phải lớn hơn 6 ký tự và nhỏ hơn 50 ký tự");
                }else {
                    break;
                }
        }while (true);
        System.out.println("Nhập vào năm xuất bản");
        do{
            this.year= Integer.parseInt(scanner.nextLine());
            if (this.year<2000){
                System.err.println("Sách phải được xuất bản ít nhất sau năm 2000");
            }else {
                break;
            }
        }while (true);
    }
    public void displayData(){
        System.out.printf("Mã sách: %s - Tên sách: %s - Giá nhập: %f - Giá xuất: %f - Tác giả: %s - Lợi nhuận: %f - Năm xuất bản: %d\n",this.bookId,this.bookName,this.importPrice,this.exportPrice,this.author,this.interest,this.year);
    }
    public void interest(){
        this.interest= this.exportPrice-this.importPrice;
    }


}

package ra.run;

import ra.entity.Book;

import java.util.Scanner;

public class BookImp {
    static Book[] arrBooks = new Book[100];
    static int index = 0;
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        do {
            System.out.println("****************MENU*****************");
            System.out.println("1. Nhập thông tin n sách (n nhập từ bàn phím)");
            System.out.println("2. Tính lợi nhuận các sách");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
            System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("6. Tìm sách theo tên sách (tên sách nhập từ bàn phím)");
            System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
            System.out.println("8. Thống kê số lượng sách theo tác giả");
            System.out.println("9. Thoát");
            System.out.print("Sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    BookImp.inputListBooks(scanner);
                    break;
                case 2:
                    BookImp.calListInterest();
                    break;
                case 3:
                    System.out.println("Thông tin các sách");
                    for (int i = 0; i < index; i++) {
                        arrBooks[i].displayData();
                    }
                    break;
                case 4:
         //           4. Sắp xếp sách theo giá bán tăng dần
                    for (int i = 0; i < index-1; i++) {
                        for (int j = i+1; j < index; j++) {
                            if (arrBooks[i].getExportPrice()>arrBooks[j].getExportPrice()){
                                Book bookTemp = arrBooks[i];
                                arrBooks[i]= arrBooks[j];
                                arrBooks[j]= bookTemp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp sách theo giá bán tăng dần");
                    break;
                case 5:
       //             5. Sắp xếp sách theo lợi nhuận giảm dần
                    for (int i = 0; i < index-1; i++) {
                        for (int j = i+1; j < index; j++) {
                            if (arrBooks[i].getInterest()<arrBooks[j].getInterest()){
                                Book bookTemp = arrBooks[i];
                                arrBooks[i]=arrBooks[j];
                                arrBooks[j]= bookTemp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp sách theo lợi nhuận giảm dần");
                    break;
                case 6:
              //      6. Tìm sách theo tên sách (tên sách nhập từ bàn phím)
                    System.out.println("Nhập tên sách cần tìm: ");
                    String nameSearch = scanner.nextLine();
                    boolean isExit = false;
                    System.out.println("Sách tìm thấy: ");
                    for (int i = 0; i < index; i++) {
                        if (arrBooks[i].getBookName().toLowerCase().contains(nameSearch.toLowerCase())){
                            arrBooks[i].displayData();
                            isExit = true;
                        }
                    }
                    if (!isExit){
                        System.out.println("Không có sách thỏa mãn điều kiện tìm kiếm");
                    }
                    break;
                case 7:
             //       7. Thống kê số lượng sách theo năm xuất bản
                    if (index==0){
                        System.out.println("Không có sách");
                        return;
                    }
                    int[] arrYear = new int[index];
                    int arrYearIndex =0;
                    for (int i = 0; i < index; i++) {
                        boolean check = false;
                        for (int j = i+1; j <index ; j++) {
                            if ((arrBooks[j].getYear()) == arrBooks[i].getYear()) {
                                check= true;
                                break;
                            }
                        }
                        if (!check){
                            arrYear[arrYearIndex]= arrBooks[i].getYear();
                            arrYearIndex++;
                        }
                    }
                    // Thống kê tần suất xuất hiện
                    int[] arrCountYear = new int[arrYearIndex];

                    for (int i = 0; i < arrYearIndex; i++) {
                        int count = 0;
                        for (int j = 0; j < index; j++) {
                            if (arrYear[i]==arrBooks[j].getYear()){
                                count++;
                            }
                        }
                        arrCountYear[i]= count;
                    }
                    for (int i = 0; i < arrYearIndex; i++) {
                        System.out.println("Năm "+arrYear[i]+" có "+arrCountYear[i]+" quyển sách xuất bản");
                    }
                    break;
                case 8:
                    if (index==0){
                        System.out.println("Không có sách");
                        return;
                    }
                    String[] arrAuthor = new String[index];
                    int arrAuthorIndex =0;
                    for (int i = 0; i < index; i++) {
                        boolean check = false;
                        for (int j = i+1; j <index ; j++) {
                            if (arrBooks[i].getAuthor().equals(arrBooks[j].getAuthor())){
                                check= true;
                                break;
                            }
                        }
                        if (!check){
                            arrAuthor[arrAuthorIndex]= arrBooks[i].getAuthor();
                            arrAuthorIndex++;
                        }
                    }
                    // Thống kê tần suất xuất hiện
                    int[] arrCountAuthor = new int[arrAuthorIndex];

                    for (int i = 0; i < arrAuthorIndex; i++) {
                        int count = 0;
                        for (int j = 0; j < index; j++) {
                            if (arrAuthor[i].equals(arrBooks[j].getAuthor())){
                                count++;
                            }
                        }
                       arrCountAuthor[i]= count;
                    }
                    for (int i = 0; i < arrAuthorIndex; i++) {
                        System.out.println("Tác giả "+arrAuthor[i]+" có "+arrCountAuthor[i]+" quyển sách");
                    }
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng nhập từ 1-9");
            }
        }while (true);
    }
    public static void inputListBooks(Scanner scanner){
        System.out.println("Nhập số sách cần nhập dữ liệu: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            arrBooks[index]= new Book();
            arrBooks[index].inputData(scanner,arrBooks,index);
            index++;
        }
    }
    public static void calListInterest(){
        for (int i = 0; i < index; i++) {
            arrBooks[i].interest();
        }
        System.out.println("Đã tính xong lợi nhuận cho tất cả sách");
    }
}

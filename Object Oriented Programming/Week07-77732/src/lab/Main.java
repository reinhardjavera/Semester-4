package lab;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Item> listOfItems = new ArrayList<>();
    static ArrayList<Order> listOfOrders = new ArrayList<>(); // Added list to store orders

    static Scanner scanner = new Scanner(System.in);

    public static void seedData() {
        listOfItems.add(new Item("Kulkas", "Electronic", 4800000));
        listOfItems.add(new Item("TV", "Electronic", 1280000));
        listOfItems.add(new Item("Laptop", "Computer", 6000000));
        listOfItems.add(new Item("PC", "Computer", 12000000));
    }

    public static void printItem(Item item) {
        System.out.println("Nama : " + item.getName());
        System.out.println("Tipe : " + item.getType());
        System.out.println("Harga : " + item.getPrice());
    }

    public static void main(String[] args) {
        seedData();
        int opt, id;
        do {
            System.out.println("---Program Toko Elektronik----");
            System.out.println("1. Pesan Barang");
            System.out.println("2. Lihat Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            opt = scanner.nextInt();
            switch (opt) {
            case 1:
                System.out.println("---Daftar Barang----");
                for (int i = 0; i < listOfItems.size(); i++) {
                    System.out.println("No : " + (i + 1));
                    printItem(listOfItems.get(i));
                    System.out.println("----------------------");
                }
                System.out.print("Pilih: ");
                id = scanner.nextInt();
                if (id >= 1 && id <= listOfItems.size()) {
                    System.out.println("Nama : " + listOfItems.get(id - 1).getName());
                    System.out.println("Tipe : " + listOfItems.get(id - 1).getType());
                    System.out.println("Harga : " + listOfItems.get(id - 1).getPrice());
                    System.out.println("----Tipe pembayaran----");
                    System.out.println("1. Cash");
                    System.out.println("2. Credit");
                    System.out.print("Pilih: ");
                    int paymentType = scanner.nextInt();
                    if (paymentType == 1) { // Cash payment
                        // Create a new order for cash payment
                        Order order = new Order(listOfItems.get(id - 1), "Cash", listOfItems.get(id - 1).getPrice());
                        System.out.print("Bayar (Y/N): ");
                        String confirm = scanner.next();
                        if (confirm.equalsIgnoreCase("Y")) {
                            System.out.println("Harga Pembayaran: " + listOfItems.get(id - 1).getPrice());
                            System.out.print("Bayar : ");
                            int amountPaid = scanner.nextInt();
                            if (amountPaid >= listOfItems.get(id - 1).getPrice()) {
                                System.out.println("Transaksi telah dibayar lunas");
                                order.setAmountRemaining(0); // Set remaining amount to 0
                                order.setPaid(true); // Mark the order as paid
                            } else {
                                System.out.println("Uang yang dibayarkan kurang dari harga barang!");
                                System.out.println("Transaksi gagal");
                                // Add the order to the list even if the transaction fails
                                listOfOrders.add(order);
                                continue; // Skip further processing for this order
                            }
                        } else {
                            System.out.println("Transaksi telah disimpan");
                        }
                        // Add the order to the list
                        listOfOrders.add(order);
                    } else if (paymentType == 2) {
                        // Proceed with credit payment as before
                        System.out.print("Lama Cicilan (3/6/9/12): ");
                        int installment = scanner.nextInt();
                        if (installment == 3 || installment == 6 || installment == 9 || installment == 12) {
                            // Create a new order for credit payment and add it to the list of orders
                            Order order = new Order(listOfItems.get(id - 1), "Credit", listOfItems.get(id - 1).getPrice());

                            Credit credit = new Credit(listOfItems.get(id - 1), installment);
                            int monthlyPayment = credit.calculateMonthlyPayment();
                            order.setMonthlyPayment(String.valueOf(monthlyPayment)); // Store monthly payment in the order
                            System.out.println("Harga Pembayaran per bulan: " + monthlyPayment);
                            System.out.print("Bayar : ");
                            int amountPaid = scanner.nextInt();
                            if (amountPaid >= listOfItems.get(id - 1).getPrice()) {
                                System.out.println("Transaksi telah dibayar lunas");
                                order.setAmountRemaining(0); // Set remaining amount to 0
                                order.setPaid(true); // Mark the order as paid
                            } else if (amountPaid >= monthlyPayment) {
                                System.out.println("Transaksi berhasil, sisa pembayaran: " + (listOfItems.get(id - 1).getPrice() - amountPaid));
                                order.setAmountRemaining(listOfItems.get(id - 1).getPrice() - amountPaid);
                            } else {
                                System.out.println("Uang yang dibayarkan kurang dari harga barang!");
                                System.out.println("Transaksi gagal");
                                order.setValidCredit(false); // Set isValidCredit flag to false for invalid credit transactions
                            }
                            // Check if the credit transaction is valid before adding it to the list
                            if (order.isValidCredit()) {
                                listOfOrders.add(order);
                            }
                        } else {
                            System.out.println("Input durasi cicilan tidak valid!");
                            System.out.println("Transaksi gagal");
                            continue; // Skip adding the order to the list
                        }
                    } else {
                        System.out.println("Salah Input");
                    }


                } else {
                    System.out.println("No Barang Salah");
                }
                break;
            case 2:
                System.out.println("---Daftar Barang----");
                int itemCount = 0;
                for (int i = 0; i < listOfOrders.size(); i++) {
                    Order order = listOfOrders.get(i);
                    Item item = order.getItem();
                    if (!order.isPaid() || (order.isPaid() && order.getPaymentType().equals("Cash"))) { // Include cash payments
                        itemCount++;
                        System.out.println("No : " + itemCount);
                        System.out.println("Nama : " + item.getName());
                        System.out.println("Tipe : " + item.getType());
                        System.out.println("Status : " + (order.isPaid() ? "LUNAS" : "ON PROGRESS"));
                        if (!order.isPaid() && order.getPaymentType().equals("Cash")) {
                            System.out.print("Harga Pembayaran : ");
                            System.out.println(item.getPrice());
                        } else if (!order.isPaid() && order.getPaymentType().equals("Credit")) {
                            System.out.print("Harga Pembayaran : ");
                            System.out.println(order.getMonthlyPayment() + " per bulan");
                        }
                        System.out.println("Sisa Pembayaran : " + order.getAmountRemaining());
                        System.out.println("----------------------");
                    }
                }
                if (itemCount == 0) {
                    System.out.println("Tidak ada pesanan yang sedang berlangsung.");
                } else {
                    System.out.print("Pilih No Transaksi : ");
                    int selectedOrder = scanner.nextInt();
                    if (selectedOrder >= 1 && selectedOrder <= itemCount) {
                        int orderIndex = 0;
                        for (int i = 0; i < listOfOrders.size(); i++) {
                            Order order = listOfOrders.get(i);
                            if (!order.isPaid() || (order.isPaid() && order.getPaymentType().equals("Cash"))) { // Include cash payments
                                orderIndex++;
                                if (orderIndex == selectedOrder) {
                                    Item selected = order.getItem();
                                    System.out.println("Nama : " + selected.getName());
                                    System.out.println("Tipe : " + selected.getType());
                                    System.out.println("Status : " + (order.isPaid() ? "LUNAS" : "ON PROGRESS"));
                                    if (!order.isPaid() && order.getPaymentType().equals("Cash")) {
                                        System.out.print("Harga Pembayaran : ");
                                        System.out.println(selected.getPrice());
                                    } else if (!order.isPaid() && order.getPaymentType().equals("Credit")) {
                                        System.out.print("Harga Pembayaran : ");
                                        System.out.println(order.getMonthlyPayment() + " per bulan");
                                    }
                                    System.out.println("Sisa Pembayaran : " + order.getAmountRemaining());
                                    if (!order.isPaid()) {
                                        System.out.print("Bayar : ");
                                        int amountPaid = scanner.nextInt();
                                        if (amountPaid >= order.getAmountRemaining()) {
                                            System.out.println("Transaksi telah lunas");
                                            order.setAmountRemaining(0); // Update the remaining amount to 0
                                            order.setPaid(true); // Mark the order as paid
                                        } else {
                                            System.out.println("Transaksi berhasil, sisa pembayaran: " + (order.getAmountRemaining() - amountPaid));
                                            order.setAmountRemaining(order.getAmountRemaining() - amountPaid); // Update the remaining amount
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("No Transaksi Salah");
                    }
                }
                break;
                case 0:
                    System.out.println("Keluar");
                    break;
                default:
                    System.out.println("Pilihan Salah");
            }
        } while (opt != 0);
    }
}

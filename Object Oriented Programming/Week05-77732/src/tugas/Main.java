package tugas;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		System.out.println("----------Program Menghitung Bangun Ruang----------");
        System.out.println("1. Lingkaran");
        System.out.println("2. Persegi");
        System.out.println("3. Persegi Panjang");
        System.out.println("4. Segitiga");
        System.out.println("Pilih bangun ruang : ");

        int choice = s.nextInt();
        switch (choice) {
            case 1:
                handleCircle(s);
                break;
            case 2:
                handleSquare(s);
                break;
            case 3:
                handleRectangle(s);
                break;
            case 4:
                handleTriangle(s);
                break;
            default:
                System.out.println("Pilihan tidak valid. Masukkan angka 1 - 4");
        }
    }

    private static void handleCircle(Scanner s) {
    	System.out.println("----------Lingkaran/Circle----------");
    	System.out.print("Masukkan jari-jari lingkaran : ");
        double radius = s.nextDouble();
        System.out.print("Masukkan warna : ");
        String color = s.next();

        Circle circle = new Circle(radius, color);
        printShapeDetails(circle);
    }

    private static void handleSquare(Scanner s) {
    	System.out.println("----------Persegi/Square----------");
        System.out.print("Masukkan sisi persegi : ");
        double side = s.nextDouble();
        System.out.print("Masukkan warna : ");
        String color = s.next();

        Square square = new Square(side, color);
        printShapeDetails(square);
    }

    private static void handleRectangle(Scanner s) {
    	System.out.println("----------Persegi Panajng/Rectangle----------");
        System.out.print("Masukkan panjang : ");
        double length = s.nextDouble();
        System.out.print("Masukkan lebar : ");
        double width = s.nextDouble();
        System.out.print("Masukkan warna : ");
        String color = s.next();

        Rectangle rectangle = new Rectangle(length, width, color);
        printShapeDetails(rectangle);
    }

    private static void handleTriangle(Scanner s) {
    	System.out.println("----------Segitiga/Triangle----------");
        System.out.print("Masukkan sisi 1 : ");
        double side1 = s.nextDouble();
        System.out.print("Masukkan sisi 2 : ");
        double side2 = s.nextDouble();
        System.out.print("Masukkan sisi 3 : ");
        double side3 = s.nextDouble();
        System.out.print("Masukkan warna : ");
        String color = s.next();

        Triangle triangle = new Triangle(side1, side2, side3, color);
        printShapeDetails(triangle);
    }

    private static void printShapeDetails(Shape shape) {
        System.out.println("Warna : " + shape.getColor());
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            System.out.println("Jari-jari : " + circle.getRadius());
        } else if (shape instanceof Square) {
            Square square = (Square) shape;
            System.out.println("Sisi : " + square.getSide());
        } else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            System.out.println("Panjang : " + rectangle.getLength());
            System.out.println("Lebar : " + rectangle.getWidth());
        } else if (shape instanceof Triangle) {
            Triangle triangle = (Triangle) shape;
            System.out.println("Sisi 1 : " + triangle.getSide1());
            System.out.println("Sisi 2 : " + triangle.getSide2());
            System.out.println("Sisi 3 : " + triangle.getSide3());
        }

        System.out.println("Keliling : " + shape.getPerimeter());
        System.out.println("Luas : " + shape.getArea());
    }

}

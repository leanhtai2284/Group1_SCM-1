package thuchanhonha;

import java.util.*;
import java.util.Arrays;

class Nhanvien {
	int CMND, Manv;
	String Hoten, Diachi;
	Double Luongcb, Namct, Tienthuong, Tamung, Thuclinh;

	void Nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap CMND: ");
		CMND = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhap Dia chi: ");
		Diachi = sc.nextLine();
		System.out.println("Nhap Ho ten: ");
		Hoten = sc.nextLine();
		System.out.println("Nhap Ma nhan vien: ");
		Manv = sc.nextInt();
		System.out.println("Nhap luong co ban: ");
		Luongcb = sc.nextDouble();
		System.out.println("Nhap Nam cong tac: ");
		Namct = sc.nextDouble();
		System.out.println("Nhap tien thuong: ");
		Tienthuong = sc.nextDouble();
		System.out.println("Nhap tien thuc linh: ");
		Thuclinh = sc.nextDouble();
	}

	void Tinhthuong() {
		if (Namct <= 3) {
			Tienthuong = Luongcb * 20 / 100;
		} else if (Namct > 3) {
			Tienthuong = Luongcb * 50 / 100;
		}
	}

	void Ungtien() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so tien tam ung: ");
		Tamung = sc.nextDouble();
	}

	void Tinhthuclinh() {

		Thuclinh = Luongcb + Tienthuong - Tamung;

	}

	void Hienthi() {
		System.out.println("CMND la: " + CMND);
		System.out.println("Dia chi la: " + Diachi);
		System.out.println("Ho ten la: " + Hoten);
		System.out.println("Ma nhan vien la: " + Manv);
		System.out.println("Luong co ban la: " + Luongcb);
		System.out.println("Nam cong tac la: " + Namct);
		System.out.println("Tien thuong la: " + Tienthuong);
		System.out.println("Tien tam ung la: " + Tamung);
		System.out.println("Tien thuc linh la: " + Thuclinh);
	}
}

class DSnhanvien {
	Nhanvien[] ds = new Nhanvien[2];

	void Nhap() {
		for (int i = 0; i < 2; i++) {
			System.out.println("Nhap thong tin nhan vien thu " + (i + 1) + ":");
			ds[i] = new Nhanvien();
			ds[i].Nhap();
			ds[i].Tinhthuong();
			ds[i].Ungtien();
			ds[i].Tinhthuclinh();
		}
	}

	double Tongthuclinh() {
		double tong = 0;
		for (int i = 0; i < 2; i++) {
			tong += ds[i].Thuclinh;
		}
		return tong;
	}

	void Ungtiennv() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so luong nhan vien can ung tien: ");
		int n = sc.nextInt();
		for (int i = 0; i < 2; i++) {
			System.out.println("Nhap vi tri nhan vien thu " + i + ":");
			int index = sc.nextInt();
			ds[index].Ungtien();
			ds[index].Tinhthuclinh();
		}
	}

	void Sapxep() {
		Arrays.sort(ds, (nv1, nv2) -> Double.compare(nv2.Thuclinh, nv1.Thuclinh));

	}

	void Hienthinv() {
		for (int i = 0; i < 2; i++) {
			System.out.println("Thong tin nhan vien thu " + (i + 1) + ":");
			ds[i].Hienthi();
		}
	}
}

public class Sinhvien {

	public static void main(String[] args) {
		DSnhanvien ds = new DSnhanvien();
		ds.Nhap();
		ds.Ungtiennv();
		ds.Sapxep();
		ds.Hienthinv();
		System.out.println("Tong thuc linh cua 10 nhan vien: " + ds.Tongthuclinh());

	}

}

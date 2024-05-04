package mang;

import java.util.*;

public class MySLL {
	private Node head;

	public MySLL() {
		this.head = null;
	}

	public void append(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}

	public void insert(int data, int k) {
		Node newNode = new Node(data);
		if (k == 0) {
			newNode.next = head;
			head = newNode;
			return;
		}
		Node current = head;
		for (int i = 0; i < k - 1; i++) {
			if (current == null) {
				System.out.println("Index out of bound");
				return;
			}
			current = current.next;
		}
		newNode.next = current.next;
		current.next = newNode;
	}

	public void deleteFirst() {
		if (head == null) {
			return;
		}
		head = head.next;
	}

	public void deleteLast() {
		if (head == null || head.next == null) {
			head = null;
			return;
		}
		Node current = head;
		while (current.next.next != null) {
			current = current.next;
		}
		current.next = null;
	}

	public void delete(int k) {
		if (k == 0) {
			head = head.next;
			return;
		}
		Node current = head;
		for (int i = 0; i < k - 1; i++) {
			if (current == null || current.next == null) {
				System.out.println("Index out of bound");
				return;
			}
			current = current.next;
		}
		current.next = current.next.next;
	}

	public void reverse() {
		Node prev = null;
		Node current = head;
		Node nextNode = null;
		while (current != null) {
			nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}
		head = prev;
	}

	public void sort() {
		if (head == null || head.next == null) {
			return;
		}

		Node current = head;
		while (current != null) {
			Node index = current.next;
			while (index != null) {
				if (current.data > index.data) {
					int temp = current.data;
					current.data = index.data;
					index.data = temp;
				}
				index = index.next;
			}
			current = current.next;
		}
	}

	public void printList() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MySLL myList = new MySLL();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập số lượng phần tử trong danh sách: ");
		int n = scanner.nextInt();

		System.out.println("Nhập " + n + " phần tử:");

		for (int i = 0; i < n; i++) {
			int value = scanner.nextInt();
			myList.append(value);
		}

		System.out.println("Danh sách sau khi nhập:");
		myList.printList();

		System.out.println("Chèn giá trị 5 vào vị trí 2:");
		myList.insert(5, 2);
		myList.printList();

		System.out.println("Xóa phần tử đầu tiên:");
		myList.deleteFirst();
		myList.printList();

		System.out.println("Xóa phần tử cuối cùng:");
		myList.deleteLast();
		myList.printList();

		System.out.println("Xóa phần tử ở vị trí 1:");
		myList.delete(1);
		myList.printList();

		System.out.println("Đảo ngược danh sách:");
		myList.reverse();
		myList.printList();

		System.out.println("Sắp xếp danh sách:");
		myList.sort();
		myList.printList();

		scanner.close();
	}
}

package com.zero.iterator;

public class Main {
	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf(4);
		bookShelf.appendBook(new Book("JavaSE"));
		bookShelf.appendBook(new Book("JavaEE"));
		bookShelf.appendBook(new Book("JVM"));
		bookShelf.appendBook(new Book("JavaWeb"));
		Iterator iterator = bookShelf.iterator();
		while(iterator.hasNext()){
			Book book = (Book)iterator.next();
			System.out.println(book.getName());
		}
		
	}
}

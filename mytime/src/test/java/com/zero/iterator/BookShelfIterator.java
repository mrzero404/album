package com.zero.iterator;

public class BookShelfIterator implements Iterator{
	private BookShelf bookSelf;
	private int index;
	
	public BookShelfIterator(BookShelf bookShelf) {
		this.bookSelf = bookShelf;
		this.index = 0;
	}
	
	@Override
	public boolean hasNext() {
		if(index < bookSelf.getLength()){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object next() {
		Book book = bookSelf.getBookAt(index);
		index ++;
		return book;
	}

}

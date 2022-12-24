package adt.hashtable.open;

import adt.hashtable.AbstractHashtable;

public abstract class AbstractHashtableOpenAddress<T extends Storable> extends
		AbstractHashtable<T> {

	protected final DELETED deletedElement = new DELETED();
	private int tableSize;

	public AbstractHashtableOpenAddress(int size) {
		this.tableSize = size;
		this.initiateInternalTable(size);
	}

	@Override
	protected void initiateInternalTable(int size) {
		this.table = new Storable[size];
	}
}

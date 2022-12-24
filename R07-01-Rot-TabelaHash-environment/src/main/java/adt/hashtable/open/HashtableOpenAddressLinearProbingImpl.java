package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (element != null && this.search(element) == null) {

			int probe = 0;
			while (probe < this.table.length) {
				int hash = this.getHash(element, probe);

				if (this.table[hash] == null || this.table[hash].equals(this.deletedElement)) {
					this.table[hash] = element;
					this.elements++;
					break;
				} else {
					probe++;
					this.COLLISIONS++;
				}
			}

			if (probe == this.table.length) {
				throw new HashtableOverflowException();
			}

		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			int probe = 0;

			while (probe < this.table.length) {
				int hash = this.getHash(element, probe);

				if (this.table[hash] == null) {
					break;
				}

				if (this.table[hash].equals(element)) {
					this.table[hash] = this.deletedElement;
					this.elements--;
					break;
				}
				probe++;
			}

		}
	}

	@Override
	public T search(T element) {
		T result = null;
		if (element != null) {
			int probe = 0;

			while (probe < this.table.length) {
				int hash = this.getHash(element, probe);

				if (this.table[hash] == null) {
					break;
				}

				if (this.table[hash].equals(element)) {
					result = element;
					break;
				}
				probe++;
			}

		}
		return result;
	}

	@Override
	public int indexOf(T element) {
		int result = -1;
		if (element != null) {
			int probe = 0;

			while (probe < this.table.length) {
				int hash = this.getHash(element, probe);

				if (this.table[hash] == null) {
					break;
				}

				if (this.table[hash].equals(element)) {
					result = hash;
					break;
				}
				probe++;
			}

		}
		return result;
	}

	private int getHash(T element, int probe) {
		return ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, probe);
	}
}

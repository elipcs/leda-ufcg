package adt.hashtable.hashfunction;

public class HashFunctionLinearProbing<T> implements HashFunctionOpenAddress<T> {

	protected HashFunctionClosedAddress<T> originalHashFunction;
	private int tableSize;

	public HashFunctionLinearProbing(int tableSize,
			HashFunctionClosedAddressMethod method) {
		this.tableSize = tableSize;
		if (method == HashFunctionClosedAddressMethod.DIVISION) {
			originalHashFunction = new HashFunctionDivisionMethod<T>(
					tableSize);
		} else {
			originalHashFunction = new HashFunctionMultiplicationMethod<T>(
					tableSize);
		}
	}

	/**
	 * The hash function considering open address with linear probing. It uses
	 * the hashCode method inherited from Object.
	 */
	@Override
	public int hash(T element, int probe) {
		int generatedIndex = 0;

		generatedIndex = ((originalHashFunction.hash(element) + probe) % this.tableSize);

		return generatedIndex;
	}
}

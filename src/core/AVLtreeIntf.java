package core;

public interface AVLtreeIntf <T extends Object>{
	public Object Search(int key);
	public void Insert(int key, T value);
	public void Delete(int key);
	public void printInOrder();
}

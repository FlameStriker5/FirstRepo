package core;
/*
 * Generic AVL Tree node (value)
 */
public class AVLTnode <T extends Object> {
	int key;
	T value;
	AVLTnode<?> LeftChild;
	AVLTnode<?> RightChild;
	
	@SuppressWarnings("unchecked")
	public AVLTnode(int key,Object value) {
		this.key = key;
		this.value = (T) value;
	}
	@Override
	public String toString() {
		return ""+value+"";
	}
}

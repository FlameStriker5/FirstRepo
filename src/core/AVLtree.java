package core;

public class AVLtree implements AVLtreeIntf<Object> {
	public AVLTnode<?> root;

	@Override
	public Object Search(int key) {
		AVLTnode<?> trav = root;
		
		   if(trav==null)
			   return null;
		
		   else if(trav.key==key)
			   return (AVLTnode<?>) trav.value;
		
		   else {
			   while(trav!=null) {
				
				   if(trav.key==key)
					   return (AVLTnode<?>) trav.value;
				   if(key<trav.key)
				       trav = trav.LeftChild;
				   else if(key>trav.key)
					   trav = trav.RightChild;
				}
			   return false;	
	       }
	}

	@Override
	public void Insert(int key,Object value) {
		AVLTnode<?> newnode = new AVLTnode<Object>(key,value);
		AVLTnode<?> trav = root;
		AVLTnode<?> prev = null;
		
		if(root==null) {
			root = newnode;
			return;
	    }
		
		while(trav!=null) {
			prev = trav;
			if(key<trav.key)
				trav = trav.LeftChild;
			else if(key>trav.key)
				trav = trav.RightChild;
		}
		if(key<prev.key)
			prev.LeftChild = newnode;
		else if(key>prev.key)
			prev.RightChild = newnode;
		//root = rebalance(root);
	}

	@Override
	public void Delete(int element) {
		AVLTnode<?> trav =root;
		AVLTnode<?> prev = null;
		
		if(root==null)
			return;
		
		else if(root.key==element) {
			if(root.LeftChild==null && root.RightChild==null) {
				root = null;
				return;
			}
			else if(root.LeftChild==null) {
				root = root.RightChild;
				return;
			}
			else if(root.RightChild==null) {
				root = root.LeftChild;
				return;
			}
			else if(root.LeftChild!=null && root.RightChild!=null) {
				trav = root.RightChild;
				prev = root;
				while(trav!=null) {
					if(trav.LeftChild==null)
						break;
					prev = trav;
					trav = trav.LeftChild;
				}
				if(trav.RightChild==null) {
					root.key = trav.key;
					prev.LeftChild = null;
					return;
				}
				else if(trav.RightChild!=null) {
					root.key = trav.key;
					prev.LeftChild = trav.RightChild;
					return;
				}	
			}
		}
		else if(root.key!=element) {
			prev = trav;
			while(trav!=null) {
				if(trav.key==element)
					break;
				prev = trav;
				if(element<trav.key)
					trav = trav.LeftChild;
				else if(element>trav.key)
					trav = trav.RightChild;		
			}
			if(trav==null)
				return;
			if(trav.key<prev.key) {
				if(trav.LeftChild==null && trav.RightChild==null) {
					prev.LeftChild = null;
					return;
				}
				else if(trav.LeftChild!=null || trav.RightChild!=null) {
					if(trav.LeftChild!=null && trav.RightChild==null) {
						prev.LeftChild = trav.LeftChild;
						return;
					}
					else if(trav.LeftChild==null && trav.RightChild!=null) {
						prev.LeftChild = trav.RightChild;
						return;
					}
					else if(trav.LeftChild!=null && trav.RightChild!=null) {
						trav.RightChild = trav.LeftChild.RightChild;
						prev.LeftChild = trav.LeftChild;
						return;
					}
					else if(trav.LeftChild.LeftChild!=null || trav.LeftChild.RightChild!=null || trav.RightChild.LeftChild!=null || trav.RightChild.RightChild!=null) {
						AVLTnode<?> curr = trav;
						prev = trav;
						if(curr.RightChild==null) {
							trav = prev.LeftChild;
							while(trav!=null) {
								if(trav.RightChild==null)
									break;
								prev = trav;
								trav = trav.RightChild;
							}
						}
						else {
						   trav = prev.RightChild;
						   while(trav!=null) {
						       if(trav.LeftChild==null)
							   	   break;
							   prev = trav;
							   trav = trav.LeftChild;
						   }
						}
						curr.key = trav.key;
						prev.LeftChild = null;
						return;
					}
				}
			}
			else if(trav.key>prev.key) {
				if(trav.LeftChild==null && trav.RightChild==null) {
					prev.RightChild = null;
					return;
				}
				else if(trav.LeftChild!=null || trav.RightChild!=null) {
					if(trav.LeftChild!=null && trav.RightChild==null) {
						prev.RightChild = trav.LeftChild;
						return;
					}
					else if(trav.LeftChild==null && trav.RightChild!=null) {
						prev.RightChild = trav.RightChild;
						return;
					}
					else if(trav.LeftChild!=null && trav.RightChild!=null) {
						trav.RightChild.LeftChild = trav.LeftChild;
						prev.RightChild = trav.RightChild;
						return;
					}
					else if(trav.LeftChild.LeftChild!=null || trav.LeftChild.RightChild!=null || trav.RightChild.LeftChild!=null || trav.RightChild.RightChild!=null) {
						AVLTnode<?> curr = trav;
						prev = trav;
						if(curr.RightChild==null) {
							trav = prev.LeftChild;
							while(trav!=null) {
								if(trav.RightChild==null)
									break;
								prev = trav;
								trav = trav.RightChild;
							}
						}
						else {
						   trav = prev.RightChild;
						   while(trav!=null) {
							   if(trav.LeftChild==null)
							   	break;
							   prev = trav;
							   trav = trav.LeftChild;
						   }
						}
						curr.key = trav.key;
						prev.LeftChild = null;
						return;
					}
				}
			}
		}
	}
	
	private void printIn(AVLTnode<?> root) {
		if(root==null)
			return;
		printIn(root.LeftChild);
		System.out.println(root.toString());
		printIn(root.RightChild);	
	}
	
	@Override
	public void printInOrder() {
		printIn(this.root);
	}
	
	private static AVLTnode<?> rebalance(AVLTnode<?> node){
		if(node==null)
			return null;
		if(node.LeftChild==null && node.RightChild==null) {
			return node;
			}
		if(node.LeftChild!=null)
			node.LeftChild = rebalance(node.LeftChild);
		if(node.RightChild!=null)
			node.RightChild = rebalance(node.RightChild);
		
		if(balanceFactor(node)<-1) {
			if(balanceFactor(node.LeftChild)<=-1) {
				node = rotateRight(node);
			}
			else if(balanceFactor(node.LeftChild)>=1) {
				node.LeftChild = rotateLeft(node.LeftChild);
				node = rotateRight(node);
			}
		}
		else if(balanceFactor(node)>1) {
			if(balanceFactor(node.RightChild)>=1) {
				node = rotateLeft(node);
			}
			else if(balanceFactor(node.RightChild)<=-1) {
				node.RightChild = rotateLeft(node.RightChild);
				node = rotateLeft(node);
			}
		}
		return node;
	}
	
	public static int balanceFactor(AVLTnode<?> node) {
		int hl=0;
		int hr=0;
		if(node.LeftChild!=null)
			hl = 1 + height(node.LeftChild);
		if(node.RightChild!=null)
			hr = 1 + height(node.RightChild);
		return hr-hl;
	}
	
	public static int height(AVLTnode<?> node) {
		
	   if(node.RightChild==null && node.LeftChild==null)
		   return 0;
	    
	    AVLTnode<?> leftside = node;
	    AVLTnode<?> rightside = node;
	    
	    if(leftside.LeftChild==null)
	        leftside = leftside.RightChild;
	    else
	       leftside = leftside.LeftChild;
	    
	    if(rightside.RightChild==null)
	        rightside = rightside.LeftChild;
	    else
	       rightside = rightside.RightChild;
	    
	    return height(leftside)<height(rightside)?height(rightside)+1:height(leftside)+1;
    }	
	
	private static AVLTnode<?> rotateRight(AVLTnode<?> node) {
		AVLTnode<?> tempnode = node.LeftChild;
		AVLTnode<?> r = tempnode.RightChild;
		
		if(r==null) {
		   tempnode.RightChild = node;
		   return tempnode;
		}
		tempnode.RightChild = node;
		node.LeftChild = r;
		return tempnode;
	}
	
	private static AVLTnode<?> rotateLeft(AVLTnode<?> node) {
		AVLTnode<?> tempnode = node.RightChild;
		AVLTnode<?> l = tempnode.LeftChild;
		
		if(l==null) {
			tempnode.LeftChild = node;
			return tempnode;
		}
		tempnode.LeftChild = node;
		node.RightChild = l;
		return tempnode;
	}
}

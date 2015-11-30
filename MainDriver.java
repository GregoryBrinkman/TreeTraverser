
public class MainDriver {

	public static void main (String [] args) {
	
		int [] myTree = new int[255];
		for(int x = 1; x-1<myTree.length; x++)
			myTree[x-1] = x;//Create a binary tree with 255 entries, starting at 1
		TreeTraverser traverser = new TreeTraverser();
		traverser.prettyPrint(myTree);
		System.out.println("\n");
		traverser.traverse(myTree);
	}
}

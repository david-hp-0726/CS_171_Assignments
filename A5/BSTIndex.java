/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
David Chen
*/
import java.util.ArrayList;

public class BSTIndex {

		private class Node {
			private String key;
			private MovieInfo data;
			private Node left, right;

			public Node(MovieInfo info) {
				data = info;
				key = data.shortTitle;
			}
		}

		// instance variables maintaining references to
		// the root node and the size of the tree
		private Node root;
		private int size;


		public BSTIndex() {
			root = null;
			size = 0;
		}

		// --------- [DO NOT MODIFY] public BST methods  --------- //
		/* Important: Notice that each public method here calls another private method while passing it a reference to the tree root. This is a common way of structuring BST functions such that external client code will not have direct access to the tree root. You will be implementing the code in the private methods, not the public ones. */

		/* Calculate and return the height of the current tree. */
		public int calcHeight(){
			return calcNodeHeight(this.root);
		}

		/* Insert the given data element into the proper place in the BST structure. */
		public void insertMovie(MovieInfo data) {
			size++;
			root = insertMovie(data, this.root);
		}

		/* Find and return the data element (i.e. the MovieInfo object)
		of the node where the movie's shortTitle matches the given key.
		Return null if the movie is not found. */
		public MovieInfo findMovie(String key) {
			return findMovie(this.root, key);
		}

		/* Traverse the tree in order based on the keys. The ArrayList
		returned should contain movie IDs based on the order of
		the keys (i.e., shortTitle) in the tree. */
		public ArrayList<Integer> inorderTraversal() {
			ArrayList<Integer> movieList = new ArrayList<Integer>();
			inorderTraversal(this.root, movieList);
			return movieList;
		}

		/* Get all movies (full title) in the database whose shortTitle begins with
		the passed prefix string. If no movies match the given prefix, the
		ArrayList should be empty. The order of the movies in the list does not matter,
		but make sure each movie is a separate element in the list. */
		public ArrayList<String> getMoviesPrefix(String prefix) {
			ArrayList<String> movieList = new ArrayList<String>();
			getMoviesPrefix(this.root, prefix, movieList);
			return movieList;
		}

		public int getSize() {
			return size;
		}


		// ----------------- (end of public methods) ------------------ //


		// ------------- private BST methods --------------- //
		private int calcNodeHeight(Node node) {
			if (node == null) {
				return 0;
			}

			// if the current node is not null, the tree must be at least 1-level tall
			int height = 1;

			// recursively find the height of left and right subtrees
			int leftHeight = calcNodeHeight(node.left);
			int rightHeight = calcNodeHeight(node.right);

			// take the height of the tallest of the two subtrees
			height += Math.max(leftHeight, rightHeight);

			return height;
		}

		private Node insertMovie(MovieInfo data, Node node) {
			// if we reach an empty node, insert the new node there
			if (node == null) {
				return new Node(data);
			}

			// if the title already exists, stop the insertion
			if (node.key.equals(data.shortTitle)) {
				return node;
			}

			// if the title is smaller than current node's key, go down the left subtree
			if (data.shortTitle.compareTo(node.key) < 0) {
				node.left = insertMovie(data, node.left);
			}
			else { // otherwise go down the right subtree
				node.right = insertMovie(data, node.right);
			}

			return node;
		}

		private MovieInfo findMovie(Node node, String key) {
			// if movie was not found, return null
			if (node == null) {
				return null;
			}

			// if key is smaller than current node's key, search the left subtree for a larger node
			if (key.compareTo(node.key) < 0) {
				return findMovie(node.left, key);
			}

			// if key is greater than current node's key, search the right subtree for a larger node
			if (key.compareTo(node.key) > 0) {
				return findMovie(node.right, key);
			}

			// else we know we've found the matching key
			return node.data;
		}

		private void getMoviesPrefix(Node node, String prefix, ArrayList<String> movieList) {
			// if no matching prefix was found, stop the recursion
			if (node == null) {
				return;
			}

			// the first time we see the star we need to remove it 
			if (prefix.indexOf("*") > 0) {
				int starIndex = prefix.indexOf("*");
				prefix = prefix.substring(0, starIndex);
			}

			// Now there are two scenarios depending on the relative lengths of prefix and the current key:
			int prefixLen = prefix.length(), keyLen = node.key.length();

			if (prefixLen > keyLen) {
				// 1. If current node's key is shorter than the prefix, take the prefix's prefix for comparison
				String prefixPrefix = prefix.substring(0, keyLen);

				// Then there are two scenarios:
				if (prefixPrefix.compareTo(node.key) > 0) {
					// a. If the prefix's prefix is larger, we need a larger and longer 
					// key, which can only be possibly found in the right subtree
					getMoviesPrefix(node.right, prefix, movieList);
				}
				else {
					// b. If the prefix's prefix is smaller, we need a smaller and longer 
					// key, which can only be possibly found in the left subtree
					getMoviesPrefix(node.left, prefix, movieList);
				}
			} 
			else {
				// 2. If current node's key is equal or greater in length, it can possibly be a match
				String keyPrefix = node.key.substring(0, prefixLen);

				// Then there are three scenarios:
				if (prefix.compareTo(keyPrefix) > 0) {
					// a. If the prefix is larger, search for a larger node
					getMoviesPrefix(node.right, prefix, movieList);
				}
				else if (prefix.compareTo(keyPrefix) < 0) {
					// b. If the prefix is smaller, search for a smaller node
					getMoviesPrefix(node.left, prefix, movieList);
				}
				else {
					// c. If the current key matches the prefix, add its title to the list
					movieList.add(node.data.fullTitle);

					// Now, both children can also be a match, for example
					// prefix = "abc"
					//       abcd
					//		/    \
					//    abcc   abce
					// thus, we examine both children
					getMoviesPrefix(node.left, prefix, movieList);
					getMoviesPrefix(node.right, prefix, movieList);
				}

			}

		}

		private void inorderTraversal(Node node, ArrayList<Integer> movieList) {
			// if the base case is reached, return
			if (node == null) {
				return;
			}

			// examine the nodes in the following order: left -> root -> right
			inorderTraversal(node.left, movieList);

			movieList.add(node.data.ID);

			inorderTraversal(node.right, movieList);
		}

		public ArrayList<String> printInorder() {
			ArrayList<String> movieList = new ArrayList<>();
			printInorder(root, movieList);
			return movieList;
		}

		private void printInorder(Node node, ArrayList<String> movieList) {
			if (node == null) {
				return;
			}

			printInorder(node.left, movieList);
			movieList.add(node.data.fullTitle);
			printInorder(node.right, movieList);
		}
}

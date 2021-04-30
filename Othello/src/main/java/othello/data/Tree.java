package othello.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * A generic Tree of type T
 *
 * @param <T>
 * @author Aleix Velasco Calvo
 */
public class Tree<T> {

    // Attributes
    private T root;
    private ArrayList<Tree<T>> leafs = new ArrayList<Tree<T>>(); //All leaves in the tree
    private Tree<T> parent = null; //Parent of a tree
    private HashMap<T, Tree<T>> locate = new HashMap<T, Tree<T>>(); //Hash table used for quickly grabbing nodes.

    // Constructors
    /**
     * Creates a tree with a root node
     * @param root 
     */
    public Tree(T root) {
        this.root = root;
        locate.put(root, this);
    }

    // Getters and Setters
   /**
    * Inserts a leaf node on a given tree
    * @param root
    * @param leaf 
    */
     public void addLeaf(T root, T leaf) {
        if (locate.containsKey(root)) {
            locate.get(root).addLeaf(leaf);
        } else {
            addLeaf(root).addLeaf(leaf);
        }
    }

    /**
     * Creates a leaf node
     * @param leaf
     * @return Tree
     */
    public Tree<T> addLeaf(T leaf) {
        Tree<T> t = new Tree<T>(leaf);
        leafs.add(t);
        t.parent = this;
        t.locate = this.locate;
        locate.put(leaf, t);
        return t;
    }

    /**
     * Sets the parent of this tree
     * @param parentRoot
     * @return T
     */
    public Tree<T> setAsParent(T parentRoot) {
        Tree<T> t = new Tree<T>(parentRoot);
        t.leafs.add(this);
        this.parent = t;
        t.locate = this.locate;
        t.locate.put(root, this);
        t.locate.put(parentRoot, t);
        return t;
    }

    /**
     * Gets the root of this tree
     * @return T
     */
    public T getRoot() {
        return root;
    }

    /**
     * Returns a node within this tree
     * @param element
     * @return Tree
     */
    public Tree<T> getTree(T element) {
        return locate.get(element);
    }

    /**
     * Gets the parent of this tree
     * @return Tree
     */
    public Tree<T> getParent() {
        return parent;
    }

    /**
     * Get all children of this root
     * @param root
     * @return Collection 
     */
    public Collection<T> getSuccessors(T root) {
        Collection<T> successors = new ArrayList<T>();
        Tree<T> tree = getTree(root);
        if (null != tree) {
            for (Tree<T> leaf : tree.leafs) {
                successors.add(leaf.root);
            }
        }
        return successors;
    }

    /**
     * Returns all subtrees
     * @return Collection tree
     */
    public Collection<Tree<T>> getSubTrees() {
        return leafs;
    }

    /**
     * Returns all subtrees of a given subtree
     * @param <T>
     * @param of
     * @param in
     * @return ArrayList
     */
    public static <T> Collection<T> getSuccessors(T of, Collection<Tree<T>> in) {
        for (Tree<T> tree : in) {
            if (tree.locate.containsKey(of)) {
                return tree.getSuccessors(of);
            }
        }
        return new ArrayList<T>();
    }

    @Override
    public String toString() {
        return printTree(0);
    }

    //Used for pretty printing the tree
    private static final int indent = 2;

    //Pretty prints the tree
    private String printTree(int increment) {
        String s = "";
        String inc = "";
        for (int i = 0; i < increment; ++i) {
            inc = inc + " ";
        }
        s = inc + root;
        for (Tree<T> child : leafs) {
            s += "\n" + child.printTree(increment + indent);
        }
        return s;
    }
}

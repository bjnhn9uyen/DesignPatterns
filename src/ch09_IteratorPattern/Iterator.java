package ch09_IteratorPattern;

// we’re not using the Java built-in Iterator, we build an Iterator from scratch to understand the pattern
public interface Iterator {

	public boolean hasNext();

	public MenuItem next();

}
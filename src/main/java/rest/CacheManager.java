package rest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javassist.NotFoundException;

/**
 * This class implements a {@link LinkedHashMap} to serve as a LRU cache. The oldest entry (which was inserted or
 * accessed) will be removed from the cache if the size exceeds the set capacity.
 * 
 * <p>
 * Note that this implementation is not synchronized. If multiple threads access a linked hash map concurrently, and at
 * least one of the threads modifies the map structurally, it must be synchronized externally. This is typically
 * accomplished by synchronizing on some object that naturally encapsulates the map. If no such object exists, the map
 * should be "wrapped" using the Collections.synchronizedMap method. This is best done at creation time, to prevent
 * accidental unsynchronized access to the map: Map m = Collections.synchronizedMap(new LinkedHashMap(...));
 * 
 * @author Edwin Anto (EA025986)
 *
 * @param <K> Type of Key element
 * @param <V> Type of Value element
 */
public class CacheManager<K, V> extends LinkedHashMap<K, V>
{
	private static final long serialVersionUID = 4967918340310305585L;

	private final int capacity;
	
	/**
	 * This manager would be a singleton 
	 */
	private CacheManager<K, V> cacheManager;

	/**
	 * 
	 * @param capacity
	 * @param loadFactor
	 * @param accessOrder
	 * @return
	 */
	public CacheManager<K, V> createCacheManager(int capacity, float loadFactor, boolean accessOrder)
	{
		if (cacheManager == null)
			cacheManager = new CacheManager<>(capacity, loadFactor, accessOrder);
		
		return cacheManager;
	}
	
	/**
	 * Get the cache manager.
	 * 
	 * @return The cache manager.
	 * @throws NotFoundException 
	 */
	public CacheManager<K, V> getManager() throws NotFoundException
	{
		if (cacheManager == null)
			throw new NotFoundException("The cache manager does not exist. Please create one first");

		return cacheManager;
	}	

	/**
	 * Constructs an empty <tt>CacheManager</tt> instance with the specified initial capacity, load factor and ordering
	 * mode.
	 *
	 * @param initialCapacity the initial capacity
	 * @param loadFactor the load factor
	 * @param accessOrder the ordering mode - <tt>true</tt> for access-order, <tt>false</tt> for insertion-order
	 * 
	 * @throws IllegalArgumentException if the initial capacity is negative or the load factor is non-positive
	 */
	private CacheManager(int capacity, float loadFactor, boolean accessOrder)
	{
		super(capacity, loadFactor, accessOrder);
		this.capacity = capacity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.LinkedHashMap#removeEldestEntry(java.util.Map.Entry)
	 */
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest)
	{
		return size() > this.capacity;
	}

}

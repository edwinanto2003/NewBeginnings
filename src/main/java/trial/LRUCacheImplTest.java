package trial;

import java.util.Map;

import javassist.NotFoundException;

public class LRUCacheImplTest
{

	public void populate()
	{
		CacheManager cachemanager = null;
		try
		{
			cachemanager = CacheManager.createCache(5, 0.75f, true);
		}
		catch (Throwable t)
		{
			System.out.println(t.getStackTrace());
		}


		cachemanager.insert("edwin", "found Edwin");
		cachemanager.insert(1, "23");

		cachemanager.insert(2, "Object2");
		cachemanager.insert(3, "Object3");
		cachemanager.insert(4, "Object4");
	//	System.out.println(cachemanager);
		cachemanager.insert(5, "Object5");

		cachemanager.insert(6, "Object6");
	//	System.out.println(cachemanager);

		cachemanager.insert(7, "Object7");
		cachemanager.insert(8, "Object8");

		cachemanager.retrieve(1);
		cachemanager.retrieve(3);
		cachemanager.retrieve(4);

	//	System.out.println(cachemanager);
	}

	public void get()
	{
		CacheManager cachemanager = null;
		try
		{
			cachemanager = CacheManager.getCache();
		}
		catch (NotFoundException e)
		{

		}
		for (Object o : cachemanager.keySet())
		{
			System.out.println(cachemanager.retrieve(o));
		}
	}

	private class MyT extends Thread
	{

		public MyT(String string)
		{
			super(string);
		}

		@Override
		public void run()
		{
			LRUCacheImplTest ltest = new LRUCacheImplTest();

			ltest.populate();
			ltest.get();
		}
	}

	int count = 0;

	public void createThreads()
	{

		MyT t = new LRUCacheImplTest.MyT(count++ + "");
		t.start();
	}

	public static void main(String arg[])
	{
		LRUCacheImplTest ltest = new LRUCacheImplTest();
		for (int i = 0; i < 5; i++)
		{
			ltest.createThreads();
		}

		// CacheManager<Integer, String> lruCache = new CacheManager<Integer, String>(4, 0.75f);
		//
		// CacheManager lrucache = CacheManager
		//
		// CacheManager<Double, Double> lruCache1 = new CacheManager<Double, Double>(4, 0.75f);
		//
		// lruCache.put(1, "Object1");
		// lruCache.put(2, "Object2");
		// lruCache.put(3, "Object3");
		// lruCache.get(1);
		// lruCache.put(4, "Object4");
		// System.out.println(lruCache);
		// lruCache.put(5, "Object5");
		// lruCache.get(3);
		// lruCache.put(6, "Object6");
		// System.out.println(lruCache);
		// lruCache.get(4);
		// lruCache.put(7, "Object7");
		// lruCache.put(8, "Object8");
		// System.out.println(lruCache);
	}
}

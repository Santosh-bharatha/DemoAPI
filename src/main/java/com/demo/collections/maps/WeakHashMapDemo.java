package com.demo.collections.maps;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {

	public static void main(String[] args) {
		
		Map hm = new HashMap();
		Map weakHm = new WeakHashMap();
		
		String hashMap_key = new String("HashMapKey");
		String weakHashMap_key = new String("WeakHashMapKey");
		
		hm.put(hashMap_key, "Arnold");
		weakHm.put(weakHashMap_key, "Sylvester");
		
		System.gc();
		
		System.out.println("Before GC colleced stuff hashmap value is: "+ hm.get("HashMapKey") + " Before GC colleced stuff WeakHashmap value is:"+weakHm.get("WeakHashMapKey"));

		hashMap_key = null;
		weakHashMap_key = null;
		
		System.gc();
		System.out.println("After GC colleced stuff hashmap value is: "+ hm.get("HashMapKey") + " After GC colleced stuff WeakHashmap value is:"+weakHm.get("WeakHashMapKey"));

	}

}

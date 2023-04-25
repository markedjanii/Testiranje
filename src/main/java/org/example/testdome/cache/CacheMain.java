package org.example.testdome.cache;

public class CacheMain
{

    public static void main(String[] args) {

        OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
        Cache cache = (Cache) optimizedDiskCache;
        DiskCache diskCache = (DiskCache) cache;

        System.out.println(true);
    }
}

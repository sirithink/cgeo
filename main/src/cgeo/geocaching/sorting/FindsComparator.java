package cgeo.geocaching.sorting;

import cgeo.geocaching.Geocache;

public class FindsComparator extends AbstractCacheComparator {

    @Override
    protected boolean canCompare(Geocache cache1, Geocache cache2) {
        return cache1.getLogCounts() != null && cache2.getLogCounts() != null;
    }

    @Override
    protected int compareCaches(Geocache cache1, Geocache cache2) {
        int finds1 = cache1.getFindsCount();
        int finds2 = cache2.getFindsCount();
        return finds2 - finds1;
    }

}

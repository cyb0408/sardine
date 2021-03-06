package sardine.asset;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author bruce-sha
 *   2015/6/19
 */
class SimpleLRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int maxEntries;

    public SimpleLRUCache(final int maxEntries) {
        super(maxEntries + 1, 1.0f, true);
        this.maxEntries = maxEntries;
    }

    /**
     * Returns <tt>true</tt> if this <code>SimpleLRUCache</code> has more entries than the maximum specified when it was
     * created.
     * <p/>
     * <p>
     * This method <em>does not</em> modify the underlying <code>Map</code>; it relies on the implementation of
     * <code>LinkedHashMap</code> to do that, but that behavior is documented in the JavaDoc for
     * <code>LinkedHashMap</code>.
     * </p>
     *
     *   eldest the <code>Entry</code> in question; this implementation doesn't care what it is, since the
     *               implementation is only dependent on the size of the cache
     * @return <tt>true</tt> if the oldest
     * @see java.util.LinkedHashMap#removeEldestEntry(Map.Entry)
     */
    @Override
    protected boolean removeEldestEntry(final Map.Entry<K, V> eldest) {
        return super.size() > maxEntries;
    }
}
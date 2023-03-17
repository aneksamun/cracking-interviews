### <ins>Expirable Map</ins>

Expireable map is a map that has a TTL (time to live) for each key. When the TTL expires, the key is removed from the map.

In the [Haskell solution](ExpireableMap.hs) the expired items gets removed once inserting a new item and get only returns an item that is still not expired.


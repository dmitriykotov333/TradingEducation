package com.kotdev.trading.trading.data

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.concurrent.ConcurrentHashMap

class ConcurrentHash<K, V> {

    private val map = ConcurrentHashMap<K, V>()
    private val mutex = Mutex()

    fun put(key: K, value: V) {
        map[key] = value
    }


    fun get(key: K): V? {
        return  map[key]
    }

    suspend fun findKeyByValue(value: V): K? {
        return mutex.withLock {
            map.entries.find { it.value == value }?.key
        }
    }

    fun remove(key: K): V? {
        return map.remove(key)
    }

    fun change(key: K, value: V): V? {
        return if (map.containsKey(key)) {
            map[key] = value
            value
        } else {
            null
        }
    }

    suspend fun size(): Int {
        return mutex.withLock {
            map.size
        }
    }

    fun getMap(): Map<K, V> {
        return map.toMap()
    }

    suspend fun clear() {
        mutex.withLock {
            map.clear()
        }
    }
}
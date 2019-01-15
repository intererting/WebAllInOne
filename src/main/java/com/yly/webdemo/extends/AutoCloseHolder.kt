package com.yly.webdemo.extends

class ResourceHolder : AutoCloseable {
    private val resources = arrayListOf<AutoCloseable>()
    fun <T : AutoCloseable> T.autoClose(): T {
        resources.add(this)
        return this
    }

    override fun close() {
        resources.reverse()
        resources.forEach { it.close() }
    }
}

@Throws(java.lang.Exception::class)
fun <R> tryWithResource(block: ResourceHolder.() -> R): R? {
    val holder = ResourceHolder()
    try {
        return holder.block()
    } catch (e: Exception) {
        e.printStackTrace()
        throw e
    } finally {
        holder.close()
    }
}
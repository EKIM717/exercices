package com.windframework.shiro.demo.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class JedisUtil {

	public static JedisPool jedisPool = null;

//	private static PropertiesFileParser propParser = new PropertiesFileParser();

	private static int dbIndex = 0;
	
	private static String hostname;
	private static String port;
	private static String password;
	private static String timeout;
	private static String maxIdle;
	private static String maxTotal;
	private static String maxWaitMillis;
	private static String testOnBorrow;
	

	private static void init() {
		JedisPoolConfig config = new JedisPoolConfig();
		// 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取
		try {
			// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)
			if (!StrUtil.isEmpty(maxTotal))
				config.setMaxTotal(Integer.parseInt(maxTotal));
			// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例
			if (!StrUtil.isEmpty(maxIdle))
				config.setMaxIdle(Integer.parseInt(maxIdle));
			// 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException
			if (!StrUtil.isEmpty(maxWaitMillis))
				config.setMaxWaitMillis(Long.parseLong(maxWaitMillis));
			// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的
			if (!StrUtil.isEmpty(testOnBorrow))
				config.setTestOnBorrow(Boolean.valueOf(testOnBorrow));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!StrUtil.isEmpty(password)) {
			jedisPool = new JedisPool(config, hostname, Integer.parseInt(port), Integer.parseInt(timeout), password);
		} else {
			jedisPool = new JedisPool(config, hostname);
		}
	}
	
	/**
	 * 获得模块所需的库号,进行切换
	 * (因为每次调用都会刷新置为0的库,导致效率降低,未有解决方案前暂不使用)
	 * 
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unused")
	private synchronized static int getDbIndex(Jedis jedis, String key) {
		String[] names = key.split("\\.");
		RedisDBType type = RedisDBType.fromName(names[0]);
		if (null != type && RedisDBType.NULL != type) {
			int index = type.getIndex();
			if (index != dbIndex) {
				//如果使用的库不同,需要进行切换,加上线程控制
				dbIndex = index;
				jedis.select(dbIndex);
			}
		}
		return dbIndex;
	}

	/**
	 * 获取指定key的值,如果key不存在返回null，如果该Key存储的不是字符串，会抛出一个错误
	 *
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		Jedis jedis = getJedis();
		String ret = null;
		try {
//			getDbIndex(jedis, key);
			ret = jedis.get(key);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 设置key的值为value
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public static String set(String key, String value) {
		Jedis jedis = getJedis();
		String ret = null;
		try {
//			getDbIndex(jedis, key);
			ret = jedis.set(key, value);
		} finally {
			close(jedis);
		}
		return ret;
	}
	
	/**
	 * 删除指定的key,也可以传入一个包含key的数组
	 *
	 * @param keys
	 * @return
	 */
	public static Long del(String... keys) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.del(keys);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 删除一类型的keys(*表达)
	 * @param keys
	 * @return
	 */
	public static Long delKeys(String keys) {
		Set<String> keySet = keys(keys);
		if (null != keySet && keySet.size() > 0) {
			String[] keyStrs = (String[]) keySet.toArray(new String[keySet.size()]);
//			Jedis jedis = getJedis();
//			getDbIndex(jedis, keys);
			return del(keyStrs);
		} else {
			return 0L;
		}
	}

	/**
	 * 通过key向指定的value值追加值
	 *
	 * @param key
	 * @param str
	 * @return
	 */
	public static Long append(String key, String str) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.append(key, str);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 判断key是否存在
	 *
	 * @param key
	 * @return
	 */
	public static Boolean exists(String key) {
		Jedis jedis = getJedis();
		Boolean ret = null;
		try {
//			getDbIndex(jedis, key);
			ret = jedis.exists(key);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 设置key value,如果key已经存在则返回0
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public static Long setnx(String key, String value) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
//			getDbIndex(jedis, key);
			ret = jedis.setnx(key, value);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 设置key value并指定这个键值的有效期
	 *
	 * @param key
	 * @param seconds
	 * @param value
	 * @return
	 */
	public static String setex(String key, int seconds, String value) {
		Jedis jedis = getJedis();
		String ret = null;
		try {
			ret = jedis.setex(key, seconds, value);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key 和offset 从指定的位置开始将原先value替换
	 *
	 * @param key
	 * @param offset
	 * @param str
	 * @return
	 */
	public static Long setrange(String key, int offset, String str) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.setrange(key, offset, str);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过批量的key获取批量的value
	 *
	 * @param keys
	 * @return
	 */
	public static List<String> mget(String... keys) {
		Jedis jedis = getJedis();
		List<String> ret = null;
		try{
			ret = jedis.mget(keys);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 批量的设置key:value,也可以一个
	 *
	 * @param keysValues
	 * @return
	 */
	public static String mset(String... keysValues) {
		Jedis jedis = getJedis();
		String ret = null;
		try {
			ret = jedis.mset(keysValues);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 批量的设置key:value,可以一个,如果key已经存在则会失败,操作会回滚
	 *
	 * @param keysValues
	 * @return
	 */
	public static Long msetnx(String... keysValues) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.msetnx(keysValues);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 设置key的值,并返回一个旧值
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public static String getSet(String key, String value) {
		Jedis jedis = getJedis();
		String ret = null;
		try {
			ret = jedis.getSet(key, value);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过下标 和key 获取指定下标位置的 value
	 *
	 * @param key
	 * @param startOffset
	 * @param endOffset
	 * @return
	 */
	public static String getrange(String key, int startOffset, int endOffset) {
		Jedis jedis = getJedis();
		String ret = null;
		try {
			ret = jedis.getrange(key, startOffset, endOffset);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key 对value进行加值+1操作,当value不是int类型时会返回错误,当key不存在是则value为1
	 *
	 * @param key
	 * @return
	 */
	public static Long incr(String key) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.incr(key);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key给指定的value加值,如果key不存在,则这是value为该值
	 *
	 * @param key
	 * @param integer
	 * @return
	 */
	public static Long incrBy(String key, long integer) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.incrBy(key, integer);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 对key的值做减减操作,如果key不存在,则设置key为-1
	 *
	 * @param key
	 * @return
	 */
	public static Long decr(String key) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.decr(key);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 减去指定的值
	 *
	 * @param key
	 * @param integer
	 * @return
	 */
	public static Long decrBy(String key, long integer) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.decrBy(key, integer);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key获取value值的长度
	 *
	 * @param key
	 * @return
	 */
	public static Long strLen(String key) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.strlen(key);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key给field设置指定的值,如果key不存在则先创建,如果field已经存在,返回0
	 *
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 */
	public static Long hsetnx(String key, String field, String value) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.hsetnx(key, field, value);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key给field设置指定的值,如果key不存在,则先创建
	 *
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 */
	public static Long hset(String key, String field, String value) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.hset(key, field, value);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key同时设置 hash的多个field
	 *
	 * @param key
	 * @param hash
	 * @return
	 */
	public static String hmset(String key, Map<String, String> hash) {
		Jedis jedis = getJedis();
		String ret = null;
		try {
			ret = jedis.hmset(key, hash);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key 和 field 获取指定的 value
	 *
	 * @param key
	 * @param failed
	 * @return
	 */
	public static String hget(String key, String failed) {
		Jedis jedis = getJedis();
		String ret = null;
		try {
			ret = jedis.hget(key, failed);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 设置key的超时时间为seconds
	 *
	 * @param key
	 * @param seconds
	 * @return
	 */
	public static Long expire(String key, int seconds) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.expire(key, seconds);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key 和 fields 获取指定的value 如果没有对应的value则返回null
	 *
	 * @param key
	 * @param fields 可以是 一个String 也可以是 String数组
	 * @return
	 */
	public static List<String> hmget(String key, String... fields) {
		Jedis jedis = getJedis();
		List<String> ret = null;
		try {
			ret = jedis.hmget(key, fields);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key给指定的field的value加上给定的值
	 *
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 */
	public static Long hincrby(String key, String field, Long value) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.hincrBy(key, field, value);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key和field判断是否有指定的value存在
	 *
	 * @param key
	 * @param field
	 * @return
	 */
	public static Boolean hexists(String key, String field) {
		Jedis jedis = getJedis();
		Boolean ret = null;
		try {
			ret = jedis.hexists(key, field);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key返回field的数量
	 *
	 * @param key
	 * @return
	 */
	public static Long hlen(String key) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.hlen(key);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key 删除指定的 field
	 *
	 * @param key
	 * @param fields 可以是 一个 field 也可以是 一个数组
	 * @return
	 */
	public static Long hdel(String key, String... fields) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.hdel(key, fields);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key返回所有的field
	 *
	 * @param key
	 * @return
	 */
	public static Set<String> hkeys(String key) {
		Jedis jedis = getJedis();
		Set<String> ret = null;
		try {
			ret = jedis.hkeys(key);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key返回所有和key有关的value
	 *
	 * @param key
	 * @return
	 */
	public static List<String> hvals(String key) {
		Jedis jedis = getJedis();
		List<String> ret = null;
		try {
			ret = jedis.hvals(key);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key获取所有的field和value
	 *
	 * @param key
	 * @return
	 */
	public static Map<String, String> hgetall(String key) {
		Jedis jedis = getJedis();
		Map<String, String> ret = null;
		try {
			ret = jedis.hgetAll(key);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key向list头部添加字符串
	 *
	 * @param key
	 * @param strs 可以是一个string 也可以是string数组
	 * @return 返回list的value个数
	 */
	public static Long lpush(String key, String... strs) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.lpush(key, strs);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key向list尾部添加字符串
	 *
	 * @param key
	 * @param strs 可以是一个string 也可以是string数组
	 * @return 返回list的value个数
	 */
	public static Long rpush(String key, String... strs) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.rpush(key, strs);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key设置list指定下标位置的value 如果下标超过list里面value的个数则报错
	 *
	 * @param key
	 * @param index 从0开始
	 * @param value
	 * @return 成功返回OK
	 */
	public static String lset(String key, Long index, String value) {
		Jedis jedis = getJedis();
		String ret = null;
		try {
			ret = jedis.lset(key, index, value);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key从对应的list中删除指定的count个 和 value相同的元素
	 *
	 * @param key
	 * @param count 当count为0时删除全部
	 * @param value
	 * @return 返回被删除的个数
	 */
	public static Long lrem(String key, long count, String value) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.lrem(key, count, value);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key保留list中从strat下标开始到end下标结束的value值
	 *
	 * @param key
	 * @param start
	 * @param end
	 * @return 成功返回OK
	 */
	public static String ltrim(String key, long start, long end) {
		Jedis jedis = getJedis();
		String ret = null;
		try {
			ret = jedis.ltrim(key, start, end);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key从list的头部删除一个value,并返回该value
	 *
	 * @param key
	 * @return
	 */
	public static synchronized String lpop(String key) {
		Jedis jedis = getJedis();
		String ret = null;
		try {
			ret = jedis.lpop(key);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key从list尾部删除一个value,并返回该元素
	 *
	 * @param key
	 * @return
	 */
	public static synchronized String rpop(String key) {
		Jedis jedis = getJedis();
		String ret = null;
		try {
			ret = jedis.rpop(key);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key从一个list的尾部删除一个value并添加到另一个list的头部,并返回该value 如果第一个list为空或者不存在则返回null
	 *
	 * @param srckey
	 * @param dstkey
	 * @return
	 */
	public static String rpoplpush(String srckey, String dstkey) {
		Jedis jedis = getJedis();
		String ret = null;
		try {
			ret = jedis.rpoplpush(srckey, dstkey);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key获取list中指定下标位置的value
	 *
	 * @param key
	 * @param index
	 * @return 如果没有返回null
	 */
	public static String lindex(String key, long index) {
		Jedis jedis = getJedis();
		String ret = null;
		try {
			ret = jedis.lindex(key, index);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key返回list的长度
	 *
	 * @param key
	 * @return
	 */
	public static Long llen(String key) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.llen(key);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key获取list指定下标位置的value 如果start 为 0 end 为 -1 则返回全部的list中的value
	 *
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<String> lrange(String key, long start, long end) {
		Jedis jedis = getJedis();
		List<String> ret = null;
		try {
			ret = jedis.lrange(key, start, end);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key向指定的set中添加value
	 *
	 * @param key
	 * @param members 可以是一个String 也可以是一个String数组
	 * @return 添加成功的个数
	 */
	public static Long sadd(String key, String... members) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.sadd(key, members);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key删除set中对应的value值
	 *
	 * @param key
	 * @param members 可以是一个String 也可以是一个String数组
	 * @return 删除的个数
	 */
	public static Long srem(String key, String... members) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.srem(key, members);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key随机删除一个set中的value并返回该值
	 *
	 * @param key
	 * @return
	 */
	public static String spop(String key) {
		Jedis jedis = getJedis();
		String ret = null;
		try {
			ret = jedis.spop(key);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key获取set中的差集 以第一个set为标准
	 *
	 * @param keys 可以 是一个string 则返回set中所有的value 也可以是string数组
	 * @return
	 */
	public static Set<String> sdiff(String... keys) {
		Jedis jedis = getJedis();
		Set<String> ret = null;
		try {
			ret = jedis.sdiff(keys);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key获取set中的差集并存入到另一个key中 以第一个set为标准
	 *
	 * @param dstkey 差集存入的key
	 * @param keys 可以 是一个string 则返回set中所有的value 也可以是string数组
	 * @return
	 */
	public static Long sdiffstore(String dstkey, String... keys) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.sdiffstore(dstkey, keys);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key获取指定set中的交集
	 *
	 * @param keys 可以 是一个string 也可以是一个string数组
	 * @return
	 */
	public static Set<String> sinter(String... keys) {
		Jedis jedis = getJedis();
		Set<String> ret = null;
		try {
			ret = jedis.sinter(keys);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key获取指定set中的交集 并将结果存入新的set中
	 *
	 * @param dstkey
	 * @param keys 可以 是一个string 也可以是一个string数组
	 * @return
	 */
	public static Long sinterstore(String dstkey, String... keys) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.sinterstore(dstkey, keys);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key返回所有set的并集
	 *
	 * @param keys 可以 是一个string 也可以是一个string数组
	 * @return
	 */
	public static Set<String> sunion(String... keys) {
		Jedis jedis = getJedis();
		Set<String> ret = null;
		try {
			ret = jedis.sunion(keys);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key返回所有set的并集,并存入到新的set中
	 *
	 * @param dstkey
	 * @param keys 可以 是一个string 也可以是一个string数组
	 * @return
	 */
	public static Long sunionstore(String dstkey, String... keys) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.sunionstore(dstkey, keys);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key将set中的value移除并添加到第二个set中
	 *
	 * @param srckey 需要移除的
	 * @param dstkey 添加的
	 * @param member set中的value
	 * @return
	 */
	public static Long smove(String srckey, String dstkey, String member) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.smove(srckey, dstkey, member);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key获取set中value的个数
	 *
	 * @param key
	 * @return
	 */
	public static Long scard(String key) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.scard(key);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key判断value是否是set中的元素
	 *
	 * @param key
	 * @param member
	 * @return
	 */
	public static Boolean sismember(String key, String member) {
		Jedis jedis = getJedis();
		Boolean ret = null;
		try {
			ret = jedis.sismember(key, member);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key获取set中随机的value,不删除元素
	 *
	 * @param key
	 * @return
	 */
	public static String srandmember(String key) {
		Jedis jedis = getJedis();
		String ret = null;
		try {
			ret = jedis.srandmember(key);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key获取set中所有的value
	 *
	 * @param key
	 * @return
	 */
	public static Set<String> smembers(String key) {
		Jedis jedis = getJedis();
		Set<String> ret = null;
		try {
			ret = jedis.smembers(key);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key向zset中添加value,score,其中score就是用来排序的 如果该value已经存在则根据score更新元素
	 *
	 * @param key
	 * @param score
	 * @param member
	 * @return
	 */
	public static Long zadd(String key, double score, String member) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.zadd(key, score, member);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key删除在zset中指定的value
	 *
	 * @param key
	 * @param members 可以 是一个string 也可以是一个string数组
	 * @return
	 */
	public static Long zrem(String key, String... members) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.zrem(key, members);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key增加该zset中value的score的值
	 *
	 * @param key
	 * @param score
	 * @param member
	 * @return
	 */
	public static Double zincrby(String key, double score, String member) {
		Jedis jedis = getJedis();
		Double ret = null;
		try {
			ret = jedis.zincrby(key, score, member);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key返回zset中value的排名 下标从小到大排序
	 *
	 * @param key
	 * @param member
	 * @return
	 */
	public static Long zrank(String key, String member) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.zrank(key, member);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key返回zset中value的排名 下标从大到小排序
	 *
	 * @param key
	 * @param member
	 * @return
	 */
	public static Long zrevrank(String key, String member) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.zrevrank(key, member);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key将获取score从start到end中zset的value socre从大到小排序 当start为0 end为-1时返回全部
	 *
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public static Set<String> zrevrange(String key, long start, long end) {
		Jedis jedis = getJedis();
		Set<String> ret = null;
		try {
			ret = jedis.zrevrange(key, start, end);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key返回指定score内zset中的value
	 *
	 * @param key
	 * @param max
	 * @param min
	 * @return
	 */
	public static Set<String> zrangebyscore(String key, String max, String min) {
		Jedis jedis = getJedis();
		Set<String> ret = null;
		try {
			ret = jedis.zrevrangeByScore(key, max, min);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key返回指定score内zset中的value
	 *
	 * @param key
	 * @param max
	 * @param min
	 * @return
	 */
	public static Set<String> zrangeByScore(String key, double max, double min) {
		Jedis jedis = getJedis();
		Set<String> ret = null;
		try {
			ret = jedis.zrevrangeByScore(key, max, min);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 返回指定区间内zset中value的数量
	 *
	 * @param key
	 * @param min
	 * @param max
	 * @return
	 */
	public static Long zcount(String key, String min, String max) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.zcount(key, min, max);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key返回zset中的value个数
	 *
	 * @param key
	 * @return
	 */
	public static Long zcard(String key) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.zcard(key);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key获取zset中value的score值
	 *
	 * @param key
	 * @param member
	 * @return
	 */
	public static Double zscore(String key, String member) {
		Jedis jedis = getJedis();
		Double ret = null;
		try {
			ret = jedis.zscore(key, member);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key删除给定区间内的元素
	 *
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public static Long zremrangeByRank(String key, long start, long end) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.zremrangeByRank(key, start, end);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key删除指定score内的元素
	 *
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public static Long zremrangeByScore(String key, double start, double end) {
		Jedis jedis = getJedis();
		Long ret = null;
		try {
			ret = jedis.zremrangeByScore(key, start, end);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 返回满足pattern表达式的所有key keys(*) 返回所有的key
	 *
	 * @param pattern
	 * @return
	 */
	public static Set<String> keys(String pattern) {
		Jedis jedis = getJedis();
		Set<String> ret = null;
		try {
			ret = jedis.keys(pattern);
		} finally {
			close(jedis);
		}
		return ret;
	}

	/**
	 * 通过key判断值得类型
	 *
	 * @param key
	 * @return
	 */
	public static String type(String key) {
		Jedis jedis = getJedis();
		String ret = null;
		try {
			ret = jedis.type(key);
		} finally {
			close(jedis);
		}
		return ret;
	}

	public static void close(Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}

	public static Jedis getJedis() {
		Jedis jedis = null;
		if (jedisPool == null) {
			init();
		}
		try {
			if (jedis == null) {
				jedis = jedisPool.getResource();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jedis;
	}

//	public static JedisUtil getJedisUtil() {
//		return new JedisUtil();
//	}
	
	@Value("${redis.hostname}")
	public void setHostname(String hostname) {
		JedisUtil.hostname = hostname;
	}
	
	@Value("${redis.port}")
	public void setPort(String port) {
		JedisUtil.port = port;
	}
	
	@Value("${redis.password:#{null}}")
	public void setPassword(String password) {
		JedisUtil.password = password;
	}
	
	@Value("${redis.timeout}")
	public void setTimeout(String timeout) {
		JedisUtil.timeout = timeout;
	}
	
	@Value("${redis.maxIdle}")
	public void setMaxIdle(String maxIdle) {
		JedisUtil.maxIdle = maxIdle;
	}
	
	@Value("${redis.maxTotal}")
	public void setMaxTotal(String maxTotal) {
		JedisUtil.maxTotal = maxTotal;
	}
	
	@Value("${redis.maxWaitMillis}")
	public void setMaxWaitMillis(String maxWaitMillis) {
		JedisUtil.maxWaitMillis = maxWaitMillis;
	}
	
	@Value("${redis.testOnBorrow}")
	public void setTestOnBorrow(String testOnBorrow) {
		JedisUtil.testOnBorrow = testOnBorrow;
	}

}

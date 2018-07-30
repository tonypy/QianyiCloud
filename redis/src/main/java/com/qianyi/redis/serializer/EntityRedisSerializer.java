package com.qianyi.redis.serializer;

import com.qianyi.redis.untils.SerializeUtil;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * 自定义Redis序列化
 * Created by tonypy on 2018-07-30.
 */
public class EntityRedisSerializer implements RedisSerializer<Object> {
    @Override
    public byte[] serialize(Object o) throws SerializationException {
        if (o == null) {
            return new byte[0];
        }
        return SerializeUtil.serialize(o);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        return SerializeUtil.unserialize(bytes);
    }
}

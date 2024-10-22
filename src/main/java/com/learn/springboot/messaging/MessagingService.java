package com.learn.springboot.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MessagingService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void saveValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object getValue(String key) {
        if (Boolean.TRUE.equals(redisTemplate.hasKey(key))) {
            return redisTemplate.opsForValue().get(key);
        }
        return "";
    }

    // TODO: below code is not working
    public Set<String> getKeys(String pattern) {
        ScanOptions options = ScanOptions.scanOptions().match(pattern).count(100).build();
        Set<String> result;
        try (Cursor<String> cursor = redisTemplate.scan(options)) {
            result = new HashSet<>();
            while (cursor.hasNext()) {
                result.add((cursor.next()));
            }
        }
        return result;
    }
}

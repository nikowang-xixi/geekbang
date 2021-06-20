package demo.datasouce.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import demo.datasouce.anno.WriteDateSourceSource;
import demo.datasouce.domain.User;
import demo.datasouce.mapper.UserMapper;
import org.springframework.stereotype.Service;


@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    User findByFirstDD(Long id) {
        return baseMapper.selectById(id);
    }

    @WriteDateSourceSource
    User findBuSecondDD(Long id) {
        return baseMapper.selectById(id);
    }
}

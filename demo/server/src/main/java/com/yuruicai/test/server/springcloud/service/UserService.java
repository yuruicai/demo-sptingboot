package com.yuruicai.test.server.springcloud.service;



import com.yuruicai.test.common.bean.UserDto;
import com.yuruicai.test.server.springcloud.domain.User;

import java.util.List;

/**
 * 2019/4/2
 * Created by 蒋欣洋.
 */

public interface UserService {

    List<User> findUserPage(UserDto userDto);
    User selectUser(User user);
    User selectUserRibbon(User user);

}

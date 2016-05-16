package UserService;

import util.MyBatisSqlSession;
import mapper.UserMapper;
import model.User;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by Administrator on 2016/5/16.
 */
public class UserService {

    private static int createUserViaXML() {
        try (SqlSession sqlSession = MyBatisSqlSession.getSqlSession(true)) {
            return sqlSession.insert("mapper.UserMapper.create",new User(null,"Tester1","password2"));
        }
    }

    private static int createUser() {
        try (SqlSession sqlSession = MyBatisSqlSession.getSqlSession(true)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.create(new User (
                null,"Tester2", "password2")
            );
        }
    }

    public static void main(String[] args) {
        createUserViaXML();
        createUser();

    }
}

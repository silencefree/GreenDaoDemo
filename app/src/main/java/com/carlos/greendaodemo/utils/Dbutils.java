package com.carlos.greendaodemo.utils;

import com.carlos.gen.DaoSession;
import com.carlos.gen.UserDao;
import com.carlos.greendaodemo.entity.User;
import com.carlos.greendaodemo.manager.GreenDaoManager;

import org.greenrobot.greendao.query.Query;

import java.util.List;

/**
 * Created by Carlos on 2017/9/12 0012.
 * Believe yourself always.
 */

public class Dbutils {

    private static DaoSession daoSession = GreenDaoManager.getInstance().getSession();
    private static UserDao userDao = daoSession.getUserDao();

    public static List<User> queryAllUser() {

        return userDao.loadAll();
    }

    public static void insertUser(User user) {
        userDao.insert(user);
    }
    public static void deleteAll() {
        userDao.deleteAll();
    }

    public static List<User> querydataBy(String userName) {////查询条件
        Query<User> nQuery = userDao.queryBuilder()
                .where(UserDao.Properties.Name.eq(userName))//.where(UserDao.Properties.Id.notEq(999))
                .build();
        List<User> users = nQuery.list();
        return users;

//        QueryBuilder qb = userDao.queryBuilder();
//        qb.where(Properties.FirstName.eq("Joe"),
//                qb.or(Properties.YearOfBirth.gt(1970),
//                        qb.and(Properties.YearOfBirth.eq(1970), Properties.MonthOfBirth.ge(10))));
//        List youngJoes = qb.list();
    }

}

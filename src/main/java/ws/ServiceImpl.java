package ws;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class ServiceImpl implements Service {
    UserDao userDao;
    @WebMethod
    public List<User> getUserById(int id) {
        userDao = new UserDaoImpl();
        return userDao.getUserById(id);
    }
}

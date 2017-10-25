package ws;

import dao.UserDao;
import model.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Service {
    @WebMethod
    public List<User> getUserById(int id);
}

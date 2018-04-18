package j2ee.eTicket.dao;

import java.util.List;

public interface BaseDao {

    public void flush();

    public void clear();

    public Object load(Class c, String id);

    public Object load(Class c,String name, String value);

    public Object load(Class c, String[] names, String[] values);

//    public Object rangeLoad(Class c, String names[], String range[]);

    public List getAllList(Class c);

    public void save(Object bean);

    public void update(Object bean);

    public void delete(Object bean);

    public void delete(Class c, String id);

    public void delete(Class c, String[] ids);

    public void delete(Class c, String name, String value);

    public void delete(Class c, String name, String[] values);
}

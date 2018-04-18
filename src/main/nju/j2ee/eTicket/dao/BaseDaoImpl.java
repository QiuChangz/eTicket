package j2ee.eTicket.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import j2ee.eTicket.util.HibernateUtil;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao{

//    @Autowired
//    protected SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory)
    {
        super.setSessionFactory(sessionFactory);
    }

//    public BaseDaoImpl(SessionFactory sessionFactory){
//        this.setSessionFactory(sessionFactory);
//    }

//    protected Session getSession(){
//        return this.sessionFactory.openSession();
//    }

    public void flush() {
        getSession().flush();
    }

    public Session getSession() {
        try {
            return super.getSessionFactory().getCurrentSession();
        }catch (HibernateException he){
            return super.getSessionFactory().openSession();
        }
    }


    public void clear() {
        getSession().clear();
    }

    public Object load(Class c, String id) {
        try {
            Session session = getSession();
//            Transaction tx=session.beginTransaction();
            Object o=session.get(c,Integer.valueOf(id));
//            tx.commit();
            return o;
        } catch (Exception e) {
            try {
                Session session = getSession();
//            Transaction tx=session.beginTransaction();
                Object o = session.get(c, id);
//            tx.commit();
                return o;
            }catch (Exception e1){
                System.out.println("Something wrong with loading " + c.toString());
                e.printStackTrace();
                e1.printStackTrace();
            }
            return null;
        }
    }

    public Object load(Class c, String name, String value) {
        try {
            Session session = getSession();
//            Transaction tx=session.beginTransaction();
            String fullClassName = c.getName();
            String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            String hql = "from "+className+" where " + name + " like '%" + value + "%'";
            Query query=session.createQuery(hql);
            List result=query.getResultList();
//            tx.commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object load(Class c, String[] names, String[] values) {
        try {
            Session session = getSession();
//            Transaction tx = session.beginTransaction();
            String fullClassName = c.getName();
            String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);

            //设置数据库语句
            String hql = "from "+className+" where ";
            for(int i = 0; i < names.length; i++){
                hql += names[i]+"='"+values[i]+"'";
                if(i != names.length - 1){
                    hql += " and ";
                }
            }
            Query query=session.createQuery(hql);
            List result=query.getResultList();

//            tx.commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List getAllList(Class c) {
        try {
            Session session = getSession();
//            Transaction tx=session.beginTransaction();
            String hql = "from " + c.getName();
            Query query = session.createQuery(hql);
            query.setFirstResult(0);
            query.setMaxResults(20);
            List resultList = query.getResultList();
//            tx.commit();
            return resultList;
        } catch (Exception e) {
            System.out.println("Something wrong with loading " + c.toString());
            e.printStackTrace();
            return null;
        }
    }

    public void save(Object bean) {
        try {
            Session session = getSession() ;
            Transaction tx=session.beginTransaction();
            session.merge(bean);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Something wrong with saving " + bean.toString());
            e.printStackTrace();
        }
    }

    public void update(Object bean) {
        try {
            Session session = getSession() ;
            Transaction tx=session.beginTransaction();
            session.update(bean);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Something wrong with updating " + bean.toString());
            e.printStackTrace();
        }
    }

    public void delete(Object bean) {

        try {
            Session session = getSession() ;
            Transaction tx=session.beginTransaction();
            session.delete(bean);;
            tx.commit();
        } catch (Exception e) {
            System.out.println("Something wrong with deleting " + bean.toString());
            e.printStackTrace();
        }
    }

    public void delete(Class c, String id) {

    }

    public void delete(Class c, String[] ids) {

    }

    public void delete(Class c, String name, String value) {

    }

    public void delete(Class c, String name, String[] values) {

    }
}

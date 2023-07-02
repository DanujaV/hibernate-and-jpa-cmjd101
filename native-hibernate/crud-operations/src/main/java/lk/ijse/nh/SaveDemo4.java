package lk.ijse.nh;

/*
    @author DanujaV
    @created 7/2/23 - 1:53 PM   
*/

import lk.ijse.nh.entity.Item;
import lk.ijse.nh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SaveDemo4 {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            Item i1 = new Item("Rice", 450);
            System.out.println("does i1 inside the context: " + session.contains(i1));  //false

            System.out.println("-------");

            session.persist(i1);
            System.out.println("item persist");
            System.out.println("does i1 inside the context: " + session.contains(i1));  //?true

            session.detach(i1);
//            session.evict(i1);
            i1.setDescription("Ice-cream");
            System.out.println("change the description to Ice-cream");
            System.out.println("does i1 inside the context: " + session.contains(i1));  //?

            transaction.commit();

        }
    }
}

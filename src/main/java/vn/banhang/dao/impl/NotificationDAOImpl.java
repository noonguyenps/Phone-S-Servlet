package vn.banhang.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import vn.banhang.Hibernate.HibernateUtil;
import vn.banhang.Model.Notification;
import vn.banhang.dao.NotificationDAO;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class NotificationDAOImpl implements NotificationDAO {
    private final static SessionFactory factory = HibernateUtil.getSessionFactory();
    @Override
    public List<Notification> getListNotificationByUserID(int userId) {
        try(Session session = factory.openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();	//builder dùng để tạo các biểu thức đk trong câu lệnh where
            CriteriaQuery<Notification> query = builder.createQuery(Notification.class);
            Root<Notification> root = query.from(Notification.class);	//root là truy vấn gốc dùng để chỉ định các trường cho phần lọc dữ liệu của builer
            query.select(root); // Chỉ định loại kết quả truy vấn

            Predicate uID = builder.equal(root.get("user").get("id").as(int.class), userId);
            query.where(uID);

            List<Notification> notifications = session.createQuery(query).getResultList();
            if(notifications.size() != 0) {
                return notifications;
            }else {
                return null;
            }
        }
    }
    @Override
    public void add(Notification notification) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.getTransaction().begin();
            session.save(notification);
            session.getTransaction().commit();
        }
    }
}

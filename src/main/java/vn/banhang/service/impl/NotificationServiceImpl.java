package vn.banhang.service.impl;

import vn.banhang.Model.Notification;
import vn.banhang.dao.NotificationDAO;
import vn.banhang.dao.impl.NotificationDAOImpl;
import vn.banhang.service.NotificationService;

import java.util.List;

public class NotificationServiceImpl implements NotificationService {
    @Override
    public List<Notification> getNotificationByUserID(int userId) {
        NotificationDAO notificationDAO = new NotificationDAOImpl();
        return notificationDAO.getListNotificationByUserID(userId);
    }

    @Override
    public void add(Notification notification) {
        NotificationDAO notificationDAO = new NotificationDAOImpl();
        notificationDAO.add(notification);

    }
}

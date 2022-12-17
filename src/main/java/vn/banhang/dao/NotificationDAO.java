package vn.banhang.dao;

import vn.banhang.Model.Notification;

import java.util.List;

public interface NotificationDAO {
    public List<Notification> getListNotificationByUserID(int userId);

    void add(Notification notification);
}

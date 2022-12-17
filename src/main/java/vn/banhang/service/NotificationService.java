package vn.banhang.service;

import vn.banhang.Model.Notification;

import java.util.List;

public interface NotificationService {
    public List<Notification> getNotificationByUserID(int userId);

    void add(Notification notification);
}

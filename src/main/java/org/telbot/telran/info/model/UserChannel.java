package org.telbot.telran.info.model;

import javax.persistence.*;

@Entity
@Table(name = "user_channels")
public class UserChannel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int userChannelId;
    @Column(name = "user_channel_name")
    private String userChannelName;

    public UserChannel() {
    }

    public UserChannel(int userChannelId, String userChannelName) {
        this.userChannelId = userChannelId;
        this.userChannelName = userChannelName;
    }

    public int getUserChannelId() {
        return userChannelId;
    }

    public void setUserChannelId(int userChannelId) {
        this.userChannelId = userChannelId;
    }

    public String getUserChannelName() {
        return userChannelName;
    }

    public void setUserChannelName(String userChannelName) {
        this.userChannelName = userChannelName;
    }

    @Override
    public String toString() {
        return "UserChannel{" +
                "userChannelId=" + userChannelId +
                ", userChannelName='" + userChannelName + '\'' +
                '}';
    }
}

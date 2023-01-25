package org.telbot.telran.info.model;

import javax.persistence.*;

@Entity
@Table(name = "user_channel")
public class UserChannel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "channel_id")
    private long channelId;

    public UserChannel() {
        //
    }

    public UserChannel(long userId, long channelId) {
        this.userId = userId;
        this.channelId = channelId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }
}

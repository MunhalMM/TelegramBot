package org.telbot.telran.info.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_channel")
public class UserChannel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "channel_id")
    private int channelId;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_channel_id", referencedColumnName = "id")
//    private List<Channel> channels = new ArrayList<>();

    public UserChannel() {
        //
    }

    public UserChannel(int userId, int channelId) {
        this.userId = userId;
        this.channelId = channelId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


//    public List<Channel> getChannels() {
//        return channels;
//    }
//
//    public void setChannels(List<Channel> channels) {
//        this.channels = channels;
//    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }
}

package org.telbot.telran.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telbot.telran.info.model.TelegramMessage;
import org.telbot.telran.info.repository.TelegramMessageRepository;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


import java.util.List;

@Service
public class TelegramMessageServiceImpl implements TelegramMessageService {

    @Autowired
    private TelegramMessageRepository telegramMessageRepository;


    @Override
    public List<TelegramMessage> findAllMessage() {
        return telegramMessageRepository.findAll();
    }

    @Override
    public TelegramMessage getMessage(int id) {
        return telegramMessageRepository.findById(id).orElse(null);
    }

    @Override
    public void addMessage(long channelId, String text, String userName, String title) {
        TelegramMessage telegramMessage = new TelegramMessage(channelId, text, userName, title);
        telegramMessageRepository.save(telegramMessage);
    }


    @Override
    public void deleteMessage(int id) {
        telegramMessageRepository.deleteById(id);
    }
}

package org.telbot.telran.info.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class TelegramBot extends TelegramLongPollingBot {

    @Autowired
    private TelegramMessageService telegramMessageService;


    @Override
    public String getBotUsername() {
        return "Mario_java_bot";
    }

    @Override
    public String getBotToken() {
        return "5787130209:AAEjQyylcbVoTRU_AxBwfRscvvyublN--uY";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        Chat chat = message.getChat();
        if (chat.isGroupChat()) {
            String title = chat.getTitle();
            Long chatId = message.getChatId();
            String text = message.getText();
            String userName = chat.getUserName();
            telegramMessageService.addMessage(chatId,text,userName,title);
        }
    }
}

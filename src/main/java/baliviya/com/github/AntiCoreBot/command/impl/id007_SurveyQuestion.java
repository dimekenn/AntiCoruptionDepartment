package baliviya.com.github.AntiCoreBot.command.impl;

import baliviya.com.github.AntiCoreBot.command.Command;
import baliviya.com.github.AntiCoreBot.enums.WaitingType;
import baliviya.com.github.AntiCoreBot.model.custom.Quest;
import baliviya.com.github.AntiCoreBot.model.custom.Survey;
import baliviya.com.github.AntiCoreBot.repository.QuestRepo;
import baliviya.com.github.AntiCoreBot.repository.SurveyRepo;
import baliviya.com.github.AntiCoreBot.repository.TelegramBotRepositoryProvider;
import baliviya.com.github.AntiCoreBot.util.ButtonsLeaf;
import baliviya.com.github.AntiCoreBot.util.Const;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class id007_SurveyQuestion extends Command {

    private List<Quest>         quests;
    private Survey              survey;
    private QuestRepo           questRepo   = TelegramBotRepositoryProvider.getQuestRepo();
    private SurveyRepo          surveyRepo  = TelegramBotRepositoryProvider.getSurveyRepo();
    private ButtonsLeaf         buttonsLeaf;
    private ArrayList<String>   list        = new ArrayList<>();
    private List<String>        answers     = new ArrayList<>();
    private int                 deleteMessageId;

    @Override
    public  boolean execute()                       throws TelegramApiException {
        switch (waitingType) {
            case START:
                deleteMessage(updateMessageId);
                quests  = questRepo.findAllByLangId(getLanguage().getId());
                if (quests == null || quests.size() == 0) {
                    sendMessage(Const.QUEST_SURVEY_DONE_MESSAGE);
                    return EXIT;
                }
                survey      = new Survey();
                survey.setChatId(chatId);
                setQuestionText(quests.get(0));
                waitingType = WaitingType.QUEST;
                return COMEBACK;
            case QUEST:
                deleteMessage(updateMessageId);
                deleteMessage(deleteMessageId);
                if (hasCallbackQuery()) {
                    if (quests == null || quests.size() == 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        answers.add(updateMessageText);
                        answers.forEach(answer -> stringBuilder.append(answer).append(Const.SPLIT));
                        survey.setAnswers(stringBuilder.substring(0, stringBuilder.length() - 1));
                        survey.setDateAnswer(new Date());
                        surveyRepo.save(survey);
                        sendMessage(Const.QUEST_SURVEY_DONE_MESSAGE);
                        return EXIT;
                    }
                    answers.add(updateMessageText);
                    setQuestionText(quests.get(0));
                    waitingType = WaitingType.QUEST;
                }
                return COMEBACK;
        }
        return EXIT;
    }

    private void    setQuestionText(Quest quest)    throws TelegramApiException {
        if (quest.getId() == 1) {
            list.clear();
            list.add("A");
            list.add("B");
            list.add("C");
            list.add("D");
        } else if (quest.getId() == 2 || quest.getId() == 4) {
            list.clear();
            list.add("A");
            list.add("B");
            list.add("C");
        } else if (quest.getId() == 3) {
            list.clear();
            list.add("A");
            list.add("B");
        }
        buttonsLeaf     = new ButtonsLeaf(list);
        quests.remove(0);
        deleteMessageId = toDeleteKeyboard(sendMessageWithKeyboard(quest.getName(), buttonsLeaf.getListButton()));
    }
}

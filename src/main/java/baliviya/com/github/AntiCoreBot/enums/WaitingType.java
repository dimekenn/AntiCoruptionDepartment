package baliviya.com.github.AntiCoreBot.enums;

public enum WaitingType {

    START,
    SET_FULL_NAME, SET_PHONE_NUMBER, // Регистрация
    SELECT_APPEAL_TYPE, SEND_APPEAL_TEXT, FILE, LOCATION,  // id004_SendAppeal
    DONE, GET_FILE, GIVE_INFO, ADD_TEXT, //id005_task
    CHOISE_RECEPTION, SET_QUESTION, WAIT, //id006_Citizens
    QUEST, START_DATE, END_DATE, //id007_Survey
    CHOOSE_CATEGORY, EDITION, NEW_CATEGORY, NEW_KZ_CATEGORY, NEW_EN_CATEGORY, UPDATE_CATEGORY,
    CHOICE_OPTION, COMMAND_EDITOR, UPDATE_BUTTON, UPDATE_TEXT, UPDATE_FILE, NEXT_KEYBOARD, UPDATE_BUTTON_LINK, // id013_EditMenu
    PHONE,
}

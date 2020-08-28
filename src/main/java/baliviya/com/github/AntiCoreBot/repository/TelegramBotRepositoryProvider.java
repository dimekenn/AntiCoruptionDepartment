package baliviya.com.github.AntiCoreBot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TelegramBotRepositoryProvider {

    private static PropertiesRepo propertiesRepo;
    private static LanguageUserRepo languageUserRepo;
    private static UsersRepo usersRepo;
    private static ButtonRepo buttonRepo;
    private static MessageRepo messageRepo;
    private static KeyboardRepo keyboardRepo;
    private static AppealTypeRepo appealTypeRepo;
    private static TaskRepo taskRepo;
    private static FileRepo fileRepo;
    private static EmployeeRepo employeeRepo;
    private static TaskArchiveRepo taskArchiveRepo;
    private static ReceptionRepo receptionRepo;
    private static CitizensInfoRepo citizensInfoRepo;
    private static CitizensRegistrationRepo citizensRegistrationRepo;
    private static QuestRepo questRepo;
    private static SurveyRepo surveyRepo;
    private static AdminRepo adminRepo;
    private static CitizenEmployeeRepo citizenEmployeeRepo;
    private static SendMemberRepo sendMemberRepo;

    @Autowired
    public TelegramBotRepositoryProvider(PropertiesRepo propertiesRepo, LanguageUserRepo languageUserRepo,
                                         UsersRepo usersRepo, ButtonRepo buttonRepo, MessageRepo messageRepo,
                                         KeyboardRepo keyboardRepo, AppealTypeRepo appealTypeRepo, TaskRepo taskRepo,
                                         FileRepo fileRepo, EmployeeRepo employeeRepo, TaskArchiveRepo taskArchiveRepo,
                                         ReceptionRepo receptionRepo, CitizensInfoRepo citizensInfoRepo,
                                         CitizensRegistrationRepo citizensRegistrationRepo, QuestRepo questRepo,
                                         SurveyRepo surveyRepo, AdminRepo adminRepo, CitizenEmployeeRepo citizenEmployeeRepo,
                                         SendMemberRepo sendMemberRepo) {
        setPropertiesRepo(propertiesRepo);
        setLanguageUserRepo(languageUserRepo);
        setUserRepo(usersRepo);
        setButtonRepo(buttonRepo);
        setMessageRepo(messageRepo);
        setKeyboardRepo(keyboardRepo);
        setAppealTypeRepo(appealTypeRepo);
        setTaskRepo(taskRepo);
        setFileRepo(fileRepo);
        setEmployeeRepo(employeeRepo);
        setTaskArchiveRepo(taskArchiveRepo);
        setReceptionRepo(receptionRepo);
        setCitizensInfoRepo(citizensInfoRepo);
        setCitizensRegistrationRepo(citizensRegistrationRepo);
        setQuestRepo(questRepo);
        setSurveyRepo(surveyRepo);
        setAdminRepo(adminRepo);
        setCitizenEmployeeRepo(citizenEmployeeRepo);
        setSendMemberRepo(sendMemberRepo);
    }

    private static void setPropertiesRepo(PropertiesRepo propertiesRepo) {
        TelegramBotRepositoryProvider.propertiesRepo = propertiesRepo;
    }

    public static PropertiesRepo getPropertiesRepo() {
        return propertiesRepo;
    }

    private static void setLanguageUserRepo(LanguageUserRepo languageUserRepo) {
        TelegramBotRepositoryProvider.languageUserRepo = languageUserRepo;
    }

    public static LanguageUserRepo getLanguageUserRepo() {
        return languageUserRepo;
    }

    private static void setUserRepo(UsersRepo usersRepo) {
        TelegramBotRepositoryProvider.usersRepo = usersRepo;
    }

    public static UsersRepo getUserRepo() {
        return usersRepo;
    }

    private static void setButtonRepo(ButtonRepo buttonRepo) {
        TelegramBotRepositoryProvider.buttonRepo = buttonRepo;
    }

    public static ButtonRepo getButtonRepo() {
        return buttonRepo;
    }

    private static void setMessageRepo(MessageRepo messageRepo) {
        TelegramBotRepositoryProvider.messageRepo = messageRepo;
    }

    public static MessageRepo getMessageRepo() {
        return messageRepo;
    }

    private static void setKeyboardRepo(KeyboardRepo keyboardRepo) {
        TelegramBotRepositoryProvider.keyboardRepo = keyboardRepo;
    }

    public static KeyboardRepo getKeyboardRepo() {
        return keyboardRepo;
    }

    private static void setAppealTypeRepo(AppealTypeRepo appealTypeRepo) {
        TelegramBotRepositoryProvider.appealTypeRepo = appealTypeRepo;
    }

    public static AppealTypeRepo getAppealTypeRepo() {
        return appealTypeRepo;
    }

    private static void setTaskRepo(TaskRepo taskRepo) {
        TelegramBotRepositoryProvider.taskRepo = taskRepo;
    }

    public static TaskRepo getTaskRepo() {
        return taskRepo;
    }

    private static void setFileRepo(FileRepo fileRepo) {
        TelegramBotRepositoryProvider.fileRepo = fileRepo;
    }

    public static FileRepo getFileRepo() {
        return fileRepo;
    }

    private static void setEmployeeRepo(EmployeeRepo employeeRepo) {
        TelegramBotRepositoryProvider.employeeRepo = employeeRepo;
    }

    public static EmployeeRepo getEmployeeRepo() {
        return employeeRepo;
    }

    private static void setTaskArchiveRepo(TaskArchiveRepo taskArchiveRepo) {
        TelegramBotRepositoryProvider.taskArchiveRepo = taskArchiveRepo;
    }

    public static TaskArchiveRepo getTaskArchiveRepo() {
        return taskArchiveRepo;
    }

    private static void setReceptionRepo(ReceptionRepo receptionRepo) {
        TelegramBotRepositoryProvider.receptionRepo = receptionRepo;
    }

    public static ReceptionRepo getReceptionRepo() {
        return receptionRepo;
    }

    private static void setCitizensInfoRepo(CitizensInfoRepo citizensInfoRepo) {
        TelegramBotRepositoryProvider.citizensInfoRepo = citizensInfoRepo;
    }

    public static CitizensInfoRepo getCitizensInfoRepo() {
        return citizensInfoRepo;
    }

    private static void setCitizensRegistrationRepo(CitizensRegistrationRepo citizensRegistrationRepo) {
        TelegramBotRepositoryProvider.citizensRegistrationRepo = citizensRegistrationRepo;
    }

    public static CitizensRegistrationRepo getCitizensRegistrationRepo() {
        return citizensRegistrationRepo;
    }

    private static void setQuestRepo(QuestRepo questRepo) {
        TelegramBotRepositoryProvider.questRepo = questRepo;
    }

    public static QuestRepo getQuestRepo() {
        return questRepo;
    }

    private static void setSurveyRepo(SurveyRepo surveyRepo) {
        TelegramBotRepositoryProvider.surveyRepo = surveyRepo;
    }

    public static SurveyRepo getSurveyRepo() {
        return surveyRepo;
    }

    private static void setAdminRepo(AdminRepo adminRepo) {
        TelegramBotRepositoryProvider.adminRepo = adminRepo;
    }

    public static AdminRepo getAdminRepo() {
        return adminRepo;
    }

    private static void setCitizenEmployeeRepo(CitizenEmployeeRepo citizenEmployeeRepo){
        TelegramBotRepositoryProvider.citizenEmployeeRepo = citizenEmployeeRepo;
    }

    public static CitizenEmployeeRepo getCitizenEmployeeRepo(){
        return citizenEmployeeRepo;
    }

    private static void setSendMemberRepo(SendMemberRepo sendMemberRepo){
        TelegramBotRepositoryProvider.sendMemberRepo = sendMemberRepo;
    }

    public static SendMemberRepo getSendMemberRepo(){return sendMemberRepo;}

}

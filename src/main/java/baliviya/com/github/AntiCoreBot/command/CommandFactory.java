package baliviya.com.github.AntiCoreBot.command;

import baliviya.com.github.AntiCoreBot.command.impl.*;
import baliviya.com.github.AntiCoreBot.exceptions.NotRealizedMethodException;

public class CommandFactory {

    public  static Command getCommand(long id) {
        Command result = getCommandWithoutReflection((int) id);
        if (result == null) throw new NotRealizedMethodException("Not realized for type: " + id);
        return result;
    }

    private static Command getCommandWithoutReflection(int id) {
        switch (id) {
            case 1:
                return new id001_ShowInfo();
            case 2:
                return new id002_Registration();
            case 3:
                return new id003_SelectionLanguage();
            case 4:
                return new id004_SendAnAppeal();
            case 5:
                return new id005_Task();
            case 6:
                return new id006_Citizens();
            case 7:
                return new id007_SurveyQuestion();
            case 8:
                return new id008_MapLocationSend();
            case 9:
                return new id009_AdminShowInfo();
            case 10:
                return new id010_AppealReport();
            case 11:
                return new id011_EditAdmin();
            case 12:
                return new id012_EditAppeal();
            case 13:
                return new id013_EditMenu();
            case 14:
                return new id014_Photo();
            case 15:
                return new id015_ShowEmployeeInfo();
            case 16:
                return new id016__CitizenMember();
            case 17:
                return new id017_CitizensReport();
            case 18:
                return new id018_AcceptOrReject();
        }
        return null;
    }
}

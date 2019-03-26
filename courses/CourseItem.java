package courses;

import valuestype.ActType;

import java.text.MessageFormat;

public class CourseItem {
    private ActType actionType;
    private int value;

    public CourseItem(ActType actionType, int value) {
        this.actionType = actionType;
        this.value = value;
    }

    public ActType getActionType() {
        return actionType;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Препятствие " +
                "тип=" + actionType +
                ", значение=" + value +
                '}';
    }

    public void printInfo(){
        System.out.println(MessageFormat.format("Препятствие {0} размер {1}", actionType, value));

    }
}

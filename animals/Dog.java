package animals;

import behavers.Swim;
import service.CharacterService;
import service.impl.DogCharacterService;
import valuestype.ActType;
import valuestype.Gender;

import java.text.MessageFormat;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 2019-03-11
 */
public class Dog extends Animal implements Swim
{
  private CharacterService characterService = new DogCharacterService();

  public Dog(Gender gender)
  {
    super(gender);
  }

  public Dog(int age, Gender gender)
  {
    super(age, gender);
  }

  public Dog(int age, String name, Gender gender)
  {
    super(age, name, gender);
  }

  @Override
  public int jump()
  {
    CharacterValue characterValue = characterService.getCharacterValue(ActType.JUMP, getGender());
    return characterValue.getValue();
  }

  @Override
  public int run()
  {

    CharacterValue characterValue = characterService.getCharacterValue(ActType.RUN, getGender());
    return characterValue.getValue();
  }

  @Override
  public int swim()
  {
    CharacterValue characterValue = characterService.getCharacterValue(ActType.SWIM, getGender());
    return characterValue.getValue();

  }

  @Override
  public String toString() {
    return MessageFormat.format("Собака {0} {1} {2} прыжок {3} бег {4}", super.getName(),
            super.getAge(), super.getGender(), jump(), run());
  }
}

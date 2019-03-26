package animals;

import service.CharacterService;
import service.impl.CatCharacterService;
import valuestype.ActType;
import valuestype.Gender;

import java.text.MessageFormat;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 2019-03-11
 */
public class Cat extends Animal
{
  private CharacterService characterService = new CatCharacterService();


  public Cat(Gender gender)
  {
    super(gender);
  }

  public Cat(int age, Gender gender)
  {
    super(age, gender);
  }

  public Cat(int age, String name, Gender gender)
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
  public String toString() {
      return MessageFormat.format("Кошка {0} {1} {2} прыжок {3} бег {4}", super.getName(),
        super.getAge(), super.getGender(), jump(), run());
    }
}

package service.impl;

import constants.Constants;
import valuestype.ActType;
import animals.CharacterValue;
import service.CharacterService;
import valuestype.Gender;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 2019-03-11
 */
public class DogCharacterService implements CharacterService
{


  @Override
  public CharacterValue getCharacterValue(ActType actType)
  {
    //TODO
    return null;
  }

  @Override
  public CharacterValue getCharacterValue(ActType actType, Gender gender)
  {
    CharacterValue characterValue = new CharacterValue();

    if (actType == ActType.JUMP)
    {
      if (gender == Gender.MALE)
      {
        int value = (Constants.Dog.Male.POWER) / 2;
        characterValue.setValue(value);
        characterValue.setName(ActType.JUMP.toString());
      }
      else
      {
        int value = (Constants.Dog.Female.POWER) / 5;
        characterValue.setValue(value);
        characterValue.setName(ActType.JUMP.toString());
      }
    }
    else if (actType == ActType.RUN)
    {
      if (gender == Gender.MALE)
      {
        int value = (Constants.Dog.Male.SPEED) / 3;
        characterValue.setValue(value);
        characterValue.setName(ActType.RUN.toString());
      }
      else
      {
        int value = (Constants.Dog.Female.SPEED) / 3;
        characterValue.setValue(value);
        characterValue.setName(ActType.RUN.toString());
      }
    }
    else if (actType == ActType.SWIM)
    {
      if (gender == Gender.MALE)
      {
        int value = (Constants.Dog.Male.SPEED) / 5;
        characterValue.setValue(value);
        characterValue.setName(ActType.SWIM.toString());
      }
      else
      {
        int value = (Constants.Dog.Female.SPEED) / 6;
        characterValue.setValue(value);
        characterValue.setName(ActType.SWIM.toString());
      }
    }

    return characterValue;
  }
}

// IMyAidlInterface.aidl
package com.example.aidldemo;

// Declare any non-default types here with import statements

import com.example.aidldemo.Person;

interface IMyAidlInterface {
    oneway void addPerson(in Person person);

    String modifyPerson(in Person person);
    String getPersonInfo(out Person info);
    void convertPeople(inout Person people);
    List<Person> getPersonList();

}

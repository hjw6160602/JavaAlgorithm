/**
 * Person.java
 * Created by SaiDiCaprio on 2020/6/18.
 * Copyright © 2020 SaiDiCaprio. All rights reserved.
 */

package 数据结构.二叉树;

public class Person implements Comparable<Person> {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person e) {
        return age - e.age;
    }
}
